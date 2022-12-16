package circuits;
//Class that will be a not gate has only one input
public class NotGate extends Gate {
// Constructor for the gate
	public NotGate(Gate in)
	{
		super(new Gate[]{in});
	}
	//Method to return the NOT value of an input
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return !inValues[0];
	}
//method to return name
	@Override
	public String getName() {
		return "NOT";
	}
//method to simplify the gate
	@Override
	public Gate simplify() {
		if(inGates[0].simplify() == TrueGate.instance())
			return FalseGate.instance();
		else if(inGates[0].simplify() == FalseGate.instance())
			return TrueGate.instance();
		else if(inGates[0] instanceof NotGate)
			return inGates[0].inGates[0];
		return this;
	}

}
