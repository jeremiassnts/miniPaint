package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import model.Shape;

import javax.swing.JToggleButton;
import javax.swing.ListModel;

public class Ferramentas extends JPanel {

	private ShapesList lista;
	private JLabel lblEscolhido;
	private Color corAtual = Color.BLACK;
	private String shapeAtual = null;
	private Interface i;

	public Ferramentas(Interface i) {
		this.i = i;
		
		this.setBorder(new LineBorder(new Color(0, 0, 0)));
		this.setBounds(624, 38, 191, 420);
		i.getContentPane().add(this);
		this.setLayout(null);

		JPanel CorPanel = new JPanel();
		CorPanel.setBackground(Color.BLACK);
		CorPanel.setBounds(10, 11, 18, 17);
		this.add(CorPanel);

		// Botão cor principal
		Button mudarCor = new Button("OK");
		mudarCor.setBounds(154, 11, 32, 17);
		this.add(mudarCor);

		JFormattedTextField red = new JFormattedTextField();
		red.setBounds(38, 11, 32, 17);
		this.add(red);
		red.setText("R");

		JFormattedTextField green = new JFormattedTextField();
		green.setBounds(77, 11, 32, 17);
		this.add(green);
		green.setText("G");

		JFormattedTextField blue = new JFormattedTextField();
		blue.setBounds(116, 11, 32, 17);
		this.add(blue);
		blue.setText("B");

		Icon circleIcon = new ImageIcon("src/resources/circle.png");
		JButton circleBtn = new JButton("", circleIcon);
		circleBtn.setBounds(10, 39, 50, 50);
		this.add(circleBtn);

		Icon rectangleIcon = new ImageIcon("src/resources/rectangle.png");
		JButton rectangleBtn = new JButton("", rectangleIcon);
		rectangleBtn.setBounds(73, 39, 50, 50);
		this.add(rectangleBtn);

		Icon triangleIcon = new ImageIcon("src/resources/triangle.png");
		JButton triangleBtn = new JButton("", triangleIcon);
		triangleBtn.setBounds(136, 39, 50, 50);
		this.add(triangleBtn);
		// ------------------------------------------------------

		// Labels -----------------------------------------------
		JLabel lblFormas = new JLabel("FORMAS");
		lblFormas.setBounds(38, 121, 107, 16);
		this.add(lblFormas);
		lblFormas.setHorizontalAlignment(SwingConstants.CENTER);
		// ------------------------------------------------------

		/* panelInsideScroll = new JPanel(); */

		Shape[] shapes = new Shape[this.i.getShapes().size()];

		this.i.getShapes().toArray(shapes);

		lista = new ShapesList(this.i, shapes);
		lista.setToolTipText("<html>\r\n\t<b>Lista de Formas: </b> <br/> \r\n\tAqui \u00E9 listado as formas presentes no Canvas\r\n</html>");

		// Formas -----------------------------------------------
		JScrollPane formasScrollPanel = new JScrollPane(lista);
		formasScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		formasScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		formasScrollPanel.setBounds(10, 137, 171, 272);
		this.add(formasScrollPanel);
		
		JLabel chosenLbl = new JLabel("Escolhido:");
		chosenLbl.setBounds(10, 96, 60, 14);
		add(chosenLbl);
		
		lblEscolhido = new JLabel("");
		lblEscolhido.setForeground(Color.BLUE);
		lblEscolhido.setBounds(77, 96, 109, 14);
		add(lblEscolhido);

		JLabel lblFerramentas = new JLabel("FERRAMENTAS");
		lblFerramentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFerramentas.setBounds(648, 11, 139, 16);
		i.getContentPane().add(lblFerramentas);
		// ------------------------------------------------------

		// Ações
		// Mudar cor objeto nao criado
		mudarCor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) throws NumberFormatException {
				try {
					int r = Integer.parseInt(red.getText().trim());
					int g = Integer.parseInt(green.getText().trim());
					int b = Integer.parseInt(blue.getText().trim());
					if (r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0)
						JOptionPane.showMessageDialog(null, "O intervalo de cores é de 0 a 255", "ERRO",JOptionPane.ERROR_MESSAGE);
					else {
						CorPanel.setBackground(new Color(r, g, b));
						corAtual = new Color(r, g, b);
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Somente são aceitos valores numéricos", "ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		// Shapes
		circleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeAtual = "Círculo";
				lblEscolhido.setText("Círculo");
				lblEscolhido.setForeground(corAtual);
				
			}
		});
		rectangleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeAtual = "Retângulo";
				lblEscolhido.setText("Retângulo");
				lblEscolhido.setForeground(corAtual);
			}
		});
		triangleBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shapeAtual = "Triângulo";
				lblEscolhido.setText("Triângulo");
				lblEscolhido.setForeground(corAtual);
			}
		});
	}

	public void relista() {
		Shape[] shapes = new Shape[this.i.getShapes().size()];

		this.i.getShapes().toArray(shapes);
		
		this.lista.setListData(shapes);
	}

	public ShapesList getLista() {
		return lista;
	}

	public void setLista(ShapesList lista) {
		lista = lista;
	}

	public JLabel getLblEscolhido() {
		return lblEscolhido;
	}

	public void setLblEscolhido(JLabel lblEscolhido) {
		lblEscolhido = lblEscolhido;
	}

	public Color getCorAtual() {
		return corAtual;
	}

	public void setCorAtual(Color corAtual) {
		corAtual = corAtual;
	}

	public String getShapeAtual() {
		return shapeAtual;
	}

	public void setShapeAtual(String shapeAtual) {
		shapeAtual = shapeAtual;
	}
	
	public Interface getInterface() {
		return i;
	}

	public void setInterface(Interface i) {
		this.i = i;
	}

}
