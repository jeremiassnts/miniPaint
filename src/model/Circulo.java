package model;
import java.awt.Color;

public class Circulo extends Shape{
	
	private float raio;
	
	public Circulo(int size, Color Cor, float Raio){
		super(size, "Círculo", Cor);
		raio = Raio;
	}
	
	public void setCor(Color Cor){
		cor = Cor;
	}
	public void setX(int X){
		x = X;
	}
	public void setY(int Y){
		y = Y;
	}

	public String getNome(){
		return nome;
	}
	public Color getCor(){
		return cor;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	
	public void setRaio(float raio){
		this.raio = raio;
	}
	public float getRaio(){
		return raio;
	}
	public float getHeight(){
		return raio * 2;
	}
	public float getWidth(){
		return raio * 2;
	}
	public int getID(){
		return id;
	}
}
