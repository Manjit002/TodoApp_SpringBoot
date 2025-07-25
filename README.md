# 📝 Todo App - Spring Boot + JWT Authentication

This is a full-stack-ready backend REST API for a Todo application built using **Spring Boot**. It features **JWT-based authentication**, **role-based access control**, and **CRUD operations** for managing todo tasks.

---

## 🚀 Features

- User Signup & Login (JWT token-based)
- Role-based user access (Admin/User)
- Create, Read, Update, Delete Todos
- Filter Todos by status (complete/incomplete)
- Pagination support
- Secure REST API with Spring Security
- ModelMapper integration
- Exception handling with `@ControllerAdvice`

---

## 🔐 Authentication Endpoints

| Method | Endpoint        | Description         |
|--------|-----------------|---------------------|
| POST   | `/auth/signup`  | Register new user   |
| POST   | `/auth/login`   | Login & get JWT     |

📦 **Login Response:**
```json
{
  "token": "jwt_token_here",
  "user": {
    "id": 1,
    "name": "John",
    "email": "john@example.com",
    "role": "ROLE_USER"
  }
}


📋 Todo Endpoints
All Todo endpoints require a valid JWT token in the Authorization header:

| Method | Endpoint               | Description                     |
| ------ | ---------------------- | ------------------------------- |
| POST   | `/todo/create`         | Create a new todo item          |
| PUT    | `/todo/update/{id}`    | Update an existing todo         |
| DELETE | `/todo/delete/{id}`    | Delete a todo                   |
| GET    | `/todo/get/{id}`       | Get todo by ID                  |
| GET    | `/todo/all`            | Get all todos (with pagination) |
| GET    | `/todo/all/complete`   | Get completed todos             |
| GET    | `/todo/all/incomplete` | Get incomplete todos            |
| PUT    | `/todo/{id}/complete`  | Mark a todo as complete         |


🛠 Tech Stack
Java 17
Spring Boot
Spring Security
JWT (JSON Web Tokens)
Hibernate & JPA
MySQL
Lombok
ModelMapper

