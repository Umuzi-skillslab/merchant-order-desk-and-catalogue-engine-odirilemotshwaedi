package com.paynest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.paynest.domain.Customer;
import com.paynest.domain.Product;
import com.paynest.service.ReceiptService;
import com.paynest.domain.Order;
public class ReceiptTest {
     
    //Tests for the order summary display
    //Test if the expected output is the same.
    @Test
    void renderReceiptWithItems(){Customer customer = new Customer(1, "Jane Doe", "jane@example.com");
    Order order = new Order(1, customer);

    order.addItem(new Product(1, "Phone", BigDecimal.valueOf(8000)), 2);
    order.addItem(new Product(2, "Tablet", BigDecimal.valueOf(2000)), 1);

    ReceiptService receiptService = new ReceiptService();
    String receipt = receiptService.render(order);

    String expected =
            "\t\u001B[1mPayNest\n" +
            "----------------------------------\n" +
            "Order Number: 1\n" +
            "Customer Name: Jane Doe\n" +
            "Customer Email: jane@example.com\n" +
            "----------------------------------\n" +
            "\t\u001B[1mOrder Items\n" +
            "----------------------------------\n" +
            "Phone x (Qty)2 = R16 000,00\n" +
            "Tablet x (Qty)1 = R2 000,00\n" +
            "----------------------------------\n" +
            "Grand Total: R18 000,00";

    assertEquals(expected, receipt);
    }

    //Throws an error if an order is null
    @Test
    void renderThrowsOnNullOrder() {
        ReceiptService receiptService = new ReceiptService();
        IllegalArgumentException nullReceipt = assertThrows(IllegalArgumentException.class,
                () -> receiptService.render(null));
        assertEquals("Cannot render receipt for null order", nullReceipt.getMessage());
    }

    //Thows an error is there is not customer information entered
    @Test
    void renderThrowsOnNullCustomer() {
        Order order = new Order(4, null);

        ReceiptService receiptService = new ReceiptService();
        IllegalArgumentException nullReceipt = assertThrows(IllegalArgumentException.class,
                () -> receiptService.render(order));
        assertEquals("Order must have a customer", nullReceipt.getMessage());
    }
}
