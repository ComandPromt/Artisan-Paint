package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Cilindro extends Figura {

	public Cilindro(Point ubicacion, int anchura, int altura, Color color, Color backgroundColor,
			boolean figuraRellena) {

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura, true));

	}

	@Override
	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override

	public void dibujar(Graphics g) {
		if (VentanaPrincipal.verRegla.isSelected()) {

			pintarRegla(g);

		}
		getMarcoDeFigura().calcularDimensiones();

		Graphics2D g2 = (Graphics2D) g;

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		int radius = getRadio();

		if (dibujarRellena()) {

			g.setColor(getColorSecundario());

			g.fillOval(x, y, anchura, radius - radius / 2);

		}

		else {

			g.drawOval(x, y, anchura, radius - radius / 2);

		}

		g.setColor(getColor());

		g.drawLine(x, (y + (radius - radius / 2)) - (radius / 4), x, (y + altura) - (radius / 4));

		if (dibujarRellena()) {

			g.setColor(getColorSecundario());

			g.fillOval(x, (y + altura) - (radius - radius / 2), anchura, radius - radius / 2);

		}

		else {

			g.drawOval(x, (y + altura) - (radius - radius / 2), anchura, radius - radius / 2);

		}

		g.setColor(getColor());

		g.drawLine(x + anchura, (y + (radius - radius / 2)) - (radius / 4), x + anchura, (y + altura) - (radius / 4));

	}

}
