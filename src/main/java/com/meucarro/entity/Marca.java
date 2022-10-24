package com.meucarro.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Marca implements Serializable {



    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Campo Obrigatório")
    @Size(min = 2, max=255,message="campo com no mínimo 2 e no máximo de 255 caracteres.")
    private String nome_marca;

    public Marca() {
    }

    public Marca(Long id,   @NotBlank(message="Campo Obrigatório")
                            @Size(min = 2, max=255,message="campo com no mínimo 2 e no máximo de 255 caracteres.")
                            String nome_marca) {
        this.id = id;
        this.nome_marca = nome_marca.toUpperCase();
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nome_marca='" + nome_marca + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_marca() {
        return nome_marca;
    }

    public void setNome_marca(String nome_marca) {
        this.nome_marca = nome_marca.toUpperCase();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return id.equals(marca.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}