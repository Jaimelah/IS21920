package practica3;

public class SensoresActivados extends AlarmaHogarState{

	@Override
	public void entryAction(AlarmaHogar context) {
		context.getPiloto().encender();
	}
	@Override
	public void intruso(AlarmaHogar context) {
		if(context.getNumeroIntentos()==0) {
			context.setState(getEstadoIntrusoDetectado());
			getEstadoIntrusoDetectado().entryAction(context);
		}
		
	}
	
}
