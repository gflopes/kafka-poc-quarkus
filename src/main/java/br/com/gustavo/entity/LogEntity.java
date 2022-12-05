package br.com.gustavo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "trilha_auditoria")
public class LogEntity extends PanacheEntityBase  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dhOperacao;

    private String tipoOperacao;

    private String pontoVenda;

    private String sistema;

    private String usuario;
    
    private String programa;
}
