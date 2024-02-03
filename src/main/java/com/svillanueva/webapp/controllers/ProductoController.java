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

    @Inject
    private ProductoService productoService;

    @Produces
    @Model
    public String titulo() {
        return "Facelet Title desde Controller!";
    }

    @Produces
    @RequestScoped
    @Named("listadoProducto")
    public List<Producto> findAll() {
        return productoService.listar();
    }
}
