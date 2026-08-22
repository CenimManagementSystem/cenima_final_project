GitHub Actions, use:

GitHub
   │
   ├── main       → production
   │
   └── dev        → development
           │
           ↓
    GitHub Actions
           │
     ┌─────┴─────┐
     ↓           ↓
    CI          CD
 Build/Test    Deploy
                 ↓
              Docker
                 ↓
               
               
## CI Flow :

git push origin dev
       ↓
GitHub Actions
       ↓
Checkout code
       ↓
Setup Java
       ↓
Maven build
       ↓
Run tests
       ↓
✅ Success / ❌ Failed