package entidades;

import java.util.Objects;

public abstract class Vehiculo implements Comparable<Vehiculo>{

	private static float PORC_VALOR_VALUACION = 1;
	
	private String marca;
	private String patente;
	private int año;
	private long valuacion;
	
	public Vehiculo(String marca, String patente, int anio, long valuacion) {
		super();
		this.marca = marca;
		this.patente = patente;
		this.año = anio;
		this.valuacion = valuacion;
	}
	
	public float getPrecioAlquilerDiario() {
		return this.valuacion * (float)(PORC_VALOR_VALUACION / 100);
	}

	@Override
	public int compareTo(Vehiculo v) {
		return this.año - v.getAño();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ": "+ patente + ", año: "+ this.año + ", marca: "+ marca+ ", valor de alquiler diario: "+ getPrecioAlquilerDiario() ;
	}
		
	
	@Override
	public int hashCode() {
		return Objects.hash(año, marca, patente, valuacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return año == other.año && Objects.equals(marca, other.marca) && Objects.equals(patente, other.patente)
				&& valuacion == other.valuacion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int Año) {
		this.año = Año;
	}

	public long getValuacion() {
		return valuacion;
	}

	public void setValuacion(long valuacion) {
		this.valuacion = valuacion;
	}	
	
}
