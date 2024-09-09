package ar.com.eventos.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class Evento {

   
    private UUID id;
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaHora;
    private String ubicacion;
    private int capacidadMaxima;

    private List<Chef> chefs;
    private List<Resena> resenas;
    private List<Participante> participantes;



    // Getters y setters
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void FechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public List<Chef> getChefs() {
        return chefs;
    }
        
    public void setChefs(List<Chef> chefs) {
        this.chefs = chefs;
    }    

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public List<Resena> getResenas() {
        return resenas;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
    
    public Chef getChefAsignado() {
        return chefAsignado;
    }

    public void setChefAsignado(Chef chefAsignado) {
        this.chefAsignado = chefAsignado;
    }


    @Override
    public String toString() {

        //Patron builder
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Id : ")
                .append(this.getId()).append("\n")
                .append("Nombre : ")
                .append(this.getNombre()).append("\n")
                .append("Descripcion : ")
                .append(this.getDescripcion()).append("\n")
                .append("Fecha y Hora : ")
                .append(this.getFechaHora()).append("\n")
                .append("Ubicacion : ")
                .append(this.getUbicacion()).append("\n")
                .append("Capacidad : ")
                .append(this.getCapacidadMaxima()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();

    } 
    
    
}
