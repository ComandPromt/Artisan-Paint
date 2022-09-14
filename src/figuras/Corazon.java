/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Berlis
 */
public class Corazon extends Figura {

    public Corazon(Point ubicacion, int anchura, int altura, Color color) {
        super(color);
        setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));
    }

    @Override
    public void actualizar(Point puntoActual) {
        getMarcoDeFigura().actualizarDimensiones(puntoActual);
    }

    @Override
    public void dibujar(Graphics g) {
        getMarcoDeFigura().calcularDimensiones();
        Graphics2D g2 = (Graphics2D) g;

        int x = getMarcoDeFigura().getX();
        int y = getMarcoDeFigura().getY();
        int anchura = getMarcoDeFigura().getAnchura();
        int altura = getMarcoDeFigura().getAltura();

        //Punto de las lineas
        Point punto1 = new Point((int) (x + anchura / 6.64516129), y + (int) (altura / 1.9047619));
        Point punto2 = new Point(x + anchura / 2, y + altura);

        Point punto3 = new Point((int) (x + anchura - anchura / 6.64516129), y + (int) (altura / 1.9047619));
        Point punto4 = new Point(x + anchura / 2, y + altura);

        if (dibujarRellena()) {
            //Relleno
            g2.setColor(getColorSecundario());
            g2.fillArc(x + anchura / 12, y + altura / 10, anchura / 2, altura / 2, 45, 360);
            g2.fillArc(x - anchura / 12 + anchura / 2, y + altura / 10, anchura / 2, altura / 2, -45, 360);
            g2.fillPolygon(new int[]{punto1.x, punto2.x, punto3.x, punto4.x}, new int[]{punto1.y, punto2.y, punto3.y, punto4.y}, 3);

        }

        g2.setStroke(new BasicStroke(getGrosor()));
        g2.setColor(getColor());

        //Arcos
        g2.drawArc(x + anchura / 12, y + altura / 10, anchura / 2, altura / 2, 45, 180);
        g2.drawArc(x - anchura / 12 + anchura / 2, y + altura / 10, anchura / 2, altura / 2, -45, 180);
        //Lineas
        g2.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);
        g2.drawLine(punto3.x, punto3.y, punto4.x, punto4.y);

    }

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
