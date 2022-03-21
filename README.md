AYROTEK CHALLENGE


This project helps you to calculate the prices of product with appropriate tax rate.

Description
In order to work with this program, first user needs to add the tax rates alongside with matching product categories. Then
using user-product microservice, users can calculate product prices with tax easily by add product with name, price, category 
information.

Getting Started
Dependencies
Gradle
Spring Boot
MapStruct
Lombok
Postgresql
MongoDb
OpenApi

Installing & Running
Before start working with the code users needs to 
1. Clean and build their gradles first.

MongoDb
database: "taxcalculationdb"
username: ayrotax
password: ayrotek123!

PostgreSql
url: jdbc:postgresql://localhost:5432/userproductdb
username: postgres
password: root

2. Databases and user information needs to be created according to given information. This is not a necessity you can change these
information from application.yml files.

3. Start both services and connect them through http://localhost:8080/swagger-ui/index.html and http://localhost:8081/swagger-ui/index.html


Authors
Yusuf Burak Gunes
