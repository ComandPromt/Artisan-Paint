package figuras.simbolos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.Figura;
import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;

public class YingYang extends Figura {

	public YingYang(Point ubicacion, int anchura, int altura) {

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

		if (anchura > altura) {

			altura = anchura;

		}

		else if (altura > anchura) {

			anchura = altura;

		}

		if (getColorSecundario().equals(Color.WHITE)) {

			VentanaPrincipal.color2.setColor(Color.GRAY);

			setBackgroundColor(Color.GRAY);

		}

		g.setColor(getColor());

		if (dibujarRellena()) {

			anchura /= 2;

			g.fillOval(x, y, 2 * anchura, 2 * anchura);

			g.setColor(getColorSecundario());

			g.fillArc(x, y, 2 * anchura, 2 * anchura, 270, 180);

			g.setColor(getColor());

			g.fillOval(x + (anchura / 2), y, anchura, anchura);

			g.setColor(getColorSecundario());

			g.fillOval(x + (anchura / 2), y + anchura, anchura, anchura);

			g.setColor(getColorSecundario());

			g.fillOval(x + anchura - (anchura / 4), y + anchura / 4, anchura / 2, anchura / 2);

			g.setColor(getColor());

			g.fillOval(x + anchura - (anchura / 4), y + anchura + anchura / 4, anchura / 2, anchura / 2);

		}

		else {

			g2.drawOval(x, y, anchura, altura);

			g2.drawArc(x + anchura / 4, y, anchura / 2, altura / 2, -90, 180);

			g2.drawArc(x + anchura / 4, y + anchura / 2, anchura / 2, altura / 2, 90, 180);

			g2.drawOval((x + anchura / 2) - ((anchura / 4) / 2), y + altura / 8, anchura / 4, altura / 4);

			g2.drawOval((x + anchura / 2) - ((anchura / 4) / 2), y + (altura / 2) + (altura / 8), anchura / 4,
					altura / 4);
		}

	}

}
