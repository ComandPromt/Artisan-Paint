package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.Figura;

public class Rectangulo extends Figura {

	public Rectangulo(Point ubicacion, int anchura, int altura) {

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

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		if (!isRedondear() && dibujarRellena()) {

			g2.setColor(getColorSecundario());

			g2.fillRect(x, y, anchura, altura);

		}

		if (isRedondear()) {

			g2.drawRoundRect(x, y, anchura, altura, anchura / 2, altura / 2);

		}

		else {

			g2.drawRect(x, y, anchura, altura);

		}

	}

}
