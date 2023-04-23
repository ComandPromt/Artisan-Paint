package figuras.basicas;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import util.Figura;

public class Linea extends Figura {

	Point puntoInicial;

	Point puntoFinal;

	public Linea(Point puntoInicial, Point puntoFinal, Color color) {

		this.puntoInicial = puntoInicial;

		this.puntoFinal = puntoFinal;

	}

	@Override
	public void actualizar(Point puntoActual) {

		this.puntoFinal = puntoActual;

	}

	@Override
	public void dibujar(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);

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

}
