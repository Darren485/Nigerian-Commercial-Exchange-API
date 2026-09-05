package com.example.niceapi.dto.request;

import java.time.LocalDate;

import com.example.niceapi.model.Company;
import com.example.niceapi.model.Currency;
import com.example.niceapi.model.Sector;
import com.example.niceapi.model.TransactionStatus;
import com.example.niceapi.model.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TransactionRequestDTO {
    @NotNull(message = "Transaction ID is required")
    private Long id;

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
}
