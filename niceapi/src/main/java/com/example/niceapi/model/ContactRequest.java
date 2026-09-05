package com.example.niceapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact_request")
public class ContactRequest extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "subject", nullable = false)
    private String subject;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "sector", nullable = false)
    private Sector sector; // (OIL_GAS/MINING/MARITIME/FINANCE/REAL_ESTATE/TRADING/IMPORT_EXPORT/GENERAL)

    @Column(name = "category", nullable = false)
    private Category category; // (COMPLAINT/PARTNERSHIP/INQUIRY/SUPPORT)

    @Column(name = "status")
    private ContactStatus status; // (OPEN/IN_PROGRESS/RESOLVED/CLOSED)

}
