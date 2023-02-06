/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reto.principal.persistencia;


public class ControladoraPersistencia {
    NavesJpaController naves = new NavesJpaController();

    public void agregar() {
        naves.create();
    }
    
}
