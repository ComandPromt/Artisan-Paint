package figuras.utils;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;

import util.Figura;

public class Linea extends Figura {

	Point puntoInicial;

	Point puntoFinal;

	public Linea(Point puntoInicial, Point puntoFinal) {

		this.puntoInicial = puntoInicial;

		this.puntoFinal = puntoFinal;

	}

	@Override
	public void actualizar(Point puntoActual) {

		this.puntoFinal = puntoActual;

	}

	@Override
	public void dibujar(Graphics g) {

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

}
