package org.example;

public class Tareas {
    String id_tarea;
    String nombre;
    String descripcion;
    String imagen;
    String NombreEncargado;
    double avance;
    String fechaAsignacion;
    String fechaVencimiento;

    public Tareas() {
    }

    public Tareas(String id_tarea, String nombre, String descripcion, String imagen, String nombreEncargado, double avance, String fechaAsignacion, String fechaVencimiento) {
        this.id_tarea = id_tarea;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.NombreEncargado = nombreEncargado;
        this.avance = avance;
        this.fechaAsignacion = fechaAsignacion;
        this.fechaVencimiento = fechaVencimiento;
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
}
