package org.example.apifluxar.service;

import org.example.apifluxar.model.Subscription;
import org.example.apifluxar.repository.SubscriptionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
public class SubscriptionService {

    final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription getSubscriptionById(Long id){
        Subscription subscription = subscriptionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return subscription;
    }

    public Subscription getSubscriptionByPlanId(Long planId){
        Subscription subscription = subscriptionRepository.findById(planId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return subscription;
    }

    public Subscription getSubscriptionByIndustryId(Long industryId){
        Subscription subscription = subscriptionRepository.findById(industryId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return subscription;
    }
}
