package ar.com.eventos.service.evento;

import ar.com.eventos.domain.Chef;
import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resena;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.util.List;

import java.util.UUID;

public interface EventoService {

    void crearEvento(String nombre, String descripcion, LocalDateTime fechaHora, String ubicacion, int capacidadMaxima)
    String getFechaFormateada();
    void editarEvento(Evento evento);
    List<Evento> obtenerEventos();
    void eliminarEvento(UUID id);
    Evento buscarEvento(UUID id);
    List<Evento> listarEventosPorFecha(LocalDate fecha);
    void asignarChefAEvento(Chef chef, Evento evento);
    void eliminarChef(Evento evento, Chef chef);
    List<Chef> obtenerChefs(Evento evento);
    void agregarParticipante(Participante participante);

}
