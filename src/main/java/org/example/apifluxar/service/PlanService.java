package org.example.apifluxar.service;

import org.example.apifluxar.dto.PlanResponseDTO;
import org.example.apifluxar.model.Plan;
import org.example.apifluxar.model.Subscription;
import org.example.apifluxar.repository.PlanRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class PlanService {
    final PlanRepository planRepository;
    private SubscriptionService subscriptionService;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public PlanResponseDTO fromPlanResponseDTO(Plan plan) {
        PlanResponseDTO planResponseDTO = new PlanResponseDTO();
        planResponseDTO.setNome(plan.getNome());
        planResponseDTO.setPreco(plan.getPreco());
        planResponseDTO.setDuracaoMeses(calculatePlanDuration(plan));
        return planResponseDTO;
    }

    public PlanResponseDTO getPlanById(Long id) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return fromPlanResponseDTO(plan);
    }

    public Integer calculatePlanDuration(Plan plan) {
        Subscription subscriptionPlan = subscriptionService.getSubcriptionByPlanId(plan.getId());
        LocalDateTime dataInicio = subscriptionPlan.getDataInicio();
        LocalDateTime dataFim = subscriptionPlan.getDataFim();
        long meses = ChronoUnit.MONTHS.between(dataInicio, dataFim);

        return (int) meses;
    }
}
