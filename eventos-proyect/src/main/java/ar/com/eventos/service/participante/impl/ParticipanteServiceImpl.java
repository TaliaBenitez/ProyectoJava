package ar.com.eventos.service.participante.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.UUID;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resena;
import ar.com.eventos.service.participante.ParticipanteService;

public class ParticipanteServiceImpl implements ParticipanteService {
    private GestionParticipantes gestionParticipantes;
    
    public ParticipanteServiceImpl(GestionParticipantes gestionParticipantes) {
        this.gestionParticipantes = gestionParticipantes;
    }
    
    @Override
    public Participante registrarParticipante() {
        Participante  participanteNuevo   = new Participante();
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Participante: ");
        String nombreParticipante = sc.nextLine();
        sc.nextLine();
        participanteNuevo.setNombre(nombreParticipante);

        System.out.println("Ingrese el Apellido del Participante: ");
        String apellidoParticipante = sc.nextLong();
        participanteNuevo.setApellido(apellidoParticipante);
        sc.nextLine();

        System.out.println("Ingrese el interes culinario del Participante: ");
        String interesesCulinariosParticipante = sc.nextInt();
        participanteNuevo.setInteresesCulinarios(interesesCulinariosParticipante);
        sc.nextLine();

        return participanteNuevo;
    }

    @Override
    public void inscribirseEnEvento(Evento evento) {
        if (evento.getCapacidadMaxima() > evento.getParticipantes().size()) {
            int indice = historialEventos.indexOf(evento);
            if (indice == -1) {
                historialEventos.add(evento);
                evento.agregarParticipante(this);
            } else {
                System.out.println("El participante ya está inscrito en este evento.");
            }
        } else {
            System.out.println("Lo sentimos, el evento ha alcanzado su capacidad máxima.");
        }
    }


    @Override
    public void eliminarParticipante(UUID id) {
        gestionParticipantes.eliminarParticipante(id);
        if (participante != null) {
            gestionParticipantes.getParticipantes().remove(participante);
            
            // Eliminar el participante de los eventos en los que está inscrito
            for (Evento evento : gestionEventos.getEventos()) {
                evento.eliminarParticipante(participante);
            }
        } else {
            System.out.println("El participante no se encuentra en la lista.");
        }
        
    }
    
    
    @Override
    public Participante buscarParticipante(UUID id) {
        if (id == null) {
        throw new NullPointerException("El id del participante no puede ser null");
        }
        try {
        Participante participante = gestionParticipantes.buscarParticipante(id);
        if (participante == null) {
        throw new NoSuchElementException("El participante no existe");
        }
        return participante;
        } catch (Exception e) {
        // Manejo de excepciones, por ejemplo, registrar el error en un log
        logger.error("Error al buscar participante", e);
        return null;
        }
    }
    
    @Override
    public List<Participante> listarParticipantes() {
        List<Participante> participantes = gestionParticipantes.obtenerParticipantes();
        if (participantes == null) {
        return new ArrayList<>(); 
        }
        return new ArrayList<>(participantes); 
    }

    @Override
    public void agregarResena(Evento evento, Resena resena) {
        if (evento == null) {
            throw new IllegalArgumentException("El evento no puede ser null");
            }
            if (resena != null && !evento.getResenas().contains(resena)) {
            evento.getResenas().add(resena);
            } else {
            throw new IllegalArgumentException("Reseña no puede ser null o ya existe en la lista");
            }
    
    }
}


