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
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Berlis
 */
public class Anillo extends Figura {

    public Anillo(Point ubicacion, int anchura, int altura, Color color) {
        super(color);
        setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));
    }

    @Override
    public void actualizar(Point puntoActual) {
        getMarcoDeFigura().actualizarDimensiones(puntoActual);
    }

    @Override
    public void dibujar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        getMarcoDeFigura().calcularDimensiones();

        int x = getMarcoDeFigura().getX();
        int y = getMarcoDeFigura().getY();
        int anchura = getMarcoDeFigura().getAnchura();
        int altura = getMarcoDeFigura().getAltura();

        Shape anillo = crearFiguraDeAnillo(x, y, anchura, altura);

        if (dibujarRellena()) {
            g2.setColor(getColorSecundario());
            g2.fill(anillo);
        }

        g2.setColor(getColor());
        g2.setStroke(new BasicStroke(getGrosor()));
        g2.draw(anillo);

    }

    private Shape crearFiguraDeAnillo(double x, double y, double anchura, double altura) {
        Ellipse2D externa = new Ellipse2D.Double(x, y, anchura, altura);
        Ellipse2D interna = new Ellipse2D.Double(x + anchura / 4, y + altura / 4, anchura / 2, altura / 2);
        Area area = new Area(externa);
        area.subtract(new Area(interna));
        return area;
    }

    //Metodo original tomado prestado de StackOverFlow
    /*private Shape createRingShape(
            double centerX, double centerY, double outerRadius, double thickness) {
        Ellipse2D outer = new Ellipse2D.Double(
                centerX - outerRadius,
                centerY - outerRadius,
                outerRadius + outerRadius,
                outerRadius + outerRadius);
        Ellipse2D inner = new Ellipse2D.Double(
                centerX - outerRadius + thickness,
                centerY - outerRadius + thickness,
                outerRadius + outerRadius - thickness - thickness,
                outerRadius + outerRadius - thickness - thickness);
        Area area = new Area(outer);
        area.subtract(new Area(inner));
        return area;
    }*/

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
