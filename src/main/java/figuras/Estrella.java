package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Estrella extends Figura {

	Graphics2D g2;
	private int grados = 0;

	public Estrella(Point ubicacion, int anchura, int altura, Color color) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

	}

	@Override

	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {

		getMarcoDeFigura().calcularDimensiones();

		g2 = (Graphics2D) g;

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		Point punto1 = new Point(x + anchura / 2, y);

		Point punto2 = new Point(x + (int) (anchura / 1.6), y + (int) (altura / 2.571428571));

		Point punto3 = new Point(x + anchura, y + (int) (altura / 2.571428571));

		Point punto4 = new Point(x + (int) (anchura / 1.454545454), y + (int) (altura / 1.636363636));

		Point punto5 = new Point(x + (int) (anchura / 1.23076923), y + (altura));

		Point punto6 = new Point(x + anchura / 2, y + (int) (altura / 1.285714285));

		Point punto7 = new Point(x + (int) (anchura / 5.333333333), y + (altura));

		Point punto8 = new Point(x + (int) (anchura / 3.2), y + (int) (altura / 1.636363636));

		Point punto9 = new Point(x, y + (int) (altura / 2.571428571));

		Point punto10 = new Point(x + (int) (anchura / 2.666666666), y + (int) (altura / 2.571428571));

		int[] puntosX = { punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x, punto9.x,
				punto10.x };

		int[] puntosY = { punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y, punto9.y,
				punto10.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 10);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 10);

	}

	@Override

	public void rotar(int grados) {

		this.grados = grados;

	}

}
