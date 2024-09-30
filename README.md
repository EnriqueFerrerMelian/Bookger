# Book Management Application

This is a **Spring Boot** project for managing a collection of books. The application allows users to add, update, view, and delete books.
![bookger](https://github.com/user-attachments/assets/cb793c83-324f-4e8d-991a-f20fb520765e)


## Features

- **CRUD Operations**: Create, Read, Update, and Delete books in an H2 in-memory database.
- **Thymeleaf**: Server-side rendering of HTML pages for the frontend.
- **API Integration**: Fetch book details from the Open Library API by ISBN.
- **H2 Database**: In-memory database for development and testing.
  
## Project Structure

- **Controller**: Handles incoming requests and responses.
- **Model**: Represents the Book entity.
- **Repository**: Manages database interactions.
- **Templates**: HTML files rendered using Thymeleaf.

## How to Run

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/book-management-app.git
   cd book-management-app
2. **Install dependencies:**
   ```bash
   Make sure you have Maven installed. Then, run:
   mvn clean install
3. **Run the application:**
   ```bash
   mvn spring-boot:run

4. **Access the application:**
   ```bash
   Open your browser and navigate to http://localhost:8080.

## Endpoints
* View all books: /
* Add a new book: /addBook

## Technologies Used
* Spring Boot
* Spring Data JPA (for data persistence)
* Thymeleaf (for HTML rendering)
* H2 Database (using externel file)
  
![bookgerdetail](https://github.com/user-attachments/assets/b79d546a-6f27-4a35-998e-04c2e66b7ae3)

File-Based detail

* Maven (for project management)

## Posible Improvements
* Add user authentication and roles (admin/user).
* Implement pagination for large book collections.
* Enhance the UI with CSS frameworks like Bootstrap.
* Add support for external APIs.

## License
This project is licensed under the MIT License.

