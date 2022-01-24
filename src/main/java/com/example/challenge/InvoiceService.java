package com.example.challenge;

import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import java.lang.String;
import java.awt.print.Pageable;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService<invoiceRepository> {
    @Autowired
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public Page<Invoice> getInvoices(String invoiceNumber, String externalSystem, String netAmount, Pageable pageable) {
        if (null != invoiceNumber) {
            return invoiceRepository.findAllInvoices(invoiceNumber, pageable);
        }
//        else if (externalSystem != null) {
//            return invoiceRepository.findByExternalSystem(externalSystem, pageable);
//        } else if (netAmount != null) {
//            return invoiceRepository.findByNetAmount(netAmount, pageable);
//        }
        return null;
    }

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public void addNewInvoice(Invoice invoice) {
        Optional<Invoice> studentOptional = invoiceRepository.findAllInvoices(invoice.getId());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("");
        }
        invoiceRepository.save(invoice);
    }
 }