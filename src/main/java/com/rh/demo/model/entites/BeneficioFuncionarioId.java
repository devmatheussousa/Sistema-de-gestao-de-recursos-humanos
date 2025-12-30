package com.rh.demo.model.entites;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class BeneficioFuncionarioId  implements Serializable {
    private Long funcionarioId;
    private Long beneficioId;
}
