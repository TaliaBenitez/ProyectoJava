package ar.com.eventos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Participante {
    private UUID id;
    private String nombre;
    private String apellido;
    private String interesesCulinarios;
    private List<Evento> historialEventos;
    private List<Resena> resenas;

    // Constructor
    public Participante(UUID id, String nombre, String apellido, String interesesCulinarios) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.interesesCulinarios = interesesCulinarios;
        this.historialEventos = new ArrayList<>();
        this.resenas = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }


    public void setId(UUID id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getInteresesCulinarios() {
        return interesesCulinarios;
    }


    public void setInteresesCulinarios(String interesesCulinarios) {
        this.interesesCulinarios = interesesCulinarios;
    }


    public List<Evento> getHistorialEventos() {
        return historialEventos;
    }


    public void setHistorialEventos(List<Evento> historialEventos) {
        this.historialEventos = historialEventos;
    }


    public List<Resena> getResenas() {
        return resenas;
    }


    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
}

