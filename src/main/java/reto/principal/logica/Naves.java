
package reto.principal.logica;


public abstract class Naves {
    
    private int numNave;
    private String nombre;
    private String tipo;
    private String tripulada;
    private int tamaño;
    public abstract void objetivo();
    public abstract void despegue();

    public Naves() {
    }

    public Naves(int numNave, String nombre, String tipo, String tripulada, int tamaño) {
        this.numNave = numNave;
        this.nombre = nombre;
        this.tipo = tipo;
        this.tripulada = tripulada;
        this.tamaño = tamaño;
    }

    public int getNumNave() {
        return numNave;
    }

    public void setNumNave(int numNave) {
        this.numNave = numNave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTripulada() {
        return tripulada;
    }

    public void setTripulada(String tripulada) {
        this.tripulada = tripulada;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    
    
    
    
    
    
}
