package com.example.challenge;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class InvoiceConfig {
    @Bean
    CommandLineRunner commandLineRunner(InvoiceRepository repository) {
        return args -> {
            Invoice invoice1 = new Invoice(
                    123L,
                    123,
                    123,
                    "System1",
                    456

            );

            Invoice invoice2 = new Invoice(

                    123L,
                    123,
                    123,
                    "System1",
                    456
            );

            repository.saveAll(
                    List.of(invoice1, invoice2)
            );
        };
    }
}