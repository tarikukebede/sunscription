package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Dtos.BillingAddressInDto;
import com.tarikukebede.sunscription.Entities.BillingAddress;
import com.tarikukebede.sunscription.Repositories.BillingAddressRepository;
import com.tarikukebede.sunscription.Utils.Transform;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BillingAddressServiceTest {

    @InjectMocks
    private BillingAddressService underTest;

    @Mock
    private BillingAddressRepository repository;

    @Test
    void testCreate() {
        BillingAddressInDto inDto = new BillingAddressInDto();
        inDto.setAddressOne("address_one");
        inDto.setAddressOne("address_two");
        inDto.setPostalCode("1234");
        inDto.setProvince("province");

        BillingAddress billingAddress = Transform.toBillingAddress(inDto);

        when(repository.save(any(BillingAddress.class))).thenReturn(billingAddress);
        BillingAddress result = underTest.create(inDto);

        assertThat(result).isEqualTo(billingAddress);
    }
}