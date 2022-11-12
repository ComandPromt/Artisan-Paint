package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import util.Figura;

public class Star extends Figura {

	private boolean mainLevee;

	int tipo;

	Point p2;

	boolean star360 = false;

	private static Shape createStar(double centerX, double centerY, double innerRadius, double outerRadius, int numRays,
			double startAngleRad) {

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

	public Star(int type) {

		this.tipo = type;

	}

	int conteo = 0;

	@Override
	public void dibujar(Graphics g) {

		try {

			getMarcoDeFigura().calcularDimensiones();

			Graphics2D g2 = (Graphics2D) g;

			int x = getMarcoDeFigura().getX();

			int y = getMarcoDeFigura().getY();

			switch (this.tipo) {

			case 1:

				double radius = 90 * Fenetre.cm.getValor();

				int STAR_POINTS = 10;

				int[] polygonX = new int[STAR_POINTS];

				int[] polygonY = new int[STAR_POINTS];

				double innerRadius = radius * Math.sin(Math.toRadians(18) / Math.sin(Math.toRadians(54)));

				for (int i = 18; i < 360; i += 72) {

					polygonX[(i - 18) / 36] = centerX + (int) (radius * Math.cos(Math.toRadians(i)));

					polygonY[(i - 18) / 36] = centerY - (int) (radius * Math.sin(Math.toRadians(i)));

				}

				for (int i = 54; i < 360; i += 72) {

					polygonX[(i - 18) / 36] = centerX + (int) (innerRadius * Math.cos(Math.toRadians(i)));

					polygonY[(i - 18) / 36] = centerY - (int) (innerRadius * Math.sin(Math.toRadians(i)));

				}

				g.drawPolygon(polygonX, polygonY, STAR_POINTS);

				break;

			case 3:

				int x = 56;

				int y = 0;

				int[] xPoints = { x, x + 12, x + 54, x + 18, x + 28, x, x - 28, x - 18, x - 54, x - 12 };

				int[] yPoints = { y, y + 36, y + 36, y + 54, y + 96, y + 72, y + 96, y + 54, y + 36, y + 36 };

				GeneralPath star = new GeneralPath();

				star.moveTo(xPoints[0], yPoints[0]);

				for (int count = 1; count < xPoints.length; count++) {

					star.lineTo(xPoints[count], yPoints[count]);

				}

				star.closePath();

				for (int count = 1; count <= 20; count++) {

					g2d.rotate(Math.PI / 10.0);

					g2d.setColor(PanneauChoix.couleur.getColor());

					g2d.draw(star);

				}

				g2d.translate(0, 0);

				break;

			case 0:

				float witdh = (float) 75 * Fenetre.cm.getValor();

				float height = witdh - (float) 50 * Fenetre.cm.getValor();

				Point2D.Float point = new Point2D.Float(p2.getX(), p2.getY());

				GeneralPath p = new GeneralPath(GeneralPath.WIND_NON_ZERO);

				point.x = centerX - (100 * Fenetre.cm.getValor());

				p.moveTo(point.x, point.y);

				p.lineTo(point.x + witdh, point.y - height);

				point = (Point2D.Float) p.getCurrentPoint();

				p.lineTo(point.x + height, point.y - witdh);

				point = (Point2D.Float) p.getCurrentPoint();

				p.lineTo(point.x + height, point.y + witdh);

				point = (Point2D.Float) p.getCurrentPoint();

				p.lineTo(point.x + witdh, point.y + height);

				point = (Point2D.Float) p.getCurrentPoint();

				p.lineTo(point.x - witdh, point.y + height);

				point = (Point2D.Float) p.getCurrentPoint();

				p.lineTo(point.x - height, point.y + witdh);

				point = (Point2D.Float) p.getCurrentPoint();

				p.lineTo(point.x - height, point.y - witdh);

				p.closePath();

				g2d.draw(p);

				g2d.translate(0, 0);

				break;

			case 2:

				g.translate(centerX, centerY);

				int a = 100;

				int incremento = a / 2;

				int s = a + incremento;

				int d = s + incremento;

				int[] wx = { a, s, d };

				int[] wy = { a, d, a };

				int dividir = s / 2;

				a += dividir;

				int[] yPoints2 = { a, dividir, a };

				g.drawPolygon(wx, wy, 3);

				g.drawPolygon(wx, yPoints2, 3);

				break;

			case 4:

				if (PanneauChoix.thin.isSelected()) {

					g2d.setPaint(new RadialGradientPaint(new Point2D.Double(400, 200), 60, new float[] { 0, 1 },
							new Color[] { color, color }));

					pintarEstrella(g2d, 20, 60, 8, 0);
				}

				else {

					g2d.setPaint(new RadialGradientPaint(new Point2D.Double(200, 400), 50, new float[] { 0, 0.3f, 1 },
							new Color[] { color, color, color }));

					pintarEstrella(g2d, 40, 50, 20, 0);

				}

				break;

			}
		}

		catch (Exception e) {

		}

	}

	private void pintarEstrella(Graphics2D g, int i, int j, int k, int l) {

		if (!Fenetre.defaultShape.isSelected() && Fenetre.r1.getValor() > 1 && Fenetre.r2.getValor() > 1
				&& Fenetre.tip.getValor() > 2) {

			g.draw(createStar(p2.getX(), p2.getY(), Fenetre.r1.getValor(), Fenetre.r2.getValor(),
					Fenetre.tip.getValor(), 0));

		}

		else {

			Fenetre.r1.setValor(i);

			Fenetre.r2.setValor(j);

			Fenetre.tip.setValor(k);

			g.draw(createStar(p2.getX(), p2.getY(), i, j, k, l));

		}

	}

	public void rotar(int rotar) {
	}

	@Override
	public void actualizar(Point puntoActual) {
		// TODO Auto-generated method stub

	}
}