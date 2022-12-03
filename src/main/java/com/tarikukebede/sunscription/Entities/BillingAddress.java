package com.tarikukebede.sunscription.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class BillingAddress extends Model {
    private String addressOne;
    private String addressTwo;
    private String postalCode;
    private String province;
    @OneToOne(mappedBy = "billingAddress")
    @JsonIgnore
    private Account account;
}
