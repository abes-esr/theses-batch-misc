package fr.abes.theses.batch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Batch {
    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Batch.class, args)));
    }
}
