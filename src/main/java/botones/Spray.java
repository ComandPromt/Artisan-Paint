/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package botones;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;

public class Spray extends DibujoLibre {

	public double raio;

	ArrayList<Double> equis;

	ArrayList<Double> ys;

	Color color;

	Graphics2D g2;

	public Spray(Point puntoInicial, Color color) {

		super(puntoInicial, Color.WHITE);

		this.color = color;

		raio = 10.0;

		equis = new ArrayList();

		ys = new ArrayList();

		equis.add(1.7063972223700814);

		ys.add(1.1749362568345256);

		equis.add(0.06470110824278918);

		ys.add(1.4975011036471526);

		equis.add(-0.9086800674769953);

		ys.add(-0.004110505137084685);

		equis.add(-0.1067203298794473);

		ys.add(-0.9338864733163198);

		equis.add(0.20066792433812886);

		ys.add(-0.153541503718076);

		equis.add(-0.0926988980074235);

		ys.add(0.5644305876853237);

		equis.add(-1.976252291323171);

		ys.add(0.41987703977914403);

		equis.add(-1.0535899329959142);

		ys.add(-0.6730041352328676);

		equis.add(1.6951618774174793);

		ys.add(0.4662181792439448);

		equis.add(1.213402343992506);

		ys.add(0.7234128743265458);

		equis.add(0.262044332446936);

		ys.add(1.133218410816797);

		equis.add(-0.37945489349060413);

		ys.add(0.8380721364838775);

		equis.add(0.029031015441279378);

		ys.add(1.392853427584005);

		equis.add(1.1952990121375917);

		ys.add(2.3312570127942798);

		equis.add(-0.4012147095125229);

		ys.add(-0.8469253778021306);

	}

	@Override

	public void dibujar(Graphics g) {

		g2 = (Graphics2D) g;

		g2.setColor(this.color);

		g2.setStroke(new BasicStroke(getGrosor()));

		if (puntos.size() == 1) {

			for (int i = 0; i < 15; i++) {

				if (puntos.get(0).y != 0) {

					int xNew = (int) (puntos.get(0).x + equis.get(i) * raio);

					int yNew = (int) (puntos.get(0).y + ys.get(i) * raio);

					g2.drawLine(xNew, yNew, xNew, yNew);

				}

			}

		}

		else {

			Point puntoAnterior;

			Point puntoActual;

			for (int x = 1; x < puntos.size(); x++) {

				puntoAnterior = puntos.get(x - 1);

				puntoActual = puntos.get(x);

				for (int i = 0; i < 15; i++) {

					if (puntos.get(0).y != 0) {

						int xNew = (int) (puntoAnterior.x + equis.get(i) * raio);

						int yNew = (int) (puntoActual.y + ys.get(i) * raio);

						g2.drawLine(xNew, yNew, xNew, yNew);

					}

				}

			}

		}

	}

}
