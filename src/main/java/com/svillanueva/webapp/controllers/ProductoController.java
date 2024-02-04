package com.svillanueva.webapp.controllers;

import com.svillanueva.webapp.entities.Producto;
import com.svillanueva.webapp.services.ProductoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Model
public class ProductoController {

    private Producto producto;

    @Inject
    private ProductoService productoService;

    @Produces
    @Model
    public String titulo() {
        return "Facelet Title desde Controller!" + System.currentTimeMillis();
    }

    @Produces
    @RequestScoped
    @Named("listadoProducto")
    public List<Producto> findAll() {
        return productoService.listar();
    }

    @Produces
    @Model
    public Producto nuevoProducto() {
        producto = new Producto();
        return producto;
    }

    public String guardar() {
        productoService.guardar(producto);
        return "index?faces-redirect=true";
    }
}
