package com.example.niceapi.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.niceapi.dto.request.TransactionRequestDTO;
import com.example.niceapi.dto.response.TransactionResponseDTO;
import com.example.niceapi.model.Asset;
import com.example.niceapi.model.Company;
import com.example.niceapi.model.Transaction;
import com.example.niceapi.repository.AssetRepository;
import com.example.niceapi.repository.CompanyRepository;
import com.example.niceapi.repository.TransactionRepository;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CompanyRepository companyRepository;
    private final AssetRepository assetRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, CompanyRepository companyRepository, AssetRepository assetRepository) {
        this.transactionRepository = transactionRepository;
        this.companyRepository = companyRepository;
        this.assetRepository = assetRepository;
    }

    public List<TransactionResponseDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(transaction -> new TransactionResponseDTO(
                        transaction.getId(),
                        transaction.getTransactionCode(),
                        transaction.getTransactionType(),
                        transaction.getSector(),
                        transaction.getAmountNGN(),
                        transaction.getAmountUSD(),
                        transaction.getCurrency(),
                        transaction.getStatus(),
                        transaction.getTradeDate(),
                        transaction.getSettlementDate()))
                .collect(Collectors.toList());
    }

    public Optional<TransactionResponseDTO> getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        return Optional.of(new TransactionResponseDTO(
                transaction.getId(),
                transaction.getTransactionCode(),
                transaction.getTransactionType(),
                transaction.getSector(),
                transaction.getAmountNGN(),
                transaction.getAmountUSD(),
                transaction.getCurrency(),
                transaction.getStatus(),
                transaction.getTradeDate(),
                transaction.getSettlementDate()));
    }

    public TransactionResponseDTO createTransaction(TransactionRequestDTO request) {
        Transaction transaction = new Transaction();
        transaction.setTransactionCode(request.getTransactionCode());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setSector(request.getSector());
        transaction.setAmountNGN(request.getAmountNGN());
        transaction.setAmountUSD(request.getAmountUSD());
        transaction.setCurrency(request.getCurrency());
        transaction.setStatus(request.getStatus());
        transaction.setTradeDate(request.getTradeDate().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime());
        transaction.setSettlementDate(request.getSettlementDate().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime());

        Company buyerCompany = companyRepository.findById(request.getBuyerCompanyId())
                .orElseThrow(() -> new RuntimeException("Buyer company not found with id: " + request.getBuyerCompanyId()));
        transaction.setBuyerCompany(buyerCompany);

        Company sellerCompany = companyRepository.findById(request.getSellerCompanyId())
                .orElseThrow(() -> new RuntimeException("Seller company not found with id: " + request.getSellerCompanyId()));
        transaction.setSellerCompany(sellerCompany);

        Asset asset = assetRepository.findById(request.getAssetId())
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + request.getAssetId()));
        transaction.setAsset(asset);

        Transaction savedTransaction = transactionRepository.save(transaction);
        return new TransactionResponseDTO(
                savedTransaction.getId(),
                savedTransaction.getTransactionCode(),
                savedTransaction.getTransactionType(),
                savedTransaction.getSector(),
                savedTransaction.getAmountNGN(),
                savedTransaction.getAmountUSD(),
                savedTransaction.getCurrency(),
                savedTransaction.getStatus(),
                savedTransaction.getTradeDate(),
                savedTransaction.getSettlementDate());
    }

    public TransactionResponseDTO updateTransaction(Long id, TransactionRequestDTO request) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));
        
        transaction.setTransactionCode(request.getTransactionCode());
        transaction.setTransactionType(request.getTransactionType());
        transaction.setSector(request.getSector());
        transaction.setAmountNGN(request.getAmountNGN());
        transaction.setAmountUSD(request.getAmountUSD());
        transaction.setCurrency(request.getCurrency());
        transaction.setStatus(request.getStatus());
        transaction.setTradeDate(request.getTradeDate().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime());
        transaction.setSettlementDate(request.getSettlementDate().atStartOfDay(ZoneId.systemDefault()).toLocalDateTime());

        Company buyerCompany = companyRepository.findById(request.getBuyerCompanyId())
                .orElseThrow(() -> new RuntimeException("Buyer company not found with id: " + request.getBuyerCompanyId()));
        transaction.setBuyerCompany(buyerCompany);

        Company sellerCompany = companyRepository.findById(request.getSellerCompanyId())
                .orElseThrow(() -> new RuntimeException("Seller company not found with id: " + request.getSellerCompanyId()));
        transaction.setSellerCompany(sellerCompany);

        Asset asset = assetRepository.findById(request.getAssetId())
                .orElseThrow(() -> new RuntimeException("Asset not found with id: " + request.getAssetId()));
        transaction.setAsset(asset);

        Transaction savedTransaction = transactionRepository.save(transaction);
        return new TransactionResponseDTO(
                savedTransaction.getId(),
                savedTransaction.getTransactionCode(),
                savedTransaction.getTransactionType(),
                savedTransaction.getSector(),
                savedTransaction.getAmountNGN(),
                savedTransaction.getAmountUSD(),
                savedTransaction.getCurrency(),
                savedTransaction.getStatus(),
                savedTransaction.getTradeDate(),
                savedTransaction.getSettlementDate());
    }

    public void deleteTransaction(Long id){
        if(!transactionRepository.existsById(id)){
            throw new RuntimeException("Transaction not found with id: " + id);
        }
        transactionRepository.deleteById(id);
    }
}
