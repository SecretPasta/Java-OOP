package circuits;

//Class for a gate that returns False the class being Singleton
public class FalseGate extends Gate {

	private static FalseGate instance = null;

	// empty constructor for the class to create an instance of itself
	private FalseGate() {
		super(null);
	}

	// static method to create an instance of the class
	public static Gate instance() {
		if (instance == null)
			instance = new FalseGate();
		return instance;
	}

	// Overriding the abstract method to return False
	@Override
	protected boolean func(boolean[] inValues) {
		return false;
	}

	// Overriding the abstract method to return the name of the Gate
	@Override
	public String getName() {
		return "F";
	}
	// nothing to complicated with this gate so it only returns an instance of
	// itself

	@Override
	public Gate simplify() {
		return instance;
	}

}
