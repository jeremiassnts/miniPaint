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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.TextField;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
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
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		abrirOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					openShapes(e);
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo: " + e1.getMessage());
				}
			}
		});
		menu.add(abrirOption);
		
		JMenuItem salvarOption = new JMenuItem("Salvar");
		salvarOption.setIcon(new ImageIcon(Interface.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		salvarOption.setHorizontalAlignment(SwingConstants.CENTER);
		salvarOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					saveShapes(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao salvar arquivo: " + e1.getMessage());
				}
			}
		});
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
	
	public void saveShapes(ActionEvent e) throws IOException{
		if(shapes.size() != 0){
			//Pega diretório para salvar arquivo
			JFileChooser file = new JFileChooser();
			file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			//Pega nome do arquivo
			String name = JOptionPane.showInputDialog("Digite o nome do arquivo") + ".dat";
			//Verifica se não foi cancelado
			if(file.showSaveDialog(null) != 1){
				//Salva objetos em arquivo .dat
				File tempFile = new File(file.getSelectedFile().getPath() + "/" + name);
				FileOutputStream fileStream = new FileOutputStream(tempFile);
				ObjectOutputStream obj = new ObjectOutputStream(fileStream);
				for(Shape shape : shapes){
					obj.writeObject(shape);
				}
				obj.flush();
				obj.close();
				JOptionPane.showMessageDialog(null, "Arquivo salvo com sucesso!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não existem formas no painel para serem salvas!");
		}
	}
	
	public void openShapes(ActionEvent e) throws IOException, ClassNotFoundException{
		JFileChooser file = new JFileChooser();
		file.setFileSelectionMode(JFileChooser.FILES_ONLY);
		if(file.showSaveDialog(null) != 1){
			FileInputStream fileStream = new FileInputStream(file.getSelectedFile().getAbsolutePath());
			ObjectInputStream obj = new ObjectInputStream(fileStream);
			try {
	            while (true){ shapes.add((Shape)obj.readObject()); }
	         } 
	    	catch(EOFException err){ }
	    	finally{ obj.close(); }
			areaDesenho = new AreaDesenho(this);
			Collections.sort(shapes);
			ferramentas.relista();
		}
	}
}
