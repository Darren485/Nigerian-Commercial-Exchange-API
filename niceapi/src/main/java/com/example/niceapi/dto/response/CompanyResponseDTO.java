package com.example.niceapi.dto.response;

import com.example.niceapi.model.CompanyStatus;
import com.example.niceapi.model.Sector;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyResponseDTO {

    private Long id;
    private String companyName;
    private String rcNumeber;
    private Sector sector;
    private String subSector;
    private String state;
    private String country;
    private String stockTicker;
    private Double marketCapNGN;
    private CompanyStatus status;
}
