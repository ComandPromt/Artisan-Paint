package figuras.basicas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.LinkedList;

import dibujante.Figura;

public class Line extends Figura {

	protected LinkedList<Point> puntos;

	@Override
	public boolean contiene(Point punto) {

		return false;

	}

	public Line(Point puntoInicial) {

		puntos = new LinkedList<>();

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

		g2.drawLine(puntos.getFirst().x, puntos.getFirst().y, puntos.getLast().x, puntos.getLast().y);

	}

}
