# Driver-Vehicle Management System

## Project Overview
This Spring Boot application manages drivers, vehicles, and their assignments with the following business rules:

- Each vehicle can be assigned to only one driver at a time.
- Drivers and vehicles can be filtered based on license and vehicle age.
- Provides REST APIs for managing drivers, vehicles, and their mappings.

---

## Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL Database
- Maven
- RESTful Web Services

---

## Application Configuration

```properties
spring.application.name=Driver-Vehicle-Management-System

spring.datasource.url=jdbc:mysql://localhost:3306/driver_vehicle_db
spring.datasource.username=root
spring.datasource.password=Root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
API Endpoints and Features
Driver APIs (/drivers)
POST /drivers
Add a new driver with license details.

GET /drivers/older-than-5-years
List all drivers whose licenses are older than 5 years.

Vehicle APIs (/vehicles)
POST /vehicles
Add a new vehicle with model and manufacture date.

GET /vehicles/older-than-5-years
List all vehicles older than 5 years.

Driver-Vehicle Mapping APIs (/api/drivers)
POST /api/drivers
Map a driver to a vehicle ensuring a vehicle is assigned to only one driver at a time.

GET /api/drivers/older-than-5-years-with-new-license-drivers
Retrieve vehicles older than 5 years that are assigned to drivers whose licenses are less than 3 years old.

Response Structure
All API responses follow this format:

json
Copy
Edit
{
  "status": 200,
  "message": "Success",
  "data": { ... }
}
Database Schema Overview
Drivers
Fields: Driver Code, Driver Name, Licence Number, Licence Expiry Date

Vehicles
Fields: Vehicle Number, Model, Manufacture Date

Driver-Vehicle Mapping
Links each vehicle to one driver, enforcing one-to-one assignments.

How to Run
Set up a MySQL database named driver_vehicle_db.

Adjust the application.properties file with your MySQL credentials.

Import the project into your IDE as a Maven project.

Run the application:

bash
Copy
Edit
mvn spring-boot:run
The application will be accessible at http://localhost:8080.

# Abhi374426-backend-assignment-papl
# Abhi374426-backend-assignment-papl
