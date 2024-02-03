package com.svillanueva.webapp.repositories;

import java.util.List;

public interface CrudRepository<T> {
    List<T> listar();

    T porId(Long id);
}
