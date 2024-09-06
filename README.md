# Furniture Webshop

This is a repository for a full-stack webshop application that allows users to browse and purchase furniture. The backend is built using Spring and Spring Boot, providing API endpoints for managing products, orders, and users. The frontend is developed in React, offering user-friendly interaction and experience. This project is part of an exercise to demonstrate my skills in building modern web applications.

## Backend Checklist

### Completed
- [x] Setup Spring Boot application
- [x] User registration - [PR #1](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/1)
- [x] Implement user login and authentication with JWT - [PR #2](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/2)
- [x] Implement role-based access control (admin/user) - [PR #3](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/3)
- [x] Implement RESTful API endpoints (#4 - #8) - [PR #4](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/4), [PR #5](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/5), [PR #6](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/6), [PR #7](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/7), [PR #8](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/8)
- [x] Create service layer to handle business logic (#4 - #8) 
- [x] Setup JPA repositories for database interactions (#4 - #8) 
- [x] Implement DTOs for data transfer (#4 - #8) 
- [x] Configure PostgreSQL database with Flyway for migrations - [PR #9](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/9)
- [x] Refactoring: separate entities from domain models (#10 - #17) - [PR #10](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/10), [PR #11](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/11), [PR #12](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/12), [PR #13](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/13), [PR #14](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/14), [PR #15](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/15), [PR #16](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/16), [PR #17](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/17)

### To Do
- [ ] Finish business logic
- [ ] Implement unit and integration tests
- [ ] Implement refresh token functionality
- [ ] Create custom exceptions and improve error handling
- [ ] Add email notifications for order confirmations
- [ ] Optimize database queries for better performance
- [ ] Add caching for frequently accessed data
- [ ] Standardize logging and set up CloudWatch
- [ ] Deployment & CI/CD
- [ ] Deploy backend on AWS (EC2 or EKS)
- [ ] Use AWS RDS for the database
- [ ] Set up a CI/CD pipeline
- [ ] Add Sonar checks for PRs

## Frontend Checklist

### Completed
- [x] Setup React application with TypeScript
- [x] Create static pages/components (#19 - #25) - [PR #19](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/19), [PR #20](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/20), [PR #21](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/21), [PR #22](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/22), [PR #23](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/23), [PR #24](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/24), [PR #25](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/25)
- [x] Create models with same structure like domain models from backend - [PR #26](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/26)
- [x] Implement Router - [PR #27](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/27)
- [x] Implement product listing and details pages - [PR #32](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/17), [PR #33](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/33)
- [x] Implement user authentication flow - [PR #35](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/35)
- [x] Integrate frontend with backend API - [PR #36](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/36)
- [x] Create reusable components (e.g., Input, Select) - [PR #37](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/37)
- [x] Setup state management with React Context - CategoryContext - [PR #37](https://github.com/avdosator/Furniture-Shop-Spring-React-Web-App/pull/37)
- [x] Implement responsiveness for different screen sizes

### To Do
- [ ] Implement shopping cart and order functionality
- [ ] Migrate all forms to react hook forms
- [ ] Add animations and transitions for better UX
- [ ] Improve error handling and user feedback
- [ ] Implement product search and filtering
- [ ] Implement payment integration
- [ ] Deploy the frontend to a static hosting provider

