package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author josearielpereyra
 */
public abstract class Figura {

	private Color color;
	private Color colorSecundario;
	private MarcoDeFigura marcoDeFigura;
	private boolean dibujarRellena;
	private int grosor;
	public static Graphics2D figuraDibujada;

	public enum Estado {
		ARRASTRANDO, ACTUALIZANDO, EN_REPOSO
	};

	private Estado estadoActual;

	public Figura(Color color) {
		this.color = color;
		this.colorSecundario = Color.WHITE;
		this.dibujarRellena = false;
		this.grosor = 1;
		estadoActual = Estado.EN_REPOSO;
	}

	public Figura() {
		this(Color.BLACK);
		this.colorSecundario = Color.WHITE;
		this.dibujarRellena = false;
		this.grosor = 1;
		estadoActual = Estado.EN_REPOSO;
	}

	public Color getColor() {

		return (color != null) ? color : Color.BLACK;
	}

	public Color getColorSecundario() {
		// (color!=null)?color:Color.BLACK
		return (colorSecundario != null) ? colorSecundario : Color.WHITE;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setColorSecundario(Color colorSecundario) {
		this.colorSecundario = colorSecundario;
	}

	public boolean dibujarRellena() {
		return dibujarRellena;
	}

	public void setDibujarRellena(boolean dibujarRellena) {
		this.dibujarRellena = dibujarRellena;
	}

	public int getGrosor() {
		return (grosor > 0) ? grosor : 1;
	}

	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}

	public MarcoDeFigura getMarcoDeFigura() {
		return marcoDeFigura;
	}

	public void setMarcoDeFigura(MarcoDeFigura marcoDeFigura) {
		this.marcoDeFigura = marcoDeFigura;
	}

	public Cursor getCursor(Point p) {
		return marcoDeFigura.getCursor(p);
	}

	public void setEstadoArrastrando() {
		estadoActual = Estado.ARRASTRANDO;
	}

	public boolean estaArrastrando() {
		return estadoActual == Estado.ARRASTRANDO;
	}

	public boolean contiene(Point punto) {
		return marcoDeFigura.contiene(punto);
	}

	public void dibujarMarcoDeSeleccion(Graphics g) {
		marcoDeFigura.dibujarMarcoDeSeleccion(g);
	}

	public void desplazarFigura(Point puntoActual) {
		marcoDeFigura.desplazarFigura(puntoActual);
	}

	public void setPuntosDentroDeLaFigura(Point puntoActual) {
		marcoDeFigura.setPuntosDentroDeLaFigura(puntoActual);
	}

	public abstract void actualizar(Point puntoActual);

	public abstract void dibujar(Graphics g);

        public abstract void rotar(int grados);
        
	public void pintarRegla(Graphics g) {

		getMarcoDeFigura().calcularDimensiones();

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(getGrosor()));

		g2.setColor(getColor());

		g.fillRect(10, 10, 4, 4);

		g.drawLine(10, 10, 10, 600);

		g.drawLine(10, 10, 600, 10);

		for (int i = 10; i <= 600; i += 50) {

			g.drawString(Integer.toString(i), i, 10);

			g.drawString(Integer.toString(i), 10, i);
		}

	}

}
