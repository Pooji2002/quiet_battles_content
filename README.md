# QUIET BATTLES™ – Content Service

The Content Service is a backend microservice responsible for managing the editorial content of the QUIET BATTLES™ application.

It manages fashion collections (Series) and their associated Chapters, including descriptions, story content, and image references.

## Technology Stack

- Java 17
- Spring Boot 4.1.2
- Spring WebMVC
- Spring Data JPA
- MySQL
- Bean Validation
- Spring Boot Actuator
- Maven

## Service Overview

| Property | Value |
|---|---|
| Service Name | Content Service |
| Port | 8092 |
| Database | qb_content_db |
| Build Tool | Maven |
| Architecture | Microservice |

## Key Features

### 1. Series Management

The service supports managing Series content.

- Create new Series.
- Retrieve Series information.
- Update existing Series.
- Delete Series.
- Maintain Series details for the frontend.

### 2. Chapter Management

The service manages Chapters associated with a Series.

- Create Chapters.
- Retrieve Chapter details.
- Update Chapter content.
- Delete Chapters.
- Associate Chapters with their respective Series.

### 3. Content and Image References

- Stores content details used by the frontend.
- Supports image references through image URLs.
- Provides chapter content and image information for the Chapter detail pages.
- Supports linking a Chapter to a related product using its product ID.

**Note:** Product information is managed by the separate Product Service. The `productId` is used to connect related content across services.

## Microservice Architecture

The Content Service operates independently and communicates with the frontend through the API Gateway.

**Application flow:**

Frontend → API Gateway (8090) → Content Service (8092) → MySQL

The API Gateway forwards content-related API requests to this service.

## Database Configuration

The service uses MySQL with the database:

`qb_content_db`

Create the database before starting the application:

```sql
CREATE DATABASE qb_content_db;
```

Configure the database connection in the application's configuration file.

Do not commit database passwords or other sensitive configuration values to GitHub.

## Running the Application Locally

### Prerequisites

- Java 17 or later
- Maven
- MySQL Server
- Git

### 1. Clone the repository

```bash
git clone https://github.com/Pooji2002/quiet_battles_content.git
```

### 2. Open the project

Open the cloned project in Eclipse, IntelliJ IDEA, or VS Code.

### 3. Configure MySQL

Create the `qb_content_db` database and configure the database connection.

### 4. Run the service

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application class from your IDE.

The service runs at:

`http://localhost:8092`

## Integration with Other Services

The Content Service is part of the QUIET BATTLES™ microservices architecture.

| Component | Port |
|---|---:|
| API Gateway | 8090 |
| Identity Service | 8091 |
| Content Service | 8092 |
| Product Service | 8093 |
| Order Service | 8094 |

The frontend accesses content through the API Gateway instead of communicating directly with the Content Service.

## Project Repository

GitHub: https://github.com/Pooji2002/quiet_battles_content

## Project Context

This service is part of the QUIET BATTLES™ full-stack fashion and lifestyle e-commerce prototype.

**Brand Tagline: WEAR YOUR BATTLES.**