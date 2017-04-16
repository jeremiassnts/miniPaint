package model;
import java.awt.Color;

public class Retangulo extends Shape{
	
	private float base;
	private float altura;
	
	public Retangulo(int size, Color Cor, float Base, float Altura){
		super(size, "Retângulo", Cor);
		base = Base;
		altura = Altura;
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
	
	public void setBase(float base){
		this.base = base;
	}
	public void setAltura(float altura){
		this.altura = altura;
	}
	
	public float getBase(){
		return base;
	}
	public float getAltura(){
		return altura;
	}
	
	public float getHeight(){
		return altura;
	}
	public float getWidth(){
		return base;
	}
	public int getID(){
		return id;
	}
	public String toString(){
		return this.id+" - Retângulo";
	}
}
