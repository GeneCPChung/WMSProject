package practice;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

@Service
@SpringBootApplication
@ComponentScan({"ItemPopulator", "InventoryItemRepository", "IMSController"})
public class ImsApp {

    public static void main(String[] args) {
        SpringApplication.run(ImsApp.class, args);

    }

}