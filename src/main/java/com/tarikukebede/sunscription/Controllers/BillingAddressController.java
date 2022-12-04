package com.tarikukebede.sunscription.Controllers;

import com.tarikukebede.sunscription.Dtos.BillingAddressInDto;
import com.tarikukebede.sunscription.Entities.BillingAddress;
import com.tarikukebede.sunscription.Services.BillingAddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/billing-address")
@Tag(name = "Billing Address")
@RequiredArgsConstructor
public class BillingAddressController  {

    private final BillingAddressService service;

    @PostMapping
    public BillingAddress create(@Valid @RequestBody BillingAddressInDto request){
        return service.create(request);
    }
}
