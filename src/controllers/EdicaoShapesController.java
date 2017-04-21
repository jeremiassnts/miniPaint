package controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.*;
import view.AreaDesenho;
import view.EdicaoShapes;
import view.Ferramentas;
import view.Interface;
import view.ShapesList;

public class EdicaoShapesController {
	
	private Interface i;
	private EdicaoShapes es;
	
	public EdicaoShapesController(Interface i, EdicaoShapes es){
		this.i = i;
		this.es = es;
	}
	
	public ActionListener alteraCor(){
		EdicaoShapes es = this.es;
		
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int red = Integer.parseInt(es.getTxtR().getText().trim());
					int green = Integer.parseInt(es.getTxtG().getText().trim());
					int blue = Integer.parseInt(es.getTxtB().getText().trim());
					if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0){
						throw new IllegalArgumentException();
					} else {
						Color c = new Color(red, green, blue);
						es.getCorShape().setBackground(c);
						es.setCorEdicao(c); 
					}
				} catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(null, "Somente são aceitos valores numéricos", "ERRO",JOptionPane.ERROR_MESSAGE);
				} catch (IllegalArgumentException exc) {
					JOptionPane.showMessageDialog(null, "O intervalo de cores é de 0 a 255", "ERRO",JOptionPane.ERROR_MESSAGE);
				}
			}
		};
	}
	
	public ActionListener editaShape(Shape shape){
		Ferramentas f = this.i.getFerramentas();
		EdicaoShapes es = this.es;
		Interface i = this.i;
		
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int index = f.getLista().getSelectedIndex();
				
				if(shape instanceof Circulo){
					
					Circulo circulo = (Circulo) shape;
					circulo.setCor(es.getCorEdicao()); 
					circulo.setRaio(Float.valueOf(es.getTxtRaioCirculo().getText()));
					circulo.setX( Integer.valueOf( es.getTxtX().getText() ) );
					circulo.setY( Integer.valueOf( es.getTxtY().getText() ) );
					i.getShapes().set(index, circulo);
					
				}else if(shape instanceof Retangulo){
					
					Retangulo retangulo = (Retangulo) shape;
					retangulo.setCor(es.getCorEdicao()); 
					retangulo.setBase(Float.valueOf(es.getTxtBaseRetangulo().getText()));
					retangulo.setAltura(Float.valueOf(es.getTxtAlturaRetangulo().getText()));
					retangulo.setX( Integer.valueOf( es.getTxtX().getText() ) );
					retangulo.setY( Integer.valueOf( es.getTxtY().getText() ) );
					i.getShapes().set(index, retangulo);
					
				}else{
					
					Triangulo triangulo = (Triangulo) shape;
					triangulo.setCor(es.getCorEdicao()); 
					triangulo.setBase(Float.valueOf(es.getTxtBaseTriangulo().getText()));
					triangulo.setAltura(Float.valueOf(es.getTxtAlturaTriangulo().getText()));
					triangulo.setX( Integer.valueOf( es.getTxtX().getText() ) );
					triangulo.setY( Integer.valueOf( es.getTxtY().getText() ) );
					i.getShapes().set(index, triangulo);
					
				}
				
				f.relista();
				i.getAreaDesenho().limpaCanvas(false);
				i.getFerramentas().getLista().getJframe().setVisible(false);
				i.getFerramentas().getLista().getJframe().dispose();
				
			}
		};
	}
	
	public ActionListener removeShape(){
		
		Ferramentas f = this.i.getFerramentas();
		Interface i = this.i;
		
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = f.getLista().getSelectedIndex();
				
				i.getShapes().remove(index);
				
				f.relista();
				i.getAreaDesenho().limpaCanvas(false);
				i.getFerramentas().getLista().getJframe().setVisible(false);
				i.getFerramentas().getLista().getJframe().dispose();
			}
		};
	}
	
	public ActionListener cancela(){
		
		Interface i = this.i;
		
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				i.getFerramentas().getLista().getJframe().setVisible(false);
				i.getFerramentas().getLista().getJframe().dispose();
			}
		};
	}
	
}
