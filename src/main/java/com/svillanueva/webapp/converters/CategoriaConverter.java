package com.svillanueva.webapp.converters;

import com.svillanueva.webapp.entities.Categoria;
import com.svillanueva.webapp.services.ProductoService;
import jakarta.enterprise.inject.Model;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;


@Model
public class CategoriaConverter implements Converter<Categoria> {

    @Inject
    ProductoService productoService;

    @Override
    public Categoria getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        return productoService.categoriaPorId(Long.parseLong(s))
                .orElse(null);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Categoria categoria) {
        if (categoria == null) {
            return "0";
        }
        return categoria.getId()
                .toString();
    }
}
