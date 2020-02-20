package practica3;

public abstract class AlarmaHogarState {
	
	private static CentralitaNotificada estadoCentralitaNotificada=new CentralitaNotificada();
	private static Apagada estadoApagada=new Apagada();
	private static SensoresActivados estadoSensoresActivados=new SensoresActivados();
	private static IntrusoDetectado estadoIntrusoDetectado=new IntrusoDetectado();
	private static EsperandoSalida estadoEsperandoSalida=new EsperandoSalida();
	
	public static AlarmaHogarState init(AlarmaHogar context) {
		estadoApagada.entryAction(context);
		return estadoApagada;
	}
	
	public void entryAction(AlarmaHogar context) {}
	public void exitAction(AlarmaHogar context) {}
	public void doAction(AlarmaHogar context) {}
	public void alarmaOff(AlarmaHogar context) {}
	public void alarmaOn(AlarmaHogar context) {}
	public void intruso(AlarmaHogar context) {}
	public void off(AlarmaHogar context) {}

	public static CentralitaNotificada getEstadoCentralitaNotificada() {
		return estadoCentralitaNotificada;
	}

	public static Apagada getEstadoApagada() {
		return estadoApagada;
	}

	public static SensoresActivados getEstadoSensoresActivados() {
		return estadoSensoresActivados;
	}

	public static EsperandoSalida getEstadoEsperandoSalida() {
		return estadoEsperandoSalida;
	}

	public static IntrusoDetectado getEstadoIntrusoDetectado() {
		return estadoIntrusoDetectado;
	}
	
	
	
	

}
