package com.tarikukebede.sunscription.Dtos;

import com.tarikukebede.sunscription.Utils.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddressInDto {
    @NotEmpty(message = Validation.ADDRESS_REQUIRED)
    private String addressOne;
    @NotEmpty(message = Validation.ADDRESS_REQUIRED)
    private String addressTwo;
    @NotEmpty(message = Validation.POSTAL_CODE_REQUIRED)
    private String postalCode;
    @NotEmpty(message = Validation.PROVINCE_REQUIRED)
    private String province;
}
