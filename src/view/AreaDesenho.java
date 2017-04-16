package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controllers.AreaDesenhoController;
import model.Circulo;
import model.Retangulo;
import model.Shape;
import model.Triangulo;

public class AreaDesenho extends JPanel implements ActionListener, MouseListener {

	private boolean cleanIt;

	public AreaDesenho(Interface i) {
		this.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		this.cleanIt = false;
		this.setBounds(10, 11, 604, 447);
		i.getContentPane().add(this);
		this.setLayout(null);
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
	}

	public void mouseClicked(MouseEvent evt) {

		AreaDesenhoController adc = new AreaDesenhoController();
		try {
			adc.clicaMouse(evt);
			repaint(); // esse m�todo limpa a tela, e rechama o m�todo
						// paintComponent presente nessa classe
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Digite valores v�lidos", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void limpaCanvas(){
		this.cleanIt = true;
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (!cleanIt) {
			for (Shape s : Interface.shapes) {
				if (s instanceof Circulo) {
					Circulo c = (Circulo) s;
					g.setColor(c.getCor());
					int x = c.getX() - Math.round(c.getRaio());
					int y = c.getY() - Math.round(c.getRaio());
					g.drawOval(x, y, Math.round(c.getRaio()) * 2, Math.round(c.getRaio()) * 2);
				} else if (s instanceof Retangulo) {
					Retangulo r = (Retangulo) s;
					g.setColor(r.getCor());
					int x = r.getX() - (Math.round(r.getBase() / 2));
					int y = r.getY() - (Math.round(r.getAltura() / 2));
					g.drawRect(x, y, Math.round(r.getBase()), Math.round(r.getHeight()));
				} else {
					Triangulo t = (Triangulo) s;
					Graphics2D g2d = (Graphics2D) g;
					Polygon triangle = new Polygon();
					int x = t.getX();
					int y = t.getY() - Math.round(t.getAltura() / 2);
					int b = Math.round(t.getBase());
					int h = Math.round(t.getAltura());
					triangle.addPoint(x, y);
					triangle.addPoint((x - (b / 2)), (y + h));
					triangle.addPoint((x + (b / 2)), (y + h));
					g2d.setColor(t.getCor());
					g2d.draw(triangle);
				}
			}
		}else{
			cleanIt = false;
		}
	}

}
