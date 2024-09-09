package ar.com.eventos.service.resena.impl;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Participante;
import ar.com.eventos.domain.Resena;
import ar.com.eventos.service.ResenaRepository.ResenaRepository;
import ar.com.eventos.service.resena.ResenaService;

public class ResenaServiceImpl implements ResenaService {
    private ResenaRepository resenaRepository;
    
    public ResenaServiceImpl(ResenaRepository resenaRepository) {
        this.resenaRepository = resenaRepository;
    }
    
    @Override
    public void dejarResena(UUID idParticipante, UUID idEvento, int calificacion, String comentario) {
        // Utilizar resenaRepository para guardar la reseña
        Resena resena = new Resena(UUID.randomUUID(), idEvento, idParticipante, calificacion, comentario);
        resenaRepository.save(resena);
    }

    @Override
    public void crearResena() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el ID del participante:");
        UUID idParticipante = UUID.fromString(scanner.nextLine());
    
        System.out.println("Ingrese el ID del evento:");
        UUID idEvento = UUID.fromString(scanner.nextLine());
    
        System.out.println("Ingrese la calificación (1-5):");
        int calificacion = scanner.nextInt();
    
        System.out.println("Ingrese el comentario:");
        String comentario = scanner.next();
    
        dejarResena(idParticipante, idEvento, calificacion, comentario);
    }

    
    
    @Override
    public boolean eliminarResena(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la reseña no puede ser nulo");
            }
            try {
            resenaRepository.eliminarResena(id);
            return true;
            } catch (Exception e) {
            // Manejo de excepciones
            log.error("Error al eliminar la reseña", e);
            return false;
            }
    }

    
    @Override
    public List<Resena> listarResenas() {
        try {
        log.info("Listando reseñas...");
        return resenaRepository.listarResenas();
        } catch (Exception e) {
        // Manejo de excepciones
        log.error("Error al listar reseñas", e);
        throw new RuntimeException("Error al listar reseñas", e);
        }
    }

    @Override
    public void listarResenas(Evento evento) {
        if (evento != null) {
            System.out.println("Lista de reseñas para el evento " + evento.getNombre() + ":");
            for (Resena resena : resenaService.listarResenasPorEvento(evento)) {
                System.out.println(resena.toString());
            }
        } else {
            System.out.println("Lista de reseñas:");
            for (Resena resena : resenaService.listarResenas()) {
                System.out.println(resena.toString());
            }
        }
    }
    
}
    