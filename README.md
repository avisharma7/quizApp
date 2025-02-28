QuizApp

Overview

QuizApp is a monolithic quiz application designed to provide users with an interactive quiz experience. The project will initially be developed as a monolith and then progressively refactored into microservices using Java-based technologies.

Project Roadmap

Phase 1: Develop a fully functional monolithic quiz application.

Phase 2: Identify key functionalities (e.g., question management, quiz creation, user management).

Phase 3: Modularize the monolith by extracting functionalities into independent microservices.

Phase 4: Implement API Gateway, Service Discovery, and Inter-Service Communication.

Phase 5: Deploy and monitor the microservices architecture.

Features

Create and manage quizzes.

Add, update, and delete questions.

Submit and evaluate quiz responses.

Track user progress and scores.

RESTful API endpoints for seamless integration.

Tech Stack

Backend

Java (Spring Boot)

Spring MVC

Spring Data JPA (Hibernate)

MySQL/PostgreSQL

Maven

Frontend (Future Enhancement)

React/Angular (Planned for future iterations)

Microservices Stack (Planned)

Spring Cloud

Eureka Service Discovery

API Gateway (Spring Cloud Gateway)

Docker & Kubernetes (For containerization and orchestration)

Getting Started

Prerequisites

Java 17+

Maven 3+

MySQL/PostgreSQL (or H2 for testing)

Git

Installation & Setup

Clone the repository:

git clone https://github.com/YOUR_GITHUB_USERNAME/quizApp.git
cd quizApp

Configure database settings in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/quizdb
spring.datasource.username=root
spring.datasource.password=yourpassword

Build and run the application:

mvn clean install
mvn spring-boot:run

Access the application:

API: http://localhost:8080/api

Swagger UI (if enabled): http://localhost:8080/swagger-ui.html

API Endpoints

Method

Endpoint

Description

GET

/api/questions

Get all questions

POST

/api/questions

Add a new question

GET

/api/quiz/{id}

Get quiz details

POST

/api/quiz/submit

Submit quiz answers

Future Enhancements

Implement authentication & authorization (Spring Security + JWT/OAuth2)

Convert to a microservices architecture

Deploy to cloud platforms (AWS/GCP/Azure)

Add frontend UI for user interaction

Contributing

Contributions are welcome! Feel free to fork this repository, create a feature branch, and submit a pull request.

License

This project is licensed under the MIT License - see the LICENSE file for details.

Contact

For any inquiries, reach out via:

GitHub: avisharma7

Email: aviral.np12@gmail.com