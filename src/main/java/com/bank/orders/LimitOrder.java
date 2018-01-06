package main.java.com.bank.orders;

import java.math.BigDecimal;
import java.util.Calendar;

public class LimitOrder extends Order {

    private Calendar calendar;

    public static final class LimitOrderBuilder {
        protected String society;
        protected OrderOperation operation;
        protected int quantity;
        protected BigDecimal price;
        private Calendar calendar;

        private LimitOrderBuilder() {
        }

        public static LimitOrderBuilder aLimitOrder() {
            return new LimitOrderBuilder();
        }

        public LimitOrderBuilder withCalendar(Calendar calendar) {
            this.calendar = calendar;
            return this;
        }

        public LimitOrderBuilder withSociety(String society) {
            this.society = society;
            return this;
        }

        public LimitOrderBuilder withOperation(OrderOperation operation) {
            this.operation = operation;
            return this;
        }

        public LimitOrderBuilder withQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public LimitOrderBuilder withPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public LimitOrder build() {
            LimitOrder limitOrder = new LimitOrder();
            limitOrder.quantity = this.quantity;
            limitOrder.operation = this.operation;
            limitOrder.society = this.society;
            limitOrder.calendar = this.calendar;
            limitOrder.price = this.price;
            return limitOrder;
        }
    }
}
