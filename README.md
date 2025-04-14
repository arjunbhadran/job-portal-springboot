# Job Portal - Spring Boot Application

Job Portal Banner

## 📌 Overview

Job Portal is a modern web application built with Spring Boot that connects job seekers with employers. The platform offers comprehensive job listings, company profiles, and authentic company reviews to facilitate better career decisions.

This application implements a clean 3-tier architecture with clear separation of concerns, ensuring maintainability, scalability, and testability.

## 🏗️ Architecture

Application Architecture

The application follows a classic 3-tier architecture:

- **Controller Layer**: Handles HTTP requests, manages routing, and returns responses
- **Service Layer**: Contains business logic and orchestrates data operations
- **Repository Layer**: Interfaces with the database for CRUD operations


## 🛠️ Tech Stack

- **Backend**: Java 17, Spring Boot 3.1
- **Database**: MySQL/PostgreSQL with JPA/Hibernate
- **API**: RESTful endpoints with Spring Web
- **Security**: Spring Security with JWT authentication
- **Build Tool**: Maven
- **Testing**: JUnit 5, Mockito
- **Documentation**: Swagger/OpenAPI


## ✨ Features

- **Job Management**
    - Browse available jobs
    - Filter jobs by multiple criteria
    - Apply for positions
- **Company Profiles**
    - Comprehensive company information
    - Job listings by company
    - Company metrics and insights
- **Review System**
    - Submit company reviews
    - Rate companies on multiple factors
    - View aggregated ratings
- **User Management**
    - Secure registration and authentication
    - Profile management
    - Application tracking


## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven 3.6+
- MySQL/PostgreSQL


### Installation

```bash
# Clone the repository
git clone https://github.com/yourusername/job-portal-springboot.git

# Navigate to project directory
cd job-portal-springboot

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```


### Configuration

Create an `application.properties` file in `src/main/resources/`:

```properties
# Database Configuration
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update

# Server Configuration
server.port=8080

# JWT Configuration
jwt.secret=your-secret-key
jwt.expiration=86400000
```


## 📊 Database Schema

The application uses a relational database with the following core entities:

- **Jobs**: Stores job listings with details like title, description, requirements
- **Companies**: Contains company information, including profiles and contact details
- **Reviews**: Stores user-submitted reviews and ratings for companies
- **Users**: Manages user accounts and profile information


## 🔌 API Endpoints

### Job APIs

```
GET    /api/jobs                - Get all jobs with pagination
GET    /api/jobs/{id}           - Get job by ID
POST   /api/jobs                - Create new job
PUT    /api/jobs/{id}           - Update existing job
DELETE /api/jobs/{id}           - Delete job
GET    /api/jobs/search         - Search jobs with filters
```


### Company APIs

```
GET    /api/companies           - Get all companies
GET    /api/companies/{id}      - Get company by ID
POST   /api/companies           - Create new company
PUT    /api/companies/{id}      - Update company
DELETE /api/companies/{id}      - Delete company
GET    /api/companies/{id}/jobs - Get jobs by company
```


### Review APIs

```
GET    /api/reviews                 - Get all reviews
GET    /api/reviews/{id}            - Get review by ID
POST   /api/reviews                 - Create new review
PUT    /api/reviews/{id}            - Update review
DELETE /api/reviews/{id}            - Delete review
GET    /api/companies/{id}/reviews  - Get reviews by company
```


## 🧪 Testing

```bash
# Run tests
mvn test

# Run tests with coverage report
mvn test jacoco:report
```


## 📁 Project Structure

```
job-portal-springboot/
├── src/
│   ├── main/
│   │   ├── java/com/company/jobportal/
│   │   │   ├── controller/
│   │   │   │   ├── JobController.java
│   │   │   │   ├── CompanyController.java
│   │   │   │   └── ReviewController.java
│   │   │   ├── service/
│   │   │   │   ├── JobService.java
│   │   │   │   ├── CompanyService.java
│   │   │   │   └── ReviewService.java
│   │   │   ├── repository/
│   │   │   │   ├── JobRepository.java
│   │   │   │   ├── CompanyRepository.java
│   │   │   │   └── ReviewRepository.java
│   │   │   ├── model/
│   │   │   │   ├── Job.java
│   │   │   │   ├── Company.java
│   │   │   │   └── Review.java
│   │   │   ├── dto/
│   │   │   ├── exception/
│   │   │   ├── config/
│   │   │   ├── security/
│   │   │   └── JobPortalApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/
│       └── java/com/company/jobportal/
├── pom.xml
├── .gitignore
└── README.md
```

