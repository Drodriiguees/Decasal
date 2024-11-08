package com.fina.decasal.model;

import org.hibernate.annotations.ManyToAny;

import com.fina.decasal.enums.StatusConvite;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Convite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String codigo;
    
    @Enumerated(EnumType.STRING)
    private StatusConvite status;

    @ManyToAny
    @JoinColumn(name = "convidado_id")
    private Usuario convidado;

    @ManyToAny
    @JoinColumn(name = "convidante_id")
    private Usuario convidante;
    
    
}
