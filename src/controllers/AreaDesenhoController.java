package controllers;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Circulo;
import model.Retangulo;
import model.Triangulo;
import view.Interface;

public class AreaDesenhoController {

	public boolean clicaMouse(MouseEvent e) throws IllegalArgumentException {
		if (Interface.shapeAtual != null) {
			if (Interface.shapeAtual.equals("C�rculo")) {				//	Adiciona C�rculo � lista
				String input = JOptionPane.showInputDialog(null, "Digite o raio do c�rculo", "");
				if (input != null) {
					float raio = Float.parseFloat(input);
					if (raio <= 0) {
						throw new IllegalArgumentException();
					}
					Circulo aux = new Circulo(Interface.shapes.size(), Interface.corAtual, raio);
					aux.setX(e.getX());
					aux.setY(e.getY());
					Interface.shapes.add(aux);
				}
			}else if(Interface.shapeAtual.equals("Ret�ngulo")){			//	Adiciona Ret�ngulo � lista
				String inputBase = JOptionPane.showInputDialog(null, "Digite a base do ret�ngulo", "");
				String inputLado = JOptionPane.showInputDialog(null, "Digite o lado do ret�ngulo", "");
				if (inputBase != null && inputLado != null) {
					float base = Float.parseFloat(inputBase);
					float lado = Float.parseFloat(inputLado);
					if (base <= 0 || lado <= 0) {
						throw new IllegalArgumentException();
					}
					Retangulo aux = new Retangulo(Interface.shapes.size(), Interface.corAtual, base, lado);
					aux.setX(e.getX());
					aux.setY(e.getY());
					Interface.shapes.add(aux);
				}
			}else{														// Adiciona Tri�ngulo � lista
				String inputBase = JOptionPane.showInputDialog(null, "Digite a base do tri�ngulo", "");
				String inputLado = JOptionPane.showInputDialog(null, "Digite o lado do tri�ngulo", "");
				if (inputBase != null && inputLado != null) {
					float base = Float.parseFloat(inputBase);
					float lado = Float.parseFloat(inputLado);
					if (base <= 0 || lado <= 0) {
						throw new IllegalArgumentException();
					}
					Triangulo aux = new Triangulo(Interface.shapes.size(), Interface.corAtual, base, lado);
					aux.setX(e.getX());
					aux.setY(e.getY());
					Interface.shapes.add(aux);
				}
			}
			//JButton newShapeBtn = new JButton(Interface.shapes.get(Interface.shapes.size() - 1).getNome());
			//newShapeBtn.setBounds(10, 137 + (30 * Interface.formasScrollPanel.getComponentCount()), 171, 30);
			//Interface.formasScrollPanel.add(newShapeBtn);
			//JOptionPane.showMessageDialog(null, "ID: " + Interface.shapes.get(Interface.shapes.size() - 1).getID());
			Interface.shapeAtual = null;
			return true;
		}else{
			return false;
		}
	}
}
