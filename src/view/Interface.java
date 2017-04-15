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

	public static JPanel contentPane;
	public static Color corAtual = Color.BLACK;
	public static String shapeAtual = null;
	public static List<Shape> shapes = new ArrayList<>();
	public static List<JButton> buttons = new ArrayList<>();
	public static AreaDesenho ad;
	public static JScrollPane formasScrollPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interface frame = new Interface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public Interface() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 841, 532);
		
		//Menu e opções ----------------------------------------
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenuItem abrirOption = new JMenuItem("Abrir");
		menu.add(abrirOption);
		
		JMenuItem salvarOption = new JMenuItem("Salvar");
		menu.add(salvarOption);
		
		JMenuItem limparTelaOption = new JMenuItem("Limpar tela");
		limparTelaOption.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ad.limpaCanvas();
				shapes = new ArrayList<>();
			}
		});
		menu.add(limparTelaOption);
		
		JMenuItem sairOption = new JMenuItem("Sair");
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
		ad = new AreaDesenho(this);
		//------------------------------------------------------

		
		//Ferramentas ------------------------------------------
		JPanel ferramentasPanel = new JPanel();
		ferramentasPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		ferramentasPanel.setBounds(624, 38, 191, 420);
		getContentPane().add(ferramentasPanel);
		ferramentasPanel.setLayout(null);
		
		JPanel CorPanel = new JPanel();
		CorPanel.setBackground(Color.BLACK);
		CorPanel.setBounds(10, 11, 18, 17);
		ferramentasPanel.add(CorPanel);
		
		//Botão cor principal
		Button mudarCor = new Button("OK");
		mudarCor.setBounds(154, 11, 32, 17);
		ferramentasPanel.add(mudarCor);
		
		JFormattedTextField red = new JFormattedTextField();
		red.setBounds(38, 11, 32, 17);
		ferramentasPanel.add(red);
		new MaskFormatter("###").install(red);
		red.setText("0");
		
		JFormattedTextField green = new JFormattedTextField();
		green.setBounds(77, 11, 32, 17);
		ferramentasPanel.add(green);
		new MaskFormatter("###").install(green);
		green.setText("0");
		
		JFormattedTextField blue = new JFormattedTextField();
		blue.setBounds(116, 11, 32, 17);
		ferramentasPanel.add(blue);
		new MaskFormatter("###").install(blue);
		blue.setText("0");
		
		Icon circleIcon = new ImageIcon("src/resources/circle.png");
		JButton circleBtn = new JButton("", circleIcon);
		circleBtn.setBounds(10, 39, 50, 50);
		ferramentasPanel.add(circleBtn);
		
		Icon rectangleIcon = new ImageIcon("src/resources/rectangle.png");
		JButton rectangleBtn = new JButton("", rectangleIcon);
		rectangleBtn.setBounds(73, 39, 50, 50);
		ferramentasPanel.add(rectangleBtn);
		
		Icon triangleIcon = new ImageIcon("src/resources/triangle.png");
		JButton triangleBtn = new JButton("", triangleIcon);
		triangleBtn.setBounds(136, 39, 50, 50);
		ferramentasPanel.add(triangleBtn);
		//------------------------------------------------------
		
		//Labels -----------------------------------------------
		JLabel lblFormas = new JLabel("FORMAS");
		lblFormas.setBounds(41, 110, 107, 16);
		ferramentasPanel.add(lblFormas);
		lblFormas.setHorizontalAlignment(SwingConstants.CENTER);
		//------------------------------------------------------
		
		//Formas -----------------------------------------------
		formasScrollPanel = new JScrollPane();
		formasScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		formasScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		formasScrollPanel.setBounds(10, 137, 171, 272);
		ferramentasPanel.add(formasScrollPanel);
		
		JLabel lblFerramentas = new JLabel("FERRAMENTAS");
		lblFerramentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFerramentas.setBounds(648, 11, 139, 16);
		getContentPane().add(lblFerramentas);
		//------------------------------------------------------
		
		//Ações
		try{
			//Mudar cor objeto nao criado
			mudarCor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int r = Integer.parseInt(red.getText().trim());
					int g = Integer.parseInt(green.getText().trim());
					int b = Integer.parseInt(blue.getText().trim());
					if(r > 255 || g > 255 || b > 255)
						JOptionPane.showMessageDialog(null, "O intervalo de cores é de 0 a 255", "ERRO", JOptionPane.ERROR_MESSAGE);
					else {
						CorPanel.setBackground(new Color(r, g, b));
						corAtual = new Color(r, g, b);
					}
				}
			});
			//Shapes
			circleBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					shapeAtual = "Círculo";
				}
			});
			rectangleBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					shapeAtual = "Retângulo";
				}
			});
			triangleBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					shapeAtual = "Triângulo";
				}
			});
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
