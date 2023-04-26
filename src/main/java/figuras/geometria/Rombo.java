package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class Rombo extends Figura {

	public Rombo(Point ubicacion, int anchura, int altura) {

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

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		Point punto1 = new Point(x, y + (altura / 2));

		Point punto2 = new Point(x + (anchura / 2), y);

		Point punto3 = new Point(x + anchura, y + (altura / 2));

		Point punto4 = new Point(x + (anchura / 2), y + altura);

		int[] puntosX = new int[] { punto1.x, punto2.x, punto3.x, punto4.x };

		int[] puntosY = new int[] { punto1.y, punto2.y, punto3.y, punto4.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 4);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 4);

	}
}
