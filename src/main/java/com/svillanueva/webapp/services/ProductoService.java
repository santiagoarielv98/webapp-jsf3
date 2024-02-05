package com.svillanueva.webapp.services;

import com.svillanueva.webapp.entities.Categoria;
import com.svillanueva.webapp.entities.Producto;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategorias();

    Optional<Categoria> categoriaPorId(Long id);
}

