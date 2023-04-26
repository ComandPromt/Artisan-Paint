package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class Octogono extends Figura {

	public Octogono(Point ubicacion, int anchura, int altura) {

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

		int separacionX = anchura / 4;

		int separacionY = altura / 4;

		Point punto1 = new Point(x + separacionX, y);

		Point punto2 = new Point(x + anchura - separacionX, y);

		Point punto3 = new Point(x + anchura, y + separacionY);

		Point punto4 = new Point(x + anchura, y + altura - separacionY);

		Point punto5 = new Point(x + anchura - separacionX, y + altura);

		Point punto6 = new Point(x + separacionX, y + altura);

		Point punto7 = new Point(x, y + altura - separacionY);

		Point punto8 = new Point(x, y + separacionY);

		int[] puntosX = { punto1.x, punto2.x, punto3.x, punto4.x, punto5.x, punto6.x, punto7.x, punto8.x };

		int[] puntosY = { punto1.y, punto2.y, punto3.y, punto4.y, punto5.y, punto6.y, punto7.y, punto8.y };

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillPolygon(puntosX, puntosY, 8);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawPolygon(puntosX, puntosY, 8);

	}

}
