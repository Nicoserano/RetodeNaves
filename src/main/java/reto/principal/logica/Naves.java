
package reto.principal.logica;


public abstract class Naves {
    
    private int numNave;
    private String nombre;
    private String tipo;
    private String proposito;
    
    public abstract void objetivo();
    public abstract void despegue();

    public Naves() {
    }
    
    

    public Naves(int numNave, String nombre, String tipo, String proposito) {
        this.numNave = numNave;
        this.nombre = nombre;
        this.tipo = tipo;
        this.proposito = proposito;
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

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }
    
    
    
    
    
    
}
