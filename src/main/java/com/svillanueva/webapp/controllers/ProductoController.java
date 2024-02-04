package com.svillanueva.webapp.controllers;

import com.svillanueva.webapp.entities.Producto;
import com.svillanueva.webapp.services.ProductoService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class ProductoController implements Serializable {
    @Inject
    private ProductoService productoService;

    private Producto producto = new Producto();
    private List<Producto> productos;

    public String guardar() {
        productoService.guardar(producto);
        producto = new Producto();
        return "index?faces-redirect=true";
    }

    public String editar(Long id) {
        producto = productoService.porId(id)
                .orElse(new Producto());
        return "form?faces-redirect=true";
    }

    public void eliminar(Long id) {
        productoService.eliminar(id);
        productos = null;
    }

    // Getters y Setters
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getProductos() {
        if (productos == null) {
            productos = productoService.listar();
        }
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
