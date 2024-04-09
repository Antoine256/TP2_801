package org.archilog.tp2_801.test;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class EntityProcessor {

    private final EntityManager entityManager;

    public EntityProcessor(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void processEntityFields(Object entity) {
        Class<?> clazz = entity.getClass();
        System.out.println(Arrays.toString(clazz.getDeclaredFields()));
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(UseIdInsteadOfEntity.class)) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
