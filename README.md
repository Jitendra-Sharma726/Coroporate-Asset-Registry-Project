# Coroporate Asset Registry Project

### Corporate Asset Registry Project Description

The **Corporate Asset Registry Project** is a Spring Boot backend application designed to help organizations efficiently manage and track their physical assets such as laptops, vehicles, monitors, office equipment, and other company-owned resources.

The application provides a complete **CRUD (Create, Read, Update, Delete)** system built using **Spring Data JPA** and an **H2 in-memory database**, allowing users to store, retrieve, update, search, and delete asset records through RESTful APIs without writing SQL queries manually.

This project demonstrates how modern enterprise applications use a **Layered Architecture** to separate concerns, improve maintainability, and simplify database operations.

---

## Project Objective

Build a backend asset management system that enables organizations to:

* Register new assets
* View all registered assets
* Search assets by ID
* Filter assets by category
* Update asset information
* Remove assets from the registry

The system acts as a centralized digital ledger that keeps track of company resources and their associated information.

---

## Architecture Overview

### 1. Entity Layer (`Asset.java`)

The Entity represents a database table row and defines the structure of asset data.

Each asset contains:

| Field      | Type   | Description                                     |
| ---------- | ------ | ----------------------------------------------- |
| id         | Long   | Auto-generated unique identifier                |
| name       | String | Asset name                                      |
| category   | String | Asset category (Laptop, Vehicle, Monitor, etc.) |
| cost       | Double | Purchase cost of the asset                      |
| assignedTo | String | Employee currently using the asset              |

Responsibilities:

* Map Java objects to database records.
* Define table structure.
* Provide constructors, getters, and setters.
* Support automatic persistence through JPA.

---

### 2. Repository Layer (`AssetRepository.java`)

The Repository acts as the Data Access Layer.

Responsibilities:

* Save asset records.
* Retrieve assets from the database.
* Delete assets.
* Search assets by category.
* Leverage Spring Data JPA's built-in methods.

Key features:

```java
save()
findAll()
findById()
delete()
findByCategory()
```

Spring automatically generates SQL queries based on method names.

---

### 3. Service Layer (`AssetService.java`)

The Service layer contains the application's business logic.

Responsibilities:

* Coordinate data flow between Controller and Repository.
* Validate asset existence before updates and deletion.
* Manage asset creation and retrieval.
* Handle category-based filtering.
* Return appropriate responses for successful and failed operations.

This layer ensures that business rules remain separate from web and database code.

---

### 4. Controller Layer (`AssetController.java`)

The Controller exposes REST APIs to external clients.

Responsibilities:

* Receive HTTP requests.
* Convert JSON data into Java objects.
* Call Service methods.
* Return responses to clients.

Base URL:

```text
/api
```

---

## Database Configuration

The application uses:

* **Spring Data JPA**
* **H2 In-Memory Database**

Benefits:

* No external database installation required.
* Fast startup and execution.
* Automatic table creation.
* Ideal for development and learning.

Database URL:

```text
jdbc:h2:mem:assetdb
```

Data persists only while the application is running.

---

## REST API Endpoints

### Add Asset

```http
POST /api/add
```

Creates a new asset record.

Example Request:

```json
{
  "name": "Dell Latitude 5440",
  "category": "Laptop",
  "cost": 75000,
  "assignedTo": "John"
}
```

---

### Get All Assets

```http
GET /api/all
```

Returns all registered assets.

---

### Get Asset by ID

```http
GET /api/{id}
```

Returns a specific asset using its unique ID.

Example:

```http
GET /api/1
```

---

### Search Assets by Category

```http
GET /api/category/{category}
```

Returns all assets belonging to a specific category.

Example:

```http
GET /api/category/Laptop
```

---

### Update Asset

```http
PUT /api/update/{id}
```

Updates an existing asset.

Example:

```json
{
  "name": "Dell Latitude 5450",
  "category": "Laptop",
  "cost": 80000,
  "assignedTo": "Alice"
}
```

---

### Delete Asset

```http
DELETE /api/delete/{id}
```

Removes an asset from the registry.

Example:

```http
DELETE /api/delete/1
```

---

## Application Workflow

### Asset Creation

1. User submits asset details through a POST request.
2. Controller receives the request.
3. Service processes the asset.
4. Repository saves it to the H2 database.
5. Generated ID is returned.

---

### Asset Retrieval

1. User requests asset data.
2. Controller forwards request.
3. Service retrieves data via Repository.
4. Results are returned as JSON.

---

### Asset Update

1. User provides an asset ID and updated information.
2. Service verifies that the asset exists.
3. Existing fields are updated.
4. Repository saves the updated record.

---

### Asset Deletion

1. User sends an asset ID.
2. Service checks if the asset exists.
3. Repository removes the record.
4. Success or failure message is returned.

---

## Technologies Used

* Spring Boot
* Spring Data JPA
* H2 Database
* Lombok
* Java
* REST API
* CRUD Operations
* Dependency Injection
* Layered Architecture

---

## Key Learning Outcomes

After completing this project, learners will understand:

* Spring Boot application architecture
* RESTful API development
* JPA entity mapping
* Repository pattern implementation
* Spring Data derived queries
* Constructor-based dependency injection
* CRUD operations with databases
* H2 database integration
* Service-layer business logic
* Enterprise backend development best practices

---

## Expected Outcome

Upon completing all TODO sections, the application will function as a fully operational **Corporate Asset Management System** capable of:

* Registering company assets
* Persisting asset data in a database
* Searching assets by category
* Updating asset ownership and details
* Deleting obsolete assets
* Exposing production-style REST APIs

This project provides a practical introduction to database-driven backend development and prepares learners for building larger enterprise systems using databases such as MySQL, PostgreSQL, and MongoDB.
