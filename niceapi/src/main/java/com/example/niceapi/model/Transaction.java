package com.example.niceapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transactions")
public class Transaction extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "transaction_code")
    private String transactionCode;

    @Column(name = "transaction_type")
    private TransactionType transactionType;// (BUY/SELL/LEASE/CHARTER/EXPORT/IMPORT/MORTGAGE/SWAP)

    @Column(name = "sector")
    private Sector sector;// (OIL_GAS/MINING/MARITIME/FINANCE/REAL_ESTATE/TRADING/IMPORT_EXPORT)

    @Column(name = "amount_ngn")
    private Double amountNGN;

    @Column(name = "amount_usd")
    private Double amountUSD;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "currency")
    private Currency currency;// (NGN/USD/GBP/EUR)

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private TransactionStatus status;// (PENDING/ACTIVE/SETTLED/CANCELLED/DISPUTE)

    @Column(name = "trade_date")
    private LocalDateTime tradeDate;

    @Column(name = "settlement_date")
    private LocalDateTime settlementDate;

    // As buyer
    @ManyToOne
    @JoinColumn(name = "buyer_company_id")
    private Company buyerCompany;

    // As seller
    @ManyToOne
    @JoinColumn(name = "seller_company_id")
    private Company sellerCompany;

    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;
}
