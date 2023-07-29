package figuras.simbolos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.Figura;
import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;

public class Check extends Figura {

	public Check() {

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

		int[] px = { x + (Math.round((float) (anchura * 0.375))), x, x + (Math.round((float) (anchura * 0.1875))),
				x + (Math.round((float) (anchura * 0.375))), x + (Math.round((float) (anchura * 0.875))), x + anchura };

		int[] py = { y + altura, y + (Math.round((float) (altura * 0.333))), y + (Math.round((float) (altura * 0.166))),
				y + (Math.round((float) (altura * 0.5833))), y, y + (Math.round((float) (altura * 0.25))) };

		if (dibujarRellena()) {

			if (getColorSecundario().equals(Color.WHITE)) {

				setBackgroundColor(Color.BLACK);

			}

			g2.setColor(getColorSecundario());

			g2.fillPolygon(px, py, px.length);

		}

		else {

			g2.drawPolygon(px, py, px.length);
		}

	}

}
