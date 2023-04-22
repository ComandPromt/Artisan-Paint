
package figuras.mandalas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class Mandala2 extends Figura {

	public Mandala2(Point ubicacion, int anchura, int altura) {

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

		g2.setStroke(new BasicStroke(VentanaPrincipal.grosor.getValor()));

		g2.setColor(getColor());

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g2.translate(x + anchura / 2, y + altura / 2);

		for (int i = 0; i < VentanaPrincipal.saberVueltas(); i++) {

			g2.rotate(VentanaPrincipal.saberAngulo(), 100, 100);

			g.drawArc(x, 29, 80, 100, 45, 180);

		}

		g2.translate(x + anchura / 2, y + altura / 2);

	}

}
