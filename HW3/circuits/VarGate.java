package circuits;
//Class that describes a gate input variable
public class VarGate extends Gate{
	
	private String name;
	private boolean val,setFlag = false;
	
	
	//Constructor to initialize the Class
	public VarGate(String name) {
		super(null);
		this.name = name;
	}
//method to return val if it has been set otherwise throws an exception
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException{
		if(setFlag)
			return val;
		throw new CircuitException(name);
	}
//method to return name of the gate
	@Override
	public String getName() {
		return "V"+name;
	}
	//method to set the gate value
	public void setVal(boolean value) {
		setFlag = true;
		val = value;
	}
	
//method to simplify the gate
	@Override
	public Gate simplify() {
		if(setFlag)
			return val? TrueGate.instance():FalseGate.instance();
		return this;
	}

}
