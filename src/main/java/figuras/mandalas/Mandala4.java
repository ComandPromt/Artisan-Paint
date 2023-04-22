
package figuras.mandalas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Mandala4 extends Figura {

	public Mandala4(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(VentanaPrincipal.grosor.getValor()));

		g2.setColor(getColor());

		int equis = x + (anchura / 2);

		int ye = y + (altura / 2);

		g2.translate(equis, ye);

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), equis, ye);

			g.drawArc(equis, ye, 80, 100, -50, 100);

			g.drawArc(equis, ye, 80, 100, 130, 100);

		}

		g2.translate(equis, ye);

	}

}
