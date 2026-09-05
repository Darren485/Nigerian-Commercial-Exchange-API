package com.example.niceapi.dto.request;

import com.example.niceapi.model.CompanyStatus;
import com.example.niceapi.model.Sector;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyRequestDTO {
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Company name is required")
    private String companyName;

    @NotBlank(message = "RC name is required")
    private String rcName;

    @NotNull(message = "Sector is required")
    private Sector sector;

    @NotBlank(message = "Sub sector is required")
    private String subSector;

    @NotBlank(message = "Date is required")
    private String date;

    @NotBlank(message = "Country is required")
    private String country;

    @NotBlank(message = "Stock ticker is required")
    private String stockTicker;

    @NotNull(message = "Market cap is required")
    private Double marketCapNGN;

    @NotNull(message = "Status is required")
    private CompanyStatus status;
}
