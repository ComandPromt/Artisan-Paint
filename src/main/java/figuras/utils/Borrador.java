package figuras.utils;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Borrador extends Lapiz {

	public Borrador(Point puntoInicial) {

		super(puntoInicial);

	}

	@Override
	public void dibujar(Graphics g) {

		Graphics2D g2 = (Graphics2D) g;

		g2.setStroke(new BasicStroke(getGrosor()));

		int tamanoDeCuadrito = 5 * (getGrosor());

		g2.setColor(getColorSecundario());

		if (puntos.size() == 1) {

			Point puntoActual = puntos.get(0);

			g2.fillRect(puntoActual.x - tamanoDeCuadrito, puntoActual.y - tamanoDeCuadrito, tamanoDeCuadrito * 2,
					tamanoDeCuadrito * 2);
		
		}

		for (int i = 1; i < puntos.size(); i++) {
			
			Point puntoAnterior = puntos.get(i - 1);
			
			Point puntoActual = puntos.get(i);
			
			int[] puntosX = new int[] { puntoAnterior.x - tamanoDeCuadrito, puntoActual.x - tamanoDeCuadrito,
					puntoActual.x + tamanoDeCuadrito, puntoAnterior.x + tamanoDeCuadrito };

			int[] puntosY = new int[] { puntoAnterior.y - tamanoDeCuadrito, puntoActual.y - tamanoDeCuadrito,
					puntoActual.y + tamanoDeCuadrito, puntoAnterior.y + tamanoDeCuadrito };

			g2.fillPolygon(puntosX, puntosY, 4);
					
		}

	}

}
