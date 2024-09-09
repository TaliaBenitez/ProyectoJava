package ar.com.eventos;
import java.util.Scanner;

import ar.com.eventos.domain.GestionEventos;
import ar.com.eventos.service.archivos.ArchivosEventosService;
import ar.com.eventos.service.archivos.impl.ArchivosEventosServiceImpl;
import ar.com.eventos.service.evento.EventoService;
import ar.com.eventos.service.evento.impl.EventoServiceImpl;
import ar.com.eventos.service.participante.ParticipanteService;
import ar.com.eventos.service.participante.impl.ParticipanteServiceImpl;
import ar.com.eventos.service.gestionEventos.GestionEventosService;
import ar.com.eventos.service.gestionEventos.impl.GestionEventosServiceImpl;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.service.menu.impl.MenuServiceImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        GestionEventos gestionEventos = new GestionEventos();
        ParticipanteService participanteService = new ParticipanteServiceImpl();
        GestionEventosService gestionEventosService = new GestionEventosServiceImpl(gestionEventos);
        ArchivosEventosService archivosEventosService = new ArchivosEventosServiceImpl();

        EventoService eventoService = new EventoServiceImpl(participanteService, gestionEventosService);
        MenuService menuService = new MenuServiceImpl(eventoService, archivosEventosService);
        Scanner scanner = new Scanner(System.in);

        menuService.mostrarMenu(scanner);

        scanner.close();
        archivosEventosService.cerrarWriter();
    }
}
