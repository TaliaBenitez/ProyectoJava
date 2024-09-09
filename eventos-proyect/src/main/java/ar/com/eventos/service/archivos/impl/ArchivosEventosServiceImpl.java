package ar.com.eventos.service.archivos.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.service.archivos.ArchivosEventosService;

public class ArchivosEventosServiceImpl implements ArchivosEventosService{
    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\ar\\com\\eventos\\recursos\\";

    CSVWriter csvWriter;


    @Override
    public void exportarEventosCsv(List<Evento> eventos){
        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat("nuevos-eventos.csv");

        try {
        this.csvWriter = new CSVWriter(new FileWriter(ruta));
        // Creamos encabezado
        String[] encabezado = {"ID", "NOMBRE", "DESCRIPCION", "FECHA Y HORA", "UBICACION", "CAPACIDAD MAXIMA"};
        this.csvWriter.writeNext(encabezado);
        if (eventosNoDisponibles != null && !eventosNoDisponibles.isEmpty()) {
            for (Evento evento : eventosNoDisponibles) {
                String[] datos = {
                    evento.getId().toString(),
                    evento.getNombre(),
                    evento.getDescripcion(),
                    evento.getFechaHora().toString(),
                    evento.getUbicacion(),
                    String.valueOf(evento.getCapacidadMaxima())
                };
                this.csvWriter.writeNext(datos);
            }
        } else {
            System.out.println("No hay eventos para exportar");
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Algo salio mal motivo :" + e.getMessage().concat(" Ubicacion archivo : " + ruta));
    } finally {
        if (this.csvWriter != null) {
            try {
                this.csvWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
    }
}


