package myself.jsf;

import javax.faces.bean.ManagedBean;


@ManagedBean
public class Counter {
	private int counter = 0;

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public String increase() {
		counter++;
		return null;
	}
}
