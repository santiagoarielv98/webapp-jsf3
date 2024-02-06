package com.svillanueva.webapp.controllers;

import com.svillanueva.webapp.entities.Categoria;
import com.svillanueva.webapp.entities.Producto;
import com.svillanueva.webapp.services.ProductoService;
import jakarta.enterprise.inject.Model;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

import java.util.List;

@Model
public class ProductoController {
    @Inject
    private ProductoService productoService;

    @Inject
    private FacesContext facesContext;

    private Producto producto = new Producto();
    private List<Producto> productos;
    private List<Categoria> categorias;

    public String guardar() {
        productoService.guardar(producto);

        if (producto.getId() == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto:", "Producto guardado con éxito."));
        } else {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto:", "Producto actualizado con éxito."));
        }
        productos = null;
        return "index";
    }

    public String editar(Long id) {
        producto = productoService.porId(id)
                .orElse(new Producto());
        return "form";
    }

    public void eliminar(Long id) {
        productoService.eliminar(id);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto:", "Producto eliminado con éxito."));
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
