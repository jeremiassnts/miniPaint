package controllers;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import model.Circulo;
import model.Retangulo;
import model.Triangulo;
import view.Interface;

public class AreaDesenhoController {

	public boolean clicaMouse(MouseEvent e) throws IllegalArgumentException {
		if (Interface.shapeAtual != null) {
			if (Interface.shapeAtual.equals("Círculo")) {				//	Adiciona Círculo à lista
				String input = JOptionPane.showInputDialog(null, "Digite o raio do círculo", "");
				if (input != null) {
					float raio = Float.parseFloat(input);
					if (raio <= 0) {
						throw new IllegalArgumentException();
					}
					Circulo aux = new Circulo(Interface.corAtual, raio);
					aux.setX(e.getX());
					aux.setY(e.getY());
					Interface.shapes.add(aux);
				}
			}else if(Interface.shapeAtual.equals("Retângulo")){			//	Adiciona Retângulo à lista
				String inputBase = JOptionPane.showInputDialog(null, "Digite a base do retângulo", "");
				String inputLado = JOptionPane.showInputDialog(null, "Digite o lado do retângulo", "");
				if (inputBase != null && inputLado != null) {
					float base = Float.parseFloat(inputBase);
					float lado = Float.parseFloat(inputLado);
					if (base <= 0 || lado <= 0) {
						throw new IllegalArgumentException();
					}
					Retangulo aux = new Retangulo(Interface.corAtual, base, lado);
					aux.setX(e.getX());
					aux.setY(e.getY());
					Interface.shapes.add(aux);
				}
			}else{														// Adiciona Triângulo à lista
				String inputBase = JOptionPane.showInputDialog(null, "Digite a base do triângulo", "");
				String inputLado = JOptionPane.showInputDialog(null, "Digite o lado do triângulo", "");
				if (inputBase != null && inputLado != null) {
					float base = Float.parseFloat(inputBase);
					float lado = Float.parseFloat(inputLado);
					if (base <= 0 || lado <= 0) {
						throw new IllegalArgumentException();
					}
					Triangulo aux = new Triangulo(Interface.corAtual, base, lado);
					aux.setX(e.getX());
					aux.setY(e.getY());
					Interface.shapes.add(aux);
				}
			}
			
			Interface.shapeAtual = null;
			return true;
		}else{
			return false;
		}
	}
}
