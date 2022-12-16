package circuits;

//Class that is an AND gate can have more than two inputs
public class AndGate extends Gate {

	public AndGate(Gate[] inGates) {
		super(inGates);
	}

	// method to calculate the gate output
	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		boolean result = true;
		for (int i = 0; i < inValues.length; i++)
			result = result && inValues[i];
		return result;
	}

//method to get name
	@Override
	public String getName() {
		return "AND";
	}

//method to simplify the gate
	@Override
	public Gate simplify() {
		int gateCount = 0;
		for (int i = 0; i < inGates.length; i++) {// If one gate is False
			if (inGates[i] == FalseGate.instance())
				return FalseGate.instance();
		}
		for (int i = 0; i < inGates.length; i++) {// counting how many are not true
			if (inGates[i].simplify() != TrueGate.instance())
				gateCount++;
		}
		if (gateCount == 1) {// One child left
			for (int i = 0; i < inGates.length; i++) {
				if (inGates[i].simplify() != TrueGate.instance())
					return inGates[i].simplify();
			}
		} else if (gateCount == 0) // All gates are true
			return TrueGate.instance();
		else {
			int index = 0;
			Gate[] newGates = new Gate[gateCount];
			for (int i = 0; i < inGates.length; i++) {
				if (inGates[i].simplify() != TrueGate.instance()) {
					newGates[index] = inGates[i].simplify();
					index++;
				}
			}
			return new AndGate(newGates);
		}
		return null;
	}

}
