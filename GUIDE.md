# GitHub Repository Setup Guide

## 🚀 Quick Setup Instructions

Follow these steps to create your GitHub repository for the Spring Boot REST API project:

### Step 1: Create GitHub Repository

1. Go to [GitHub](https://github.com) and log in to your account
2. Click the "+" icon in the top right corner and select "New repository"
3. Fill in the repository details:
   - **Repository name**: `spring-boot-rest-api`
   - **Description**: `A simple Spring Boot REST API example with welcome endpoint`
   - **Visibility**: Public or Private (your choice)
   - **Initialize**: ✅ Add a README file
   - **Add .gitignore**: Choose "Java" template
   - **Choose a license**: MIT License (recommended)

### Step 2: Clone the Repository

```bash
git clone https://github.com/YOUR_USERNAME/spring-boot-rest-api.git
cd spring-boot-rest-api
```

### Step 3: Set Up Project Structure

Create the following directory structure:

```bash
mkdir -p src/main/java/org/amazon/example
mkdir -p src/main/resources
mkdir -p src/test/java/org/amazon/example
mkdir -p src/test/resources
mkdir -p docker
```

### Step 4: Add Project Files

Copy the following files from the project artifacts:

1. **pom.xml** (in root directory)
2. **src/main/java/org/amazon/example/ExampleApplication.java**
3. **src/main/java/org/amazon/example/HomeController.java**
4. **src/main/resources/application.properties**
5. **src/test/java/org/amazon/example/ExampleApplicationTests.java**
6. **src/test/java/org/amazon/example/HomeControllerTest.java**
7. **src/test/resources/application-test.properties**
8. **CONTRIBUTING.md**
9. **docker/Dockerfile**
10. **docker-compose.yml**

### Step 5: Initial Commit

```bash
git add .
git commit -m "Initial commit: Spring Boot REST API example

- Add basic Spring Boot application with REST controller
- Implement /welcome endpoint
- Include comprehensive documentation
- Add unit and integration tests
- Configure Maven build
- Add Docker support"

git push origin main
```

## 📁 Final Repository Structure

Your repository should look like this:

```
spring-boot-rest-api/
├── .gitignore
├── CONTRIBUTING.md
├── LICENSE
├── README.md
├── docker-compose.yml
├── pom.xml
├── docker/
│   └── Dockerfile
└── src/
    ├── main/
    │   ├── java/
    │   │   └── org/
    │   │       └── amazon/
    │   │           └── example/
    │   │               ├── ExampleApplication.java
    │   │               └── HomeController.java
    │   └── resources/
    │       └── application.properties
    └── test/
        ├── java/
        │   └── org/
        │       └── amazon/
        │           └── example/
        │               ├── ExampleApplicationTests.java
        │               └── HomeControllerTest.java
        └── resources/
            └── application-test.properties
```

## 🏷️ Repository Tags and Releases

### Create Tags for Milestones

1. **Initial Release**:
```bash
git tag -a v1.0.0 -m "Initial release: Basic Spring Boot REST API"
git push origin v1.0.0
```

2. **Lab Completion**:
```bash
git tag -a lab-complete -m "Lab instructions completed successfully"
git push origin lab-complete
```

### Create a Release on GitHub

1. Go to your repository on GitHub
2. Click on "Releases" tab
3. Click "Create a new release"
4. Choose tag `v1.0.0`
5. Add release title: "Initial Spring Boot REST API Release"
6. Add description:
   ```markdown
   ## 🎉 Spring Boot REST API v1.0.0
   
   Initial release of the Spring Boot REST API example project.
   
   ### Features
   - ✅ Basic REST controller with /welcome endpoint
   - ✅ Spring Boot auto-configuration
   - ✅ Maven build configuration
   - ✅ Unit and integration tests
   - ✅ Docker support
   - ✅ Comprehensive documentation
   
   ### Lab Requirements Completed
   - [x] Create Spring Boot application
   - [x] Implement REST controller
   - [x] Test with browser and Postman
   - [x] Verify server startup on port 8080
   
   ### Quick Start
   ```bash
   git clone https://github.com/YOUR_USERNAME/spring-boot-rest-api.git
   cd spring-boot-rest-api
   mvn spring-boot:run
   ```
   
   Then visit: http://localhost:8080/welcome
   ```

## 📋 Repository Issues Template

Create these issue templates in `.github/ISSUE_TEMPLATE/`:

### Bug Report Template
```yaml
name: Bug Report
about: Create a report to help us improve
title: '[BUG] '
labels: bug
assignees: ''

body:
- type: markdown
  attributes:
    value: |
      Thanks for taking the time to fill out this bug report!
- type: input
  id: java-version
  attributes:
    label: Java Version
    description: What version of Java are you running?
    placeholder: ex. Java 17
  validations:
    required: true
- type: textarea
  id: what-happened
  attributes:
    label: What happened?
    description: Also tell us, what did you expect to happen?
    placeholder: Tell us what you see!
  validations:
    required: true
```

### Feature Request Template
```yaml
name: Feature Request
about: Suggest an idea for this project
title: '[FEATURE] '
labels: enhancement
assignees: ''

body:
- type: textarea
  id: feature-description
  attributes:
    label: Feature Description
    description: A clear and concise description of what you want to happen.
  validations:
    required: true
```

## 🔒 Repository Settings

### Recommended Settings

1. **Branch Protection Rules**:
   - Require pull request reviews before merging
   - Require status checks to pass before merging
   - Require branches to be up to date before merging

2. **Actions**:
   - Enable GitHub Actions for CI/CD

3. **Security**:
   - Enable dependency scanning
   - Enable code scanning

### GitHub Actions Workflow

Create `.github/workflows/ci.yml`:

```yaml
name: CI

on:
  push:
    branches: [ main, develop ]
  pull_request:
    branches: [ main ]

jobs:
  test:
    runs-on: ubuntu-latest
    
    strategy:
      matrix:
        java-version: [11, 17, 21]
    
    steps:
    - uses: actions/checkout@v3
    
    - name: Set up JDK ${{ matrix.java-version }}
      uses: actions/setup-java@v3
      with:
        java-version: ${{ matrix.java-version }}
        distribution: 'temurin'
        
    - name: Cache Maven packages
      uses: actions/cache@v3
      with:
        path: ~/.m2
        key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}
        restore-keys: ${{ runner.os }}-m2
        
    - name: Run tests
      run: mvn clean verify
      
    - name: Generate test report
      uses: dorny/test-reporter@v1
      if: success() || failure()
      with:
        name: Maven Tests
        path: target/surefire-reports/*.xml
        reporter: java-junit
```

## 🎯 Next Steps

After setting up your repository:

1. **Verify the setup**: Clone the repository and run the application
2. **Test all endpoints**: Ensure the welcome endpoint works
3. **Run tests**: Verify all tests pass
4. **Review documentation**: Make sure README is accurate
5. **Share the repository**: Add collaborators if needed

## 📞 Support

If you encounter any issues during setup:

1. Check the repository's Issues tab
2. Review the troubleshooting section in README.md
3. Create a new issue with detailed information

---

**Happy coding! 🚀**