package util;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Board extends JPanel {

	public Board() {
	}

	private int figure;

	private int ancho;

	private int alto;

	public void setAncho(int ancho) {

		this.ancho = ancho;

	}

	public void setAlto(int alto) {

		this.alto = alto;

	}

	public void setFigure(int figure) {

		this.figure = figure;

	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.setColor(Color.BLUE);

		switch (this.figure) {

		default:

		case 0:

			g.fillRect(0, 0, ancho, alto);

			break;

		case 1:

			g.fillOval(0, 0, ancho, alto);

			break;

		}

	}

}
