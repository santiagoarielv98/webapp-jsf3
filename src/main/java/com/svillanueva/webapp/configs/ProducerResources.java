package com.svillanueva.webapp.configs;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.util.ResourceBundle;

@ApplicationScoped
public class ProducerResources {

    @Produces
    @Named("messages")
    public ResourceBundle produceResourceBundle() {
        return ResourceBundle.getBundle("messages", FacesContext.getCurrentInstance()
                .getViewRoot()
                .getLocale());
    }
}


