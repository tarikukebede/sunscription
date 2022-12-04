package com.tarikukebede.sunscription.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInDto {
    private double balance;
    @NotEmpty(message = "{address.required}")
    private String addressOne;
    @NotEmpty(message = "{address.required}")
    private String addressTwo;
    @NotEmpty(message = "{postal.required}")
    private String postalCode;
    @NotEmpty(message = "{province.required}")
    private String province;
    @NotEmpty(message = "{phone.required}")
    @Pattern(regexp = "^\\d{10}$", message = "{phone.valid}")
    private String phoneNo;
    private Long pricePlan;
}
