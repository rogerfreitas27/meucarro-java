package com.meucarro.service;

import com.meucarro.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meucarro.entity.*;
import com.meucarro.dto.CarroDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.transaction.Transactional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Transactional
    public CarroDto save(CarroDto carro){
        return CarroDto.conversorDtoCadastro(carroRepository.save(Carro.conversorCarro(carro)));

    }

    @Transactional
    public CarroDto update(CarroDto carro){
          findById(carro.getId());
        return save(carro);
    }

    public CarroDto findById(Long id){
       return CarroDto.conversorDto(carroRepository.findById(id).orElseThrow());
    }

    public Page<CarroDto> findAll(Pageable peageble){

        Page<CarroDto> carroDto =
                carroRepository.findAll(peageble)
                        .map(CarroDto::conversorDto);
        return carroDto;
    }


    @Transactional
    public void delete(Long id){
           findById(id) ;
           carroRepository.deleteById(id);
    }

    public Page<CarroDto> findByModelo(String search,Pageable peageble){
        Page<CarroDto> carroDto =
                carroRepository.search(search,peageble)
                        .map(CarroDto::conversorDto);
            return carroDto;
    }



}
