package com.tarikukebede.sunscription.Repositories;

import com.tarikukebede.sunscription.Entities.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
}
