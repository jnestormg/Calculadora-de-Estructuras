/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorat;

/**
 *
 * @author Nestor
 */
public class Terreno {

    protected float largoTerreno;

    protected float anchoTerreno;
    /**
     * Se agrega el largo y ancho del terreno en metros para calcular el área
     * para la estructura
     * Se Agregaran números decimales 
     * Ejemplo: Largo: 20, Ancho: 10.5
     * @param largoTerreno
     * @param anchoTerreno 
     */

    public Terreno(float largoTerreno, float anchoTerreno) {
        this.largoTerreno = largoTerreno;
        this.anchoTerreno = anchoTerreno;
    }

    public float getLargoTerreno() {
        return largoTerreno;
    }

    public void setLargoTerreno(float largoTerreno) {
        this.largoTerreno = largoTerreno;
    }

    public float getAnchoTerreno() {
        return anchoTerreno;
    }

    public void setAnchoTerreno(float anchoTerreno) {
        this.anchoTerreno = anchoTerreno;
    }

    public float calcularAreaTerreno() {
        return anchoTerreno * largoTerreno;
    }

}
