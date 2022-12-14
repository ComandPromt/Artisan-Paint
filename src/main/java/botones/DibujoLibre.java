
package botones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

import dibujante.VentanaPrincipal;
import figuras.Linea;
import util.Figura;

public class DibujoLibre extends Figura {

	protected ArrayList<Point> puntos;

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

	public DibujoLibre(Point puntoInicial, Color color) {

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

		if (VentanaPrincipal.verRegla.isSelected()) {

			pintarRegla(g);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g.setColor(getColor());

		if (puntos.size() == 1) {

			g2.drawLine(puntos.get(0).x, puntos.get(0).y, puntos.get(0).x, puntos.get(0).y);

		}

		for (int i = 1; i < puntos.size(); i++) {

			Linea lineaActual = new Linea(puntos.get(i - 1), puntos.get(i), getColor());

			lineaActual.dibujar(g2);
		}

	}

	public void rotar(int grados) {

	}

}
