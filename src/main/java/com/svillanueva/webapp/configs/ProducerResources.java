package com.svillanueva.webapp.configs;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.ws.rs.Produces;

@ApplicationScoped
public class ProducerResources {
    @Produces
    @RequestScoped
    public FacesContext getFacesContext() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext()
                .getFlash()
                .setKeepMessages(true);
        return facesContext;
    }
}