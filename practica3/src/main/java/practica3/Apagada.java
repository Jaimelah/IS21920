package practica3;

public class Apagada extends AlarmaHogarState {
	@Override
	public void entryAction(AlarmaHogar context) {
		context.getPiloto().apagar();
		
	}
	@Override
	public void alarmaOn(AlarmaHogar context) {
		context.setState(getEstadoEsperandoSalida());
		getEstadoEsperandoSalida().entryAction(context);
	}
}
