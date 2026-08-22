package com.cinema.booking.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class CloudinaryService {

    private final Cloudinary cloudinary;

    /**
     * Uploads an image file to Cloudinary.
     *
     * @param file the image file to upload
     * @return a Map containing "secure_url" and "public_id"
     * @throws RuntimeException if the upload fails
     */
    @SuppressWarnings("unchecked")
    public Map<String, Object> upload(MultipartFile file) {
        try {
            Map<String, Object> result = cloudinary.uploader().upload(file.getBytes(),
                    ObjectUtils.asMap(
                            "folder", "Cinema_Project/product",
                            "resource_type", "image"
                    ));
            log.info("Image uploaded to Cloudinary: publicId={}", result.get("public_id"));
            return result;
        } catch (IOException e) {
            log.error("Failed to upload image to Cloudinary", e);
            throw new RuntimeException("Failed to upload image to Cloudinary: " + e.getMessage(), e);
        }
    }

    /**
     * Deletes an image from Cloudinary by its public ID.
     *
     * @param publicId the Cloudinary public ID of the image
     */
    public void delete(String publicId) {
        if (publicId == null || publicId.isBlank()) {
            return;
        }
        try {
            Map<?, ?> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            log.info("Image deleted from Cloudinary: publicId={}, result={}", publicId, result.get("result"));
        } catch (IOException e) {
            log.error("Failed to delete image from Cloudinary: publicId={}", publicId, e);
            throw new RuntimeException("Failed to delete image from Cloudinary: " + e.getMessage(), e);
        }
    }
}
