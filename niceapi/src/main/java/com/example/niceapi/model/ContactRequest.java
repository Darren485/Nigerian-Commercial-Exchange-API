package com.example.niceapi.model;

import java.util.Locale.Category;

public class ContactRequest extends Auditable {
    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String subject;
    private String message;
    private Sector sector; // (OIL_GAS/MINING/MARITIME/FINANCE/REAL_ESTATE/TRADING/IMPORT_EXPORT/GENERAL)
    private Category category; // (COMPLAINT/PARTNERSHIP/INQUIRY/SUPPORT)
    private ContactStatus status; // (OPEN/IN_PROGRESS/RESOLVED/CLOSED)
}
