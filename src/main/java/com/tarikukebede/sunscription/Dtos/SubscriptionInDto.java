package com.tarikukebede.sunscription.Dtos;

import com.tarikukebede.sunscription.Utils.Validation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Tariku Lemma
 * pricePlan represents the id of a price plan
 * that would have been already created in the
 * system by admins
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionInDto {
    @NotEmpty(message = Validation.PHONE_NO_REQUIRED)
    @Pattern(regexp = "^\\d{10}$", message = Validation.PHONE_NO_REQUIRED)
    private String phoneNo;
    @NotNull(message = Validation.PRICE_PLAN_REQUIRED)
    private Long pricePlan;
}
