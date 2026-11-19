# PayNest

A lightweight Java-based commerce and payment simulation system for small businesses in South Africa.

PayNest is an early-stage South African fintech project exploring accessible commerce tools for small merchants. Built with Java, the application demonstrates core e-commerce functionality, including product catalogue management, customer orders, receipt generation, and simulated payment processing.

The project focuses on clean object-oriented design, reliable monetary calculations, and extensible payment processing through interchangeable payment methods.

## Features

- Product Catalogue Management – Maintain an in-memory product catalogue with lookups by product ID or product name.
- Order Management – Create customer orders and add products with validated quantities.
- Accurate Monetary Calculations – Use Java's BigDecimal to calculate item prices and order totals without floating-point precision errors.
- Receipt Generation – Generate formatted receipts with South African Rand (ZAR) currency formatting.
- Flexible Payment Processing – Support interchangeable simulated payment methods:
  - Card
  - Electronic Funds Transfer (EFT)
  - PayPal
  - Digital Wallet
- Input Validation – Validate products and order quantities to help maintain data consistency.
- Extensible Architecture – Use interfaces and service classes to separate business logic and simplify future enhancements.

Important: Payment processing is simulated. The application prints payment results to the console and does not connect to external payment providers, process actual transactions, or transfer money.

## Requirements

- JDK 21
- Maven 3.9 or later

## Getting Started

```bash
# Clone the repository

git clone https://github.com/Umuzi-skillslab/merchant-order-desk-and-catalogue-engine-odirilemotshwaedi.git

# Compile the application

mvn compile

# Start the application

mvn exec:java
```

The sample application creates a catalogue, builds an order for a customer, prints its receipt, and checks out using the simulated PayPal implementation.

### Example output

The receipt headings may appear in bold in terminals that support ANSI formatting.

```text
        PayNest
----------------------------------------
Order Number: 1
Customer Name: John Doe
Customer Email: john.doe@example.com
----------------------------------------
        Order Items
----------------------------------------
Laptop x (Qty)1 = R12 000,00
Smartphone x (Qty)2 = R16 000,00
Headphones x (Qty)1 = R1 000,00
----------------------------------------
Grand Total: R29 000,00
----------------------------------------
        Payment
----------------------------------------
Processing PayPal payment for R29 000,00
Payment successful via PAYPAL
Amount: R29 000,00
Order #1 completed successfully via PAYPAL
```

## Project structure

```text
PayNest/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/paynest/
│   │           ├── app/
│   │           │   └── PayNestApplication.java
│   │           │
│   │           ├── domain/
│   │           │   ├── Product.java
│   │           │   ├── Customer.java
│   │           │   ├── Order.java
│   │           │   └── OrderItem.java
│   │           │
│   │           ├── payment/
│   │           │   ├── PaymentMethod.java
│   │           │   ├── PaymentProcessor.java
│   │           │   ├── CardPayment.java
│   │           │   ├── WalletPayment.java
│   │           │   ├── PayPalPayment.java
│   │           │   ├── EftPayment.java
│   │           │   └── CurrencyFormatter.java
│   │           │
│   │           └── service/
│   │               ├── CatalogueService.java
│   │               ├── OrderService.java
│   │               └── ReceiptService.java
│   │
│   └── test/
│       └── java/
│           └── com/paynest/
│               ├── payment/
│               │   └── TestPaymentMethod.java
│               │
│               └── service/
│                   ├── OrderValidationAndReceiptTest.java
│                   ├── PaymentMethodTest.java
│                   └── ReceiptTest.java
│
├── pom.xml
└── README.md
```

## Design notes

- Product prices and order totals use BigDecimal to avoid floating-point money calculations.
- Order items validate that products are present and quantities are positive.
- The catalogue validates products and returns Optional for lookups that may not find a match.
- Receipt rendering returns a string; the application is responsible for printing it.
- Payment implementations share the PaymentMethod interface. This allows checkout to work with any payment rail through polymorphism rather than relying on a large method containing conditional logic for every payment type.
- Checkout depends on the PaymentMethod abstraction rather than concrete payment classes, reducing coupling and making the payment flow easier to maintain.
- New payment methods can be added without changing checkout logic because checkout depends on the PaymentMethod interface.
- To add a new payment rail, create a class that implements PaymentMethod and wire that implementation into PayNestApplication.

## Testing
PayNest includes automated tests that verify order validation, receipt generation, payment-method polymorphism, and checkout behavior.

```bash
# Run the complete test suite using:
mvn test
```