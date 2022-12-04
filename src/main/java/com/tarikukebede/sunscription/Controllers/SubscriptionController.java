package com.tarikukebede.sunscription.Controllers;

import com.tarikukebede.sunscription.Dtos.SubscriptionInDto;
import com.tarikukebede.sunscription.Entities.Subscription;
import com.tarikukebede.sunscription.Services.SubscriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/subscriptions")
@Tag(name = "Subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService service;

    @PostMapping
    public Subscription create(@Valid @RequestBody SubscriptionInDto request){
        return service.create(request);
    }

}
