package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Dtos.SubscriptionInDto;
import com.tarikukebede.sunscription.Entities.Subscription;
import com.tarikukebede.sunscription.Repositories.SubscriptionRepository;
import com.tarikukebede.sunscription.Utils.Transform;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SubscriptionServiceTest {

    @InjectMocks
    private SubscriptionService  underTest;

    @Mock
    private SubscriptionRepository repository;

    @Test
    void testCreate() {
        SubscriptionInDto inDto = new SubscriptionInDto();
        inDto.setPhoneNo("123456");
        inDto.setPricePlan(1L);
        Subscription subscription = Transform.toSubscription(inDto);

        when(repository.save(any(Subscription.class))).thenReturn(subscription);
        Subscription result = underTest.create(inDto);

        assertThat(result).isEqualTo(subscription);
    }
}