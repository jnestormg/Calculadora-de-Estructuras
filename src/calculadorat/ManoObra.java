/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorat;

/**
 *
 * @author Nestor Meneses
 */
public class ManoObra {

    private float costo;

    /**
     * Se agrega el costo de mano de obra por metro lineal
     * Se debe agregar un número decimal  del costo en pesos
     * Ejemplo: 17.5
     * 
     * @param costo 
     */
    
    public ManoObra(float costo) {
        this.costo = costo;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
