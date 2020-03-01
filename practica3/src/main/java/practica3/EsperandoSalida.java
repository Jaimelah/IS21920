package practica3;

import java.util.Timer;
import java.util.TimerTask;

public class EsperandoSalida extends AlarmaHogarState {
	protected Timer timer=new Timer();
	protected IntervaloSalidaTask task;
	
	@Override
	public void entryAction(AlarmaHogar context) {
		task=new IntervaloSalidaTask(context);
		timer.schedule(task, context.getIntervaloSalida());
	}
	@Override
	public void alarmaOff(AlarmaHogar context,String codigo) {
		if(context.getCodigoDesactivacion().equals(codigo)) {
			context.setState(getEstadoApagada());
		}
	}
	@Override
	public void activarSensores(AlarmaHogar context) {
		context.setState(getEstadoSensoresActivados());
		
	}
	public class IntervaloSalidaTask extends TimerTask {
		private AlarmaHogar context;
		public IntervaloSalidaTask(AlarmaHogar c) {
			this.context=c;
		}
		@Override
		public void run() {
			context.setState(getEstadoSensoresActivados());
			getEstadoSensoresActivados().entryAction(context);
			
			
			
		}
		

	}


}
