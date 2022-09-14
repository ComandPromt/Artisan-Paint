/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author josearielpereyra
 */
public class DibujoLibre extends Figura {

    protected ArrayList<Point> puntos;

    public void dibujarMarcoDeSeleccion(Graphics g) {

    }

    @Override
    public boolean contiene(Point punto) {
        return false;
    }
    
    @Override
    public Cursor getCursor(Point p) {
        return new Cursor(Cursor.CROSSHAIR_CURSOR);
    }

    public DibujoLibre(Point puntoInicial, Color color) {
        super(color);
        puntos = new ArrayList<>();
        puntos.add(puntoInicial);
    }

    @Override
    public void actualizar(Point puntoActual) {
        puntos.add(puntoActual);
    }

    @Override
    public void dibujar(Graphics g) {
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(getGrosor()));
        g.setColor(getColor());

        if (puntos.size() == 1) {
            g2.drawLine(puntos.get(0).x, puntos.get(0).y, puntos.get(0).x, puntos.get(0).y);
        }

        for (int i = 1; i < puntos.size(); i++) {
            Linea lineaActual = new Linea(puntos.get(i - 1), puntos.get(i), getColor());
            lineaActual.dibujar(g2);
        }

        System.out.println("puntos: " + puntos.size());
    }

    @Override
    public void rotar(Graphics g, int grados) {
    //
    }

}
