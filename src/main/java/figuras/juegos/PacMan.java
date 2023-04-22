package figuras.juegos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class PacMan extends Figura {

	public PacMan(Point ubicacion, int anchura, int altura) {

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

		Point punto1 = new Point(x + anchura / 2, y);

		Point punto2 = new Point(x + (anchura / 2), y + (altura / 2));

		Point punto3 = new Point(x + anchura, y + altura / 2);

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillArc(x, y, anchura, altura, 0, -270);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawArc(x, y, anchura, altura, 0, -270);

		g2.drawLine(punto1.x, punto1.y, punto2.x, punto2.y);

		g2.drawLine(punto2.x, punto2.y, punto3.x, punto3.y);

	}

}
