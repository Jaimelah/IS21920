package practica3;

import java.util.Timer;
import java.util.TimerTask;


public class IntrusoDetectado extends AlarmaHogarState {
	protected Timer timer=new Timer();
	protected IntervaloDesactivacionTask task;
	
	@Override
	public void entryAction(AlarmaHogar context) {
		task=new IntervaloDesactivacionTask(context);
		timer.schedule(task,context.getIntervaloDesactivacion());
	}
	@Override
	public void alarmaOff(AlarmaHogar context, String codigo) {
		if(codigo!=context.getCodigoDesactivacion()&&context.getNumeroIntentos()!=0) {
			context.setNumeroIntentos(context.getNumeroIntentos()-1);
		}
	}
	public class IntervaloDesactivacionTask extends TimerTask {
		private AlarmaHogar context;
		public IntervaloDesactivacionTask(AlarmaHogar c) {
			this.context=c;
		}
		@Override
		public void run() {
			context.setState(getEstadoCentralitaNotificada());
			getEstadoSensoresActivados().entryAction(context);
		}
		

	}

	

}
