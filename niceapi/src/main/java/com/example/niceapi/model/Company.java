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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRcNumber() {
        return rcNumber;
    }

    public void setRcNumber(String rcNumber) {
        this.rcNumber = rcNumber;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getSubSector() {
        return subSector;
    }

    public void setSubSector(String subSector) {
        this.subSector = subSector;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    public Double getMarketCapNGN() {
        return marketCapNGN;
    }

    public void setMarketCapNGN(Double marketCapNGN) {
        this.marketCapNGN = marketCapNGN;
    }

    public CompanyStatus getStatus() {
        return status;
    }

    public void setStatus(CompanyStatus status) {
        this.status = status;
    }

    public List<Asset> getAssets() {
        return assets;
    }

    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<Transaction> getTransactions2() {
        return transactions2;
    }

    public void setTransactions2(List<Transaction> transactions2) {
        this.transactions2 = transactions2;
    }

}
