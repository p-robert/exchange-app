package main.java.com.bank.orders;

import java.math.BigDecimal;
import java.util.Calendar;

public class Order  {

	protected String society;
	protected OrderOperation operation;
	protected int quantity;
	protected BigDecimal price;

    public static final class OrderBuilder {
        protected String society;
        protected OrderOperation operation;
        protected int quantity;
        protected BigDecimal price;

        public static OrderBuilder anOrder() {
            return new OrderBuilder();
        }

        public OrderBuilder withSociety(String society) {
            this.society = society;
            return this;
        }

        public OrderBuilder withOperation(OrderOperation operation) {
            this.operation = operation;
            return this;
        }

        public OrderBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Order build() {
            Order order = new Order();
            order.quantity = this.quantity;
            order.operation = this.operation;
            order.society = this.society;
            order.price = this.price;
            return order;
        }
    }

    public String getSociety() {
        return society;
    }

    public OrderOperation getOperation() {
        return operation;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "society='" + society + '\'' +
                ", operation=" + operation +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
