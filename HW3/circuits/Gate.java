package circuits;

// abstract class that all other classes will inherit from and override
//the abstract methods
public abstract class Gate {

	protected Gate[] inGates;

//Constructor to initialize class
	public Gate(Gate[] inGates) {
		this.inGates = inGates;
	}

//Method to calculate the boolean value of the gate if it cannot do so
// it will throw an exception, func depends on the gate
	public boolean calc() throws CircuitException {
		boolean[] GateVal = null;
		if (inGates != null) {
			GateVal = new boolean[inGates.length];
			for (int i = 0; i < inGates.length; i++) {
				if (inGates[i] == null)
					throw new CircuitException("Gate number " + i + 1 + "no value!");
				GateVal[i] = inGates[i].calc();
			}
		}
		return func(GateVal);
	}

//Abstract methods to be overridden by other classes
	// method to what the gate is supposed to calculate based on the inputs
	protected abstract boolean func(boolean[] inValues) throws CircuitException;

//method to get name
	public abstract String getName();

//returns the gate after simplification
	public abstract Gate simplify();

//Method to create a formated string
	public String toString() {
		StringBuilder s = new StringBuilder(getName());
		if (inGates != null) {
			s.append("[");
			for (int i = 0; i < inGates.length - 1; i++) {
				s.append(inGates[i].toString());
				s.append(", ");
			}
			s.append(inGates[inGates.length - 1].toString());
			s.append("]");
		}
		return s.toString();
	}
}
