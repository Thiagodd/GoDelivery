# GoDelivery

## Introduction
The GoDelivery for food delivery is a RestFul API for managing food orders. It includes endpoints for managing restaurants, menus, orders, and deliveries, allowing users to create, modify, and delete orders and make payments. Additionally, the API includes features for searching restaurants and menus and detailed documentation of available endpoints.

## Project Installation Basics
To install the project, follow these steps:

1. Clone this repository: `git clone git@github.com:Thiagodd/GoDelivery.git`
2. Make sure you have MySQL installed and running on your machine.
3. Configure the database access information in the `application.properties file`.
4. Run the application: `./mvnw spring-boot:run`

## Setting up Development Environment
To set up the development environment, you will need:

* JDK 8 or higher
* IDE of your choice (Eclipse, IntelliJ, etc.)

## Building
To build the project, run the following command:

```bash
./mvnw clean build
```

This will compile the code and generate the JAR file in the target/ directory.

## Packaging and Installation
To package and install the application, run the following command:

```bash
./mvnw clean install
```

This will compile the code, generate the JAR file, and install it in your local Maven repository.

## Notes
* Make sure that MySQL is running and that the database access information is correct in the application.properties file.
* You can change the default port on which the application is running by editing the application.properties file.
* Please note that the code available in this repository is still in development and may contain bugs or security vulnerabilities. Use it at your own risk. Additionally, this project may undergo significant changes in the future, so please check this README frequently for updated information.

## How to Contribute
If you want to contribute to the development of the application, follow these steps:

1. Fork this repository.
2. Create a branch for your feature or bug fix: `git checkout -b my-feature-or-fix`
3. Make the necessary changes and commit: `git commit -am 'Adding new feature'`
4. Push the changes to your fork: `git push origin my-feature-or-fix`
5. Create a Pull Request to the original repository.

Thank you for contributing!