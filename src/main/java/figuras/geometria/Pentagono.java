
package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Pentagono extends Figura {

	public Pentagono(Point ubicacion, int anchura, int altura) {

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

		Point punto1 = new Point(x + anchura / 2, y);

		Point punto2 = new Point(x + anchura, y + (int) (altura / 2.571428571));

		Point punto3 = new Point(x + (int) (anchura / 1.23076923), y + (altura));

		Point punto4 = new Point(x + (int) (anchura / 5.333333333), y + (altura));

		Point punto5 = new Point(x, y + (int) (altura / 2.571428571));

		int[] puntosX = new int[] { punto1.x, punto2.x, punto3.x, punto4.x, punto5.x };

		int[] puntosY = new int[] { punto1.y, punto2.y, punto3.y, punto4.y, punto5.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 5);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 5);

	}

}
