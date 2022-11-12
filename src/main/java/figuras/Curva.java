package figuras;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Path2D;

import dibujante.MarcoDeFigura;
import util.Figura;

public class Curva extends Figura {
	float x1, y1, xc1cur, yc1cur, xc1new, yc1new, xc2cur, yc2cur, xc2new, yc2new, x4cur, y4cur, x4new, y4new;

	int pressNo = 0;

	int dragFlag1 = -1;

	int dragFlag2 = -1;

	boolean clearFlag = false;

	float dashes[] = { 5f, 5f };

	BasicStroke stroke;

	public Curva(Point ubicacion, int anchura, int altura, Color color, boolean fanCircle) {

		super(color);

		setMarcoDeFigura(new MarcoDeFigura(ubicacion, anchura, altura));

	}

	class MyMouseListener extends MouseAdapter implements MouseMotionListener {
		@Override
		public void mousePressed(MouseEvent e) {
			if (pressNo == 0) {
				pressNo++;
				x1 = x4cur = e.getX();
				y1 = y4cur = e.getY();
			} else if (pressNo == 1) {
				pressNo++;
				xc1cur = e.getX();
				yc1cur = e.getY();
			} else if (pressNo == 2) {
				pressNo++;
				xc2cur = e.getX();
				yc2cur = e.getY();
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (pressNo == 1) {
				x4new = e.getX();
				y4new = e.getY();
				// canvas.repaint();
			} else if (pressNo == 2) {
				xc1new = e.getX();
				yc1new = e.getY();
				// canvas.repaint();
			} else if (pressNo == 3) {
				xc2new = e.getX();
				yc2new = e.getY();
				// canvas.repaint();
				pressNo = 0;
				dragFlag1 = -1;
				dragFlag2 = -1;
				clearFlag = true;
			}
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			if (pressNo == 1) {
				x4new = e.getX();
				y4new = e.getY();
				String string = "(" + Integer.toString(e.getX()) + ", " + Integer.toString(e.getY()) + ")";

				// canvas.repaint();
			} else if (pressNo == 2) {
				xc1new = e.getX();
				yc1new = e.getY();

				String string = "(" + Integer.toString(e.getX()) + ", " + Integer.toString(e.getY()) + ")";

				// canvas.repaint();
			} else if (pressNo == 3) {
				xc2new = e.getX();
				yc2new = e.getY();
				String string = "(" + Integer.toString(e.getX()) + ", " + Integer.toString(e.getY()) + ")";

				// canvas.repaint();
			}
		}

	}

	@Override
	public void actualizar(Point puntoActual) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dibujar(Graphics g) {
		getMarcoDeFigura().calcularDimensiones();

		int x = getMarcoDeFigura().getX();

		int y = getMarcoDeFigura().getY();
		int anchura = getMarcoDeFigura().getAnchura();

		int altura = getMarcoDeFigura().getAltura();
		Graphics2D g2 = (Graphics2D) g;

		// draw quadratic curve
		g.setColor(Color.red);
		Path2D p = new Path2D.Double();
		p.moveTo(50, 150);
		p.quadTo(150, 0, x + anchura, y + altura);

		g2.draw(p);
	}

	@Override
	public void rotar(int grados) {
		// TODO Auto-generated method stub

	}
}
