package com.svillanueva.webapp.services;

import com.svillanueva.webapp.entities.Categoria;
import com.svillanueva.webapp.entities.Producto;
import com.svillanueva.webapp.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;


@Stateless
public class ProductoServiceImpl implements ProductoService {
    @Inject
    private CrudRepository<Producto> productoRepository;

    @Inject
    private CrudRepository<Categoria> categoriaRepository;

    @Override
    public List<Producto> listar() {
        return productoRepository.listar();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return Optional.ofNullable(productoRepository.porId(id));
    }

    @Override
    public void guardar(Producto producto) {
        productoRepository.guardar(producto);
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.eliminar(id);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.listar();
    }

    @Override
    public Optional<Categoria> categoriaPorId(Long id) {
        return Optional.ofNullable(categoriaRepository.porId(id));
    }
}
