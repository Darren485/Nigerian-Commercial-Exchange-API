package com.example.niceapi.dto.request;

import java.time.LocalDate;

import com.example.niceapi.model.Currency;
import com.example.niceapi.model.Sector;
import com.example.niceapi.model.TransactionStatus;
import com.example.niceapi.model.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

public class TransactionRequestDTO {
    @NotBlank(message = "Transaction code is required")
    private String transactionCode;

    @NotNull(message = "Transaction type is required")
    private TransactionType transactionType;

    @NotNull(message = "Sector is required")
    private Sector sector;

    @NotNull(message = "Buyer company ID is required")
    private Long buyerCompanyId;

    @NotNull(message = "Seller company ID is required")
    private Long sellerCompanyId;

    @NotNull(message = "Asset ID is required")
    private Long assetId;

    @NotNull(message = "Amount NGN is required")
    private Double amountNGN;

    @NotNull(message = "Amount USD is required")
    private Double amountUSD;

    @NotNull(message = "Currency is required")
    private Currency currency;

    @NotNull(message = "Status is required")
    private TransactionStatus status;

    @NotNull(message = "Trade date is required")
    private LocalDate tradeDate;

    @NotNull(message = "Settlement date is required")
    private LocalDate settlementDate;

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Long getBuyerCompanyId() {
        return buyerCompanyId;
    }

    public void setBuyerCompanyId(Long buyerCompanyId) {
        this.buyerCompanyId = buyerCompanyId;
    }

    public Long getSellerCompanyId() {
        return sellerCompanyId;
    }

    public void setSellerCompanyId(Long sellerCompanyId) {
        this.sellerCompanyId = sellerCompanyId;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public Double getAmountNGN() {
        return amountNGN;
    }

    public void setAmountNGN(Double amountNGN) {
        this.amountNGN = amountNGN;
    }

    public Double getAmountUSD() {
        return amountUSD;
    }

    public void setAmountUSD(Double amountUSD) {
        this.amountUSD = amountUSD;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public LocalDate getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(LocalDate tradeDate) {
        this.tradeDate = tradeDate;
    }

    public LocalDate getSettlementDate() {
        return settlementDate;
    }

    public void setSettlementDate(LocalDate settlementDate) {
        this.settlementDate = settlementDate;
    }

}
