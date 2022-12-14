package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;

import dibujante.MarcoDeFigura;
import util.Figura;

public class StarFree extends Figura {

	Point p2;

	private static Shape createStar(int anchura, int altura, int centerX, int centerY, int numRays, int innerAngle,
			int startAngleRad) {

		Path2D path = new Path2D.Double();

		try {

			double relX;

			double relY;

			int dividir = 4;

			if (numRays % 2 == 0) {

				if (numRays == 6) {

					if (altura >= 200) {

						altura += (45 * altura) / 300;
					}

					else {

						altura += (10 * altura) / 180;

					}

				}

				else {

					altura += 3;

				}

			}

			else {

				if (numRays == 7) {
					anchura += 10;
				}
				if (numRays == 9) {
					anchura += 5;
				}
			}

			for (int i = 0; i < numRays; i++) {

				relX = Math.cos(i * 2 * Math.PI / numRays);

				relY = Math.sin(i * 2 * Math.PI / numRays);

				relX *= anchura / 2;

				relY *= altura / 2;

				relX += centerX + anchura / 2;

				relY += centerY + altura / 2;

				if (altura >= 200 && numRays == 6) {

					relY -= 10;

				}

				if (numRays == 7 || numRays == 9) {

					relX -= 5;

				}
				if (i == 0) {

					path.moveTo(relX - anchura / 4, relY - altura / dividir);

				}

				else {

					path.lineTo(relX - anchura / 4, relY - altura / dividir);

				}

			}

			path.closePath();

		}

		catch (Exception e) {

		}

		return path;

	}

	private int grados = 0;

	public StarFree(Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {

		super(color, backgroundColor, figuraRellena);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

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

		int width = getMarcoDeFigura().getAnchura();

		int height = getMarcoDeFigura().getAltura();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		p2 = new Point(width / 2, height / 2);

		try {

			int centerX;

			int centerY;

			centerX = p2.x;

			centerY = p2.y;

			Graphics2D g2d = (Graphics2D) g;

			g.translate(0, 0);

			g2d.translate(0, 0);

			((Graphics2D) g).draw(
					createStar(width, height, x + (p2.x / 2), y + (p2.y / 2), getVueltas(), 180 * (5 - 2) / 5, 0));

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	@Override

	public void rotar(int grados) {

		this.grados = grados;

	}

}
