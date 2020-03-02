package practica3;

public class AlarmaHogar {
	private AlarmaHogarState state;
	private int intervaloSalida=4;
	private int intervaloDesactivacion=4;
	private String codigoDesactivacion="123456";
	private Piloto piloto;
	private int numeroIntentos=3;
	public AlarmaHogar() {
		piloto=new Piloto();
		state=AlarmaHogarState.init(this);
	}
	
	public void setNumeroIntentos(int numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}
	public int getNumeroIntentos() {
		return numeroIntentos;
	}
	public void setState(AlarmaHogarState value) {
		this.state=value;
	}
	public void notificarCentralita() {
		state.notificarCentralita(this);
	}
	public void desactivarSensores() {
		state.desactivarSensores(this);
	}
	public void activarSensores() {
		state.activarSensores(this);
	}
	public void alarmaOff(String codigo) {
		state.alarmaOff(this, codigo);
	}
	public void alarmaOn() {
		state.alarmaOn(this);
	}
	public void intruso() {
		state.intruso(this);
	}
	public void off() {
		state.off(this);
	}
	public AlarmaHogarState getState() {
		return state;
	}
	public int getIntervaloSalida() {
		return intervaloSalida;
	}
	public int getIntervaloDesactivacion() {
		return intervaloDesactivacion;
	}
	public String getCodigoDesactivacion() {
		return codigoDesactivacion;
	}
	public Piloto getPiloto() {
		return piloto;
	}

}
