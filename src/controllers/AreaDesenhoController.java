package controllers;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Circulo;
import model.Retangulo;
import model.Triangulo;
import view.Ferramentas;
import view.Interface;

public class AreaDesenhoController {
	
	private Interface i;
	
	public AreaDesenhoController(Interface i){
		this.i = i;
	}

	public boolean clicaMouse(MouseEvent e) throws IllegalArgumentException {
		if (this.i.getFerramentas().getShapeAtual() != null) {
			if (this.i.getFerramentas().getShapeAtual().equals("C�rculo")) {				//	Adiciona C�rculo � lista
				String input = JOptionPane.showInputDialog(null, "Digite o raio do c�rculo", "");
				if (input != null) {
					float raio = Float.parseFloat(input);
					if (raio <= 0) {
						throw new IllegalArgumentException();
					}
					Circulo aux = new Circulo(this.i.getFerramentas().getCorAtual(), raio);
					aux.setX(e.getX());
					aux.setY(e.getY());
					this.i.getShapes().add(aux);
				}
			}else if(this.i.getFerramentas().getShapeAtual().equals("Ret�ngulo")){			//	Adiciona Ret�ngulo � lista
				String inputBase = JOptionPane.showInputDialog(null, "Digite a base do ret�ngulo", "");
				String inputLado = JOptionPane.showInputDialog(null, "Digite o lado do ret�ngulo", "");
				if (inputBase != null && inputLado != null) {
					float base = Float.parseFloat(inputBase);
					float lado = Float.parseFloat(inputLado);
					if (base <= 0 || lado <= 0) {
						throw new IllegalArgumentException();
					}
					Retangulo aux = new Retangulo(this.i.getFerramentas().getCorAtual(), base, lado);
					aux.setX(e.getX());
					aux.setY(e.getY());
					this.i.getShapes().add(aux);
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
					Triangulo aux = new Triangulo(this.i.getFerramentas().getCorAtual(), base, lado);
					aux.setX(e.getX());
					aux.setY(e.getY());
					this.i.getShapes().add(aux);
				}
			}
			this.i.getFerramentas().getLblEscolhido().setText("");
			this.i.getFerramentas().setShapeAtual(null);
			this.i.getFerramentas().relista();
			return true;
		}else{
			return false;
		}
	}
}
