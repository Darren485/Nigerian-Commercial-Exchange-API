package com.example.niceapi.dto.response;

import com.example.niceapi.model.Currency;
import com.example.niceapi.model.Sector;
import com.example.niceapi.model.TransactionStatus;
import com.example.niceapi.model.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {
    private Long id;
    private String referenceNumber;
    private TransactionType transactionType;
    private Sector sector;
    private Double amount;
    private Double fees;
    private Currency currency;
    private TransactionStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
