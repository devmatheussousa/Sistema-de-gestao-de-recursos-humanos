package com.rh.demo.model.entites;

import com.rh.demo.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_usuario_login")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UsuarioLoginEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_username", length = 255, nullable = false, unique = true)
    private String username;

    @Column(name = "login_password", length = 255, nullable = false)
    private String password;

    @Column(name = "login_tipo_usuario", length = 255)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
