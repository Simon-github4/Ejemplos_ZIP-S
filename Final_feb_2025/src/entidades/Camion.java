package entidades;

import java.util.Objects;

public class Camion extends Vehiculo{

	private int capacidad;
	
	public Camion(String marca, String patente, int anio, long valuacion, int capacidad) {
		super(marca, patente, anio, valuacion);
		this.capacidad = capacidad;
	}
	
	@Override
	public float getPrecioAlquilerDiario() {
		float precio = super.getPrecioAlquilerDiario();
		return precio + 50 * capacidad;
	}

	@Override
	public String toString() {
		return super.toString() + ", capacidad de carga en toneladas: "+ capacidad;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(capacidad);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camion other = (Camion) obj;
		return capacidad == other.capacidad;
	}

	
}
