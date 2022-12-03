package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Dtos.AccountInDto;
import com.tarikukebede.sunscription.Entities.Account;
import com.tarikukebede.sunscription.Entities.BillingAddress;
import com.tarikukebede.sunscription.Repositories.AccountRepository;
import com.tarikukebede.sunscription.Utils.Transform;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AccountServiceTest {

    @InjectMocks
    private AccountService  underTest;

    @Mock
    private AccountRepository repository;

    @Mock
    private BillingAddressService billingAddressService;

    @Test
    void testCreate() {
        AccountInDto dto = new AccountInDto();
        dto.setAddressOne("address one");
        dto.setAddressTwo("address two");
        dto.setPostalCode("1234");
        dto.setProvince("province");
        dto.setBalance(100);
        dto.setPhoneNo("0989786756");
        dto.setPricePlan(1L);
        Account account = Transform.toAccount(dto);

        when(repository.save(any(Account.class))).thenReturn(account);
        when(billingAddressService.create(any(BillingAddress.class))).thenReturn(new BillingAddress());
        Account result = underTest.create(dto);

        assertThat(result).isEqualTo(account);
    }

    @Test
    void testGet(){
        AccountInDto dto = new AccountInDto();
        dto.setAddressOne("address one");
        dto.setAddressTwo("address two");
        dto.setPostalCode("1234");
        dto.setProvince("province");
        dto.setBalance(100);
        dto.setPhoneNo("0989786756");
        dto.setPricePlan(1L);
        Account account = Transform.toAccount(dto);
        account.setId(1L);

        when(repository.findById(any(Long.class))).thenReturn(Optional.of(account));
        Account result = underTest.get(account.getId());
        assertThat(result).isEqualTo(account);

        when(repository.findById(any(Long.class))).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, ()-> underTest.get(account.getId()));
    }

    @Test
    void testDelete(){
        Long id = 1L;

        when(repository.existsById(any(Long.class))).thenReturn(true);
        doNothing().when(repository).deleteById(any(Long.class));
        long result = underTest.delete(id);

        assertThat(result).isEqualTo(id);

        when(repository.existsById(any(Long.class))).thenReturn(false);
        assertThrows(ResponseStatusException.class, ()-> underTest.delete(id));
    }

}