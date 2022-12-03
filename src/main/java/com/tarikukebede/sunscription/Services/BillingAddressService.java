package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Dtos.BillingAddressInDto;
import com.tarikukebede.sunscription.Entities.BillingAddress;
import com.tarikukebede.sunscription.Repositories.BillingAddressRepository;
import com.tarikukebede.sunscription.Utils.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillingAddressService extends ServiceTemplate<BillingAddress, Long> {

    @Autowired
    public BillingAddressService(BillingAddressRepository repository) {
        super(repository, new BillingAddress());
    }

    public BillingAddress create(BillingAddressInDto request){
        BillingAddress billingAddress = Transform.toBillingAddress(request);
        return super.create(billingAddress);
    }
}
