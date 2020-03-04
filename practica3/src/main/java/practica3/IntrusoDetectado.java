package practica3;

import java.util.Timer;
import java.util.TimerTask;


public class IntrusoDetectado extends AlarmaHogarState {
	protected Timer timer=new Timer();
	protected IntervaloDesactivacionTask task;
	
	@Override
	public void entryAction(AlarmaHogar context) {
		task=new IntervaloDesactivacionTask(context);
		timer.schedule(task,context.getIntervaloDesactivacion()*1000);
	}
	@Override
	public void alarmaOff(AlarmaHogar context, String codigo) {
		if(!codigo.equals(context.getCodigoDesactivacion())) {
			getEstadoSensoresActivados().setIntentos(getEstadoSensoresActivados().getIntentos()-1);
		}else if(codigo.equals(context.getCodigoDesactivacion())&&getEstadoSensoresActivados().getIntentos()>0) {
			context.setState(getEstadoApagada());
			getEstadoApagada().entryAction(context);
			task.cancel();
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
