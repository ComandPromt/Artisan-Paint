
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Paralelograma extends Figura {

	private int grados = 0;

	public Paralelograma(Point ubicacion, int anchura, int altura, Color color) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));

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

		Point punto1 = new Point(x + anchura - (int) (anchura / (16.0 / 13.0)), y);

		Point punto2 = new Point(x + (anchura), y);

		Point punto3 = new Point(x + (int) (anchura / (16.0 / 13.0)), y + altura);

		Point punto4 = new Point(x, y + altura);

		int[] puntosX = { punto1.x, punto2.x, punto3.x, punto4.x };

		int[] puntosY = { punto1.y, punto2.y, punto3.y, punto4.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 4);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 4);

	}

	@Override

	public void rotar(int grados) {

		this.grados = grados;

	}

}
