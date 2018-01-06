package main.java.com.bank.prephases;

import main.java.com.bank.orders.Order;
import main.java.com.bank.util.PrePhasesParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class RecordsFileProcessor {
    private CountDownLatch latch;
    private ExecutorService executorService;
    private File[] files;
    private ConcurrentMap<String,List<Order>> mapOfOrders;
    private static final Logger LOGGER = LoggerFactory.getLogger(RecordsFileProcessor.class);

    public RecordsFileProcessor(File folder, int nThreads) {
        this.files = folder.listFiles();
        this.executorService = Executors.newFixedThreadPool(nThreads);
        this.latch = new CountDownLatch(files.length);
        this.mapOfOrders = new ConcurrentHashMap<>();
    }

    public void processFiles() {
        Arrays.stream(this.files).forEach(file -> {
            LOGGER.info("File to be processed: " + file.getName());
            this.executorService.execute(() -> PrePhasesParser.readFromfile(file.toPath(),this.mapOfOrders));
            this.latch.countDown();
        });
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public ConcurrentMap<String, List<Order>> getMapOfOrders() {
        return mapOfOrders;
    }
}
