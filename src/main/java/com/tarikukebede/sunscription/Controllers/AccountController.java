package com.tarikukebede.sunscription.Controllers;

import com.tarikukebede.sunscription.Dtos.AccountInDto;
import com.tarikukebede.sunscription.Entities.Account;
import com.tarikukebede.sunscription.Services.AccountService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
@Tag(name = "Account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService service;

    @PostMapping
    public Account create(@Valid @RequestBody AccountInDto request){
        return service.create(request);
    }

    @GetMapping("/{id}")
    public Account get(@PathVariable Long id){
        return service.get(id);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        return service.delete(id);
    }
}
