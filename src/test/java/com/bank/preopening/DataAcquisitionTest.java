package test.java.com.bank.preopening;

import main.java.com.bank.prephases.RecordsFileProcessor;
import org.junit.Test;

import java.io.File;

public class DataAcquisitionTest {

    @Test
    public void testFileProcess() throws InterruptedException {
        RecordsFileProcessor dataAcquisition = new RecordsFileProcessor(new File("D:\\Exchange practical seminar\\preopening"), 4);
        dataAcquisition.processFiles();
        dataAcquisition.getLatch().await();

        System.out.println("Map size:");
        StringBuilder sb = new StringBuilder("{");
        dataAcquisition.getMapOfOrders().forEach((key,value) -> {
            sb.append(key).append(" = ").append(" [");
            value.stream().forEach(order -> sb.append(order + ", "));
            sb.append(" ] ");
        });
        sb.append("}");
        System.out.println(sb.toString());

    }
}
