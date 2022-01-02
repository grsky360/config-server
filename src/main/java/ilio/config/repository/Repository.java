package ilio.config.repository;

import java.util.List;

public interface Repository<E, ID> {

    default boolean exists(ID id) {
        return findById(id) != null;
    }

    List<E> findAll();

    E findById(ID id);
}
