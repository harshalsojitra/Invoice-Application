package com.example.challenge;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;


//writing repository task is yet to complete.
@Repository
public interface InvoiceRepository extends  JpaRepository<Invoice, Long> {
    @Query("SELECT i FROM Invoice i WHERE i.invoiceNumber = ?1")
    Page<Invoice> findAllInvoices(String invoiceNumber, Pageable pageable);
}