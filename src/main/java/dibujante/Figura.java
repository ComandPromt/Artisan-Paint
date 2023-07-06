package dibujante;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {

	protected MarcoDeFigura marcoDeFigura;

	private boolean dibujarRellena = false;

	protected int grosor;

	protected Color mainColor;

	protected Color backgroundColor;

	protected int vueltas;

	protected int escala;

	protected int angulo;

	protected int radio;

	protected int moverArriba;

	protected int moverAbajo;

	private Estado estadoActual;

	private boolean giro;

	private boolean redondear;

	private short estadoGiro;

	protected int angulo2;

	protected int angulo3;

	protected int angulo4;

	protected int angulo5;

	protected int sumarAngulo;

	protected void setDefaultMoverAbajo() {

		if (getMoverAbajo() == 0) {

			setMoverAbajo(10);

		}

	}

	public boolean isRedondear() {
		return redondear;
	}

	public void setRedondear(boolean redondear) {
		this.redondear = redondear;
	}

	public int getSumarAngulo() {

		return sumarAngulo;

	}

	public void setSumarAngulo(int sumarAngulo) {
		this.sumarAngulo = sumarAngulo;
	}

	public int getAngulo5() {
		return angulo5;
	}

	public void setAngulo5(int angulo5) {
		this.angulo5 = angulo5;
	}

	public int getAngulo2() {
		return angulo2;
	}

	public void setAngulo2(int angulo2) {
		this.angulo2 = angulo2;
	}

	public int getAngulo3() {
		return angulo3;
	}

	public void setAngulo3(int angulo3) {
		this.angulo3 = angulo3;
	}

	public int getAngulo4() {
		return angulo4;
	}

	public void setAngulo4(int angulo4) {
		this.angulo4 = angulo4;
	}

	public int getAngulo() {

		return angulo;

	}

	public void setAngulo(int angulo) {

		this.angulo = angulo;

	}

	public short getEstadoGiro() {

		return estadoGiro;

	}

	public void setEstadoGiro(short estadoGiro) {

		this.estadoGiro = estadoGiro;

	}

	public boolean isGiro() {

		return giro;

	}

	public void setGiro(boolean giro) {

		this.giro = giro;

	}

	public int getWidth() {

		try {

			return marcoDeFigura.anchura;

		}

		catch (Exception e) {

			return 0;

		}

	}

	public int getHeight() {

		try {

			return marcoDeFigura.altura;

		}

		catch (Exception e) {

			return 0;

		}

	}

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

		return this.radio;

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

		g.fillRect(10, 10, 4, 4);

		g.drawLine(10, 10, 10, 600);

		g.drawLine(10, 10, 600, 10);

		for (int i = 10; i <= 600; i += 50) {

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
