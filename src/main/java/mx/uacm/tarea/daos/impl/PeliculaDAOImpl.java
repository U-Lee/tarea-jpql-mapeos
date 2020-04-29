/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos.impl;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import mx.uacm.tarea.daos.PeliculaDAO;
import mx.uacm.tarea.entidades.Pelicula;

public class PeliculaDAOImpl extends GenericDAOImpl<Pelicula, Integer> implements PeliculaDAO {

    public PeliculaDAOImpl(EntityManager em) {
        super(em);
    }

    //Código tarea(3)   
    @Override
    public List<Pelicula> peliculasPorFecha(Date fechaMin, Date fechaMax) {                            
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.fechaEstreno BETWEEN :fechaMin AND :fechaMax",Pelicula.class);
        consulta.setParameter("fechaMin", fechaMin);
        consulta.setParameter("fechaMax", fechaMax);
        List<Pelicula> peliculas = consulta.getResultList();        
        return peliculas;
    }

    //Código tarea(4)
    @Override
    public List<Pelicula> peliculasPorNombre(String nombre) {        
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.titulo LIKE :nombre", Pelicula.class);
        consulta.setParameter("nombre", nombre);
        List<Pelicula> peliculas = consulta.getResultList();
        return peliculas;
    }

    //Código tarea(5)
    @Override
    public List<Pelicula> peliculasSinGenero() {
        TypedQuery<Pelicula> consulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.generos IS EMPTY", Pelicula.class);
        List<Pelicula> peliculas = consulta.getResultList();        
        return peliculas;
    }

}
