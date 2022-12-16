package tasks;

public class Tasks {
	private int num;
	private boolean[][] depMat;
	//constructor to initialize task number and create a dependency matrix
	public Tasks(int num) {
		this.num = num;
		depMat = new boolean[num][num];
	}
	//adding a dependency to the dependency matrix
	public boolean dependsOn(int task1, int task2) {
			if(task1 > num || task2 > num)
				return false;
		depMat[task1][task2] = true;
		return true;
	}
//orders the task in consideration of the dependency of the tasks
// finding all the permutations and checking if any of them meet the dependency requirement
	public int[] order() {
		int [] orderTask = new int[num];
		for(int i = 0;i<num;i++)
			orderTask[i] = i;
		do {
		//	System.out.println(Arrays.toString(orderTask));
			if(legalOrder(orderTask))
				return orderTask;
		}while(nextPermutation.findNextPermutation(orderTask));
		return null;
	}
	//checks if the tasks meet the dependency requirements
	private boolean legalOrder(int[] orderTask) {
		int i,j;
		for(i=0;i<num;i++) {
			for(j=i+1;j<num;j++) {
				if(depMat[orderTask[i]][orderTask[j]])
					return false;
			}
		}
		return true;
	}
	
	
	
}
