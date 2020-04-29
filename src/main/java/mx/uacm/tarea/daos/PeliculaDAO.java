/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.daos;

import java.util.Date;
import java.util.List;
import mx.uacm.tarea.entidades.Pelicula;

public interface PeliculaDAO extends GenericDAO<Pelicula, Integer> {

    //Código tarea(3)
    List<Pelicula> peliculasPorFecha(Date fechaMin, Date fechaMax);
    
    //Código tarea(4)
    List<Pelicula> peliculasPorNombre(String nombre);
    
    //Código tarea(5)
    List<Pelicula> peliculasSinGenero();
}
