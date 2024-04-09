package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.entity.GenericEntity;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.service.GenericService;
import org.archilog.tp2_801.test.EntityProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> service;
    private final EntityProcessor entityProcessor;

    public GenericController(GenericRepository<T> repository, EntityProcessor entityProcessor) {
        this.service = new GenericService<T>(repository, entityProcessor) {};
        this.entityProcessor = entityProcessor;
    }

    @GetMapping("{id}")
    public ResponseEntity<T> get(@PathVariable Long id) {
        T t = service.get(id);
        System.out.println("JE PASSE "+t.getId());
        service.processEntity(t);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<T>> getAll() {
        Iterable<T> tList = service.getAll();
        tList.forEach(entityProcessor::processEntityFields);
        return new ResponseEntity<>(tList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody T t) {
        T newt = service.create(t);
        return new ResponseEntity<>(newt, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody T t) {
        T newt = service.update(t);
        return new ResponseEntity<>(newt, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("User deleted successfully!");
    }
}
