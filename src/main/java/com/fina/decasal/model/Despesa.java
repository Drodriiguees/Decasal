package com.fina.decasal.model;


import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;

   private String descricao;
   private Double valor;
   private Date data;

   @ManyToOne
   @JoinColumn(name = "categoria_id")
   private Categoria categoria;

   @ManyToOne
   @JoinColumn(name = "pagador_id")
   private Usuario pagador;
   


}
