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
public class PacMan extends Figura {

    public PacMan(Point ubicacion, int anchura, int altura, Color color) {
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

        Point punto1 = new Point(x+anchura/2, y);
        Point punto2 = new Point(x + (anchura/2), y + (altura/2));
        Point punto3 = new Point(x+anchura,y+altura/2);
        
        if(dibujarRellena()){
            g2.setColor(getColorSecundario());
            g2.fillArc(x, y, anchura, altura,0,-270);
        }
        
        g2.setStroke(new BasicStroke(getGrosor()));
        g2.setColor(getColor());
        
        g2.drawArc(x, y, anchura, altura,0,-270);
        g2.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);
        g2.drawLine(punto2.x, punto2.y,punto3.x, punto3.y);
        
    }

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
