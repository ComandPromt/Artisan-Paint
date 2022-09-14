package figuras;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
 */
public class Linea extends Figura {

    Point puntoInicial;
    Point puntoFinal;

    public Linea(Point puntoInicial, Point puntoFinal, Color color) {
        super(color);
        this.puntoInicial = puntoInicial;
        this.puntoFinal = puntoFinal;
    }

    public void actualizar(Point puntoActual) {
        this.puntoFinal = puntoActual;
    }

    public void dibujar(Graphics g) {
        //g.setColor(getColor());
        g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);
    }

    @Override
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

    @Override
    public void rotar(Graphics g, int grados) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
