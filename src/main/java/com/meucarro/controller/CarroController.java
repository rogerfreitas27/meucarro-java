package com.meucarro.controller;


import com.meucarro.dto.CarroDto;
import com.meucarro.entity.Carro;
import com.meucarro.entity.Modelo;
import com.meucarro.service.CarroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/carro")
public class CarroController {

    @Autowired
    private CarroService carroService;


    @PostMapping
    @Operation(summary = "Endpoint para cadastro de carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Carro cadastrado com sucesso "),
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar"),

    })
    public ResponseEntity<CarroDto> save(@Valid @RequestBody CarroDto carro) {

        return ResponseEntity.status(HttpStatus.CREATED).body(carroService.save(carro));

    }


    @PutMapping
    @Operation(summary = "Endpoint para atualizar cadastro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro atualizado com sucesso ")

    })
    public ResponseEntity<CarroDto> update(@Valid @RequestBody CarroDto carro) {
        return ResponseEntity.status(HttpStatus.OK).body(carroService.update(carro));
    }


    @GetMapping
    @Operation(summary = "Endpoint para buscar todos os carros, a api devolve a lista de carros "
            + "paginada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buscar todos os carros"),
            @ApiResponse(responseCode = "404", description = "Não há registro de carros")
    })
    public ResponseEntity<Page<CarroDto>> findAll(@PageableDefault(size=10) Pageable peageable){
        return  ResponseEntity.ok(carroService.findAll(peageable));
    }


    @GetMapping("findByModelo/{search}")
    @Operation(summary = "Endpoint para buscar todos os carros de um determinado modelo" +
            ", a api devolve a lista de carros paginada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buscar todos os carros"),
            @ApiResponse(responseCode = "404", description = "Não há registro de carros")
    })
    public ResponseEntity<Page<CarroDto>> findByModelo(@PageableDefault(size=10) Pageable peageable,
                                                       @PathVariable("search")String search){
        return  ResponseEntity.ok(carroService.findByModelo(search,peageable));
    }




    @GetMapping("/{id}")
    @Operation(summary = "Endpoint para buscar carro por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Carro encontrada"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado") })
    public ResponseEntity<CarroDto>findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(carroService.findById(id));
    }




    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint para deletar carro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Carro excluido"),
            @ApiResponse(responseCode = "404", description = "Carro não encontrado"),
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        carroService.delete(id);
        return ResponseEntity.noContent().build();


    }



}
