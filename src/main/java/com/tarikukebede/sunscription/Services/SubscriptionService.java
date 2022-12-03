package com.tarikukebede.sunscription.Services;

import com.tarikukebede.sunscription.Dtos.SubscriptionInDto;
import com.tarikukebede.sunscription.Entities.Subscription;
import com.tarikukebede.sunscription.Repositories.SubscriptionRepository;
import com.tarikukebede.sunscription.Utils.Transform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionService extends ServiceTemplate<Subscription, Long> {

    @Autowired
    public SubscriptionService(SubscriptionRepository repository){
        super(repository, new Subscription());
    }

    public Subscription create(SubscriptionInDto request){
        return super.create(Transform.toSubscription(request));
    }
}
