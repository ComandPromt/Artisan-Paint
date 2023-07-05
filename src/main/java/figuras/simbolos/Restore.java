package figuras.simbolos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.Figura;
import dibujante.MarcoDeFigura;

public class Restore extends Figura {

	public Restore(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		if (dibujarRellena()) {

			if (getColorSecundario().equals(Color.WHITE)) {

				setBackgroundColor(Color.BLACK);

			}

			g2.setColor(getColorSecundario());

			g2.fillRect(x + ((25 * anchura) / 100), y, (75 * anchura) / 100, (75 * altura) / 100);

			g2.fillRect(x, y + ((25 * altura) / 100), (75 * anchura) / 100, (75 * altura) / 100);

		}

		else {

			g2.drawRect(x, y + ((25 * altura) / 100), ((75 * anchura) / 100), ((75 * altura) / 100));

			g2.drawLine(x + ((25 * anchura) / 100), y, x + anchura, y);

			g2.drawLine(x + anchura, y, x + anchura, y + ((75 * altura) / 100));

			g2.drawLine(x + ((25 * anchura) / 100), y, x + ((25 * anchura) / 100), y + ((25 * altura) / 100));

			g2.drawLine(x + ((75 * anchura) / 100), y + ((75 * altura) / 100), x + anchura, y + ((75 * altura) / 100));

		}

	}

}
