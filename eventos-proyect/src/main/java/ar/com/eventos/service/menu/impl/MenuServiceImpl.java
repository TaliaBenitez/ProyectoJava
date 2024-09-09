package ar.com.eventos.service.menu.impl;

import ar.com.eventos.service.evento.EventoService;
import ar.com.eventos.service.menu.MenuService;
import ar.com.eventos.bd.BaseDatosEventos;
import ar.com.eventos.domain.Chef;
import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.service.archivos.ArchivosEventosService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class MenuServiceImpl implements MenuService{
    private EventoService eventoService;

    private ArchivosEventosService archivosEventosService;

    public MenuServiceImpl(EventoService eventoService, ArchivosEventosService archivosEventosService) {
        this.eventoService = eventoService;
        this.archivosEventosService = archivosEventosService;
    }

    @Override
    public void mostrarMenu(Scanner scanner) {
    int opcion;
    do {
        System.out.println("Menu de opciones:");
        System.out.println("1. Crear evento");
        System.out.println("2. Inscribir participante");
        System.out.println("3. Asignar chef");
        System.out.println("4. Mostrar eventos disponibles");
        System.out.println("5. Exportar eventos");
        System.out.println("6. Salir");
    
        opcion = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcion) {
            case 1:
                eventoService.crearEvento();
                break;
            case 2:
                Participante participante = registrarParticipante();
                System.out.println("Ingrese el ID del evento:");
                String idEvento = scanner.nextLine();
                scanner.nextLine();
                Evento evento = gestionEventos.buscarEvento(UUID.fromString(idEvento));
                if (evento != null) {
                participante.inscribirseEnEvento(evento);
                System.out.println("Inscripción exitosa!");
                } else {
                System.out.println("Evento no encontrado.");
                }
                break;
            case 3:
                System.out.println("Ingrese el ID del evento:");
                String idEvento = scanner.nextLine();
                scanner.nextLine();
                Evento evento = gestionEventos.buscarEvento(UUID.fromString(idEvento));
                System.out.println("Ingrese el ID del chef:");
                String idChef = scanner.nextLine();
                scanner.nextLine();
                Chef chef = gestionChefs.buscarChef(UUID.fromString(idChef));
                gestionEventos.asignarChefAEvento(chef, evento);
                System.out.println("Chef asignado con éxito!");
                break;
            case 4:
                System.out.println("Ingrese la fecha para mostrar eventos disponibles (formato yyyy-MM-dd):");
                String fechaInput = scanner.next();
                LocalDate fecha = LocalDate.parse(fechaInput);
                List<Evento> eventosDisponibles = gestionEventos.listarEventosPorFecha(fecha);
                if (eventosDisponibles.isEmpty()) {
                System.out.println("No hay eventos disponibles para la fecha " + fecha);
                } else {
                gestionEventos.mostrarEventosPorFecha(fecha);
                }
                break;
            case 5:
                archivosEventosService.exportarEventosCsv(BaseDatosEventos.getEventoList());
                break;
            case 6:
                System.out.println("\n Hasta luego!");
                break;
            default:
                System.out.println("Opción inválida");
        }
    } while (opcion != 6);
    
    }

}
