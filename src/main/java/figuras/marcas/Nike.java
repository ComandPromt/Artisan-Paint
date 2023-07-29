
package figuras.marcas;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.CubicCurve2D;

import dibujante.Figura;
import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;

public class Nike extends Figura {

	public Nike() {

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

		CubicCurve2D cubcurve =

				new CubicCurve2D.Float((x + Math.round(anchura * 0.1818)), (y), x + Math.round(anchura * 0.14),

						y + Math.round(altura * 0.25), x + Math.round(anchura * 0.16), y + Math.round(altura * 0.5),

						x + Math.round(anchura * 0.27), y + Math.round(altura * 0.58));
		g2.draw(cubcurve);

		g2.drawLine((int) (x + Math.round(anchura * 0.27)), (int) (y + Math.round(altura * 0.58)), x + anchura,
				(int) (y + Math.round(altura * 0.25)));

		cubcurve =

				new CubicCurve2D.Float((x + Math.round(anchura * 0.1818)), (y),

						x + Math.round(anchura * 0.02), y + Math.round(altura * 0.5)

						, x + Math.round(anchura * 0.05), y + Math.round(altura * 0.93),

						x + Math.round(anchura * 0.23), y + Math.round(altura * 0.95));

		g2.draw(cubcurve);

		g2.drawLine((int) (x + Math.round(anchura * 0.23)), (int) (y + Math.round(altura * 0.95)), x + anchura,
				(int) (y + Math.round(altura * 0.25)));

	}

}
