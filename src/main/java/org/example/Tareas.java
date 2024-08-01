package org.example;


import org.bson.types.Binary;

public class Tareas {
    String id_tarea;
    String nombre;
    String descripcion;
    String NombreEncargado;
    double avance;
    String fechaAsignacion;
    String fechaVencimiento;
    Binary imagenPrioridad;

    public Tareas() {
    }

    public Tareas(String id_tarea, String nombre, String descripcion, String nombreEncargado, double avance, String fechaAsignacion, String fechaVencimiento, Binary imagenPrioridad) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.NombreEncargado = nombreEncargado;
        this.avance = avance;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaVencimiento = fechaVencimiento;
        this.imagenPrioridad = imagenPrioridad;
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

    public String getNombreEncargado() {
        return NombreEncargado;
    }

    public void setNombreEncargado(String nombreEncargado) {
        NombreEncargado = nombreEncargado;
    }

    public double getAvance() {
        return avance;
    }

    public void setAvance(double avance) {
        this.avance = avance;
    }

    public String getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(String fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Binary getImagenPrioridad() {
        return imagenPrioridad;
    }

    public void setImagenPrioridad(Binary imagenPrioridad) {
        this.imagenPrioridad = imagenPrioridad;
    }
}
