package com.example.niceapi.dto.response;

import java.time.LocalDateTime;

import com.example.niceapi.model.Currency;
import com.example.niceapi.model.Sector;
import com.example.niceapi.model.TransactionStatus;
import com.example.niceapi.model.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    private Long id;
    private String transactionCode;
    private TransactionType transactionType;
    private Sector sector;
    private Double amountNGN;
    private Double amountUSD;
    private Currency currency;
    private TransactionStatus status;
    private LocalDateTime tradeDate;
    private LocalDateTime settlementDate;

}
