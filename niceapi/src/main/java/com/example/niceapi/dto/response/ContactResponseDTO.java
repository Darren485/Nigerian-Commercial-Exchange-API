package com.example.niceapi.dto.response;

import com.example.niceapi.model.Category;
import com.example.niceapi.model.ContactStatus;
import com.example.niceapi.model.Sector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String company;
    private ContactStatus status;
    private Category category;
    private Sector sector;
}
