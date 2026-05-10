# Online Food Ordering System - Backend

Backend REST API for the Online Food Ordering System developed using Spring Boot.

---

# 🚀 Technologies

- Java 21
- Spring Boot 3
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok

---

# 📁 Project Structure

```txt
src/main/java
├── controller
├── dto
├── entity
├── repository
├── service
│   └── impl
├── config
└── OnlineFoodOrderingSystemApplication.java
```

---

# ⚙️ Features

- User Registration & Login
- Food Management
- Category Management
- Cart Management
- Order Management
- REST API Architecture
- Database Integration with MySQL

---

# 🛠️ Setup Guide

## 1. Clone Repository

```bash
git clone https://github.com/YOUR_USERNAME/OnlineFoodOrderingSystem-Backend.git
```

---

## 2. Configure MySQL Database

Create database:

```sql
CREATE DATABASE online_food_ordering;
```

---

## 3. Configure Application Properties

Open:

```txt
src/main/resources/application.properties
```

Update:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/online_food_ordering
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4. Run Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Or using Maven:

```bash
mvn spring-boot:run
```

---

# 🌐 API Base URL

```txt
http://localhost:8080/api
```

---

# 📌 API Endpoints

## User APIs

| Method | Endpoint |
|--------|----------|
| POST | /api/users/register |
| POST | /api/users/login |

---

## Food APIs

| Method | Endpoint |
|--------|----------|
| GET | /api/foods |
| GET | /api/foods/category/{id} |
| POST | /api/foods |

---

## Category APIs

| Method | Endpoint |
|--------|----------|
| GET | /api/categories |
| POST | /api/categories |

---

## Cart APIs

| Method | Endpoint |
|--------|----------|
| GET | /api/cart/{userId} |
| POST | /api/cart/add |
| DELETE | /api/cart/remove/{cartItemId} |

---

## Order APIs

| Method | Endpoint |
|--------|----------|
| GET | /api/orders/{userId} |
| POST | /api/orders/place |

---

# 🧪 Testing

You can test APIs using:

- Postman
- Insomnia

---

# 👨‍💻 Author

ISH  
IJSE Coursework Project

---

# 📄 License

This project is developed for educational purposes only.
