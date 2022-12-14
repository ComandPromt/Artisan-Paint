
package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import dibujante.PanelDeDibujo;
import util.Figura;

public class Cubeta extends Figura {

	List<Linea> lineas;

	private int grados = 0;

	public Cubeta(Point puntoActual, Color colorDeReemplazo, PanelDeDibujo panel) {

		super(colorDeReemplazo);

		lineas = new ArrayList<>();

		floodFillImage(puntoActual, panel);

	}

	@Override

	public void dibujar(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(1));

		lineas.forEach(linea -> {

			linea.dibujar(g2);

		});

	}

	private void rellenar(Point puntoActual, Color colorDeReemplazo, PanelDeDibujo panel) {

		Stack<Point> puntos = new Stack<>();

		Color colorObjetivo = obtenerColorEn(puntoActual, panel);

		puntos.push(puntoActual);

		while (!puntos.isEmpty()) {

			Point puntoDerecho = puntos.pop();

			Point puntoIzquierdo = puntoDerecho;

			Color colorTemporal = colorObjetivo;

			Color colorArriba;

			Color colorAbajo;

			do {

				puntoDerecho = new Point(puntoDerecho.x + 1, puntoDerecho.y);

				if (puntoDerecho.x < panel.getWidth()) {

					colorTemporal = obtenerColorEn(puntoDerecho, panel);

				}

			}

			while (colorObjetivo.equals(colorTemporal) && puntoDerecho.x < panel.getWidth());

			do {

				puntoIzquierdo = new Point(puntoIzquierdo.x - 1, puntoIzquierdo.y);

				if (puntoIzquierdo.x > 0) {

					colorTemporal = obtenerColorEn(puntoIzquierdo, panel);

				}

			}

			while (colorObjetivo.equals(colorTemporal) && puntoIzquierdo.x > 0);

			lineas.add(new Linea(puntoIzquierdo, puntoDerecho, colorDeReemplazo));

		}

	}

	private Color obtenerColorEn(Point puntoActual, PanelDeDibujo panel) {

		BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

		Graphics2D g2 = image.createGraphics();

		panel.paint(g2);

		Color colorObjetivo = new Color(image.getRGB(puntoActual.x, puntoActual.y));

		return colorObjetivo;

	}

	public void floodFillImage(Point puntoInicial, PanelDeDibujo panel) {

		int x = puntoInicial.x;

		int y = puntoInicial.y;

		BufferedImage image = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);

		Graphics2D g2 = image.createGraphics();

		panel.paint(g2);

		int srcColor = image.getRGB(x, y);

		boolean[][] hits = new boolean[image.getHeight()][image.getWidth()];

		Queue<Point> queue = new LinkedList<Point>();

		queue.add(new Point(x, y));

		while (!queue.isEmpty())

		{
			Point p = queue.remove();

			if (floodFillImageDo(image, hits, p.x, p.y, srcColor)) {

				queue.add(new Point(p.x, p.y - 1));

				queue.add(new Point(p.x, p.y + 1));

				queue.add(new Point(p.x - 1, p.y));

				queue.add(new Point(p.x + 1, p.y));

				lineas.add(new Linea(p, p, getColor()));

			}

		}

		g2.dispose();

	}

	private static boolean floodFillImageDo(BufferedImage image, boolean[][] hits, int x, int y, int srcColor) {

		Point puntoInicial = new Point(x, y);

		Point puntoFinal = new Point(x, y);

		if (y < 0)
			return false;

		if (x < 0)
			return false;

		if (y > image.getHeight() - 1)
			return false;

		if (x > image.getWidth() - 1)
			return false;

		if (hits[y][x])
			return false;

		if (image.getRGB(x, y) != srcColor)
			return false;

		hits[y][x] = true;

		return true;

	}

	@Override
	public void dibujarMarcoDeSeleccion(Graphics g) {

	}

	@Override
	public boolean contiene(Point punto) {

		return false;

	}

	@Override
	public void actualizar(Point puntoActual) {

	}

	@Override
	public Cursor getCursor(Point p) {

		return new Cursor(Cursor.CROSSHAIR_CURSOR);

	}

	@Override
	public void rotar(int grados) {

		this.grados = grados;

	}

}
