package practica3;

public class Apagada extends AlarmaHogarState {
	@Override
	public void entryAction(AlarmaHogar context) {
		context.piloto.apagar();
		
	}
	public void alarmaOn(AlarmaHogar context) {
		context.setState(getEstadoEsperandoSalida());
	}
}
