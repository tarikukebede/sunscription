package com.tarikukebede.sunscription.Utils;

import com.tarikukebede.sunscription.Dtos.AccountInDto;
import com.tarikukebede.sunscription.Dtos.BillingAddressInDto;
import com.tarikukebede.sunscription.Dtos.SubscriptionInDto;
import com.tarikukebede.sunscription.Entities.Account;
import com.tarikukebede.sunscription.Entities.BillingAddress;
import com.tarikukebede.sunscription.Entities.Subscription;

import java.util.ArrayList;

public class Transform {

    public static Account toAccount(AccountInDto inDto){
        return Account.builder()
                .balance(inDto.getBalance())
                .status(Constants.Status.active.name())
                .subscriptions(new ArrayList<>())
                .build();
    }

    public static BillingAddress toBillingAddress(AccountInDto inDto){
        return BillingAddress.builder()
                .addressOne(inDto.getAddressOne())
                .addressTwo(inDto.getAddressTwo())
                .postalCode(inDto.getPostalCode())
                .province(inDto.getProvince())
                .build();
    }

    public static BillingAddress toBillingAddress(BillingAddressInDto inDto){
        return BillingAddress.builder()
                .addressOne(inDto.getAddressOne())
                .addressTwo(inDto.getAddressTwo())
                .postalCode(inDto.getPostalCode())
                .province(inDto.getProvince())
                .build();
    }

    public static Subscription toSubscription(SubscriptionInDto inDto){
        return Subscription.builder()
                .phoneNo(inDto.getPhoneNo())
                .pricePlan(inDto.getPricePlan())
                .status(Constants.Status.active.name())
                .pricePlan(inDto.getPricePlan())
                .build();
    }
}
