/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
 */
public class Borrador extends DibujoLibre {

    public Borrador(Point puntoInicial) {
        super(puntoInicial, Color.WHITE);
    }

    @Override
    public void dibujar(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;
        
        int tamanoDeCuadrito = 5 * (getGrosor());
        
        g2.setColor(getColorSecundario());
        
        if (puntos.size() == 1) {
            Point puntoActual = puntos.get(0);
            g2.fillRect(
                    puntoActual.x - tamanoDeCuadrito,
                    puntoActual.y - tamanoDeCuadrito,
                    tamanoDeCuadrito*2, tamanoDeCuadrito*2);
        }
        
        for (int i = 1; i < puntos.size(); i++) {
            Point puntoAnterior = puntos.get(i - 1);
            Point puntoActual = puntos.get(i);
            int[] puntosX = new int[]{
                puntoAnterior.x - tamanoDeCuadrito,
                puntoActual.x - tamanoDeCuadrito,
                puntoActual.x + tamanoDeCuadrito,
                puntoAnterior.x + tamanoDeCuadrito};
            
            int[] puntosY = new int[]{
                puntoAnterior.y - tamanoDeCuadrito,
                puntoActual.y - tamanoDeCuadrito,
                puntoActual.y + tamanoDeCuadrito,
                puntoAnterior.y + tamanoDeCuadrito};
            
            g2.fillPolygon(puntosX, puntosY, 4);
            //g.fillRect( puntoActual.x - 5, puntoActual.y - 5, 10, 10);
        }

        System.out.println("puntos: " + puntos.size());
    }

}
