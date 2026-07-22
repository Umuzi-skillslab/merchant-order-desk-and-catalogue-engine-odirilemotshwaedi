# PayNest

PayNest is an early-stage South African fintech building lightweight commerce tools for small
merchants who sell hardware and accessories online and at markets. They cannot afford
Shopify-scale subscriptions but still need consistent pricing, order totals, and customer-linked receipts before any payment integration exists.

## Project Overview

PayNest is a fictional platform that allows merchants to:

- Create a product
- Create their customer profile adding their names and email.
- Create orders and add products
- Prints a receipt with a summary of their details, orders and total amounts.

## Company Background

PayNest is a early stage South African fintech company providing a simplified commerce backend. The platform enables merchants to manage their orders, supplies them with totals of those orders and provides them with a receipt as proof.

## How to Run the Project

### Prerequisites

- Java 21
- Maven 3.6+

### Build and Run

```bash
# Compile the project
mvn compile

# Run unit tests
mvn test

# Run the application
mvn exec:java
```

Alternatively:

```bash
mvn compile exec:java -Dexec.mainClass="com.paynestsystem.app.PayNestApplication"
```

### Expected Output

```
        PayNest
-----------------------------------
Order Number: 1
Customer Name: John Doe
Customer Email: *************
-----------------------------------
        Order Items
-----------------------------------
Laptop x 1 = R12000.0
Smartphone x 2 = R16000.0
Headphones x 1 = R1000.0
-----------------------------------
Total Amount For 4 Items: R29000.0
-----------------------------------
Thank You For Shopping With Us 
    Go to www.paynest.co.za 
       Tel: 012 559 0509
```

## Project Structure

```
src/main/java/com/paynest/
├──main
      ├──java
            ├──app/         # CLI application entry point (PayNestApplication)
            └── domain/     # Core business objects (Product, Customer, OrderItem, Order)

```
