package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Dtos.AccountInDto;
import com.tarikukebede.sunscription.Entities.Account;
import com.tarikukebede.sunscription.Entities.BillingAddress;
import com.tarikukebede.sunscription.Repositories.AccountRepository;
import com.tarikukebede.sunscription.Utils.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends ServiceTemplate<Account, Long> {

    private final BillingAddressService billingAddressService;

    @Autowired
    public AccountService(AccountRepository repository, BillingAddressService billingAddressService){
        super(repository, new Account());
        this.billingAddressService = billingAddressService;
    }

    public Account create(AccountInDto request){
        BillingAddress billingAddress = billingAddressService.create(Transform.toBillingAddress(request));
        Account account = Transform.toAccount(request);
        account.setBillingAddress(billingAddress);
        return super.create(account);
    }

}
