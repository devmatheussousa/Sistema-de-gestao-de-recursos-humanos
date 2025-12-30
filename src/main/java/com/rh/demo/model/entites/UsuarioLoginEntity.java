package com.rh.demo.model.entites;

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

    @Column(name = "login_username", length = 255)
    private String username;

    @Column(name = "login_password", length = 255)
    private String password;
}
