package entidades;

import java.util.Objects;

public class Auto extends Vehiculo{

	private String caja;
	
	public Auto(String marca, String patente, int anio, long valuacion, String caja) {
		super(marca, patente, anio, valuacion);
		this.caja = caja;
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

	@Override
	public float getPrecioAlquilerDiario() {
		float precio = super.getPrecioAlquilerDiario();
		
		if(caja.equalsIgnoreCase("automatico"))
			precio += 1000;
		
		return precio;
	}

	@Override
	public String toString() {
		return super.toString() + ", caja: "+caja;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(caja);
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
		Auto other = (Auto) obj;
		return Objects.equals(caja, other.caja);
	}


	
}
