package util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;

import dibujante.MarcoDeFigura;

public abstract class Figura {

	protected MarcoDeFigura marcoDeFigura;

	protected boolean dibujarRellena = false;

	protected int grosor;

	protected Color mainColor;

	protected Color backgroundColor;

	protected int vueltas;

	protected int escala;

	protected int radio;

	protected int moverArriba;

	protected int moverAbajo;

	private Estado estadoActual;

	public Color getMainColor() {

		return mainColor;

	}

	public void setMainColor(Color mainColor) {

		this.mainColor = mainColor;

	}

	public Color getBackgroundColor() {

		return backgroundColor;

	}

	public void setBackgroundColor(Color backgroundColor) {

		this.backgroundColor = backgroundColor;

	}

	protected enum Estado {

		ARRASTRANDO, ACTUALIZANDO, EN_REPOSO

	}

	public Color getColor() {

		return mainColor;

	}

	public Color getColorSecundario() {

		return backgroundColor;
	}

	public boolean dibujarRellena() {

		return dibujarRellena;

	}

	public int getGrosor() {

		return (grosor > 0) ? grosor : 1;
	}

	public int getVueltas() {

		return (vueltas > 0) ? vueltas : 1;

	}

	public int getEscala() {

		return (escala > 0) ? escala : 1;

	}

	public void setGrosor(int grosor) {

		this.grosor = grosor;

	}

	public int getRadio() {

		return (radio > 0) ? radio : 1;

	}

	public int getMoverArriba() {

		return (moverArriba > 0) ? moverArriba : 0;

	}

	public int getMoverAbajo() {

		return (moverAbajo > 0) ? moverAbajo : 0;

	}

	public void setMoverArriba(int moverArriba) {

		this.moverArriba = moverArriba;

	}

	public void setMoverAbajo(int moverAbajo) {

		this.moverAbajo = moverAbajo;

	}

	public void setRadio(int radio) {

		this.radio = radio;

	}

	public void setVueltas(int vueltas) {

		this.vueltas = vueltas;

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

	public void pintarRegla(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(1));

		g2.setColor(getColor());

		g.fillRect(10, 10, 4, 4);

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		g.drawLine(10, 10, 10, screenSize.height);

		g.drawLine(10, 10, screenSize.width, 10);

		for (int i = 0; i <= screenSize.width; i += 50) {

			g.drawString(Integer.toString(i), i, 10);

			g.drawString(Integer.toString(i), 10, i);

		}

	}

	public void setEscala(int escala) {

		this.escala = escala;

	}

	public void setDibujarRellena(boolean dibujarRellena) {

		this.dibujarRellena = dibujarRellena;

	}

}
