package org.archilog.tp2_801.controller;

import org.archilog.tp2_801.entity.GenericEntity;
import org.archilog.tp2_801.repository.GenericRepository;
import org.archilog.tp2_801.service.GenericService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


public abstract class GenericController<T extends GenericEntity<T>> {

    private final GenericService<T> service;

    public GenericController(GenericRepository<T> repository) {
        this.service = new GenericService<T>(repository) {};
    }

    @GetMapping("{id}")
    public ResponseEntity<T> get(@PathVariable Long id) {
        T t = service.get(id);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Iterable<T>> getAll() {
        Iterable<T> tList = service.getAll();
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
