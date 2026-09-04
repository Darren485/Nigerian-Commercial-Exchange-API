package com.example.niceapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "assets")
public class Asset extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_type")
    private AssetType assetType;// (STOCK/BOND/VESSEL/MINE/OIL_WELL/PROPERTY/COMMODITY/WAREHOUSE)

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "current_value_ngn")
    private Double currentValueNGN;

    @Column(name = "current_value_usd")
    private Double currentValueUSD;

    @Column(name = "unit")
    private Double unit;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status")
    private AssetStatus status;// (ACTIVE/INACTIVE/UNDER_REVIEW)

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "asset")
    private List<Transaction> transactions;
}
