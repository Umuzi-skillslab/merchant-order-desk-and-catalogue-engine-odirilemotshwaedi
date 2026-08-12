package com.paynest;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import com.paynest.domain.Customer;
import com.paynest.domain.Order;
import com.paynest.domain.OrderItem;
import com.paynest.domain.Product;
import com.paynest.service.OrderService;

class OrderValidationAndReceiptTest {
    //Tests if the total amount rounds the total off to the nearest 2 decimal places
    @Test
    void orderItemCalculateTotalRounding() {
        Product product = new Product(1, "Laptop", 11999.999);
        OrderItem item = new OrderItem(product, 1);

        assertEquals(BigDecimal.valueOf(12000).setScale(2, RoundingMode.HALF_UP), item.calculateTotal());
    }
    //Tests for grand total amount of the order
    @Test
    void orderCalculateTotalAmount() {
        Customer customer = new Customer(1, "Jane Doe", "jane@example.com");
        Order order = new Order(1, customer);

        order.addItem(new Product(1, "Phone", BigDecimal.valueOf(8000)), 2);
        order.addItem(new Product(2, "Tablet", BigDecimal.valueOf(2000)), 1);

        assertEquals(new BigDecimal("18000.00"), order.calculateTotalAmount());
    }
    //validation test for zero quantity
    @Test
    void addItemValidationZeroQuantity() {
        Order order = new Order(1, new Customer(1, "Jane Doe", "jane@example.com"));

        assertThrows(IllegalArgumentException.class, () -> order.addItem(new Product(2, "Tablet", 2000), 0));
    }
    //Tests for negative quantities and null items
    @Test
    void addItemNegativeAndNullTest(){
        Order order = new Order(1, new Customer(1, "Jane Doe", "jane@example.com"));

        assertThrows(IllegalArgumentException.class, () -> order.addItem(new Product(2, "X", 10), -5));
        assertThrows(NullPointerException.class, () -> order.addItem(null, 1));
    }
    //Tests of an grand total of 0
    @Test
    void emptyOrderHasZeroTotal() {
        Order order = new Order(1, new Customer(1, "Jane Doe", "jane@example.com"));

        assertEquals(BigDecimal.valueOf(0.00).setScale(2), order.calculateTotalAmount());
        assertTrue(order.getOrderItems().isEmpty());
    }
    //Tests if the expected receipt results will match that of the receipt
    @Test
    void testReceiptRendering() {
        OrderService service = new OrderService();
        Product product1 = new Product(1,"Powerbank", BigDecimal.valueOf(999.999));
        Product product2 = new Product(2,"Notebook",BigDecimal.valueOf(799.999));
        Order order = new Order(1, new Customer(1, "John Doe", "john.doe@example.com"));

        service.addItem(order, product1, 2);
        service.addItem(order, product2, 1);

        StringBuilder receipt = new StringBuilder();
        for (OrderItem item : order.getOrderItems()) {
            receipt.append(item.getProduct().getName()).append(" x").append(item.getQuantity())
            .append(" = ").append(item.calculateTotal().setScale(2, RoundingMode.HALF_UP))
            .append("\n");
        }

        receipt.append("TOTAL = ").append(order.calculateTotalAmount().setScale(2,RoundingMode.HALF_UP));

        String expected =
                "Powerbank x2 = 2000.00\n" +
                "Notebook x1 = 800.00\n" +
                "TOTAL = 2800.00";
        assertEquals(expected, receipt.toString());
    }
}
