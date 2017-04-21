package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import model.Shape;

public class ShapesList extends JList implements ActionListener, MouseListener {
	
	private JFrame jframe;
	private Interface i;
	
	public ShapesList(Interface i, Shape[] shapes) {
		super(shapes);
		this.i = i;
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.addMouseListener(this);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() == 2) {
			Shape shape = (Shape) this.getSelectedValue();
			
			EdicaoShapes es = new EdicaoShapes(shape, this.i);
			
			jframe = new JFrame();
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JDialog frame = new JDialog(jframe, "Edição", true);
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			frame.getContentPane().add(es);
			frame.setSize(500,300);
			frame.setVisible(true);
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	public JFrame getJframe() {
		return jframe;
	}

	public void setJframe(JFrame jframe) {
		jframe = jframe;
	}

	public Interface getInterface() {
		return i;
	}

	public void setInterface(Interface i) {
		this.i = i;
	}

}
