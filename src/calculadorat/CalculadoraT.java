/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorat;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * La  Aplicación calcula el número de tubos necesarios para 
 * contruir una techunbre de tubos, así mismo,  calcular el costo de la mano 
 * de obra para la construcción de la estructura.
 * 
 * @author Nestor Meneses
 */
public class CalculadoraT {

    static int op, numTubos;
    static Tubos pipeline;
    static Terreno land;
    static ManoObra labour;
    static float areaTerreno, areaTubos;
    static float espacioTubos = 0, areaEntreTubos;
    static float price = 0;
    static float marco, totalTubos;
    static float areaTubosenTerreno;
    static float widthPipeLine, heightPipeLine;

    public static void main(String[] args) {
        /**
         * Menú.
         * Se debe agregar el número de medidas del tubo, del terreno,
         * costo de mano de obra y el espacio que existe entre los tubos
         * que estan dentro del marco de la estructura metalica.
         */

        do {

            String opcion = JOptionPane.showInputDialog(" Menú"
                    + "\n1. Agregar medidas del tubo. \n"
                    + "2. Agregar medidas del terreno. \n"
                    + "3. Agregar costo de mano de obra. \n"
                    + "4. Agregar espacio entre tubos. \n"
                    + "5. Mostrar resultados. \n"
                    + "6. Salir. ");

            op = Integer.parseInt(opcion);

            switch (op) {
                case 1:
                    //Tubos
                    String largoTubo = JOptionPane.showInputDialog("Largo en metros: ").trim();
                    String anchoTubo = JOptionPane.showInputDialog("Ancho en pulgada: ").trim();
                    if (!largoTubo.isEmpty() && !anchoTubo.isEmpty()) {
                        heightPipeLine = Float.parseFloat(largoTubo);
                        widthPipeLine = Float.parseFloat(anchoTubo);
                        widthPipeLine = ((widthPipeLine * 2.54f) / 100); //convertir pulgada a cm 
                        pipeline = new Tubos(heightPipeLine, widthPipeLine);
                        areaTubos = pipeline.calcularAreaTubo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo vacio. \n Agregar dato.");
                    }

                    break;
                case 2:
                    //Terreno
                    String largoTerreno = JOptionPane.showInputDialog("Largo en metros: ").trim();
                    String anchoTerreno = JOptionPane.showInputDialog("Ancho en metros: ").trim();
                    if (!largoTerreno.isEmpty() && !anchoTerreno.isEmpty()) {
                        float heightLand = Float.parseFloat(largoTerreno);
                        float widthLand = Float.parseFloat(anchoTerreno);
                        land = new Terreno(heightLand, widthLand);
                        areaTerreno = land.calcularAreaTerreno();
                    } else {
                        JOptionPane.showMessageDialog(null, "Campo vacio. \n Agregar dato.");
                    }

                    break;
                case 3:
                    //Mano de obra
                    String costo = JOptionPane.showInputDialog("Costo por metro lineal: ").trim();
                    if (!costo.isEmpty()) {
                        price = Float.parseFloat(costo);
                        labour = new ManoObra(price);
                    }

                    break;
                case 4:
                    //Espacio entre tubos
                    String space = JOptionPane.showInputDialog("Agregar espacio entre tubos en centímetros: ").trim();
                    if (!space.isEmpty()) {
                        espacioTubos = Float.parseFloat(space);
                        espacioTubos = (espacioTubos / 100);
                        areaEntreTubos = espacioTubos * pipeline.getLargoTubo();
                    }
                    break;
                case 5:
                    //Mostrar información
                    try {
                        marco = ((pipeline.getAnchoTubo() * land.getAnchoTerreno()) * 2)
                                + (((land.largoTerreno - (pipeline.getAnchoTubo()) * 2) * pipeline.getAnchoTubo()) * 2);

                        totalTubos = ((land.largoTerreno - (pipeline.getAnchoTubo() * 2))
                                / (pipeline.getAnchoTubo() + espacioTubos));

                        numTubos = (int) totalTubos;

                        areaTubosenTerreno = (pipeline.getAnchoTubo()
                                * (land.anchoTerreno - (pipeline.getAnchoTubo() * 2)));

                        JOptionPane.showMessageDialog(null, "Información \n"
                                + "Área del terreno: (" + land.anchoTerreno + " x " + land.largoTerreno + ")="
                                + areaTerreno + " metros cuadrados"
                                + "\nTotal de tubos por marco: " + (marco / areaTubos) + " de " + pipeline.getLargoTubo() + "m"
                                + "\nNúmero de columnas: " + numTubos
                                + "\nTotal de tubos: " + (((numTubos * areaTubosenTerreno) / areaTubos) + (marco / areaTubos)) + " de " + pipeline.getLargoTubo() + "m"
                                + "\nTotal mano de obra: $" + (((((numTubos * areaTubosenTerreno) / areaTubos) + (marco / areaTubos))
                                * pipeline.getLargoTubo()) * price));
                    } catch (Exception err) {
                        JOptionPane.showMessageDialog(null, "Falta agregar información.");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida. \n Ingrese una opción valida");
            }
        } while (op != 6);

    }

}
