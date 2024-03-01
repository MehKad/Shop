# Shopping Website Project

This project is a simple e-commerce website built using Java servlets, Apache Tomcat, Apache Maven, and MySQL. Users can log in, navigate through available items, add them to their cart, and view their cart's summary.

## Table of Contents

- [Installation](#installation)
  - [Prerequisites](#prerequisites)
  - [Steps](#steps)
- [Usage](#usage)
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Contributing](#contributing)

## Installation

### Prerequisites

- Java Development Kit (JDK)
- Apache Tomcat
- Apache Maven
- MySQL Server (Preferably, WAMP)
- MySQL Workbench or phpMyAdmin

### Steps

1. Clone or download the project repository.
2. Run the provided SQL script `src/main/java/config/conf.sql` in your MySQL database using MySQL Workbench or phpMyAdmin to create the necessary database schema and insert dummy data.
3. Open a terminal and navigate to the project directory.
4. Run the following Maven command to build the project:

```
mvn install -f "/Directory/of/pom.xml"
```

5. After successfully building the project, deploy the generated WAR file located in the target folder (`shop.war`) to your Apache Tomcat server. You can do this by deploying it via the Tomcat Manager web interface.
6. Start or restart your Apache Tomcat server.
7. Open a web browser and navigate to `http://localhost:9090/shop/` (by default, 8080 is the tomcat port) to access the shopping website.

## Usage

1. **User Authentication**: Users can log in with their username and password. If they don't have an account, they can register for one.
2. **Home Page**: After logging in, users are directed to the home page where they can view available items.
3. **Item Details**: Users can view details of each item, including its name, description, and price.
4. **Adding Items to Cart**: Users can add items to their cart by clicking the "Add to Cart" button.
5. **Viewing Cart**: Users can view their cart summary by clicking the "View Cart" button. The cart summary includes a list of items in the cart and the total price.
6. **Checkout**: Users can proceed to checkout by clicking the "Checkout" button. This feature is under development.

## Technologies Used

- Java
- Java Servlets
- Apache Tomcat
- Apache Maven
- MySQL

## Project Structure

The project follows a standard Maven project structure:

- `src/main/java`: Contains Java source files.
- `src/main/webapp`: Contains web resources such as HTML, JSP, CSS, and JavaScript files.
- `pom.xml`: Maven project configuration file.

## Contributing

Contributions are welcome! Feel free to submit bug reports, feature requests, or pull requests.
