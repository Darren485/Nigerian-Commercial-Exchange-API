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
    private String name;
    private String registrationNumber;
    private Sector sector;
    private String address;
    private String city;
    private String state;
    private String country;
    private Double marketCap;
    private CompanyStatus status;
}
