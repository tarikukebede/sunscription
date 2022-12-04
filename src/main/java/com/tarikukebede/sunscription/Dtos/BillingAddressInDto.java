package com.tarikukebede.sunscription.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillingAddressInDto {
    @NotEmpty(message = "{address.required}")
    private String addressOne;
    @NotEmpty(message = "{address.required}")
    private String addressTwo;
    @NotEmpty(message = "{postal.required}")
    private String postalCode;
    @NotEmpty(message = "{province.required}")
    private String province;
}
