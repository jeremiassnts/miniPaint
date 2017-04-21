package view;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.Circulo;
import model.Retangulo;
import model.Shape;
import model.Triangulo;

import javax.swing.JMenuBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.TextField;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Button;
import javax.swing.JFormattedTextField;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.ShapeGraphicAttribute;
import java.awt.geom.Ellipse2D;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Interface extends JFrame {
	
	private List<Shape> shapes = new ArrayList<>();
	private AreaDesenho areaDesenho;
	private Ferramentas ferramentas;
	private JScrollPane formasScrollPanel;

	public Interface() throws ParseException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 532);
		
		//Menu e opções ----------------------------------------
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenuItem abrirOption = new JMenuItem("Abrir");
		abrirOption.setIcon(new ImageIcon(Interface.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		abrirOption.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(abrirOption);
		
		JMenuItem salvarOption = new JMenuItem("Salvar");
		salvarOption.setIcon(new ImageIcon(Interface.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		salvarOption.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(salvarOption);
		
		JMenuItem limparTelaOption = new JMenuItem("Limpar tela");
		limparTelaOption.setIcon(new ImageIcon(Interface.class.getResource("/com/sun/javafx/scene/web/skin/FontBackgroundColor_16x16_JFX.png")));
		limparTelaOption.setHorizontalAlignment(SwingConstants.CENTER);
		limparTelaOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				areaDesenho.limpaCanvas(true);
				shapes = new ArrayList<>();
				ferramentas.relista();
			}
		});
		menu.add(limparTelaOption);
		
		JMenuItem sairOption = new JMenuItem("Sair");
		sairOption.setIcon(new ImageIcon(Interface.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		sairOption.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(sairOption);
		getContentPane().setLayout(null);
		sairOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		//------------------------------------------------------
		
		
		//Área de desennho -------------------------------------
		areaDesenho = new AreaDesenho(this);
		//------------------------------------------------------

		//Ferramentas ------------------------------------------
		ferramentas = new Ferramentas(this);
		//------------------------------------------------------
	}
	
	public List<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	public  Ferramentas getFerramentas() {
		return ferramentas;
	}
	public void setFerramentas(Ferramentas f) {
		this.ferramentas = f;
	}
	public JScrollPane getFormasScrollPanel() {
		return formasScrollPanel;
	}
	public void setFormasScrollPanel(JScrollPane formasScrollPanel) {
		this.formasScrollPanel = formasScrollPanel;
	}
	public AreaDesenho getAreaDesenho() {
		return areaDesenho;
	}
	public void setAreaDesenho(AreaDesenho ad) {
		this.areaDesenho = ad;
	}
}
