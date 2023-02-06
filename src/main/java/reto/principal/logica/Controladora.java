
package reto.principal.logica;

import reto.principal.persistencia.ControladoraPersistencia;


public class Controladora {
    ControladoraPersistencia controla = new ControladoraPersistencia ();

    public void agregar(String nombre, String tipo, String tripulada, int tamaño) {
        
        
        
        if (tipo=="lanzadera"){
            lanzaderas lan = new lanzaderas();
            lan.setNombre(nombre);
            lan.setTipo(tipo);
            lan.setTripulada(tripulada);
            lan.setTamaño(tamaño);
            
        }
        if (tipo=="Nave No tripulada"){
            lanzaderas lan = new lanzaderas();
            lan.setNombre(nombre);
            lan.setTipo(tipo);
            lan.setTripulada(tripulada);
            lan.setTamaño(tamaño);
        }
        if (tipo=="Nave tripulada"){
            lanzaderas lan = new lanzaderas();
            lan.setNombre(nombre);
            lan.setTipo(tipo);
            lan.setTripulada(tripulada);
            lan.setTamaño(tamaño);
        }
        else{
            
        }
        controla.agregar();
    }
    
}
