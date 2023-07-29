package figuras.circulos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.Figura;
import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;

public class Anillo extends Figura {

	public Anillo() {

		setMarcoDeFigura(new MarcoDeFigura(VentanaPrincipal.fake.getPosicion(), VentanaPrincipal.fake.getAncho(), VentanaPrincipal.fake.getAlto(), true));

	}

	@Override
	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override
	public void dibujar(Graphics g) {

		setDefaultMoverAbajo();

		Graphics2D g2 = (Graphics2D) g;

		getMarcoDeFigura().calcularDimensiones();

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		int incremento = 0;

		Color colorSecundario = getColorSecundario();

		if (!dibujarRellena() && colorSecundario.equals(Color.WHITE)) {

			colorSecundario = getColor();

		}

		if (getMoverArriba() > 0) {

			incremento = getMoverArriba();

		}

		else {

			incremento = getMoverAbajo();

		}

		if (dibujarRellena()) {

			g2.fillOval(x, y, anchura, altura);

		}

		else {

			g2.drawOval(x, y, anchura, altura);

		}

		for (int i = 0; i < getVueltas(); i++) {

			if (i % 2 == 0) {

				g2.setColor(colorSecundario);

			}

			else {

				g2.setColor(getColor());

			}

			if (dibujarRellena()) {

				g2.fillOval(x + incremento, y + incremento, anchura - incremento * 2, altura - incremento * 2);

				g2.setColor(getColor());

				g2.drawOval(x + incremento, y + incremento, anchura - incremento * 2, altura - incremento * 2);

			}

			else {

				g2.drawOval(x + incremento, y + incremento, anchura - incremento * 2, altura - incremento * 2);

			}

			incremento += getMoverAbajo();

		}

	}

}
