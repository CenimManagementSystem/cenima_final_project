package com.cinema.booking.security.ratelimit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Service
public class RateLimiterService {

    @Value("${rate.limit.enabled:true}")
    private boolean enabled;

    @Value("${rate.limit.auth.requests:10}")
    private int authMaxRequests;

    @Value("${rate.limit.auth.window-seconds:60}")
    private long authWindowSeconds;

    @Value("${rate.limit.general.requests:100}")
    private int generalMaxRequests;

    @Value("${rate.limit.general.window-seconds:60}")
    private long generalWindowSeconds;

    private final ConcurrentHashMap<String, ConcurrentLinkedQueue<Long>> requestCounts = new ConcurrentHashMap<>();

    public boolean isAllowed(String clientIp, boolean isAuthEndpoint) {
        if (!enabled) {
            return true;
        }

        int maxRequests = isAuthEndpoint ? authMaxRequests : generalMaxRequests;
        long windowMillis = (isAuthEndpoint ? authWindowSeconds : generalWindowSeconds) * 1000L;
        String key = (isAuthEndpoint ? "AUTH:" : "GEN:") + clientIp;
        long now = System.currentTimeMillis();
        long windowStart = now - windowMillis;

        ConcurrentLinkedQueue<Long> timestamps = requestCounts.computeIfAbsent(key, k -> new ConcurrentLinkedQueue<>());

        // Evict expired timestamps
        while (!timestamps.isEmpty()) {
            Long oldest = timestamps.peek();
            if (oldest != null && oldest < windowStart) {
                timestamps.poll();
            } else {
                break;
            }
        }

        synchronized (timestamps) {
            if (timestamps.size() < maxRequests) {
                timestamps.add(now);
                return true;
            }
            return false;
        }
    }

    public long getRetryAfterSeconds(boolean isAuthEndpoint) {
        return isAuthEndpoint ? authWindowSeconds : generalWindowSeconds;
    }

    public void reset() {
        requestCounts.clear();
    }
}
