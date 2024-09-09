package ar.com.eventos.service.evento.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

import ar.com.eventos.domain.Chef;
import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.GestionEventos;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.service.evento.EventoService;

public class EventoServiceImpl implements EventoService {
    private GestionEventos gestionEventos;
    
    public EventoServiceImpl(GestionEventos gestionEventos) {
        this.gestionEventos = gestionEventos;
    }
    
    @Override
    public void crearEvento(String nombre, String descripcion, LocalDateTime fechaHora, String ubicacion, int capacidadMaxima) {
        
        Evento nuevoEvento = new Evento();
        Scanner sc = new Scanner(System.in);

        nuevoEvento.setId( UUID.randomUUID() );

        System.out.println("Ingrese el nombre del Evento:");
        String nombreEvento = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setNombre( nombreEvento );

        System.out.println("Ingrese una breve descripcion del Evento:");
        String descripcionEvento = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setDescripcion( descripcionEvento );
        if (nombre == null || nombre.isEmpty() || descripcion == null || descripcion.isEmpty()) {
            throw new Exception("Nombre y descripción son obligatorios");
        
        }

        System.out.println("Ingrese fecha y hora del Evento (yyyy-MM-dd HH:mm):");
        String fechaHoraEvento = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setFechaHora(LocalDateTime.parse(fechaHoraEvento));

        System.out.println("Ingrese la ubicación del Evento:");
        String ubicacionEvento = sc.nextLine();
        sc.nextLine();
        nuevoEvento.setUbicacion(ubicacionEvento);

        System.out.println("Ingrese la capacidad máxima del Evento:");
        int capacidadMaxima = sc.nextInt();
        sc.nextLine();
        nuevoEvento.setCapacidadMaxima(capacidadMaxima);


        if (nombre == null || nombre.isEmpty() || descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("Nombre y descripción son obligatorios");
        }

        GestionEventosService.getEventos().add(nuevoEvento);
        System.out.println("Curso creado satisfactoriamente");

        return nuevoCurso;
    }

    @Override
     public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        return fechaHora.format(formatter);
    }

    @Override
    private void editarEvento(Evento evento) {
        if (evento == null) {
        throw new Exception("Evento no puede ser nulo");
        }
        if (evento.getNombre() == null || evento.getNombre().isEmpty() || evento.getDescripcion() == null || evento.getDescripcion().isEmpty()) {
        throw new Exception("Nombre y descripción del evento son obligatorios");
        }
        for (Evento eventoExistente : this.eventos) {
        if (eventoExistente.getId().equals(evento.getId())) {
        eventoExistente.setNombre(evento.getNombre());
        eventoExistente.setDescripcion(evento.getDescripcion());
        }
        }
    }

   @Override
   public void eliminarEvento(UUID id) {
    if (id == null) {
        throw new NullPointerException("El id del evento no puede ser null");
        }
        if (!eventos.removeIf(evento -> evento.getId().equals(id))) {
        throw new NoSuchElementException("El evento con id " + id + " no existe");
        }
    }


    @Override
    public List<Evento> obtenerEventos() {
        if (this.eventos == null) {
        throw new NullPointerException("La lista de eventos es null");
        }
        return new ArrayList<>(this.eventos);
    }
    @Override
    public void mostrarEventos() {
        System.out.println("Lista de eventos:");
        for (Evento evento : obtenerEventos()) {
        System.out.println(evento.toString());
        }
    }

    
    @Override
    public List<Evento> listarEventosPorFecha(LocalDate fecha) {
        List<Evento> eventosPorFecha = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getFecha().equals(fecha)) {
                eventosPorFecha.add(evento);
            }
        }
        return eventosPorFecha;
    }
    @Override
    public void mostrarEventosPorFecha(LocalDate fecha) {
        System.out.println("Lista de eventos para la fecha " + fecha + ":");
        for (Evento evento : obtenerEventos(fecha)) {
        System.out.println(evento.toString());
        }
    }

    @Override
    public List<Evento> obtenerEventosNoDisponibles() {
        List<Evento> eventos = obtenerEventos();
        return eventos.stream()
        .filter(evento -> evento.getParticipantes().size() >= evento.getCapacidadMaxima())
        .collect(Collectors.toList());
    }
    
    @Override
    public Evento buscarEvento(UUID id) {
        for (Evento evento : this.eventos) {
            if (evento.getId().equals(id)) {
                return evento;
            }
        }
        return null;
    }

    @Override
    public void asignarChefAEvento(Chef chef, Evento evento) {
        if (chef == null || evento == null) {
            throw new Exception("Chef o evento no existen");
        }
        if (chef.estaParticipandoEnEvento(evento)) {
            throw new Exception("El chef ya está asignado a este evento");
        }
       chef.addEvento(evento);
       evento.agregarChef(chef);
       System.out.println("Chef asignado al evento con éxito");
       
    }

    @Override
    public void eliminarChef(Evento evento, Chef chef) {
        if (evento == null || chef == null) {
        throw new Exception("Evento y chef no pueden ser nulos");
        }
        if (!evento.getChefs().contains(chef)) {
        throw new Exception("El chef no está asociado con el evento");
        }
        evento.removeChef(chef);
    }

    @Override
    public List<Chef> obtenerChefs(Evento evento) {
        if (evento == null) {
        throw new NullPointerException("El evento no puede ser null");
        }
        List<Chef> chefs = evento.getChefs();
        if (chefs == null || chefs.isEmpty()) {
        throw new IllegalArgumentException("El evento no tiene chefs asociados");
        }
        return chefs;
    }


    @Override
    public void agregarParticipante(Participante participante) {
        if (participante == null) {
        throw new NullPointerException("El participante no puede ser null");
        }
        if (participantes.contains(participante)) {
        throw new IllegalArgumentException("El participante ya está en la lista");
        }
        participantes.add(participante);
    }
        

    
}
    
