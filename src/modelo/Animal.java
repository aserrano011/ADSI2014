package modelo;

public abstract class Animal {
	
	public String nacimiento;
	public float peso;
	public float altura;
	
	public Animal(String pNacimiento, float pPeso, float pAltura){
		nacimiento = pNacimiento;
		peso = pPeso;
		altura = pAltura;
	}
	
	//public abstract int modificarAnimal();
	public abstract void eliminarAnimal();
	public abstract String toString();
	
	public String getNacimiento(){
		return nacimiento;
	}
	
	public float getPeso(){
		return peso;
	}
	
	public float getAltura(){
		return altura;
	}
}
