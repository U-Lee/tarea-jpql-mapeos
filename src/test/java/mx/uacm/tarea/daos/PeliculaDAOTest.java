package mx.uacm.tarea.daos;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.uacm.tarea.daos.impl.PeliculaDAOImpl;
import mx.uacm.tarea.entidades.Pelicula;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PeliculaDAOTest {

    private static EntityManager em;

    private static PeliculaDAO peliculaDAO;

    @BeforeAll
    public static void inicializar() {
        System.out.println("inicializando");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas-memoria");
        //Para usar la base de datos "de verdad", comente la linea de arriba y descomente la siguiente linea.
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("base-pruebas");
        em = emf.createEntityManager();
        peliculaDAO = new PeliculaDAOImpl(em);
    }

    @AfterAll
    public static void terminar() {
        System.out.println("terminando");
    }

    @BeforeEach
    public void antesDeCadaTest() {
        System.out.println("antes del test");
        em.getTransaction().begin(); //iniciamos transaccion
    }

    @AfterEach
    public void despuesDeCadaTest() {
        System.out.println("despues del test");
        em.flush();
        em.getTransaction().rollback();
    }

    @Test
    @Order(1)
    public void buscarPorId() {
        Pelicula d = peliculaDAO.buscarPorId(1);
        Assertions.assertNotNull(d);

        //Código tarea (1)
        assertEquals(1, d.getGeneros().size());
    }

    //Código tarea(3)
    @Test
    @Order(2)
    public void peliculasPorFechaTest() {
        GregorianCalendar cal = new GregorianCalendar(1990, 0, 1);
        Date fechaMinima = cal.getTime();
        GregorianCalendar cal2 = new GregorianCalendar(2015, 0, 1);
        Date fechaMaxima = cal2.getTime();
        List<Pelicula> peliculas = peliculaDAO.peliculasPorFecha(fechaMinima, fechaMaxima);
        System.out.println("peliculas fecha:" + peliculas);
        assertEquals(3, peliculas.size());
    }

    //Código tarea(4)
    @Test
    @Order(3)
    public void peliculasPorNombreTest() {
        List<Pelicula> peliculas = peliculaDAO.peliculasPorNombre("%Voraz");
        System.out.println("peliculas nombre:" + peliculas);
        assertEquals(1, peliculas.size());
    }

    //Código tarea(5)
    @Test
    @Order(4)
    public void peliculasSinGeneroTest() {
        List<Pelicula> peliculas = peliculaDAO.peliculasSinGenero();
        System.out.println("peliculas nombre:" + peliculas);
        assertEquals(2, peliculas.size());
    }
}
