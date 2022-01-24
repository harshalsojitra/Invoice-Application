package com.example.challenge;

import com.example.challenge.InvoiceRepository;
import com.example.challenge.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="api/v1/invoice")
public class InvoiceController {

    //created dependency on the service class. The reason is clean business logic
    private final InvoiceService invoiceService;
    private InvoiceRepository invoiceRepository;

    @Autowired

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping
    public void InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}