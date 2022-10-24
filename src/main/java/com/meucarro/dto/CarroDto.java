package com.meucarro.dto;

import com.meucarro.entity.Carro;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.meucarro.util.Conversor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
public class CarroDto  {
    private Long id;
    private Long marca_id;
    private String marca_nome;
    @NotNull(message = "Informe o modelo do veiculo")
	private Long modelo_id;
    private String nome_modelo;
    @Min(value = 1800, message = "Ano minimo não pode ser menor que 1800")
    private Integer ano;
    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String combustivel;
    @Min(value = 2, message = "Numero minimo de porta são 2 ")
    private Integer num_portas;
    private BigDecimal valor_fipe;
    @NotBlank(message="Campo Obrigatório")
    @Size(min = 3, max=255,message="campo com no mínimo 3 e no máximo de 255 caracteres.")
    private String cor;
    @NotNull(message = "Informe a data do cadastro")
    private Long timestamp_cadastro;

    public CarroDto() {
    }

    public CarroDto(Long id, Long marca_id, String marca_nome,Long modelo_id,
                    String nome_modelo, Integer ano, String combustivel,
                    Integer num_portas, BigDecimal valor_fipe, String cor,
                   Long timestamp_cadastro) {
        this.id = id;
        this.marca_id = marca_id;
        this.marca_nome = marca_nome;
		this.modelo_id= modelo_id;
        this.nome_modelo = nome_modelo;
        this.ano = ano;
        this.combustivel = combustivel;
        this.num_portas = num_portas;
        this.valor_fipe = valor_fipe;
        this.cor = cor;
        this.timestamp_cadastro = timestamp_cadastro;
    }

    public CarroDto(Carro c) {
    }

    @Override
    public String toString() {
        return "CarroDto{" +
                "id=" + id +
                ", marca_id=" + marca_id +
                ", marca_nome='" + marca_nome + '\'' +
                ", modelo_id=" + modelo_id +
                ", nome_modelo='" + nome_modelo + '\'' +
                ", ano=" + ano +
                ", combustivel='" + combustivel + '\'' +
                ", num_portas=" + num_portas +
                ", valor_fipe=" + valor_fipe +
                ", cor='" + cor + '\'' +
                ", timestamp_cadastro=" + timestamp_cadastro +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(Long marca_id) {
        this.marca_id = marca_id;
    }

    public String getMarca_nome() {
        return marca_nome;
    }

    public void setMarca_nome(String marca_nome) {
        this.marca_nome = marca_nome;
    }

    public Long getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(Long modelo_id) {
        this.modelo_id = modelo_id;
    }

    public String getNome_modelo() {
        return nome_modelo;
    }

    public void setNome_modelo(String nome_modelo) {
        this.nome_modelo = nome_modelo;
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

    public BigDecimal getValor_fipe() {
        return valor_fipe;
    }

    public void setValor_fipe(BigDecimal valor_fipe) {
        this.valor_fipe = valor_fipe;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getTimestamp_cadastro() {
        return timestamp_cadastro;
    }

    public void setTimestamp_cadastro(Long timestamp_cadastro) {
        this.timestamp_cadastro = timestamp_cadastro;
    }



    public  static CarroDto conversorDto(Carro carro){

        CarroDto carroDto = new CarroDto(carro.getId() ,carro.getModelo_id().getMarca_id().getId(),
                carro.getModelo_id().getMarca_id().getNome_marca() ,carro.getModelo_id().getId(),
                carro.getModelo_id().getNome(),carro.getAno(),carro.getCombustivel(),
                carro.getNum_portas(),carro.getModelo_id().getValor_fipe(),
                carro.getCor(),new Conversor().parseLong(carro.getTimestamp_cadastro()) );
           return carroDto;
    }


    public  static CarroDto conversorDtoCadastro(Carro carro){

        CarroDto carroDto = new CarroDto();
        carroDto.setModelo_id(carro.getModelo_id().getId());
        carroDto.setAno(carro.getAno());
        carroDto.setCombustivel(carro.getCombustivel());
        carroDto.setNum_portas(carro.getNum_portas());
        carroDto.setCor(carro.getCor());
        carroDto.setTimestamp_cadastro(new Conversor().parseLong(carro.getTimestamp_cadastro()));


        return carroDto;
    }
}
