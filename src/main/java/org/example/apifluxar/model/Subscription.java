package org.example.apifluxar.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "Assinatura")
@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "industria_id")
    private Long industriaId;

    @Column(name = "plano_id")
    private Long planoId;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_fim")
    private LocalDateTime dataFim;

    private Character status;

    //Constructor

    public Subscription(Long id, Long industriaId, Long planoId, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.industriaId = industriaId;
        this.planoId = planoId;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Subscription() {}

    //Getter e Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIndustriaId() {
        return industriaId;
    }

    public void setIndustriaId(Long industriaId) {
        this.industriaId = industriaId;
    }

    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
