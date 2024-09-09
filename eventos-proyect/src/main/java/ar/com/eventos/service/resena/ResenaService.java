package ar.com.eventos.service.resena;

import java.util.List;
import java.util.UUID;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Resena;

public interface ResenaService {
    void dejarReseña(UUID idParticipante, UUID idEvento, int calificación, String comentario);
    void crearResena();
    boolean eliminarResena(UUID id);
    List<Resena> listarResenas();
    void listarResenas(Evento evento);
}