package ar.com.eventos.service.ResenaRepository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import ar.com.eventos.domain.Evento;
import ar.com.eventos.domain.Resena;
import ar.com.eventos.service.ResenaRepository.ResenaRepository;

public class ResenaRepositoryServiceImpl implements ResenaRepository {
    private List<Resena> reseñas = new ArrayList<>();
    
    @Override
    public void save(Resena resena) {
        if (resena != null) {
            reseñas.add(resena);
            } else {
            throw new RuntimeException("La reseña no puede ser nula");
            }
    }
    
    @Override
    public List<Resena> listarResenas() {
    return reseñas;
    }
    
    @Override
    public List<Resena> listarResenasPorEvento(Evento evento) {
        if (evento != null) {
            return reseñas.stream()
            .filter(resena -> resena.getEvento().equals(evento))
            .collect(Collectors.toList());
            } else {
            throw new RuntimeException("El evento no puede ser nulo");
            }
    }
    
    @Override
    public void eliminarResena(UUID id) {
        if (id != null) {
            reseñas.removeIf(resena -> resena.getId().equals(id));
            } else {
            throw new RuntimeException("El ID no puede ser nulo");
            }
    }
}