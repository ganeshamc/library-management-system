# Library Management System (Backend)

A **RESTful backend library management system** built with **Spring Boot**, **Hibernate/JPA**, and **H2 Database**.  
This project allows managing books, authors, categories, and publishers via APIs, with proper database relationships and CRUD operations.

---

## Features
- **CRUD operations** for Books, Authors, Categories, and Publishers.
- **Many-to-Many relationships**: Books ↔ Authors, Books ↔ Categories.
- **Many-to-One relationship**: Books → Publisher.
- **RESTful APIs** for backend data management.
- **JSON serialization handling** using `@JsonIgnore` to prevent infinite recursion.
- Tested APIs using **Postman**.
- **H2 in-memory database** for quick testing.

---

## Tech Stack
- **Programming Language:** Java  
- **Frameworks / Libraries:** Spring Boot, Hibernate / JPA  
- **Database:** H2, MySQL (optional for production)  
- **Tools:** Postman, Git, VS Code / IntelliJ IDEA  

---

## Project Structure
src/main/java
└── com.example.libraryManagementSystem
├── controller # REST API Controllers
├── entity # JPA Entities (Book, Author, Category, Publisher)
├── repository # Spring Data JPA Repositories
└── service # Business Logic Layer

## API Endpoints (Sample)

GET /api/books – List all books
POST /api/books – Add a new book
GET /api/publisher/{id} – Get a publisher by ID
PUT /api/publisher/{id} – Update publisher
DELETE /api/publisher/{id} – Delete publisher
