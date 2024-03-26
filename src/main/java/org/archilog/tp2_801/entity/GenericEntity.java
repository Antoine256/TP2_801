package org.archilog.tp2_801.entity;

public interface GenericEntity<T> {
    void update(T t);

    Long getId();

    String toString();
}
