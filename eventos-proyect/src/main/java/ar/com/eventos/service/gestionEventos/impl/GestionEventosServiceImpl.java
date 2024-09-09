package ar.com.eventos.service.gestionEventos.impl;
import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.GestionEventos;
import ar.com.eventos.service.gestionEventos.GestionEventosService;

import java.util.List;

public class GestionEventosServiceImpl implements GestionEventosService{
    GestionEventos gestionEventos;

    public GestionEventosServiceImpl(GestionEventos gestionEventos) {
        this.gestionEventos = gestionEventos;
    }

    @Override
    public List<Evento> getEventos() {
        return this.gestionEventos.getEventos();
    }

}
