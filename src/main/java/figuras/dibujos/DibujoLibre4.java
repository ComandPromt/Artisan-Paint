package figuras.dibujos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class DibujoLibre4 extends Figura {

	public DibujoLibre4(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		altura /= 2;

		altura -= 25;

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		anchura /= 2;

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 200, 200);

			g.drawArc(x + anchura / 2, y + altura / 2, x + 30, y, -x, y);

			g.drawArc((y + altura / 2) + 2, y + altura / 2, x + 30, y, y + 30, y);

		}

	}

	public void rotar(int grados) {

	}

}
