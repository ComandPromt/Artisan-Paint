package figuras.simbolos;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import dibujante.Figura;

public class Corazon extends Figura {

	public Corazon() {

		setMarcoDeFigura(new MarcoDeFigura(VentanaPrincipal.fake.getPosicion(), VentanaPrincipal.fake.getAncho(), VentanaPrincipal.fake.getAlto(), false));

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

		int width = getMarcoDeFigura().getAnchura();

		int height = getMarcoDeFigura().getAltura();

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g.drawLine((x + (width / 30)) - 1, (int) (y + height / 2.7), (x + width / 2), y + height);

		g.drawLine((x + width) - (width / 30), (int) (y + height / 2.7), x + width / 2, y + height);

		g.drawArc(x, y, width / 2, height / 2, -360, 210);

		g.drawArc((x + width) - (width / 2), y, width / 2, height / 2, 180, -210);

	}

}
