
package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import util.Figura;

public class MedioCirculo extends Figura {

	private int grados = 0;

	public MedioCirculo(Point ubicacion, int anchura, int altura, Color color) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));
	}

	@Override
	public void actualizar(Point puntoActual) {

		getMarcoDeFigura().actualizarDimensiones(puntoActual);

	}

	@Override
	public void dibujar(Graphics g) {

		getMarcoDeFigura().calcularDimensiones();

		Graphics2D g2 = (Graphics2D) g;

		g.setColor(getColor());

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();

		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();

		g.drawOval(x, y, anchura, altura);

		if (getColorSecundario().equals(Color.WHITE)) {

			g.setColor(Color.BLACK);

		}

		else {

			g.setColor(getColorSecundario());

		}

		g.fillArc(x, y, anchura, altura, 180, 180);

	}

	@Override

	public void rotar(int grados) {

		this.grados = grados;

	}

}
