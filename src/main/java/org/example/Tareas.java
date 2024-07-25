package org.example;

public class Tareas {
    String id_tarea;
    String nombre;
    String descripcion;
    String imagen;
    String NombreEncargado;
    int avance;

    public Tareas() {
    }

    public Tareas(String id_tarea, String nombre, String descripcion, String imagen, String nombreEncargado, int avance) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        NombreEncargado = nombreEncargado;
        this.avance = avance;
    }

    public String getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(String id_tarea) {
        this.id_tarea = id_tarea;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombreEncargado() {
        return NombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        NombreEncargado = nombreEncargado;
    }

    public int getAvance() {
        return avance;
    }

    public void setAvance(int avance) {
        this.avance = avance;
    }
}
