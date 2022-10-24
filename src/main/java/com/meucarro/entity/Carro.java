package com.meucarro.entity;

import com.meucarro.dto.CarroDto;
import com.meucarro.util.Conversor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import java.sql.Timestamp;

@Entity
public class Carro implements Serializable {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate timestamp_cadastro;


    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private Modelo modelo_id;

    @Min(value = 1800, message = "Ano minimo não pode ser menor que 1800")
    private Integer ano;

    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String combustivel;
    @Min(value = 2, message = "Numero minimo de porta são 2 ")
    private Integer num_portas;

    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String cor;

    public Carro() {
    }


    public Carro(Long id, LocalDate timestamp_cadastro, Modelo modelo_id,
                 @Min(value = 1800, message = "Ano minimo não pode ser menor que 1800")  Integer ano,
                 @NotBlank(message="Campo Obrigatório")
                 @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
                 String combustivel,
                 @Min(value = 2, message = "Numero minimo de porta são 2 ")
                 Integer num_portas,
                 @NotBlank(message="Campo Obrigatório")
                 @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
                 String cor) {
        this.id = id;
        this.timestamp_cadastro = timestamp_cadastro;
        this.modelo_id = modelo_id;
        this.ano = ano;
        this.combustivel = combustivel;
        this.num_portas = num_portas;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "id=" + id +
                ", timestamp_cadastro=" + timestamp_cadastro +
                ", modelo_id=" + modelo_id +
                ", ano=" + ano +
                ", combustivel='" + combustivel + '\'' +
                ", num_portas=" + num_portas +
                ", cor='" + cor + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTimestamp_cadastro() {
        return timestamp_cadastro;
    }

    public void setTimestamp_cadastro(LocalDate timestamp_cadastro) {
        this.timestamp_cadastro = timestamp_cadastro;
    }

    public Modelo getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Modelo modelo_id) {
        this.modelo_id = modelo_id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public Integer getNum_portas() {
        return num_portas;
    }

    public void setNum_portas(Integer num_portas) {
        this.num_portas = num_portas;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Metodo usado para conversao de CarroDto para carro
     * @param carroDto
     * @return Carro
     */
    public  static Carro conversorCarro(CarroDto carroDto){
        Carro carro;

       if(carroDto.getId() != null){
           Modelo modelo = new Modelo();
           modelo.setId(carroDto.getModelo_id());
           carro = new Carro(carroDto.getId(), new Conversor().parseLocalDate(carroDto.getTimestamp_cadastro()),
                   modelo, carroDto.getAno(), carroDto.getCombustivel(), carroDto.getNum_portas(), carroDto.getCor());
       }else {
           carro = cadastroDeCarro(carroDto);
       }
        return carro;
    }




    public  static Carro cadastroDeCarro(CarroDto carroDto){

         Marca marca = new Marca();
         marca.setId(carroDto.getMarca_id());
         Modelo modelo = new Modelo();
         modelo.setValor_fipe(carroDto.getValor_fipe());
         modelo.setId(carroDto.getModelo_id());
         Carro carro = new Carro();
         carro.setTimestamp_cadastro(new Conversor().parseLocalDate(carroDto.getTimestamp_cadastro()));
         carro.setModelo_id(modelo);
         carro.setAno(carroDto.getAno());
         carro.setCombustivel(carroDto.getCombustivel());
         carro.setNum_portas(carroDto.getNum_portas());
         carro.setCor(carroDto.getCor());

        return carro;
    }
}