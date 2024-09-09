package ar.com.eventos.service.participante;

import java.util.List;
import java.util.UUID;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resena;

public interface ParticipanteService {
    Participante registrarParticipante();
    void inscribirseEnEvento(Evento evento);
    void eliminarParticipante(UUID id);
    Participante buscarParticipante(UUID id);
    List<Participante> listarParticipantes();
    void agregarResena(Evento evento, Resena resena);
}
