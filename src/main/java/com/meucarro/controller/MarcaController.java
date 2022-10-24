package com.meucarro.controller;

import com.meucarro.entity.Marca;
import com.meucarro.entity.Modelo;
import com.meucarro.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @PostMapping
    @Operation(summary = "Endpoint para cadastro de marca")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Marca cadastrada com sucesso "),
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar"),

    })
    public ResponseEntity<Marca> save(@Valid @RequestBody Marca marca) {

        return ResponseEntity.status(HttpStatus.CREATED).body(marcaService.save(marca));

    }


    @PutMapping
    @Operation(summary = "Endpoint para atualizar cadastro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro atualizado com sucesso ")

    })
    public ResponseEntity<Marca> update(@Valid @RequestBody Marca marca) {
        return ResponseEntity.status(HttpStatus.OK).body(marcaService.update(marca));
    }


    @GetMapping
    @Operation(summary = "Endpoint para buscar todas as marcas, a api devolve a lista de marcas "
            + "paginada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buscar todas as marcas"),
            @ApiResponse(responseCode = "404", description = "Não há registro de marcas")
    })
    public ResponseEntity<Page<Marca>> findAll(@PageableDefault(size=10)Pageable peageable){
        PageRequest pageRequest = null;
        pageRequest=PageRequest.of(peageable.getPageNumber(),peageable.getPageSize(), Sort.by("id"));
        return  ResponseEntity.ok(marcaService.findAll(pageRequest));
    }


    @GetMapping("/{id}")
    @Operation(summary = "Endpoint para buscar marca por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Marca encontrada"),
            @ApiResponse(responseCode = "404", description = "Marca não encontrado") })
    public ResponseEntity<Marca>findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(marcaService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint para deletar marca ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Marca excluida"),
            @ApiResponse(responseCode = "404", description = "Marca não encontrado"),
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
           marcaService.delete(id);
            return ResponseEntity.noContent().build();
    }

    @GetMapping("/findAll")
    @Operation(summary = "Endpoint para listar marcas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de marcas é exibida")
    })
    public ResponseEntity<List<Marca>> findAll() {
        return ResponseEntity.ok(marcaService.findAll());
    }

}
