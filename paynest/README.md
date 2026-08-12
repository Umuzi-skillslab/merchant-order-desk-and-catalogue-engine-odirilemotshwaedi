# PayNest

PayNest is an early-stage South African fintech building lightweight commerce tools for small merchants who sell hardware and accessories online and at markets. They cannot afford Shopify-scale subscriptions but still need consistent pricing, order totals, and customer-linked receipts before any payment integration exists.

## Project Overview

PayNest is a fictional platform that allows merchants to:

- Create a product
- Create their customer profile adding their names and email.
- Create orders and add products
- Prints a receipt with a summary of their details, orders and total amounts.


## Prerequisites

- Java 21 (JDK 21)
- Maven 3.6+ (3.9+ recommended)
- Optical: VS Code setup if that your preferred IDE.

## Build and run

```bash
# compile
mvn clean install
mvn compile

# run unit tests
mvn test

# run the application
mvn exec:java

```

Expected output (example):

```
        PayNest
----------------------------------
Order Number: 1
Customer Name: John Doe
Customer Email: *************
----------------------------------
        Order Items
----------------------------------
Laptop x (Qty)1 = R12 000,00
Smartphone x (Qty)2 = R16 000,00
Headphones x (Qty)1 = R1 000,00
----------------------------------
Grand Total: R29 000,00
```

## Unit Tests cover
- OrderItem.calculateTotal
- Order.calculateTotalAmount
- Validation for zero/negative/null products
- Empty order behavior
- Receipt rendering regression check

## Project structure

```
src/main/java/com/paynest/
├── app/        # CLI application entry point (PayNestApplication)
├── domain/     # Core business objects (Product, Customer, OrderItem, Order)
└── service/    # Application services (OrderService, ReceiptPrinter)
```

Notes about recent hygiene changes
- `Product` uses BigDecimal for prices and normalizes to 2 decimal places.
- `OrderItem` is immutable and validates `product != null` and `quantity > 0`.
- `Order` validates non-null `Customer` at construction and non-null `Product` when adding items.
- `ReceiptPrinter` no longer writes directly to System.out; it renders into a provided StringBuilder (`render`) so I/O can be handled at the application boundary.

These changes improve numeric safety (money handling), make domain objects safer to reason about, and separate I/O from domain logic to ease testing and future integrations.
