package com.tarikukebede.sunscription.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Account extends Model{
    private double balance;
    private String status;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "biing_address_id")
    private BillingAddress billingAddress;
    @OneToMany
    @JsonManagedReference
    private Collection<Subscription> subscriptions;
}
