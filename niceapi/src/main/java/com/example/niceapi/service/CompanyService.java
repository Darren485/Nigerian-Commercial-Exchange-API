package com.example.niceapi.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.niceapi.dto.request.CompanyRequestDTO;
import com.example.niceapi.dto.response.CompanyResponseDTO;
import com.example.niceapi.model.Company;
import com.example.niceapi.repository.CompanyRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyResponseDTO> getAllCompanies() {
        return companyRepository.findAll().stream()
                .map(company -> new CompanyResponseDTO(
                        company.getId(),
                        company.getCompanyName(),
                        company.getRcNumber(),
                        company.getSector(),
                        company.getSubSector(),
                        company.getState(),
                        company.getCountry(),
                        company.getStockTicker(),
                        company.getMarketCapNGN(),
                        company.getStatus()))
                .collect(Collectors.toList());
    }

    public Optional<CompanyResponseDTO> getCompanyById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        return Optional.of(new CompanyResponseDTO(
                company.getId(),
                company.getCompanyName(),
                company.getRcNumber(),
                company.getSector(),
                company.getSubSector(),
                company.getState(),
                company.getCountry(),
                company.getStockTicker(),
                company.getMarketCapNGN(),
                company.getStatus()));
    }

    public CompanyResponseDTO createCompany(CompanyRequestDTO request) {
        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setRcNumber(request.getRcName());
        company.setSector(request.getSector());
        company.setSubSector(request.getSubSector());
        company.setState(request.getDate());
        company.setCountry(request.getCountry());
        company.setStockTicker(request.getStockTicker());
        company.setMarketCapNGN(request.getMarketCapNGN());
        company.setStatus(request.getStatus());

        Company savedCompany = companyRepository.save(company);
        return new CompanyResponseDTO(
                savedCompany.getId(),
                savedCompany.getCompanyName(),
                savedCompany.getRcNumber(),
                savedCompany.getSector(),
                savedCompany.getSubSector(),
                savedCompany.getState(),
                savedCompany.getCountry(),
                savedCompany.getStockTicker(),
                savedCompany.getMarketCapNGN(),
                savedCompany.getStatus());
    }

    public CompanyResponseDTO updateCompany(Long id, CompanyRequestDTO request) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found with id: " + id));

        company.setCompanyName(request.getCompanyName());
        company.setRcNumber(request.getRcName());
        company.setSector(request.getSector());
        company.setSubSector(request.getSubSector());
        company.setState(request.getDate());
        company.setCountry(request.getCountry());
        company.setStockTicker(request.getStockTicker());
        company.setMarketCapNGN(request.getMarketCapNGN());
        company.setStatus(request.getStatus());

        Company savedCompany = companyRepository.save(company);
        return new CompanyResponseDTO(
                savedCompany.getId(),
                savedCompany.getCompanyName(),
                savedCompany.getRcNumber(),
                savedCompany.getSector(),
                savedCompany.getSubSector(),
                savedCompany.getState(),
                savedCompany.getCountry(),
                savedCompany.getStockTicker(),
                savedCompany.getMarketCapNGN(),
                savedCompany.getStatus());
    }

    public void deleteCompany(Long id) {
        if (!companyRepository.existsById(id)) {
            throw new RuntimeException("Company not found with id: " + id);
        }
        companyRepository.deleteById(id);
    }

    public List<CompanyResponseDTO> findBySector(String query){
        List<Company> companies = companyRepository.findBySector(query);
        if(companies.isEmpty()){
            throw new RuntimeException("No companies found for sector: " + query);
        }
        return companies.stream()
            .map(m -> new CompanyResponseDTO(
                m.getId(),
                m.getCompanyName(),
                m.getRcNumber(),
                m.getSector(),
                m.getSubSector(),
                m.getState(),
                m.getCountry(),
                m.getStockTicker(),
                m.getMarketCapNGN(),
                m.getStatus()))
            .collect(Collectors.toList());
    }
}
