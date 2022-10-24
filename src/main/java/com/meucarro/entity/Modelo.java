package com.meucarro.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

@Entity
public class Modelo implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca_id;

    @NotBlank(message="Campo Obrigatório")
    @Size(min = 2, max=255,message="campo com no mínimo 2 e no máximo de 255 caracteres.")
    private String nome;

    @NotNull(message = "Campo Obrigatório")
    @DecimalMin(value = "0.99", inclusive = false, message = "Valor minimo 0.99")
    @DecimalMax(value = "999999.99", inclusive = true, message = "Valor maximo 999.999.99")
    @Digits(integer = 6, fraction = 2)
    private BigDecimal valor_fipe;


    public Modelo() {
    }


    public Modelo(Long id, Marca marca_id,
                  @NotBlank(message="Campo Obrigatório")
                  @Size(min = 2, max=255,message="campo com no mínimo 2 e no máximo de 255 caracteres.")
                  String nome,
                  @NotNull(message = "Campo Obrigatório")
                  @DecimalMin(value = "0.99", inclusive = false, message = "Valor minimo 0.99")
                  @DecimalMax(value = "999999.99", inclusive = true, message = "Valor maximo 999.999.99")
                  @Digits(integer = 6, fraction = 2) BigDecimal valor_fipe) {
        this.id = id;
        this.marca_id = marca_id;
        this.nome = nome.toUpperCase();
        this.valor_fipe = valor_fipe;
    }


    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", marca_id=" + marca_id +
                ", nome='" + nome + '\'' +
                ", valor_fipe=" + valor_fipe +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Marca getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Marca marca_id) {
        this.marca_id = marca_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome.toUpperCase();
    }

    public BigDecimal getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(BigDecimal valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Modelo modelo = (Modelo) o;
        return id.equals(modelo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}