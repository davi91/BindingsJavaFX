package dad.javafx.bindings.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Mueble {
	private String modelo;
	private String fabricante;
	private Boolean hechoMano;
	private LocalDate fechaFabricacion;
	private TipoMueble tipo;
	
	
	public Long getAntiguedad() {
		return fechaFabricacion.until(LocalDate.now(), ChronoUnit.YEARS);
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Boolean getHechoMano() {
		return hechoMano;
	}
	public void setHechoMano(Boolean hechoMano) {
		this.hechoMano = hechoMano;
	}
	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}
	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}
	public TipoMueble getTipo() {
		return tipo;
	}
	public void setTipo(TipoMueble tipo) {
		this.tipo = tipo;
	}
	
	
	
}
