package practica3;

public class SensoresActivados extends AlarmaHogarState{
	public int intentos=3;
	@Override
	public void entryAction(AlarmaHogar context) {
		context.getPiloto().encender();
	}
	@Override
	public void intruso(AlarmaHogar context) {
		context.setState(getEstadoIntrusoDetectado());
		getEstadoIntrusoDetectado().entryAction(context);	
	}
	public int getIntentos() {
		return intentos;
	}
	public void setIntentos(int intentos) {
		this.intentos = intentos;
	}
}
