package com.meucarro.service;

import com.meucarro.exception.ObjetoNotFoundException;
import com.meucarro.repository.MarcaRepository;
import com.meucarro.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.meucarro.entity.Marca;
import com.meucarro.exception.RegraNegocioException;
import javax.transaction.Transactional;
import java.util.List;
@Service
public class MarcaService {

    @Autowired
    private  MarcaRepository marcaRepository;

    @Autowired
    private  ModeloRepository modeloRepository;



    @Transactional
    public Marca save(Marca marca){
       return marcaRepository.save(marca);
    }

    @Transactional
    public Marca update(Marca marca){
        findById(marca.getId());
      return marcaRepository.save(marca);
    }

    public Page<Marca> findAll(Pageable peageble){
          Page<Marca> marcas = marcaRepository.findAll(peageble);
        if( marcas.getTotalPages() < 1) {
          throw  new ObjetoNotFoundException("Não há registros");
        }
        return marcas;
    }


    public Marca findById(Long id) {
        return marcaRepository.findById(id).orElseThrow(() ->
                new ObjetoNotFoundException("Marca não encontrada"));
    }


    @Transactional
    public void delete(Long id) {
        // 1° Verifico se existe
        findById(id);

        // 2° Garanto que não exista modelos com esta marca
        int contador = modeloRepository.contadorDeMarcasNaTabelaModelo(id);

        if(contador > 0 ){
            throw	new RegraNegocioException("Para excluir esta marca é necessario excluir" +
                    " os modelos de carros desta marca");
        }
        marcaRepository.deleteById(id);
    }

     public List<Marca> findAll(){
        return marcaRepository.findAll();
     }

}
