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
mvn clean compile exec:java
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
----------------------------------
Laptop x (Qty)1 = R12 000,00
Smartphone x (Qty)2 = R16 000,00
Headphones x (Qty)1 = R1 000,00
----------------------------------
Grand Total: R29 000,00
```

## Project Structure

```
src\main\java\com\paynest\
├──app\         # CLI application entry point (PayNestApplication)
├──domain\    # Core business objects (Product, Customer, OrderItem, Order, ReceiptPrinter)
└──Service\     #OrderService
```
