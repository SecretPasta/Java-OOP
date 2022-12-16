package circuits;

//Class that is an Or gate can have more than two inputs
public class OrGate extends Gate {

	public OrGate(Gate[] inGates) {
		super(inGates);
	}

	// method to calculate the gate output
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException{
		boolean result = false;
		for (int i = 0; i < inValues.length; i++)
			result = result || inValues[i];

		return result;
	}

	// method to get name
	@Override
	public String getName() {
		return "OR";
	}

	// method to simplify the gate
	@Override
	public Gate simplify() {
		int gateCount = 0;
		for (int i = 0; i < inGates.length; i++) {// If one gate is True
			if (inGates[i] == TrueGate.instance())
				return TrueGate.instance();
		}
		for (int i = 0; i < inGates.length; i++) {// counting how many are not false
			if (inGates[i].simplify() != FalseGate.instance())
				gateCount++;
		}
		if (gateCount == 1) {// One child left
			for (int i = 0; i < inGates.length; i++) {
				if (inGates[i].simplify() != FalseGate.instance())
					return inGates[i].simplify();
			}
		} else if (gateCount == 0) // All gates are false
			return FalseGate.instance();
		else {
			int index = 0;
			Gate[] newGates = new Gate[gateCount];
			for (int i = 0; i < inGates.length; i++) {
				if (inGates[i].simplify() != FalseGate.instance()) {
					newGates[index] = inGates[i].simplify();
					index++;
				}
			}
			return new OrGate(newGates);
		}
		return null;
	}

}
