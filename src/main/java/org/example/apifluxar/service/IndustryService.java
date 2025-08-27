package org.example.apifluxar.service;

import org.example.apifluxar.dto.IndustryResponseDTO;
import org.example.apifluxar.dto.PlanResponseDTO;
import org.example.apifluxar.model.Industry;
import org.example.apifluxar.model.Plan;
import org.example.apifluxar.repository.IndustryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class IndustryService {
    final private IndustryRepository industryRepository;

    public IndustryService(IndustryRepository industryRepository) {
        this.industryRepository = industryRepository;
    }

    public IndustryResponseDTO fromIndustryResponseDTO(Industry industry) {
        IndustryResponseDTO industryDTO = new IndustryResponseDTO();
        industryDTO.setNome(industry.getNome());
        industryDTO.setCnpj(industry.getCnpj());
        return industryDTO;
    }

    public IndustryResponseDTO getPlanById(Long id) {
        Industry industry = industryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return fromIndustryResponseDTO(industry);
    }
}
