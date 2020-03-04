package practica3;

public class CentralitaNotificada extends AlarmaHogarState {
	@Override
	public void off(AlarmaHogar context) {
		context.setState(getEstadoApagada());
		getEstadoApagada().entryAction(context);
	}

}
