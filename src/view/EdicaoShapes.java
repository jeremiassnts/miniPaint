package view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import controllers.EdicaoShapesController;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class EdicaoShapes extends JPanel{
	private Interface i;
	
	private JTextField txtX;
	private JTextField txtY;
	
	private JTextField txtBaseTriangulo;
	private JTextField txtAlturaTriangulo;
	
	private JTextField txtBaseRetangulo;
	private JTextField txtAlturaRetangulo;
	
	private JTextField txtRaioCirculo;
	
	private Color corEdicao;

	private JTextField txtR;
	private JTextField txtG;
	private JTextField txtB;
	
	private static JPanel corShape;
	
	public EdicaoShapes(Shape shape, Interface i) {
		
		corEdicao = shape.getCor();
		
		this.i = i;
		
		EdicaoShapesController esc = new EdicaoShapesController(this.i, this);
		
		setLayout(null);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(9, 61, 46, 14);
		this.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(9, 110, 46, 14);
		this.add(lblY);
		
		this.txtX = new JTextField();
		this.txtX.setText(String.valueOf(shape.getX()));
		this.txtX.setBounds(65, 58, 117, 20);
		this.add(txtX);
		this.txtX.setColumns(10);
		
		this.txtY = new JTextField();
		this.txtY.setText(String.valueOf(shape.getY()));
		this.txtY.setColumns(10);
		this.txtY.setBounds(65, 107, 117, 20);
		this.add(txtY);
		
		this.txtR = new JTextField();
		this.txtR.setText(String.valueOf(shape.getCor().getRed()));
		this.txtR.setBounds(28, 11, 46, 20);
		this.add(txtR);
		this.txtR.setColumns(10);
		
		txtG = new JTextField();
		txtG.setText(String.valueOf(shape.getCor().getGreen()));
		txtG.setColumns(10);
		txtG.setBounds(103, 11, 46, 20);
		this.add(txtG);
		
		txtB = new JTextField();
		txtB.setText(String.valueOf(shape.getCor().getBlue()));
		txtB.setColumns(10);
		txtB.setBounds(177, 11, 46, 20);
		this.add(txtB);
		
		JLabel lblRed = new JLabel("R:");
		lblRed.setBounds(9, 14, 18, 14);
		this.add(lblRed);
		
		JLabel lblGreen = new JLabel("G:");
		lblGreen.setBounds(84, 14, 18, 14);
		this.add(lblGreen);
		
		JLabel lblBlue = new JLabel("B:");
		lblBlue.setBounds(159, 14, 18, 14);
		this.add(lblBlue);
		
		corShape = new JPanel();
		corShape.setBackground(shape.getCor());
		corShape.setBorder(new LineBorder(new Color(0, 0, 0)));
		corShape.setBounds(332, 11, 100, 20);
		this.add(corShape);
		
		JButton btnAplicarCor = new JButton("Aplicar");
		//Aplicando Funcionalidade de trocar a Cor do JPanel no botão
		btnAplicarCor.addActionListener(esc.alteraCor());
		btnAplicarCor.setBounds(233, 10, 89, 23);
		this.add(btnAplicarCor);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(esc.editaShape(shape));
		btnEditar.setIcon(new ImageIcon(EdicaoShapes.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		btnEditar.setBounds(28, 168, 89, 65);
		this.add(btnEditar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(esc.cancela());
		btnCancelar.setIcon(new ImageIcon(EdicaoShapes.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
		btnCancelar.setBounds(352, 168, 106, 65);
		this.add(btnCancelar);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(esc.removeShape());
		btnRemover.setIcon(new ImageIcon(EdicaoShapes.class.getResource("/javax/swing/plaf/metal/icons/ocean/paletteClose.gif")));
		btnRemover.setBounds(180, 168, 106, 65);
		this.add(btnRemover);
		
		if(shape instanceof Circulo){
			
			JLabel lblRaioCirculo = new JLabel("Raio:");
			lblRaioCirculo.setBounds(233, 84, 46, 14);
			this.add(lblRaioCirculo);
			
			txtRaioCirculo = new JTextField();
			txtRaioCirculo.setText(String.valueOf(((Circulo) shape).getRaio()));
			txtRaioCirculo.setBounds(289, 81, 143, 20);
			this.add(txtRaioCirculo);
			txtRaioCirculo.setColumns(10);
			
		}else if(shape instanceof Retangulo){
			
			txtBaseRetangulo = new JTextField();
			txtBaseRetangulo.setText(String.valueOf(((Retangulo) shape).getBase()));
			txtBaseRetangulo.setBounds(305, 58, 127, 20);
			this.add(txtBaseRetangulo);
			txtBaseRetangulo.setColumns(10);
			
			txtAlturaRetangulo = new JTextField();
			txtAlturaRetangulo.setText(String.valueOf(((Retangulo) shape).getAltura()));
			txtAlturaRetangulo.setColumns(10);
			txtAlturaRetangulo.setBounds(305, 107, 127, 20);
			this.add(txtAlturaRetangulo);
			
			JLabel lblBaseRetangulo = new JLabel("Base:");
			lblBaseRetangulo.setBounds(249, 61, 46, 14);
			this.add(lblBaseRetangulo);
			
			JLabel lblAlturaRetangulo = new JLabel("Altura:");
			lblAlturaRetangulo.setBounds(249, 110, 46, 14);
			this.add(lblAlturaRetangulo);
			
		}else{
			
			txtBaseTriangulo = new JTextField();
			txtBaseTriangulo.setText(String.valueOf(((Triangulo) shape).getBase()));
			txtBaseTriangulo.setBounds(305, 58, 127, 20);
			this.add(txtBaseTriangulo);
			txtBaseTriangulo.setColumns(10);
			
			txtAlturaTriangulo = new JTextField();
			txtAlturaTriangulo.setText(String.valueOf(((Triangulo) shape).getAltura()));
			txtAlturaTriangulo.setColumns(10);
			txtAlturaTriangulo.setBounds(305, 107, 127, 20);
			this.add(txtAlturaTriangulo);
			
			JLabel lblBaseTriangulo = new JLabel("Base:");
			lblBaseTriangulo.setBounds(249, 61, 46, 14);
			this.add(lblBaseTriangulo);
			
			JLabel lblAlturaTriangulo = new JLabel("Altura:");
			lblAlturaTriangulo.setBounds(249, 110, 46, 14);
			this.add(lblAlturaTriangulo);
			
		}
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtBaseTriangulo() {
		return txtBaseTriangulo;
	}

	public void setTxtBaseTriangulo(JTextField txtBaseTriangulo) {
		this.txtBaseTriangulo = txtBaseTriangulo;
	}

	public JTextField getTxtAlturaTriangulo() {
		return txtAlturaTriangulo;
	}

	public void setTxtAlturaTriangulo(JTextField txtAlturaTriangulo) {
		this.txtAlturaTriangulo = txtAlturaTriangulo;
	}

	public JTextField getTxtBaseRetangulo() {
		return txtBaseRetangulo;
	}

	public void setTxtBaseRetangulo(JTextField txtBaseRetangulo) {
		this.txtBaseRetangulo = txtBaseRetangulo;
	}

	public JTextField getTxtAlturaRetangulo() {
		return txtAlturaRetangulo;
	}

	public void setTxtAlturaRetangulo(JTextField txtAlturaRetangulo) {
		this.txtAlturaRetangulo = txtAlturaRetangulo;
	}

	public JTextField getTxtRaioCirculo() {
		return txtRaioCirculo;
	}

	public void setTxtRaioCirculo(JTextField txtRaioCirculo) {
		this.txtRaioCirculo = txtRaioCirculo;
	}

	public Color getCorEdicao() {
		return corEdicao;
	}

	public void setCorEdicao(Color corEdicao) {
		this.corEdicao = corEdicao;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public JTextField getTxtG() {
		return txtG;
	}

	public void setTxtG(JTextField txtG) {
		this.txtG = txtG;
	}

	public JTextField getTxtB() {
		return txtB;
	}

	public void setTxtB(JTextField txtB) {
		this.txtB = txtB;
	}

	public JPanel getCorShape() {
		return corShape;
	}

	public void setCorShape(JPanel corShape) {
		this.corShape = corShape;
	}

	public Interface getInterface() {
		return i;
	}

	public void setInterface(Interface i) {
		this.i = i;
	}
}
