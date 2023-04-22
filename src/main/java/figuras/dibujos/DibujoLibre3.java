package figuras.dibujos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class DibujoLibre3 extends Figura {

	public DibujoLibre3(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 200, 200);

			g.drawArc(x + anchura / 2, y + altura / 2, 80, 100, -50, 100);

			g.drawArc(x + anchura / 2, y + altura / 2, 80, 100, 130, 100);

		}

	}

}
