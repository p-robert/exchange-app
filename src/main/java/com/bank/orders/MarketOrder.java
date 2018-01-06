package main.java.com.bank.orders;

import java.math.BigDecimal;
import java.util.Calendar;

public class MarketOrder extends  Order{

    private Calendar calendar;

    public static final class MarketOrderBuilder {
        protected String society;
        protected OrderOperation operation;
        protected int quantity;
        protected BigDecimal price;
        private Calendar calendar;

        private MarketOrderBuilder() {
        }

        public static MarketOrderBuilder aMarketOrder() {
            return new MarketOrderBuilder();
        }

        public MarketOrderBuilder withCalendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public MarketOrderBuilder withSociety(String society) {
            this.society = society;
            return this;
        }

        public MarketOrderBuilder withOperation(OrderOperation operation) {
            this.operation = operation;
            return this;
        }

        public MarketOrderBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public MarketOrderBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public MarketOrder build() {
            MarketOrder marketOrder = new MarketOrder();
            marketOrder.quantity = this.quantity;
            marketOrder.operation = this.operation;
            marketOrder.society = this.society;
            marketOrder.calendar = this.calendar;
            marketOrder.price = this.price;
            return marketOrder;
        }
    }
}
