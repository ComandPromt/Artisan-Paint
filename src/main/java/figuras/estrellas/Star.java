package figuras.estrellas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Path2D;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Star extends Figura {

	public Star(Point ubicacion, int anchura, int altura) {

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, false));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	private static Shape createStar(int anchura, int altura, double centerX, double centerY, double innerRadius,
			double outerRadius, int numRays, double startAngleRad) {

		Path2D path = new Path2D.Double();

		try {

			double deltaAngleRad = Math.PI / numRays;

			double angleRad;

			double ca;

			double sa;

			double relX;

			double relY;

			for (int i = 0; i < numRays * 2; i++) {

				angleRad = startAngleRad + i * deltaAngleRad;

				ca = Math.cos(angleRad);

				sa = Math.sin(angleRad);

				relX = ca;

				relY = sa;

				if ((i & 1) == 0) {

					relX *= outerRadius;

					relY *= outerRadius;

				}

				else {

					relX *= innerRadius;

					relY *= innerRadius;

				}

				relX += anchura;

				relY += altura;

				if (i == 0) {

					path.moveTo(centerX + relX, centerY + relY);

				}

				else {

					path.lineTo(centerX + relX, centerY + relY);

				}

			}

			path.closePath();

		}

		catch (Exception e) {

		}

		return path;
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

		int vueltas = getVueltas();

		if (vueltas < 3) {

			vueltas = 3;

		}

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fill(createStar(anchura / 2, altura / 2, x, y, getRadio(), altura / 2, vueltas, 40));

		}

		else {

			g2.draw(createStar(anchura / 2, altura / 2, x, y, getRadio(), altura / 2, vueltas, 40));

		}

	}

}
