package com.AddressBookApp;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressBookDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "City is mandatory")
    private String city;
}
