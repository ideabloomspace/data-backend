package com.data.entry.kendra.model;

import lombok.Data;

import java.util.List;

@Data
public class DataEntryDetails {
    String name;
    String address;
    String city;
    String state;
    String complaintPhoneNumber;
    String officerPhoneNumbers;
    String complaintDetails;

}
