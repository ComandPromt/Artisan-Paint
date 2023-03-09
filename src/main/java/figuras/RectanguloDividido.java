package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class RectanguloDividido extends Figura {
	public RectanguloDividido(Point ubicacion, int anchura, int altura, Color color, boolean fanCircle) {

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

		if (dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillRect(x, y, anchura, altura);

		}

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.drawRect(x, y, anchura, altura);

	}

}
