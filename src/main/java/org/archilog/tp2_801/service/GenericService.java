package org.archilog.tp2_801.service;

import org.archilog.tp2_801.entity.GenericEntity;
import org.archilog.tp2_801.repository.GenericRepository;


public abstract class GenericService<T extends GenericEntity<T>> {

    private final GenericRepository<T> repository;

    public GenericService(GenericRepository<T> repository) {
        this.repository = repository;
    }

    public T create(T t) {
        return repository.save(t);
    }

    public T get(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<T> getAll() {
        return repository.findAll();
    }

    public T update(T t) {
        T newt = get(t.getId());
        newt.update(t);
        return repository.save(newt);
    }

    public void delete(Long id) {
        get(id); // check if the entity exists (throw exception if not found)
        repository.deleteById(id);
    }

}
