package com.aluracursos.literalura.principal;

import com.aluracursos.literalura.model.Datos;
import com.aluracursos.literalura.model.DatosLibros;
import com.aluracursos.literalura.service.ConsumoAPI;
import com.aluracursos.literalura.service.ConvierteDatos;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConsumoAPI consumoAPI= new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private Scanner kb = new Scanner(System.in);
    public void muestraMenu(){

        //Alura base method to get the book info.

        var json = consumoAPI.obtenerDatos(URL_BASE);
        //System.out.println(json);
        var datos = conversor.obtenerDatos(json, Datos.class);
        //System.out.println(datos);

        // Busqueda de Libros por Nombre.
        System.out.println("Ingresa el nombre del libro que deseas buscar: ");
        var tituloLibro = kb.nextLine();
        json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + tituloLibro.replace(" ","+"));
        var datosBusqueda = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLibros> libroBuscado = datosBusqueda.resultados().stream()
                .filter(l -> l.titulo().toUpperCase().contains(tituloLibro.toUpperCase()))
                .findFirst();
        if (libroBuscado.isPresent()) {
            System.out.println("Libro Encontrado");
            //System.out.println(libroBuscado.get());
            System.out.println(
                    "Titulo: "
                    + libroBuscado.get().titulo() + "\n"
                    + "Autor: "
                    + libroBuscado.get().autor().get(0).nombre() + "\n"
                    + "Idioma: "
                    + libroBuscado.get().idiomas() + "\n"
                    + "Numero de descargas: "
                    + libroBuscado.get().numeroDeDescargas() + "\n"
            );
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
