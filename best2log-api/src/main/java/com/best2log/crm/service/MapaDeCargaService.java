package com.best2log.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.best2log.crm.repository.MapaDeCargaRepository;
import com.best2log.crm.entity.MapaDeCarga;

@Service
public class MapaDeCargaService {

    @Autowired
    MapaDeCargaRepository mapaDeCargaRepository;

	public List<MapaDeCarga> getAllMapaDeCarga(){
		return mapaDeCargaRepository.findAll(); 
	}
	
	public MapaDeCarga getMapaDeCargaById(int id) {
		return mapaDeCargaRepository.findById(id).orElse(null);
	}

    public MapaDeCarga saveMapaDeCarga(MapaDeCarga mapaDeCarga) {
        return mapaDeCargaRepository.save(mapaDeCarga);
    }
    
    public MapaDeCarga updateMapaDeCarga(MapaDeCarga mapaDeCarga, Integer id) {
        MapaDeCarga mapaDeCargaExistente = getMapaDeCargaById(id);
        mapaDeCargaExistente.setAllAtributos(mapaDeCarga);
        return mapaDeCargaRepository.save(mapaDeCargaExistente);
    }
    
    public MapaDeCarga deleteMapaDeCarga(Integer id) {
        mapaDeCargaRepository.deleteById(id);
        return getMapaDeCargaById(id);
    }

}

