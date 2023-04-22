
package figuras.utils;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import dibujante.PanelDeDibujo;
import figuras.Linea;
import util.Figura;

public class Cubeta extends Figura {

	List<Linea> lineas;

	public Cubeta(Point puntoActual, PanelDeDibujo panel) {

		lineas = new ArrayList<>();

		floodFillImage(puntoActual, panel);

	}

	@Override

	public void dibujar(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setColor(getColor());

		g2.setStroke(new BasicStroke(getGrosor()));

		lineas.forEach(linea -> {

			linea.dibujar(g2);

		});

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

				lineas.add(new Linea(p, p, getColor(), getGrosor()));

			}

		}

		g2.dispose();

	}

	private static boolean floodFillImageDo(BufferedImage image, boolean[][] hits, int x, int y, int srcColor) {

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

}
