package tasks;

public class NamedTasks extends Tasks{
	private String[] names;
	//constructor to get names of tasks
	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
	}
	//adding dependency to the dependency matrix
	public boolean dependsOn(String task1,String task2) {
		int index1 = -1,index2 = -1;
		for(int i = 0;i<names.length;i++) {
			if(names[i] == task1)
				index1= i;
			if(names[i] == task2)
				index2 = i;
		}
		if(index1 == -1 || index2 == -1)
			return false;
		
		return super.dependsOn(index1, index2);
		
		
	}
//orders the tasks using the method for Tasks
	public String[] nameOrder() {
		int[] numarray = super.order();
		String[] orderName = new String[names.length];
		if(numarray == null)
			return null;
		for(int i=0;i<names.length;i++) {
			orderName[i] = names[numarray[i]];
		}
		return orderName;
	}
	
}
