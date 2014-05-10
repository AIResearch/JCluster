package com.airesearch.jcluster.server.transport;

import java.util.ArrayList;

public class TaskDispatcher {
	private ArrayList<TaskData> subsets = new ArrayList<TaskData>();
	
	public void divideOntoSubsets(TaskData set, int resoursesCount) {
		
	}
	
	public int getCountOfElements() {
		return subsets.size();
	}
	
	public void getSubsetByIndex(int index) {
		this.subsets.get(index);
	}
}