package ar.com.eventos.domain;

import java.util.UUID;

public class Resena {
    private UUID id;
    private Evento evento;
    private Participante participante;
    private int calificacion;
    private String comentario;

    public Resena(UUID id, Evento evento, Participante participante, int calificacion, String comentario) {
        if (calificacion <= 1 || calificacion >= 5) {
            throw new IllegalArgumentException("La calificación debe ser del 1 al 5");
        }
        this.id = id;
        this.evento = evento;
        this.participante = participante;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificación(int calificación) {
        if (calificación <= 1 || calificación >= 5) {
        throw new RuntimeException("Calificación inválida");
        }
        this.calificación = calificación;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {

        //Patron builder
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Id : ")
                .append(this.getId()).append("\n")
                .append("Calificacion: ")
                .append(this.getCalificacion()).append("\n")
                .append("Comentario: ")
                .append(this.getComentario()).append("\n")
                .append("-------------------------------------------------------\n")
                .toString();

    } 
}