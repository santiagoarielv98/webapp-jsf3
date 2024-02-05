package com.svillanueva.webapp.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String nombre;

    @NotNull
    @Min(5)
    @Max(100000)
    private Integer precio;

    @NotEmpty
    @Size(min = 4, max = 10)
    private String sku;

    @Column(name = "fecha_registro")
    //    @CreationTimestamp
    private LocalDate fechaRegistro;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Categoria categoria;


    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @PrePersist
    public void prePersist() {
        fechaRegistro = LocalDate.now();
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", sku='" + sku + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
