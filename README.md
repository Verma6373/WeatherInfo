# Weather Information for Pincode API

This project is a Spring Boot-based REST API that fetches weather information for a given pincode and date. The application uses external APIs (Google Geocoding API and OpenWeather API) to get latitude/longitude from a pincode and fetch weather details. The fetched data is cached in a relational database to optimize subsequent API calls.

## Features
- REST API for weather information by pincode and date.
- Converts pincode to latitude and longitude using Google Geocoding API.
- Fetches weather information using latitude and longitude from OpenWeather API.
- Caches location and weather information in the database for optimized future requests.
- Unit test cases using JUnit and Mockito.
- Design patterns: Singleton, Repository, and Factory.

## Technologies Used
- **Java 11**
- **Spring Boot**
- **Spring Data JPA**
- **H2/MySQL** (for development and production)
- **JUnit 5** and **Mockito** (for testing)
- **Maven** (for dependency management)

## Project Structure
```plaintext
src/
│
├── main/
│   ├── java/
│   │   └── com/
│   │       └── weatherapi/
│   │           ├── controller/       # API Controllers
│   │           ├── service/           # Business Logic
│   │           ├── model/             # Entity Definitions
│   │           ├── repository/        # Repositories for Database Access
│   │           └── client/            # API Clients for External Services
│   └── resources/
│       ├── application.properties     # Configuration
│       └── schema.sql                 # Database Schema (if needed)
├── test/
│   └── java/                          # Unit Test Cases
└── pom.xml                             # Maven Dependencies

## Getting Started
Prerequisites
To run this project, you need the following:

Java 11 or above
Maven
API keys for Google Geocoding API and OpenWeather API
## Clone the Repository
bash
Copy
Edit
git clone https://github.com/your-username/weather-pincode-api.git
cd weather-pincode-api
## Set Up API Keys
Create a .env file in the root of the project and add your API keys:

env
Copy
Edit
GEOCODE_API=your-google-geocoding-api-key
WEATHER_API=your-openweather-api-key
## Database Configuration
By default, the application is configured to use an H2 in-memory database. If you want to use MySQL, modify the application.properties file:

properties
Copy
Edit
# MySQL configuration
spring.datasource.url=jdbc:mysql://localhost:3306/weatherdb
spring.datasource.username=root
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
## Run the Application
To start the Spring Boot application, run the following command:

bash
Copy
Edit
mvn spring-boot:run
API Endpoints
POST /api/weather
Request Body:
json
Copy
Edit
{
  "pincode": "411014",
  "for_date": "2020-10-15"
}
Response:
json
Copy
Edit
{
  "weather": "Sunny",
  "temperature": "30°C"
}
## Testing
Unit tests are written using JUnit 5 and Mockito. To run the tests:

bash
Copy
Edit
mvn test
## How It Works
Pincode to Latitude/Longitude Conversion:
When you provide a pincode, the application uses Google Geocoding API to get the latitude and longitude.

Fetching Weather Information:
Once the latitude and longitude are obtained, the weather information is fetched using the OpenWeather API.

Database Caching:
The location and weather data are cached in the database. Subsequent requests for the same pincode and date will return cached data, optimizing API calls.

## License
This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements
Spring Boot
Google Geocoding API
OpenWeather API
