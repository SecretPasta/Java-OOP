package iterator;

public class Fibonacci implements MyIterator {
	//class to print fibonacci sequence 
	private int upperbound;
	private int f1, f2, res, flag = 0;
//Constructor to initialize the class
	public Fibonacci(int upperbound) {
		this.upperbound = upperbound;
		this.f1 = 0;
		this.f2 = 1;
	}
//using the Interface to check if upperbound was reached
	@Override
	public boolean hasNext() {
		if ((f1 + f2) > upperbound)
			return false;
		return true;
	}
//using the interface method to return the next value of the sequance
	@Override
	public int next() {
		if (hasNext()) {
			if (flag == 0) {
				flag = 1;
				return 1;
			}
			res = f1 + f2;
			f1 = f2;
			f2 = res;
		}
		return res;
	}

}
