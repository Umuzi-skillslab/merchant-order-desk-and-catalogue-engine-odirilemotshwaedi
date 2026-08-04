package com.paynest.domain;


import com.paynest.service.OrderService;;

public class ReceiptPrinter {
    
    OrderService service = new OrderService();

     //method to display order details
    public void displayOrderDetails(Order order){

        System.out.println("\t\u001B[1mPayNest");
        System.out.println("-----------------------------------");
        System.out.println("Order Number: " + order.getId());
        System.out.println("Customer Name: " + order.getCustomer().getName());
        System.out.println("Customer Email: *************");
        System.out.println("-----------------------------------");
        System.out.println("\t\u001B[1mOrder Items");
        System.out.println("----------------------------------");
        System.out.println(order.printSummary());
    }

}
