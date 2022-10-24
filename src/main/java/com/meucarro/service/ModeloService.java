package com.meucarro.service;
import com.meucarro.entity.Modelo;
import com.meucarro.exception.ObjetoNotFoundException;
import com.meucarro.exception.RegraNegocioException;
import com.meucarro.repository.ModeloRepository;
import com.meucarro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.transaction.Transactional;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private CarroRepository carroRepository;

    @Transactional
    public Modelo save(Modelo modelo){
      return modeloRepository.save(modelo);
    }

    @Transactional
    public Modelo update(Modelo modelo){
      findById(modelo.getId()) ;
      return modeloRepository.save(modelo);
    }


    public Page<Modelo> findAll(Pageable peageble){
           Page<Modelo> modelos = modeloRepository.findAll(peageble);
        if( modelos.getTotalPages() < 1) {
            throw  new ObjetoNotFoundException("Não há registros");
        }
        return modelos;
    }


    public Modelo findById(Long id){
      return modeloRepository.findById(id).orElseThrow(() ->
              new ObjetoNotFoundException("Modelo não encontrado"));
    }

    @Transactional
    public void delete(Long id){
        findById(id) ;

        // 2° Garanto que não exista modelos com esta marca
        int contador = carroRepository.contadorModeloNaTabelaCarro(id);

        if(contador > 0 ){
            throw	new RegraNegocioException("Para excluir este modelo é necessario excluir" +
                    " os  carros desta marca");
        }
        modeloRepository.deleteById(id);
    }

    public List<Modelo>findAll(){
        return modeloRepository.findAll();
    }


    public List<Modelo>findAllByMarca(Long marca){
        return modeloRepository.findAllByMarca(marca);
    }
}
