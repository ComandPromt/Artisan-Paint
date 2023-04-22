package dibujante;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CubicCurveMouse extends JFrame {

	private static final long serialVersionUID = 1L;

	DrawingCanvas canvas;

	public CubicCurveMouse() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Drawing Curve");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CubicCurveMouse.class.getResource("/imagenes/curva.png")));

		Container container = getContentPane();

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(1, 2));

		container.add(panel, BorderLayout.SOUTH);

		canvas = new DrawingCanvas();

		container.add(canvas);

		addWindowListener(new WindowEventHandler());

		setSize(800, 600);

		this.setLocationRelativeTo(null);

		setVisible(true);

	}

	class WindowEventHandler extends WindowAdapter {

		@Override

		public void windowClosing(WindowEvent e) {

			System.exit(0);

		}

	}

	class DrawingCanvas extends Canvas {

		private static final long serialVersionUID = 1L;

		float x1, y1, xc1cur, yc1cur, xc1new, yc1new, xc2cur, yc2cur, xc2new, yc2new, x4cur, y4cur, x4new, y4new;

		int pressNo = 0;

		int dragFlag1 = -1;

		int dragFlag2 = -1;

		boolean clearFlag = false;

		float dashes[] = { 5f, 5f };

		BasicStroke stroke;

		public DrawingCanvas() {

			setBackground(Color.white);

			addMouseListener(new MyMouseListener());

			addMouseMotionListener(new MyMouseListener());

			stroke = new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10f, dashes, 0f);

		}

		@Override
		public void update(Graphics g) {

			paint(g);

		}

		@Override
		public void paint(Graphics g) {

			Graphics2D g2D = (Graphics2D) g;

			switch (pressNo) {

			default:

			case 1:

				g2D.setXORMode(getBackground());

				g2D.setColor(Color.black);

				g2D.setStroke(stroke);

				// Erase the currently existing line

				g2D.draw(new Line2D.Float(x1, y1, x4cur, y4cur));

				// Draw the new line

				g2D.draw(new Line2D.Float(x1, y1, x4new, y4new));

				// Update the currently existing coordinate values

				x4cur = x4new;

				y4cur = y4new;

				break;

			case 2:

				g2D.setXORMode(getBackground());

				g2D.setColor(Color.black);

				g2D.setStroke(stroke);

				if (dragFlag1 != -1) {

					g2D.draw(new QuadCurve2D.Float(x1, y1, xc1cur, yc1cur, x4new, y4new));

				}

				dragFlag1++; // Reset the drag-flag

				g2D.draw(new QuadCurve2D.Float(x1, y1, xc1new, yc1new, x4new, y4new));

				xc1cur = xc1new;

				yc1cur = yc1new;

				break;

			case 3:

				g2D.setXORMode(getBackground());

				g2D.setColor(Color.black);

				if (dragFlag2 != -1) {

					g2D.draw(new CubicCurve2D.Float(x1, y1, xc1new, yc1new, xc2cur, yc2cur, x4new, y4new));

				}

				dragFlag2++; // Reset the drag flag

				g2D.draw(new CubicCurve2D.Float(x1, y1, xc1new, yc1new, xc2new, yc2new, x4new, y4new));

				xc2cur = xc2new;

				yc2cur = yc2new;

				break;

			}

			if (clearFlag) {

				g2D.setXORMode(getBackground());

				g2D.setColor(Color.black);

				g2D.setStroke(stroke);

				g2D.draw(new Line2D.Float(x1, y1, x4new, y4new));

				g2D.draw(new QuadCurve2D.Float(x1, y1, xc1new, yc1new, x4new, y4new));

				clearFlag = false;

			}

		}

		class MyMouseListener extends MouseAdapter implements MouseMotionListener {

			@Override

			public void mousePressed(MouseEvent e) {

				switch (pressNo) {

				case 0:

					pressNo++;

					x1 = x4cur = e.getX();

					y1 = y4cur = e.getY();

					break;

				case 1:

					pressNo++;

					xc1cur = e.getX();

					yc1cur = e.getY();

					break;

				default:

					pressNo++;

					xc2cur = e.getX();

					yc2cur = e.getY();

					break;

				}

			}

			@Override
			public void mouseReleased(MouseEvent e) {

				switch (pressNo) {

				case 1:

					x4new = e.getX();

					y4new = e.getY();

					break;

				case 2:

					xc1new = e.getX();

					yc1new = e.getY();

					break;

				case 3:

					xc2new = e.getX();

					yc2new = e.getY();

					pressNo = 0;

					dragFlag1 = -1;

					dragFlag2 = -1;

					clearFlag = true;

					break;

				}

				canvas.repaint();

			}

			@Override
			public void mouseDragged(MouseEvent e) {

				switch (pressNo) {

				default:

				case 1:

					x4new = e.getX();

					y4new = e.getY();

					break;

				case 2:

					xc1new = e.getX();

					yc1new = e.getY();

					break;

				case 3:

					xc2new = e.getX();

					yc2new = e.getY();

					break;

				}

				canvas.repaint();

			}

		}

	}

}