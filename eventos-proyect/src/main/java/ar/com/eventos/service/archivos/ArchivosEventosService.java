package ar.com.eventos.service.archivos;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

import ar.com.eventos.domain.Evento;

public interface ArchivosEventosService {
    void exportarEventosCsv(List<Evento> eventos);

    void cerrarWriter();
}
