package com.example.niceapi.dto.request;

import com.example.niceapi.model.CompanyStatus;
import com.example.niceapi.model.Sector;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDTO {
    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "RC number is required")
    private String rcNumber;

    @NotNull(message = "Sector is required")
    private Sector sector;

    @NotBlank(message = "Sub sector is required")
    private String subSector;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Stock ticker is required")
    private String stockTicker;

    @NotNull(message = "Market cap is required")
    private Double marketCapNGN;

    @NotNull(message = "Status is required")
    private CompanyStatus status;

    @NotBlank(message = "State is required")
    private String state;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
