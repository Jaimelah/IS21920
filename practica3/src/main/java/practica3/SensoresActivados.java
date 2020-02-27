package practica3;

public class SensoresActivados extends AlarmaHogarState{

	@Override
	public void entryAction(AlarmaHogar context) {
		context.piloto.encender();
	}
	@Override
	public void intruso(AlarmaHogar context) {
		
		
	}
	
}
