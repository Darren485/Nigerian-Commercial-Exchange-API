package com.example.niceapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.niceapi.model.Company;
import com.example.niceapi.model.Sector;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findBySector(Sector sector);

}
