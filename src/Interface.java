import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JMenuBar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import java.awt.TextField;
import java.text.ParseException;
import java.awt.Color;
import java.awt.Button;
import javax.swing.JFormattedTextField;

public class Interface extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 762, 507);
		
		//Menu e opções ----------------------------------------
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenuItem abrirOption = new JMenuItem("Abrir");
		menu.add(abrirOption);
		
		JMenuItem salvarOption = new JMenuItem("Salvar");
		menu.add(salvarOption);
		
		JMenuItem limparTelaOption = new JMenuItem("Limpar tela");
		menu.add(limparTelaOption);
		
		JMenuItem sairOption = new JMenuItem("Sair");
		menu.add(sairOption);
		getContentPane().setLayout(null);
		//------------------------------------------------------
		
		//Formas -----------------------------------------------
		JScrollPane formasScrollPanel = new JScrollPane();
		formasScrollPanel.setBounds(10, 38, 107, 395);
		getContentPane().add(formasScrollPanel);
		//------------------------------------------------------
		
		//Área de desennho -------------------------------------
		JPanel paintPanel = new JPanel();
		paintPanel.setBounds(127, 11, 412, 422);
		getContentPane().add(paintPanel);
		paintPanel.setLayout(null);
		
		Canvas paintCanvas = new Canvas();
		paintCanvas.setBounds(10, 27, 392, 385);
		paintPanel.add(paintCanvas);
		paintCanvas.setBackground(Color.WHITE);
		//------------------------------------------------------
		
		//Ferramentas ------------------------------------------
		JPanel ferramentasPanel = new JPanel();
		ferramentasPanel.setBounds(549, 38, 191, 395);
		getContentPane().add(ferramentasPanel);
		ferramentasPanel.setLayout(null);
		
		JPanel CorPanel = new JPanel();
		CorPanel.setBackground(Color.BLACK);
		CorPanel.setBounds(10, 11, 18, 17);
		ferramentasPanel.add(CorPanel);
		
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
		
		Icon circleIcon = new ImageIcon("C:\\Users\\Ednilson\\workspace\\MiniPaint\\src\\circle.png");
		JButton circleBtn = new JButton("", circleIcon);
		circleBtn.setBounds(10, 39, 50, 50);
		ferramentasPanel.add(circleBtn);
		
		Icon rectangleIcon = new ImageIcon("C:\\Users\\Ednilson\\workspace\\MiniPaint\\src\\rectangle.png");
		JButton rectangleBtn = new JButton("", rectangleIcon);
		rectangleBtn.setBounds(73, 39, 50, 50);
		ferramentasPanel.add(rectangleBtn);
		
		Icon triangleIcon = new ImageIcon("C:\\Users\\Ednilson\\workspace\\MiniPaint\\src\\triangle.png");
		JButton triangleBtn = new JButton("", triangleIcon);
		triangleBtn.setBounds(136, 39, 50, 50);
		ferramentasPanel.add(triangleBtn);
		
		JButton apagarBtn = new JButton("Apagar");
		apagarBtn.setBounds(54, 361, 89, 23);
		ferramentasPanel.add(apagarBtn);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 100, 176, 250);
		ferramentasPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Propriedades");
		lblNewLabel.setBounds(56, 5, 84, 14);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBounds(10, 38, 156, 79);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(69, 5, 38, 14);
		panel_1.add(lblCor);
		
		JFormattedTextField redProp = new JFormattedTextField();
		redProp.setBounds(36, 37, 32, 17);
		panel_1.add(redProp);
		new MaskFormatter("###").install(redProp);
		redProp.setText("0");
		
		JFormattedTextField greenProp = new JFormattedTextField();
		greenProp.setBounds(75, 37, 32, 17);
		panel_1.add(greenProp);
		new MaskFormatter("###").install(greenProp);
		greenProp.setText("0");
		
		JFormattedTextField blueProp = new JFormattedTextField();
		blueProp.setBounds(114, 37, 32, 17);
		panel_1.add(blueProp);
		new MaskFormatter("###").install(blueProp);
		blueProp.setText("0");
		
		JPanel corProp = new JPanel();
		corProp.setBackground(Color.BLACK);
		corProp.setBounds(10, 37, 18, 17);
		panel_1.add(corProp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 128, 156, 79);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPosio = new JLabel("Posi\u00E7\u00E3o");
		lblPosio.setBounds(60, 5, 65, 14);
		panel_2.add(lblPosio);
		
		JFormattedTextField posicaoXprop = new JFormattedTextField();
		posicaoXprop.setBounds(33, 35, 44, 22);
		panel_2.add(posicaoXprop);
		new MaskFormatter("####").install(posicaoXprop);
		posicaoXprop.setText("0");
		
		JFormattedTextField posicaoYprop = new JFormattedTextField();
		posicaoYprop.setBounds(102, 35, 44, 22);
		panel_2.add(posicaoYprop);
		new MaskFormatter("####").install(posicaoYprop);
		posicaoYprop.setText("0");
		
		JLabel lblNewLabel_1 = new JLabel("X");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 35, 18, 22);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblY = new JLabel("Y");
		lblY.setHorizontalAlignment(SwingConstants.CENTER);
		lblY.setBounds(83, 35, 18, 22);
		panel_2.add(lblY);
		
		JButton propBtn = new JButton("OK");
		propBtn.setBounds(56, 216, 63, 23);
		panel.add(propBtn);
		//------------------------------------------------------
		
		//Labels -----------------------------------------------
		JLabel lblFormas = new JLabel("FORMAS");
		lblFormas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormas.setBounds(10, 11, 107, 16);
		getContentPane().add(lblFormas);
		
		JLabel lblFerramentas = new JLabel("FERRAMENTAS");
		lblFerramentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFerramentas.setBounds(570, 11, 139, 16);
		getContentPane().add(lblFerramentas);
		//------------------------------------------------------
	}
}
