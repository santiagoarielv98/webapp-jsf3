package com.svillanueva.webapp.services;

import com.svillanueva.webapp.entities.Producto;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);
}
