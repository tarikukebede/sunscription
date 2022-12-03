package com.tarikukebede.sunscription.Dtos;

import com.tarikukebede.sunscription.Utils.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountInDto {
    private double balance;
    @NotEmpty(message = Validation.ADDRESS_REQUIRED)
    private String addressOne;
    @NotEmpty(message = Validation.ADDRESS_REQUIRED)
    private String addressTwo;
    @NotEmpty(message = Validation.POSTAL_CODE_REQUIRED)
    private String postalCode;
    @NotEmpty(message = Validation.PROVINCE_REQUIRED)
    private String province;
    @NotEmpty(message = Validation.PHONE_NO_REQUIRED)
    @Pattern(regexp = "^\\d{10}$", message = Validation.PHONE_NO_REQUIRED)
    private String phoneNo;
    private Long pricePlan;
}
