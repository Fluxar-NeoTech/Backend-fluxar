package org.example.apifluxar.controller;

import org.example.apifluxar.dto.SectorResponseDTO;
import org.example.apifluxar.service.SectorService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/sector")
public class SectorController {
    final SectorService sectorService;
    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @GetMapping("search/{id}")
    public SectorResponseDTO selectId(@PathVariable long id) {
        SectorResponseDTO sectorResponseDTO = sectorService.getSectorById(id);
        return sectorResponseDTO;
    }
    @GetMapping("search/name/{name}")
    public SectorResponseDTO selectName(@PathVariable String name) {
        SectorResponseDTO sectorResponseDTO = sectorService.getSectorByName(name);
        return sectorResponseDTO;
    }
}
