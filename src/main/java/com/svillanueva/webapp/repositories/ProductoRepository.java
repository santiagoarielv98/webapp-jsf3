package com.svillanueva.webapp.repositories;

import com.svillanueva.webapp.entities.Producto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class ProductoRepository implements CrudRepository<Producto> {

    @Inject
    private EntityManager em;

    @Override
    public List<Producto> listar() {
        return em.createQuery("SELECT p FROM Producto p", Producto.class)
                .getResultList();
    }

    @Override
    public Producto porId(Long id) {
        return em.find(Producto.class, id);
    }

    @Override
    public void guardar(Producto producto) {
        if (producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    public void eliminar(Long id) {
        Producto producto = porId(id);
        em.remove(producto);
    }
}
