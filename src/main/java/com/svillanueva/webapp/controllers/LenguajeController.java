package com.svillanueva.webapp.controllers;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Named
@SessionScoped
public class LenguajeController implements Serializable {
    private Locale locale;
    private List<Locale> supportedLocales;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance()
                .getViewRoot()
                .getLocale();
        supportedLocales = Arrays.asList(
                new Locale.Builder().setLanguage("es")
                        .build(),
                new Locale.Builder().setLanguage("en")
                        .build()
        );
    }

    public Locale getLocale() {
        return locale;
    }

    public String getLanguage() {
        return locale.getLanguage();
    }

    public void setLanguage(String language) {
        locale = new Locale.Builder().setLanguage(language)
                .build();
        FacesContext.getCurrentInstance()
                .getViewRoot()
                .setLocale(locale);
    }

    public List<Locale> getSupportedLocales() {
        return supportedLocales;
    }
}
