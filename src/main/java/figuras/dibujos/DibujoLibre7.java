package figuras.dibujos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import dibujante.Figura;

public class DibujoLibre7 extends Figura {

	public DibujoLibre7(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		int equis = x + (anchura / 2);

		int ye = y + (altura / 2);

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), equis, ye);

			g.drawArc(equis / 4, ye / 2, (int) (equis / 2.5), ye / 2, (equis / 4) * -1, ye / 2);

			g.drawArc(equis / 2, ye / 2, (int) (equis / 2.5), ye / 2, (equis / 2) + 10, ye / 2);

		}

	}

}
