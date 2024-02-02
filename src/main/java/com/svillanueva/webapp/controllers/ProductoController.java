package com.svillanueva.webapp.controllers;

import com.svillanueva.webapp.entities.Producto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import java.util.Arrays;
import java.util.List;

@Model
public class ProductoController {
    @Produces
    @Model
    public String titulo() {
        return "Facelet Title desde Controller!";
    }

    @Produces
    @RequestScoped
    @Named("listadoProducto")
    public List<Producto> findAll() {
        return Arrays.asList(new Producto("Peras"), new Producto("Manzanas"), new Producto("Mandarinas"));
    }
}
