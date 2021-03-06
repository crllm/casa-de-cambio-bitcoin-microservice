package com.example.casadecambio.bitcoin.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.math.BigDecimal;

import static java.math.RoundingMode.HALF_EVEN;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "INVESTIMENTOS")
public class Investimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valorInvestido;

    private BigDecimal quantidadeInvestida;

    private BigDecimal lucro;

    private String cpf;

    public Investimento() {
    }

    public Investimento(BigDecimal valorInvestido, BigDecimal quantidadeInvestida, BigDecimal lucro, String cpf) {
        this.valorInvestido = valorInvestido.setScale(3, HALF_EVEN);
        this.quantidadeInvestida = quantidadeInvestida;
        this.lucro = lucro.setScale(3, HALF_EVEN);
        this.cpf = cpf;
    }


    public Investimento update(Investimento investimento) {
        BeanUtils.copyProperties(investimento, this, "id");
        return this;
    }

}
