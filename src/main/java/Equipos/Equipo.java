package Equipos;

public class Equipo {
    String nombre;
    String id_grupo;
    String desarrollador1;
    String desarrollador2;
    String desarrollador3;
    String desarrollador4;
    String desarrollador5;

    public Equipo() {
    }

    public Equipo(String nombre, String desarrollador1, String desarrollador3, String desarrollador2, String desarrollador4, String desarrollador5, String id_grupo) {
        this.nombre = nombre;
        this.desarrollador1 = desarrollador1;
        this.desarrollador3 = desarrollador3;
        this.desarrollador2 = desarrollador2;
        this.desarrollador4 = desarrollador4;
        this.desarrollador5 = desarrollador5;
        this.id_grupo = id_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador1() {
        return desarrollador1;
    }

    public void setDesarrollador1(String desarrollador1) {
        this.desarrollador1 = desarrollador1;
    }

    public String getDesarrollador2() {
        return desarrollador2;
    }

    public void setDesarrollador2(String desarrollador2) {
        this.desarrollador2 = desarrollador2;
    }

    public String getDesarrollador3() {
        return desarrollador3;
    }

    public void setDesarrollador3(String desarrollador3) {
        this.desarrollador3 = desarrollador3;
    }

    public String getDesarrollador4() {
        return desarrollador4;
    }

    public void setDesarrollador4(String desarrollador4) {
        this.desarrollador4 = desarrollador4;
    }

    public String getDesarrollador5() {
        return desarrollador5;
    }

    public void setDesarrollador5(String desarrollador5) {
        this.desarrollador5 = desarrollador5;
    }

    public String getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(String id_grupo) {
        this.id_grupo = id_grupo;
    }
}
