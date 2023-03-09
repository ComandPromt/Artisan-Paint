package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import dibujante.MarcoDeFigura;
import dibujante.VentanaPrincipal;
import util.Figura;

public class LineaRedimensionable extends Figura {

	private Point puntoInicial;
	private Point puntoFinal;
	private String dondeEstaMiCursor;
	private int distanciaEnX;
	private int distanciaEnY;

	public LineaRedimensionable(Point puntoInicial, Point puntoFinal, Color color) {

		setMarcoDeFigura(new MarcoDeFigura(puntoInicial, 0, 0, dibujarRellena));
		this.puntoInicial = puntoInicial;
		this.puntoFinal = puntoFinal;
		dondeEstaMiCursor = "FUERA_DEL_AREA";
	}

	@Override
	public void actualizar(Point puntoActual) {
		this.puntoFinal = puntoActual;
	}

	private void actualizarPuntoInicial(Point puntoActual) {
		this.puntoInicial = puntoActual;
	}

	private void mover(Point puntoActual) {

		puntoInicial.x = puntoActual.x - distanciaEnX;
		puntoInicial.y = puntoActual.y - distanciaEnY;

		puntoFinal.x = puntoActual.x + distanciaEnX;
		puntoFinal.y = puntoActual.y + distanciaEnY;

	}

	@Override
	public void dibujar(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		if (VentanaPrincipal.verRegla.isSelected()) {

			pintarRegla(g);

		}

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g2.drawLine(puntoInicial.x, puntoInicial.y, puntoFinal.x, puntoFinal.y);

	}

	// Metodos Sobreescritos.
	@Override
	public void dibujarMarcoDeSeleccion(Graphics g) {
		g.drawString("Final", puntoFinal.x, puntoFinal.y);
		g.drawString("Inicio", puntoInicial.x, puntoInicial.y);
		g.drawRect(puntoFinal.x - 2, puntoFinal.y - 2, 5, 5);
		g.drawRect(puntoInicial.x - 2, puntoInicial.y - 2, 5, 5);
		g.drawRect(((puntoInicial.x + puntoFinal.x) / 2) - 2, ((puntoInicial.y + puntoFinal.y) / 2) - 2, 5, 5);
	}

	@Override
	public boolean contiene(Point p) {

		if (estaEnPuntoInicio(p)) {
			return true;
		} else if (estaEnPuntoMedio(p)) {
			return true;
		} else if (estaEnPuntoFinal(p)) {
			return true;
		}

		return false;
	}

	@Override
	public Cursor getCursor(Point p) {

		if (estaEnPuntoInicio(p)) {
			dondeEstaMiCursor = "PUNTO_INICIO";
			return new Cursor(Cursor.N_RESIZE_CURSOR);
		} else if (estaEnPuntoMedio(p)) {
			dondeEstaMiCursor = "PUNTO_MEDIO";
			return new Cursor(Cursor.MOVE_CURSOR);
		} else if (estaEnPuntoFinal(p)) {
			dondeEstaMiCursor = "PUNTO_FINAL";
			return new Cursor(Cursor.N_RESIZE_CURSOR);
		}

		return new Cursor(Cursor.CROSSHAIR_CURSOR);
	}

	@Override
	public void desplazarFigura(Point puntoActual) {

		switch (dondeEstaMiCursor) {
		case "PUNTO_INICIO":
			actualizarPuntoInicial(puntoActual);
			break;
		case "PUNTO_FINAL":
			actualizar(puntoActual);
			break;
		case "PUNTO_MEDIO":
			mover(puntoActual);
			break;
		default:
			break;
		}
	}

	@Override
	public void setPuntosDentroDeLaFigura(Point puntoActual) {
		Point puntoMedio = new Point(((puntoInicial.x + puntoFinal.x) / 2), ((puntoInicial.y + puntoFinal.y) / 2));

		distanciaEnX = puntoFinal.x - puntoMedio.x;
		distanciaEnY = puntoFinal.y - puntoMedio.y;
	}

	// Metodos Para Saber Donde Esta el Cursor
	private boolean estaEnPuntoInicio(Point p) {
		return (p.x > puntoInicial.x - 5 && p.x < puntoInicial.x + 5 && p.y > puntoInicial.y - 5
				&& p.y < puntoInicial.y + 5);

	}

	private boolean estaEnPuntoFinal(Point p) {
		return (p.x > puntoFinal.x - 5 && p.x < puntoFinal.x + 5 && p.y > puntoFinal.y - 5 && p.y < puntoFinal.y + 5);

	}

	private boolean estaEnPuntoMedio(Point punto) {
		return (punto.x > ((puntoInicial.x + puntoFinal.x) / 2) - 5
				&& punto.x < ((puntoInicial.x + puntoFinal.x) / 2) + 5
				&& punto.y > ((puntoInicial.y + puntoFinal.y) / 2) - 5
				&& punto.y < ((puntoInicial.y + puntoFinal.y) / 2) + 5);
	}

}
