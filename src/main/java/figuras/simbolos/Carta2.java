package figuras.simbolos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import dibujante.Figura;

public class Carta2 extends Figura {

	public Carta2() {

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

		g2.drawRect(x, y, anchura, altura);

		g2.drawLine(x, y, x + anchura / 2, y + altura / 2);

		g2.drawLine(x + anchura, y, x + anchura / 2, y + altura / 2);

		g2.drawLine(x, y + altura, (x + anchura / 2) - (anchura / 8), (y + altura / 2) - altura / 8);

		g2.drawLine(x + anchura, y + altura, (x + anchura / 2) + (anchura / 8), (y + altura / 2) - altura / 8);

	}

}
