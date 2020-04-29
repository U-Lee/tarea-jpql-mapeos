/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.uacm.tarea.entidades;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @SequenceGenerator(name = "sec_gen", sequenceName = "generos_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "sec_gen", strategy = GenerationType.SEQUENCE)
    Integer id;

    @Column(name = "nombre")
    String nombre;
    
    
    //Código tarea(2)
    @ManyToMany(mappedBy = "generos")
    private List<Pelicula> peliculas;

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
