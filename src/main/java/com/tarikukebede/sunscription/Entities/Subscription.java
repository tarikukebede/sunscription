package com.tarikukebede.sunscription.Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToOne;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Subscription extends Model{
    private String phoneNo;
    private String status;
    private Long pricePlan;
    @JsonBackReference
    @OneToOne
    private Account account;
}
