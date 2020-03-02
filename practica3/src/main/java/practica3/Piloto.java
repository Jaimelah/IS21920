package practica3;

public class Piloto {
	private int state=0;
	public void encender() {
		state=1;
	}
	public void apagar() {
		state=0;
	}
	
	public void parpadear() {
		state=2;
	}
	public int getState() {
		return state;
	}

}
