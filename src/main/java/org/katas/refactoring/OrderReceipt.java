package org.katas.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder outputMessage = new StringBuilder();

        outputMessage.append("======Printing Orders======\n");

        outputMessage.append(order.getCustomerName());
        outputMessage.append(order.getCustomerAddress());

        double totalSalesPrice= 0d;
        double totalPrice = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            outputMessage.append(lineItem.getDescription());
            outputMessage.append('\t');
            outputMessage.append(lineItem.getPrice());
            outputMessage.append('\t');
            outputMessage.append(lineItem.getQuantity());
            outputMessage.append('\t');
            outputMessage.append(lineItem.totalAmount());
            outputMessage.append('\n');

            double salesTax = lineItem.totalAmount() * .10;
            totalSalesPrice += salesTax;

            totalPrice += lineItem.totalAmount() + salesTax;
        }

        outputMessage.append("Sales Tax").append('\t').append(totalSalesPrice);

        outputMessage.append("Total Amount").append('\t').append(totalPrice);
        return outputMessage.toString();
    }
}