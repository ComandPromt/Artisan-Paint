
package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class Poligono extends Figura {

	private static double halfPI = Math.PI / 2.0;

	public Poligono(Point ubicacion, int anchura, int altura) {

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, false));

	}

	@Override
	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	static private Shape regularPolygon(int sides, double x, double y, double width, double height) {

		Path2D poly = new Path2D.Double(Path2D.WIND_EVEN_ODD, 12);

		if (sides > 3) {

			width = width / 2;

			height = height / 2;

			switch (sides) {

			case 5:

				height += height / 9.7;

				x -= width / 20;

				width += width / 20;

				break;

			case 6:

				x -= width / 6.5;

				width += width / 6.5;

				break;

			case 7:

				x -= width / 40;

				width += width / 40;

				height += height / 20;

				break;

			case 9:

				x -= width / 70;

				width += width / 70;

				height += height / 35;

				break;

			case 10:

				x -= width / 20;

				width += width / 20;

				break;

			case 11:

				x -= width / 100;

				width += width / 100;

				height += height / 50;

				break;

			case 13:

				height += height / 85;

				width += width / 300;

				break;

			case 15:

				width += width / 300;

				height += height / 100;

				break;

			case 17:

				height += height / 100;

				break;

			case 18:

				x -= width / 100;

				width += width / 90;

				break;

			}

			if (sides >= 19 && sides % 2 != 0) {

				height += height / 200;

			}

			x = x + width;

			y = y + height;

			Point2D.Double points[] = new Point2D.Double[sides];

			for (int i = 0; i < sides; i++) {

				double x1 = circleX(sides, i) * width + x;

				double y1 = circleY(sides, i) * height + y;

				double x2 = circleX(sides, (i + 1) % sides) * width + x;

				double y2 = circleY(sides, (i + 1) % sides) * height + y;

				points[i] = new Point2D.Double(x1, y1);

				points[(i + 1) % sides] = new Point2D.Double(x2, y2);

			}

			poly.moveTo(points[0].getX(), points[0].getY());

			for (int i = 1; i < sides; i++) {

				poly.lineTo(points[i].getX(), points[i].getY());

			}

			poly.closePath();

		}

		return poly;

	}

	static double circleX(int sides, int angle) {

		double coeff = (double) angle / (double) sides;

		return epsilon(Math.cos(2 * coeff * Math.PI - halfPI));

	}

	static double circleY(int sides, int angle) {

		double coeff = (double) angle / (double) sides;

		return epsilon(Math.sin(2 * coeff * Math.PI - halfPI));

	}

	static double epsilon(double v) {

		if (Math.abs(v) < 1.0E-10)

			return 0.0;

		return v;

	}

	@Override
	public void dibujar(Graphics g) {

		if (getVueltas() < 3) {

			setVueltas(3);

		}

		Graphics2D g2 = (Graphics2D) g;

		getMarcoDeFigura().calcularDimensiones();

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		if (getVueltas() == 3) {

			Point punto1 = new Point(x + (anchura / 2), y);

			Point punto2 = new Point(x, y + altura);

			Point punto3 = new Point(x + anchura, y + altura);

			int[] puntosX = { punto1.x, punto2.x, punto3.x };

			int[] puntosY = { punto1.y, punto2.y, punto3.y };

			if (dibujarRellena()) {

				g2.setColor(getColorSecundario());

				g2.fillPolygon(puntosX, puntosY, 3);

			}

			else {

				g2.drawPolygon(puntosX, puntosY, 3);

			}

		}

		else {

			if (dibujarRellena()) {

				g2.setColor(getColorSecundario());

				g2.fill(regularPolygon(getVueltas(), x, y, anchura, altura));

			}

			else {

				g2.draw(regularPolygon(getVueltas(), x, y, anchura, altura));

			}

		}

	}

}
