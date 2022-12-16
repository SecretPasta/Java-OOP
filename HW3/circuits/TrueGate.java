package circuits;
//Class for a gate that returns True the class being Singleton
public class TrueGate extends Gate{
	
	private static TrueGate instance = null;
	//empty constructor for the class to create an instance of itself
	private TrueGate() {
		super(null);
	}
//static method to create an instance of the class
	public static Gate instance() {
		if(instance == null)
			instance  = new TrueGate();	
		return instance;
	}
	//Overriding the abstract method to return True
	@Override
	protected boolean func(boolean[] inValues) {
		return true;
	}
	//Overriding the abstract method to return the name of the Gate
	@Override
	public String getName() {
		return "T";
	}

//nothing to complicated with this gate so it only returns an instance of itself
	@Override
	public Gate simplify() {
		return instance;
	}

}
