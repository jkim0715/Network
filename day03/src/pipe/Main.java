package pipe;

public class Main {

	public static void main(String[] args) {
		InputThread it = new InputThread("Input");
		OutputThread ot = new OutputThread("output");
		it.connect(ot.getOutput());
		it.start();
		ot.start();
	}

}
