package secao13.fixationexercise.entities;

import secao13.fixationexercise.entities.enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private final Client client;
    private final List<OrderItem> items = new ArrayList<>();
    private Date moment = new Date();
    private OrderStatus status;

    public Order(Client client, OrderStatus status) {
        this.client = client;
        this.status = status;
    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        this.getItems().add(item);
    }

    public void removeItem(OrderItem item) {
        this.getItems().remove(item);
    }

    public Double totalValue() {
        return this.getItems().stream().collect(Collectors.summingDouble(orderItem -> orderItem.subTotal()));
    }

    @Override
    public String toString() {
        return "ORDER SUMMARY: \n"
                + "Order moment: " + sdf.format(this.moment) + "\n"
                + "Order status: " + this.status.name() + "\n"
                + "Client: " + this.client + "\n"
                + "Order items: \n "
                + this.items.stream().map(OrderItem::toString).collect(Collectors.joining("\n")) + "\n"
                + "Total price: $" + totalValue();
    }
}
