package ar.com.eventos.service.chef.impl;

public class ChefServiceImpl implements ChefService {
    private GestionChefs gestionChefs;
    
    public ChefServiceImpl(GestionChefs gestionChefs) {
    this.gestionChefs = gestionChefs;
    }
    
    @Override
    public void agregarChef(Chef chef) {
    gestionChefs.agregarChef(chef);
    }
    
    @Override
    public void eliminarChef(UUID id) {
    gestionChefs.eliminarChef(id);
    }
    
    @Override
    public Chef buscarChef(UUID id) {
    return gestionChefs.buscarChef(id);
    }
    
    @Override
    public List<Chef> listarChefs() {
    return gestionChefs.obtenerChefs();
    }
    
}
