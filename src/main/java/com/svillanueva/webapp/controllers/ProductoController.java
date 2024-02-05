package com.svillanueva.webapp.controllers;

import com.svillanueva.webapp.entities.Categoria;
import com.svillanueva.webapp.entities.Producto;
import com.svillanueva.webapp.services.ProductoService;
import jakarta.enterprise.inject.Model;
import jakarta.inject.Inject;

import java.util.List;

@Model
public class ProductoController {
    @Inject
    private ProductoService productoService;

    private Producto producto = new Producto();
    private List<Producto> productos;
    private List<Categoria> categorias;

    public String guardar() {
        System.out.println("Guardando producto: " + producto);
        productoService.guardar(producto);
        return "index?faces-redirect=true";
    }

    public String editar(Long id) {
        producto = productoService.porId(id)
                .orElse(new Producto());
        return "form";
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

    public List<Categoria> getCategorias() {
        if (categorias == null) {
            categorias = productoService.listarCategorias();
        }
        return categorias;
    }



    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
