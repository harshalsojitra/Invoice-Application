package com.example.challenge;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;


@JsonIgnoreProperties(
        value = {"id", "created_at"},
        allowGetters = true
)

@Entity
@Table
public class Invoice {
    public Invoice() {

    }

//    @Id
//    @GeneratedValue(strategy= AUTO)

    @JsonProperty("id")
    @JsonIgnore
    private Long id;

    @JsonProperty("invoice_number")
    @NotNull
    private int invoiceNumber;

    @JsonProperty("total_amount")
    @NotNull
    private int totalAmount;

    @JsonProperty("external_system")
    @NotNull
    private String externalSystem;

    @JsonProperty("net_amount")
    @NotNull
    private int netAmount;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setExternalSystem(int externalSystem) {
        this.externalSystem = String.valueOf(externalSystem);
    }

    public void setNetAmount(int netAmount) {
        this.netAmount = netAmount;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getExternalSystem() {
        return Integer.parseInt(externalSystem);
    }

    public int getNetAmount() {
        return netAmount;
    }

    public Invoice(int invoiceNumber, int totalAmount, String externalSystem, int netAmount) {
        this.invoiceNumber =invoiceNumber;
        this.totalAmount =totalAmount;
        this.externalSystem = String.valueOf(externalSystem);
        this.netAmount =netAmount;
   }

    Invoice(Long id, int invoiceNumber, int totalAmount, String externalSystem, int netAmount) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.totalAmount = totalAmount;
        this.externalSystem = String.valueOf(externalSystem);
        this.netAmount = netAmount;
    }

    @Override
    public String toString() {
        return String.valueOf(id + invoiceNumber + totalAmount + externalSystem + netAmount);
    }
}