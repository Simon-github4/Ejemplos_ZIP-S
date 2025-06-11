package entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Agencia {

	private String nombre; 
	private List<Vehiculo> vehiculos;
	private Map<String, List<Vehiculo>> vehiculosXMarca;
	
	public static void main(String args[]) {
		Agencia a = new Agencia("Diaz Automotores");
		a.agregar(new Auto("toyota", "aaa111", 2010, 10000000, "manual"));
		a.agregar(new Camion("fiat", "zzz999", 2022, 40000000, 100));
		a.agregar(new Auto("volkswagen", "bbb222", 2025, 10000000, "automatico"));
		a.agregar(new Camion("fiat", "ppp999", 2019, 33000000, 75));
		
		System.out.println(a.getInformacionAgencia());
		System.out.println("\n" + a.getInformacionAgencia("toyota"));
		System.out.println("\n" + a.getInformacionAgencia("fiat"));
		System.out.println("\n" + a.getInformacionAgencia("zzzzzzz"));
	}
	
	public Agencia(String nombre) {
		this.nombre = nombre;
		this.vehiculos = new ArrayList<Vehiculo>();
		this.vehiculosXMarca = new HashMap<String, List<Vehiculo>>();
	}

	public void agregar(Vehiculo vehiculo) {
		this.vehiculos.add(vehiculo);
		
		if(vehiculosXMarca.containsKey(vehiculo.getMarca())) 
			vehiculosXMarca.get(vehiculo.getMarca()).add(vehiculo);
		else {
			List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
			vehiculos.add(vehiculo);
			vehiculosXMarca.put(vehiculo.getMarca(), vehiculos);
		}
	}
	
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	
	public List<Vehiculo> getVehiculos(String marca){
		return vehiculos.stream().filter(a -> a.getMarca().equalsIgnoreCase(marca)).toList();
	}

	public String getInformacionAgencia() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.toString()).append("\n--------------------------Listado de todos los Vehiculos------------------------\n\n");
		Collections.sort(getVehiculos());
		getVehiculos().forEach(a -> sb.append(a.toString()).append("\n"));
		
		return sb.toString();
	}
	
	public String getInformacionAgencia(String marca) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.toString()).append("\n--------------------------Listado de Vehiculos marca: ").append(marca).append("----------------------\n\n");
		
		if(vehiculosXMarca.containsKey(marca)) {
			Collections.sort(vehiculosXMarca.get(marca));
			
			vehiculosXMarca.get(marca).forEach(a -> sb.append(a.toString()).append("\n"));
		}else 
			
			sb.append("\n No tenemos Vehiculos de esa marca\n");
		
		
		return sb.toString();
	}
	
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Agencia " + nombre;
	}
	

}
