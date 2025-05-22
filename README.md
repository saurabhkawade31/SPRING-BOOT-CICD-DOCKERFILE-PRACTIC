# Spring Boot REST API Example

A simple Spring Boot application demonstrating REST controller implementation with a welcome endpoint.

## 📋 Table of Contents

- [Project Overview](#project-overview)
- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Running the Application](#running-the-application)
- [Testing the API](#testing-the-api)
- [API Documentation](#api-documentation)
- [Development Guide](#development-guide)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [License](#license)

## 🚀 Project Overview

This project is a basic Spring Boot REST API that serves as an introduction to building web services with Spring Boot. It includes:

- A REST controller with a welcome endpoint
- Spring Boot auto-configuration
- Basic testing setup
- Maven build configuration

### Key Features

- **REST API**: Simple GET endpoint returning a welcome message
- **Spring Boot**: Leverages Spring Boot's auto-configuration
- **Maven**: Standard Maven project structure
- **Testing**: Basic test setup with JUnit 5

## 📋 Prerequisites

Before running this project, ensure you have the following installed:

- **Java**: JDK 11 or higher
- **Maven**: 3.6+ (or use Maven wrapper included)
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code
- **Optional**: Postman for API testing

### Version Compatibility

- Spring Boot: 2.5+ or 3.x
- Java: 11, 17, or 21
- Maven: 3.6+

## 📁 Project Structure

```
spring-boot-rest-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── amazon/
│   │   │           └── example/
│   │   │               ├── ExampleApplication.java
│   │   │               └── HomeController.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── org/
│               └── amazon/
│                   └── example/
│                       └── ExampleApplicationTests.java
├── pom.xml
├── README.md
└── .gitignore
```

### Key Files Description

| File | Description |
|------|-------------|
| `ExampleApplication.java` | Main Spring Boot application class with `@SpringBootApplication` |
| `HomeController.java` | REST controller with `/welcome` endpoint |
| `application.properties` | Application configuration file |
| `ExampleApplicationTests.java` | Basic integration test |
| `pom.xml` | Maven project configuration |

## ⚙️ Setup Instructions

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/spring-boot-rest-api.git
cd spring-boot-rest-api
```

### 2. Build the Project

```bash
# Using Maven
mvn clean install

# Or using Maven wrapper (if available)
./mvnw clean install
```

### 3. Verify Setup

```bash
# Run tests to verify everything is working
mvn test
```

## 🏃‍♂️ Running the Application

### Method 1: Using Maven

```bash
mvn spring-boot:run
```

### Method 2: Using Java Command

```bash
# First, build the JAR
mvn clean package

# Then run the JAR
java -jar target/example-0.0.1-SNAPSHOT.jar
```

### Method 3: Using IDE (IntelliJ IDEA)

1. Open the project in IntelliJ IDEA
2. Navigate to `src/main/java/org/amazon/example/ExampleApplication.java`
3. Right-click and select "Run 'ExampleApplication.main()'"
4. Or click the green arrow next to the `main()` method

### Expected Output

When the application starts successfully, you should see:

```
Started ExampleApplication in X.XXX seconds (JVM running for X.XXX)
Tomcat started on port(s): 8080 (http)
```

## 🧪 Testing the API

### 1. Using Web Browser

Open your browser and navigate to:
```
http://localhost:8080/welcome
```

Expected response:
```
Welcome to the Spring Boot REST API!
```

### 2. Using cURL

```bash
curl -X GET http://localhost:8080/welcome
```

### 3. Using Postman

1. Open Postman
2. Create a new GET request
3. Set URL to: `http://localhost:8080/welcome`
4. Click "Send"
5. Verify the response body contains: `Welcome to the Spring Boot REST API!`

### 4. Using HTTPie

```bash
http GET localhost:8080/welcome
```

## 📚 API Documentation

### Endpoints

| Method | Endpoint | Description | Response |
|--------|----------|-------------|----------|
| GET | `/welcome` | Returns a welcome message | `Welcome to the Spring Boot REST API!` |

### Response Examples

#### GET /welcome

**Request:**
```http
GET /welcome HTTP/1.1
Host: localhost:8080
```

**Response:**
```http
HTTP/1.1 200 OK
Content-Type: text/plain;charset=UTF-8
Content-Length: 35

Welcome to the Spring Boot REST API!
```

## 🛠️ Development Guide

### Adding New Endpoints

To add a new endpoint, modify the `HomeController.java`:

```java
@RestController
public class HomeController {

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return "Welcome to the Spring Boot REST API!";
    }
    
    // Add new endpoint
    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
}
```

### Configuration Changes

Modify `application.properties` to change server settings:

```properties
# Change server port
server.port=8090

# Change context path
server.servlet.context-path=/api/v1

# Application name
spring.application.name=example
```

### Adding Dependencies

Add new dependencies to `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## 🔧 Troubleshooting

### Common Issues

#### Port Already in Use
```
***************************
APPLICATION FAILED TO START
***************************

Description:
Web server failed to start. Port 8080 was already in use.
```

**Solutions:**
1. Kill the process using port 8080: `lsof -ti:8080 | xargs kill -9`
2. Change the port in `application.properties`: `server.port=8081`

#### Java Version Issues
```
Error: A JNI error has occurred
```

**Solution:** Ensure you're using Java 11 or higher:
```bash
java -version
```

#### Maven Build Failures
```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin
```

**Solutions:**
1. Check Java version compatibility
2. Clean and rebuild: `mvn clean install`
3. Verify `pom.xml` configuration

### Debugging Tips

1. **Enable Debug Logging**: Add to `application.properties`:
   ```properties
   logging.level.org.springframework=DEBUG
   ```

2. **Check Application Health**: Add Spring Boot Actuator:
   ```xml
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
   ```

3. **Use IDE Debugger**: Set breakpoints in your controller methods

## 📝 Lab Instructions Summary

This project implements the requirements from the Spring Boot lab:

### ✅ Completed Tasks

- [x] **TODO 1**: Created `ExampleApplication.java` with main method
- [x] **TODO 2**: Application can be run using multiple methods
- [x] **TODO 3**: Server starts on port 8080 with Tomcat
- [x] **TODO 4**: Browser testing at `localhost:8080/welcome`
- [x] **TODO 5**: Returns correct welcome message
- [x] **TODO 6**: Postman testing setup
- [x] **TODO 7**: Successful API response verification

### 🎯 Learning Objectives Achieved

- ✅ Created a simple REST controller in Spring Boot
- ✅ Successfully ran Spring Boot application
- ✅ Validated REST controller functionality
- ✅ Tested API using multiple tools (browser, Postman)
- ✅ Confirmed proper server startup and configuration

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/new-feature`
3. Commit changes: `git commit -am 'Add new feature'`
4. Push to branch: `git push origin feature/new-feature`
5. Submit a Pull Request

### Code Style Guidelines

- Follow Java naming conventions
- Use meaningful variable and method names
- Add comments for complex logic
- Write unit tests for new features

## 📄 License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 🆘 Support

If you encounter any issues:

1. Check the [Troubleshooting](#troubleshooting) section
2. Review the [GitHub Issues](https://github.com/your-username/spring-boot-rest-api/issues)
3. Create a new issue with detailed error information

## 🔗 Additional Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Framework Reference](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Maven Documentation](https://maven.apache.org/guides/)
- [RESTful Web Services Tutorial](https://spring.io/guides/gs/rest-service/)

---

**Happy Coding! 🚀**