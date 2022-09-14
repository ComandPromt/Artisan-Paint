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
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;

/**
 *
 * @author Berlis
 */
public class MediaLuna extends Figura {

    public MediaLuna(Point ubicacion, int anchura, int altura, Color color) {
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

        Shape luna = crearFiguraDeLuna(x, y, anchura, altura);
        if (dibujarRellena()) {
            g2.setColor(getColorSecundario());
            g2.fill(luna);
        }

        g2.setStroke(new BasicStroke(getGrosor()));
        g2.setColor(getColor());
        g2.draw(luna);

        //g.drawArc(x, y - altura, anchura, altura *2, 0, -180);
        //g.drawArc(x, y - altura/2, anchura, altura, 0, -180);
    }

    private Shape crearFiguraDeLuna(
            double x, double y, double anchura, double altura) {

        Arc2D.Float externa = new Arc2D.Float(Arc2D.PIE);
        externa.setFrame(x, y - altura, anchura, altura * 2);
        externa.setAngleStart(0);
        externa.setAngleExtent(-180);

        Arc2D.Float interna = new Arc2D.Float(Arc2D.PIE);
        interna.setFrame(x, y - altura / 2, anchura, altura);
        interna.setAngleStart(0);
        interna.setAngleExtent(-180);

        Area area = new Area(externa);
        area.subtract(new Area(interna));
        return area;
    }

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
