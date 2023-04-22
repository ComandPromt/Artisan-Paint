/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujante;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author Berlis
 */
public class MarcoDeFigura {

	private Point ubicacion;
	public int anchura;
	public int altura;
	private int x;
	private int y;
	private int puntoXDentroDelMarco;
	private int puntoYDentroDelMarco;
	private String posicionCursor;
	private int area;

	private boolean deformar;

	public MarcoDeFigura(Point ubicacion, int anchura, int altura, boolean deformar) {

		this.deformar = deformar;

		this.ubicacion = ubicacion;

		this.altura = altura;

		this.anchura = anchura;

		posicionCursor = "FUERA_DEL_AREA";

		area = 5;

	}

	public void actualizarDimensiones(Point puntoActual) {

		anchura = puntoActual.x - ubicacion.x;

		altura = puntoActual.y - ubicacion.y;

		if (!deformar) {

			if (anchura > altura) {

				altura = anchura;

			}

			if (altura > anchura) {

				anchura = altura;

			}

		}

	}

	public int getAnchura() {
		return Math.abs(anchura);
	}

	public int getAltura() {
		return Math.abs(altura);
	}

	public int getX() {

		return x;

	}

	public void setDeformar(boolean deformar) {
		this.deformar = deformar;
	}

	public int getY() {

		return y;

	}

	public void calcularDimensiones() {

		x = ubicacion.x;

		y = ubicacion.y;

		x = (anchura < 0) ? x += anchura : x;

		y = (altura < 0) ? y += altura : y;

	}

	public void desplazarFigura(Point puntoActual) {

		int puntoDondeEstaLaAnchura = ubicacion.x + anchura;
		int puntoDondeEstaLaAltura = ubicacion.y + altura;
		int distanciaEnX = puntoDondeEstaLaAnchura - puntoActual.x; // distanciaEntrePuntoActualYPuntoDeAnchura
		int distanciaEnY = puntoDondeEstaLaAltura - puntoActual.y;// distanciaEntrePuntoActualYPuntoDeAltura

		// Hize estas variables para hacer menos codigo.
		int tamanoActualEnX = puntoActual.x - ubicacion.x;
		int tamanoActualEnY = puntoActual.y - ubicacion.y;

		if (posicionCursor.equals("CENTRO_LADO_DERECHO")) {

			if (anchura < 0) {
				desplazarLadoIzquierdo(distanciaEnX, puntoActual);
			} else if (tamanoActualEnX > 0) {
				desplazarLadoDerecho(puntoActual);
			}

		} else if (posicionCursor.equals("CENTRO_LADO_INFERIOR")) {

			if (altura < 0) {
				desplazarLadoSuperior(distanciaEnY, puntoActual);
			} else if (tamanoActualEnY > 0) {
				desplazarLadoInferior(puntoActual);
			}

		} else if (posicionCursor.equals("CENTRO_LADO_IZQUIERDO")) {

			if (anchura < 0) {
				desplazarLadoDerecho(puntoActual);
			} else if (distanciaEnX > 0) {
				desplazarLadoIzquierdo(distanciaEnX, puntoActual);
			}

		} else if (posicionCursor.equals("CENTRO_LADO_SUPERIOR")) {

			if (altura < 0) {
				desplazarLadoInferior(puntoActual);
			} else if (distanciaEnY > 0) {
				desplazarLadoSuperior(distanciaEnY, puntoActual);
			}

		} else if (posicionCursor.equals("ESQUINA_INFERIOR_DERECHA")) {

			if (anchura < 0 && altura <= 0) {
				desplazarEsqSuperiorIzq(distanciaEnY, puntoActual, distanciaEnX);
			} else if (anchura < 0) {
				desplazarEsqInferiorIzq(puntoActual, distanciaEnX);
			} else if (altura < 0) {
				desplazarEsqSuperiorDer(distanciaEnY, puntoActual);
			} else if ((tamanoActualEnX > 0) && tamanoActualEnY > 0) {
				desplazarEsqInferiorDer(puntoActual);
			}

		} else if (posicionCursor.equals("ESQUINA_SUPERIOR_DERECHA")) {

			if (anchura < 0 && altura <= 0) {
				desplazarEsqInferiorIzq(puntoActual, distanciaEnX);
			} else if (anchura < 0) {
				desplazarEsqSuperiorIzq(distanciaEnY, puntoActual, distanciaEnX);
			} else if (altura < 0) {
				desplazarEsqInferiorDer(puntoActual);
			} else if ((distanciaEnY > 0) && tamanoActualEnX > 0) {
				desplazarEsqSuperiorDer(distanciaEnY, puntoActual);
			}

		} else if (posicionCursor.equals("ESQUINA_SUPERIOR_IZQUIERDA")) {

			if (anchura < 0 && altura <= 0) {
				desplazarEsqInferiorDer(puntoActual);
			} else if (anchura < 0) {
				desplazarEsqSuperiorDer(distanciaEnY, puntoActual);
			} else if (altura < 0) {
				desplazarEsqInferiorIzq(puntoActual, distanciaEnX);
			} else if ((distanciaEnY > 0) && (distanciaEnX > 0)) {
				desplazarEsqSuperiorIzq(distanciaEnY, puntoActual, distanciaEnX);
			}

		} else if (posicionCursor.equals("ESQUINA_INFERIOR_IZQUIERDA")) {

			if (anchura < 0 && altura <= 0) {
				desplazarEsqSuperiorDer(distanciaEnY, puntoActual);
			} else if (anchura < 0) {
				desplazarEsqInferiorDer(puntoActual);
			} else if (altura < 0) {
				desplazarEsqSuperiorIzq(distanciaEnY, puntoActual, distanciaEnX);
			} else if (tamanoActualEnY > 0 && (distanciaEnX > 0)) {
				desplazarEsqInferiorIzq(puntoActual, distanciaEnX);
			}

		} else if (posicionCursor.equals("DENTRO_DE_LA_FIGURA")) {
			// Mover
			ubicacion.x = puntoActual.x - puntoXDentroDelMarco;
			ubicacion.y = puntoActual.y - puntoYDentroDelMarco;
		}
	}

	public Cursor getCursor(Point p) {

		Cursor cursor;

		if (estaEnCentroLadoDerecho(p)) {
			posicionCursor = "CENTRO_LADO_DERECHO";
			cursor = new Cursor(Cursor.E_RESIZE_CURSOR);
		} else if (estaEnCentroLadoInferior(p)) {
			posicionCursor = "CENTRO_LADO_INFERIOR";
			cursor = new Cursor(Cursor.N_RESIZE_CURSOR);
		} else if (estaEnCentroLadoIzquierdo(p)) {
			posicionCursor = "CENTRO_LADO_IZQUIERDO";
			cursor = new Cursor(Cursor.E_RESIZE_CURSOR);
		} else if (estaEnCentroLadoSuperior(p)) {
			posicionCursor = "CENTRO_LADO_SUPERIOR";
			cursor = new Cursor(Cursor.N_RESIZE_CURSOR);
		} else if (estaEnEsquinaInferiorDerecha(p)) {
			posicionCursor = "ESQUINA_INFERIOR_DERECHA";
			cursor = new Cursor(Cursor.SE_RESIZE_CURSOR);
		} else if (estaEnEsquinaSuperiorDerecha(p)) {
			posicionCursor = "ESQUINA_SUPERIOR_DERECHA";
			cursor = new Cursor(Cursor.SW_RESIZE_CURSOR);
		} else if (estaEnEsquinaSuperiorIzquierda(p)) {
			posicionCursor = "ESQUINA_SUPERIOR_IZQUIERDA";
			cursor = new Cursor(Cursor.SE_RESIZE_CURSOR);
		} else if (estaEnEsquinaInferiorIzquierda(p)) {
			posicionCursor = "ESQUINA_INFERIOR_IZQUIERDA";
			cursor = new Cursor(Cursor.SW_RESIZE_CURSOR);
		} else if (contiene(p)) {
			posicionCursor = "DENTRO_DE_LA_FIGURA";
			cursor = new Cursor(Cursor.MOVE_CURSOR);
		} else {
			posicionCursor = "FUERA_DEL_AREA";
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}
		return cursor;
	}

	private void desplazarLadoSuperior(int distanciaEnY, Point puntoActual) {

		altura = distanciaEnY;

		ubicacion.y = puntoActual.y;

		if (!deformar) {

			anchura = altura;

		}

	}

	private void desplazarLadoIzquierdo(int distanciaEnX, Point puntoActual) {

		anchura = distanciaEnX;

		ubicacion.x = puntoActual.x;

		if (!deformar) {

			altura = anchura;

		}

	}

	private void desplazarLadoInferior(Point puntoActual) {

		altura = puntoActual.y - ubicacion.y;

		if (!deformar) {

			anchura = altura;

		}

	}

	private void desplazarLadoDerecho(Point puntoActual) {

		anchura = puntoActual.x - ubicacion.x;

		if (!deformar) {

			altura = anchura;

		}

	}

	// Esquinas
	private void desplazarEsqSuperiorDer(int distanciaEnY, Point puntoActual) {
		desplazarLadoSuperior(distanciaEnY, puntoActual);
		desplazarLadoDerecho(puntoActual);
		if (anchura > altura) {
			altura = anchura;
		}

		if (altura > anchura) {
			anchura = altura;
		}
	}

	private void desplazarEsqInferiorDer(Point puntoActual) {
		desplazarLadoDerecho(puntoActual);
		desplazarLadoInferior(puntoActual);
		if (anchura > altura) {
			altura = anchura;
		}

		if (altura > anchura) {
			anchura = altura;
		}
	}

	private void desplazarEsqSuperiorIzq(int distanciaEnY, Point puntoActual, int distanciaEnX) {
		desplazarLadoSuperior(distanciaEnY, puntoActual);
		desplazarLadoIzquierdo(distanciaEnX, puntoActual);
		if (anchura > altura) {
			altura = anchura;
		}

		if (altura > anchura) {
			anchura = altura;
		}
	}

	private void desplazarEsqInferiorIzq(Point puntoActual, int distanciaEnX) {
		desplazarLadoInferior(puntoActual);
		desplazarLadoIzquierdo(distanciaEnX, puntoActual);
		if (anchura > altura) {
			altura = anchura;
		}

		if (altura > anchura) {
			anchura = altura;
		}
	}
	// Fin de esquinas.

	public void setPuntosDentroDeLaFigura(Point puntoActual) {
		puntoXDentroDelMarco = puntoActual.x - ubicacion.x;
		puntoYDentroDelMarco = puntoActual.y - ubicacion.y;
	}

	public void dibujarMarcoDeSeleccion(Graphics g) {

		int tamanoLinea = 5;
		int rango = 5;

		// Lineas horizontales
		for (int i = x; i < x + getAnchura(); i += 10) {
			g.drawLine(i, y, i + tamanoLinea, y);
			g.drawLine(i, y + getAltura(), i + tamanoLinea, y + getAltura());
		}
		// Lineas verticales
		for (int i = y; i < y + getAltura(); i += 10) {
			g.drawLine(x, i, x, i + tamanoLinea);
			g.drawLine(x + getAnchura(), i, x + getAnchura(), i + tamanoLinea);
		}
		// Cuadritos esquinas
		g.drawRect(x, y, rango, rango);
		g.drawRect(x + getAnchura() - rango, y, rango, rango);
		g.drawRect(x + getAnchura() - rango, y + getAltura() - rango, rango, rango);
		g.drawRect(x, y + getAltura() - rango, rango, rango);
		// Cuadritos centrales
		g.drawRect(x + getAnchura() / 2, y + getAltura() - rango, rango, rango);
		g.drawRect(x + getAnchura() / 2, y, rango, rango);
		g.drawRect(x + getAnchura() - rango, y + getAltura() / 2, rango, rango);
		g.drawRect(x, y + getAltura() / 2, rango, rango);
	}

	// Metodos Para Saber Donde Esta el Cursor
	public boolean contiene(Point p) {
		return (p.x >= x && p.x <= x + getAnchura() && p.y >= y && p.y <= y + getAltura());
	}

	private boolean estaEnEsquinaSuperiorDerecha(Point p) {
		return (p.x >= (x + getAnchura()) - area && p.x <= x + getAnchura() && p.y >= y && p.y <= y + area);
	}

	private boolean estaEnEsquinaSuperiorIzquierda(Point p) {
		return (p.x >= x && p.x <= x + area && p.y >= y && p.y <= y + area);
	}

	private boolean estaEnEsquinaInferiorDerecha(Point p) {
		return (p.x >= (x + getAnchura()) - area && p.x <= x + getAnchura() && p.y >= y + getAltura() - area
				&& p.y <= y + getAltura());
	}

	private boolean estaEnEsquinaInferiorIzquierda(Point p) {
		return (p.x >= x && p.x <= x + area && p.y >= y + getAltura() - area && p.y <= y + getAltura());
	}

	private boolean estaEnCentroLadoDerecho(Point p) {
		return (p.x >= (x + getAnchura()) - area && p.x <= x + getAnchura() && p.y >= y + getAltura() / 2
				&& p.y <= y + getAltura() / 2 + area);
	}

	private boolean estaEnCentroLadoIzquierdo(Point p) {
		return (p.x >= x && p.x <= x + area && p.y >= y + getAltura() / 2 && p.y <= y + getAltura() / 2 + area);
	}

	private boolean estaEnCentroLadoSuperior(Point p) {
		return (p.x >= x + getAnchura() / 2 && p.x <= x + (getAnchura() / 2) + area && p.y >= y && p.y <= y + area);
	}

	private boolean estaEnCentroLadoInferior(Point p) {
		return (p.x >= x + getAnchura() / 2 && p.x <= x + (getAnchura() / 2) + area && p.y >= y + getAltura() - area
				&& p.y <= y + getAltura());
	}

	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

}
