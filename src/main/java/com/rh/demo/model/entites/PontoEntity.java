package com.rh.demo.model.entites;

import com.rh.demo.enums.TipoPonto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class PontoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private LocalTime horasTrabalhadas;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_ponto", nullable = false)
    private TipoPonto tipo;


}
