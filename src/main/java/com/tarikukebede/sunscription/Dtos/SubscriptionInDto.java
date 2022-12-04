package com.tarikukebede.sunscription.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @NotEmpty(message = "{phone.required}")
    @Pattern(regexp = "^\\d{10}$", message = "{phone.valid}")
    private String phoneNo;
    @NotNull(message = "{price_plan.required}")
    private Long pricePlan;
}
