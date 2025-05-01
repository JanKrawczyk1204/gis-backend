package com.template.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
public class ShippingDetailsDTO {
    private String firstName;
    private String lastName;
    private String phone;
    private String city;
    private String street;
    @JsonProperty("number")
    private String apartmentNumber;
    @JsonProperty("postCode")
    private String postalCode;
    private boolean isCompany;
    private String companyName;
    private String nip;
}

