package ar.com.eventos.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Chef {
    private UUID id;
    private String nombre;
    private String especialidad;
    private List<Evento> eventos;

    

    // Constructor
    public Chef(UUID id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.eventos = new ArrayList<>();
    }



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    public void agregarEvento(Evento evento) {
        this.eventos.add(evento);
    }

    public void eliminarEvento(Evento evento) {
        if (this.eventos.contains(evento)) {
        this.eventos.remove(evento);
        } else {
        System.out.println("El evento no se encuentra en la lista.");
        }
    }
    public boolean estaParticipandoEnEvento(Evento evento) {
        return this.eventos.contains(evento);
    }

    public void ordenarEventos() {
        Collections.sort(this.eventos, new Comparator<Evento>() {
            @Override
            public int compare(Evento e1, Evento e2) {
                return e1.getFecha().compareTo(e2.getFecha());
            }
        });
    }
}
