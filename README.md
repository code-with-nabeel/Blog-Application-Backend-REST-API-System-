
# Blog Application Backend – REST API System

A production-ready **Blog Management Backend API** built using **Java and Spring Boot**.
This application provides secure and scalable **RESTful APIs** for managing users, blog posts, categories, and comments.

The system implements **JWT-based authentication and role-based authorization using Spring Security**, ensuring secure access to protected endpoints. It follows a clean layered architecture with **Controller → Service → Repository → Entity** structure.

---

# 🚀 Features

* User Registration & Authentication
* JWT-based Authentication & Authorization
* Role-based access using Spring Security
* Create, Update, Delete Blog Posts
* Category-based Blog Management
* Comment system for posts
* Pagination and sorting for posts
* Global Exception Handling
* Swagger API Documentation
* Cloud-ready backend architecture

---

# 🛠 Tech Stack

* **Language:** Java
* **Framework:** Spring Boot
* **Security:** Spring Security + JWT
* **Database:** MySQL
* **ORM:** Hibernate / JPA
* **API Style:** REST APIs
* **Documentation:** Swagger (OpenAPI)
* **Build Tool:** Maven
* **Cloud:** AWS

---

# 🏗 Project Architecture

The project follows a **layered architecture**:

```
Controller Layer
      ↓
Service Layer
      ↓
Repository Layer
      ↓
Database (MySQL)
```

Key components:

* **Controller:** Handles HTTP requests
* **Service:** Business logic
* **Repository:** Database operations
* **Entity:** Database models
* **DTO:** Data transfer between layers
* **Exception Handler:** Centralized error handling

---

# 📂 Project Structure

```
blog-app-apis
│
├── controller
├── service
├── serviceImpl
├── repository
├── entity
├── payloads (DTOs)
├── config
├── security
├── exceptions
└── BlogAppApisApplication.java
```

---

# 🔐 Authentication Flow

1. User registers in the system.
2. User logs in with email and password.
3. Server generates **JWT Token**.
4. Client sends JWT token in request header.
5. Spring Security validates token and authorizes access.

---

# 📘 API Documentation

The APIs are documented using **Swagger (OpenAPI)**.

Once the application is running, you can access the documentation at:

```
http://localhost:8080/swagger-ui/index.html
```

---

# ⚙️ Installation & Setup

### 1 Clone Repository

```bash
git clone https://github.com/code-with-nabeel/Blog-Application-Backend-REST-API-System-.git
```

### 2 Navigate to Project

```bash
cd Blog-Application-Backend-REST-API-System-
```

### 3 Configure Database

Update **application.properties**

```
spring.datasource.url=jdbc:mysql://localhost:3306/blog_app
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4 Run the Application

```bash
mvn spring-boot:run
```

---

# 📊 Database Entities

Main entities in the system:

* **User**
* **Post**
* **Category**
* **Comment**

Relationships:

* One User → Many Posts
* One Category → Many Posts
* One Post → Many Comments

---

# ☁️ Deployment

The application can be deployed on **AWS cloud services** such as:

* AWS EC2
* AWS RDS (MySQL)
* Docker container deployment

---

# 📈 Future Improvements

* Image upload using AWS S3
* Email notifications
* Full-text search
* Caching with Redis
* Microservices architecture

---

# 👨‍💻 Author

**Nabeel Khan**

Backend Developer
Java | Spring Boot | REST APIs | Microservices

GitHub:
[https://github.com/code-with-nabeel](https://github.com/code-with-nabeel)


