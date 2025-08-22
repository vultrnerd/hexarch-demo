# Hexarch Demo Project

This project consists of a frontend application built with Angular and a backend built with Spring Boot following the hexagonal architecture pattern.

## Project Structure

- `ng-app/`: Frontend application built with Angular 20.1.6
- `spring-hexarch-backend/`: Backend application built with Spring Boot 3.5.4

## Prerequisites

- Node.js 22.17 and npm (for the frontend)
- Java 21 and Maven (for the backend)

## Building and Running the Frontend

1. Navigate to the frontend directory:
   ```bash
   cd ng-app
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   ng serve
   ```

   Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

4. To build the project for production:
   ```bash
   ng build
   ```

   This will compile your project and store the build artifacts in the `dist/` directory.

## Building and Running the Backend

1. Navigate to the backend directory:
   ```bash
   cd spring-hexarch-backend
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   The backend will start and be available at `http://localhost:8080` by default.

## Additional Resources

- [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli)
- [Spring Boot Reference Guide](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)