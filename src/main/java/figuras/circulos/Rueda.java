
package figuras.circulos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Rueda extends Figura {

	public Rueda(Point ubicacion, int anchura, int altura) {

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, false));

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawOval(x, y, anchura, altura);

		Point2D.Float centerPoint;

		int center = anchura / 2;

		centerPoint = new Point2D.Float(center, center);

		int divisiones = getVueltas();

		if (divisiones == 1) {

			divisiones = 2;

		}

		int centro = anchura / 2;

		Point2D.Float loc;

		for (int x1 = 0; x1 < divisiones; x1++) {

			loc = rotatedPoint(x, y, centerPoint, anchura,
					fracToRad(x1, divisiones) + (float) (2 * Math.PI / (divisiones * 2)));

			g.drawLine(x + centro, y + centro, (int) loc.x, (int) loc.y);

		}

	}

	private static Point2D.Float rotatedPoint(int x, int y, Point2D.Float center, double diameter, double rad) {

		double radius = diameter / 2;

		return new Point2D.Float(x + ((float) (Math.cos(rad) * radius + center.x)),

				y + ((float) (-Math.sin(rad) * radius + center.y)));

	}

	public static float fracToRad(int num, int denom) {

		return (float) (((double) num) / ((double) denom) * 2 * Math.PI);

	}

}
