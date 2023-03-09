package figuras;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;

import dibujante.VentanaPrincipal;
import util.Figura;

public class Linea extends Figura {

	Point puntoInicial;

	Point puntoFinal;

	public Linea(Point puntoInicial, Point puntoFinal, Color color) {

		

		this.puntoInicial = puntoInicial;

		this.puntoFinal = puntoFinal;

	}

	public void actualizar(Point puntoActual) {

		this.puntoFinal = puntoActual;

	}

	public void dibujar(Graphics g) {

		if (VentanaPrincipal.verRegla.isSelected()) {

			pintarRegla(g);

		}

		g.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);

	}

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

	public void rotar(int grados) {

	}

}
