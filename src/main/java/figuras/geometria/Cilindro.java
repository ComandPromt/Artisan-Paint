package figuras.geometria;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.Figura;
import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;

public class Cilindro extends Figura {

	public Cilindro() {
	
		setMarcoDeFigura(new MarcoDeFigura(VentanaPrincipal.fake.getPosicion(), VentanaPrincipal.fake.getAncho(), VentanaPrincipal.fake.getAlto(), true));

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

		int radius = getRadio();

		if (radius == 0) {

			radius = 100;

		}

		if (dibujarRellena()) {

			g2.fillRect(x, y + (radius / 4), anchura, altura - (radius / 2));

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
