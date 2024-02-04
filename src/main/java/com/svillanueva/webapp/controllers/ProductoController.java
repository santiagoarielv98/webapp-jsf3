package com.svillanueva.webapp.controllers;

import com.svillanueva.webapp.entities.Producto;
import com.svillanueva.webapp.services.ProductoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProductoController implements Serializable {
    @Inject
    private ProductoService productoService;

    private Producto producto;
    private List<Producto> productos;

    @PostConstruct
    public void init() {
        producto = new Producto();
        productos = productoService.listar();
    }

    public String guardar() {
        productoService.guardar(producto);
        producto = new Producto(); // Limpiar el formulario
        productos = productoService.listar(); // Actualizar la lista después de guardar
        return "index?faces-redirect=true";
    }

    public String editar(Long id) {
        producto = productoService.porId(id)
                .orElse(new Producto());
        return "form?faces-redirect=true";
    }

    public void eliminar(Long id) {
        productoService.eliminar(id);
        productos = productoService.listar(); // Actualizar la lista después de eliminar
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
