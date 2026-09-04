package com.example.niceapi.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
public class Company extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "rc_number")
    private String rcNumber;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "sector")
    private Sector sector;// (OIL_GAS/MINING/MARITIME/FINANCE/REAL_ESTATE/TRADING/IMPORT_EXPORT)

    @Column(name = "sub_sector")
    private String subSector;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "stock_ticker")
    private String stockTicker;

    @Column(name = "market_cap_ngn")
    private Double marketCapNGN;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private CompanyStatus status;// (ACTIVE/SUSPENDED/DELISTED)

    @OneToMany(mappedBy = "company")
    private List<Asset> assets;

    @OneToMany(mappedBy = "buyerCompany")
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "sellerCompany")
    private List<Transaction> transactions2;
}
