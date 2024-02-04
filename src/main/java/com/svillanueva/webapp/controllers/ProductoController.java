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

    private Long id;


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
        if (id != null && id > 0) {
            productoService.porId(id)
                    .ifPresent(p -> this.producto = p);
        }
        return producto;
    }

    public String guardar() {
        productoService.guardar(producto);
        return "index?faces-redirect=true";
    }

    public String editar(Long id) {
        this.id = id;
        return "form.xhtml";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
