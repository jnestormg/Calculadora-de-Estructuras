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
public class Tubos {

    private float largoTubo;

    private float anchoTubo;
    /**
     * Se agrega el largo del tubo en metros y el ancho en pulgadas,
     * Ejemplo: Largo: 1, Ancho: 1.5
     * 
     * @param largoTubo
     * @param anchoTubo 
     */

    public Tubos(float largoTubo, float anchoTubo) {
        this.largoTubo = largoTubo;
        this.anchoTubo = anchoTubo;
    }

    public float getLargoTubo() {
        return largoTubo;
    }

    public void setLargoTubo(float largoTubo) {
        this.largoTubo = largoTubo;
    }

    public float getAnchoTubo() {
        return anchoTubo;
    }

    public void setAnchoTubo(float anchoTubo) {
        this.anchoTubo = anchoTubo;
    }

    public float calcularAreaTubo() {
        return anchoTubo * largoTubo;
    }

}
