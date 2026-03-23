# 🔐 JWT Authentication with Role-Based Access (Spring Boot)

## 🚀 Project Overview

This project is a secure backend system built using Spring Boot that implements:

* JWT (JSON Web Token) Authentication
* Role-Based Authorization (USER / ADMIN)
* Secure REST APIs using Spring Security

It demonstrates how real-world applications handle authentication, authorization, and API security.

---

## ✨ Key Features

* User Registration & Login
* JWT Token Generation & Validation
* Role-Based Access Control (RBAC)
* Unauthorized Access Handling
* H2 In-Memory Database
* Stateless Authentication (No Sessions)
* Clean and Modular Code Structure

---

## 🛠 Tech Stack

* Java 17
* Spring Boot
* Spring Security
* JWT (jjwt library)
* H2 Database
* Maven

---

## 📂 Project Structure

src/main/java/com/example/demo

* controller → API endpoints
* model → Entity & Request classes
* repository → Database layer (JPA)
* security → JWT, Filters, SecurityConfig
* service → Business logic
* DemoApplication.java

---

## 📌 API Endpoints

### 🔹 Register User

POST /register

Request Body:
{
"username": "user1",
"password": "1234",
"role": "ROLE_USER"
}

---

### 🔹 Login

POST /login

Request Body:
{
"username": "user1",
"password": "1234"
}

Response:
JWT Token

---

### 🔹 Get Users (Protected)

GET /users

Header:
Authorization: Bearer <your_token>

---

## 🔐 Role-Based Access

ROLE_USER → Can read data (GET /users)
ROLE_ADMIN → Full access (CRUD APIs)

---

## 🧪 How to Run the Project

1. Clone the repository
   git clone https://github.com/yourusername/jwt-auth-springboot.git

2. Navigate to project folder
   cd jwt-auth-springboot

3. Run the application
   mvn spring-boot:run

4. Open H2 Console
   http://localhost:8080/h2-console

---

## 🔑 JWT Flow

1. User logs in → receives JWT token
2. Token is sent in request header
3. JwtFilter validates token
4. Access granted based on role

---

## 📸 Sample Workflow

1. Register → /register
2. Login → /login → get token
3. Use token → /users

---

