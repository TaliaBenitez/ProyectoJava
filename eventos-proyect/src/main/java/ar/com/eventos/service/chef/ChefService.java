package ar.com.eventos.service.chef;

import java.util.List;
import java.util.UUID;

import ar.com.eventos.domain.Chef;

public interface ChefService {
    void agregarChef(Chef chef);
    void eliminarChef(UUID id);
    Chef buscarChef(UUID id);
    List<Chef> listarChefs();
}
