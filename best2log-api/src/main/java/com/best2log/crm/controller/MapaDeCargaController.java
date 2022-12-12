package com.best2log.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.best2log.crm.entity.MapaDeCarga;
import com.best2log.crm.service.MapaDeCargaService;

@RestController
@RequestMapping("/mapa")
public class MapaDeCargaController {

    @Autowired
    MapaDeCargaService mapaDeCargaService;
    
    @GetMapping
    public ResponseEntity<List<MapaDeCarga>> getAllMapaDeCarga() {
        return new ResponseEntity<>(mapaDeCargaService.getAllMapaDeCarga(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapaDeCarga> getMapaDeCargaById(@PathVariable Integer id) {
        MapaDeCarga mapaDeCarga = mapaDeCargaService.getMapaDeCargaById(id);
        if (mapaDeCarga != null) {
            return new ResponseEntity<>(mapaDeCarga, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(mapaDeCarga, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MapaDeCarga> saveMapaDeCarga(@RequestBody MapaDeCarga mapaDeCarga) {
        return new ResponseEntity<>(mapaDeCargaService.saveMapaDeCarga(mapaDeCarga), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MapaDeCarga> updateMapaDeCarga(@PathVariable Integer id, @RequestBody MapaDeCarga mapaDeCarga) {
    	return new ResponseEntity<>(mapaDeCargaService.updateMapaDeCarga(mapaDeCarga, id), HttpStatus.OK);
	}

    @DeleteMapping("/{id}")
    public ResponseEntity<MapaDeCarga> deleteMapaDeCarga(@PathVariable Integer id) {
        MapaDeCarga mapaDeCarga = mapaDeCargaService.getMapaDeCargaById(id);
        if (mapaDeCarga != null) {
            return new ResponseEntity<>(mapaDeCargaService.deleteMapaDeCarga(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(mapaDeCarga, HttpStatus.NOT_FOUND);
        }
    }
    
}
