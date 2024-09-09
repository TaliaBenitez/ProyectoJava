package ar.com.eventos.service.ResenaRepository;

public interface ResenaRepository {
    void save(Resena resena);
    List<Resena> listarResenas();
    List<Resena> listarResenasPorEvento(Evento evento);
    void eliminarResena(UUID id);
}    
