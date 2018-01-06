package main.java.com.bank.util;


import main.java.com.bank.orders.Order;
import main.java.com.bank.orders.OrderOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Stream;

public class PrePhasesParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(PrePhasesParser.class);
    /*Map<String, List<String>> result = cities.parallel().collect(Collectors.groupingByConcurrent(City::getState))*/
    private static final Map<String, List<Order>> emotyMap = new HashMap<>();


    public static ConcurrentMap<String, List<Order>> readFromfile(Path path, ConcurrentMap<String,List<Order>> map) {
        try (Stream<String> lines = Files.lines(path)) {
            lines.map(line -> {
                String[] columns = line.split(";");
                String society = columns[0];
                OrderOperation operation = columns[1].equals("B") ? OrderOperation.BUY : OrderOperation.SELL;
                int quantity = Integer.parseInt(columns[2]);
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(columns[3]));

                return new Order.OrderBuilder().withOperation(operation).withPrice(price).withQuantity(quantity)
                        .withSociety(society).build();
            }).forEach(order -> {
                LOGGER.info(order.toString());
                if(map.get(order.getSociety()) != null) {
                    List<Order> list = map.get(order.getSociety());
                    map.put(order.getSociety(), list);
                } else {
                    List<Order> list = new ArrayList<>();
                    list.add(order);
                    map.put(order.getSociety(),list );
                }
            });

        } catch (IOException e) {
            LOGGER.error("Exception occurred when reading from file: ", e);
        }
        return map;
    }
}
