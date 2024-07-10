package com.aluracursos.literalura.service;

public interface IConvierteDatos {
    <T> T obtenerDatos( String jason, Class<T> clase);
}
