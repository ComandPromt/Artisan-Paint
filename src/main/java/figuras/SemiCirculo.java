
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class SemiCirculo extends Figura {

	

	public SemiCirculo(Point ubicacion, int anchura, int altura, Color color) {

		

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
		;

		Point punto1 = new Point(x, y + (altura));

		Point punto2 = new Point(x + (anchura), y + (altura));

		int[] puntosX = new int[] { punto1.x, punto2.x };

		int[] puntosY = new int[] { punto1.y, punto2.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillArc(x, y + altura / 2, anchura, altura, 0, 180);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawArc(x, y + altura / 2, anchura, altura, 0, 180);

		g2.drawPolygon(puntosX, puntosY, 2);

	}



}
