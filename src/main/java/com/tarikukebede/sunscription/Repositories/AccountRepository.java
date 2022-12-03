package com.tarikukebede.sunscription.Repositories;

import com.tarikukebede.sunscription.Entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
