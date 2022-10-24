package com.meucarro.controller;



import com.meucarro.entity.Modelo;
import com.meucarro.service.ModeloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;


    @PostMapping
    @Operation(summary = "Endpoint para cadastro de modelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Modelo cadastrado com sucesso "),
            @ApiResponse(responseCode = "400", description = "Falha ao cadastrar"),

    })
    public ResponseEntity<Modelo> save(@Valid @RequestBody Modelo modelo) {

        return ResponseEntity.status(HttpStatus.CREATED).body(modeloService.save(modelo));

    }


    @PutMapping
    @Operation(summary = "Endpoint para atualizar cadastro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cadastro atualizado com sucesso ")

    })
    public ResponseEntity<Modelo> update(@Valid @RequestBody Modelo modelo) {
        return ResponseEntity.status(HttpStatus.OK).body(modeloService.update(modelo));
    }

    @GetMapping
    @Operation(summary = "Endpoint para buscar todos os modelos, a api devolve a lista de modelos "
            + "paginada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Buscar todos os modelos"),
            @ApiResponse(responseCode = "404", description = "Não há registro de modelos")
    })
    public ResponseEntity<Page<Modelo>> findAll(@PageableDefault(size=10) Pageable peageable){
        PageRequest pageRequest = null;
        pageRequest=PageRequest.of(peageable.getPageNumber(),peageable.getPageSize(), Sort.by("id"));
        return  ResponseEntity.ok(modeloService.findAll(pageRequest));
    }



    @GetMapping("/{id}")
    @Operation(summary = "Endpoint para buscar modelo por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Modelo encontrada"),
            @ApiResponse(responseCode = "404", description = "Modelo não encontrado") })
    public ResponseEntity<Modelo>findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(modeloService.findById(id));
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Endpoint para deletar modelo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Modelo excluido"),
            @ApiResponse(responseCode = "404", description = "Modelo não encontrado"),
    })
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        modeloService.delete(id);
        return ResponseEntity.noContent().build();


    }


    @GetMapping("/findAll")
    @Operation(summary = "Endpoint para listar modelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de modelos é exibida")
               })
    public ResponseEntity<List<Modelo>> findAll() {
        return ResponseEntity.ok(modeloService.findAll());
    }



    @GetMapping("/findAllByMarca/{marca}")
    @Operation(summary = "Endpoint para listar modelos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de modelos é exibida")
    })
    public ResponseEntity<List<Modelo>> findAllByMarca(@PathVariable("marca") Long marca) {
        return ResponseEntity.ok(modeloService.findAllByMarca(marca));
    }


}






