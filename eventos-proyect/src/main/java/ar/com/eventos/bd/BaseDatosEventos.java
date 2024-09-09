package ar.com.eventos.bd;

import java.util.ArrayList;
import java.util.List;

import ar.com.eventos.domain.Evento;

public class BaseDatosEventos {
    private static List<Evento> eventoList;

    public static List<Evento> getEventoList() {
        List<Evento> eventoList = new ArrayList<>();
        return cursoList;
    }

}