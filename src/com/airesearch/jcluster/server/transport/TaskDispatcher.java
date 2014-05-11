package com.airesearch.jcluster.server.transport;

import java.util.ArrayList;

/**
 This class used for distributing TaskData set onto subsets.
 */
public class TaskDispatcher {
	private ArrayList<TaskData> subsets = new ArrayList<TaskData>();
	
	public TaskDispatcher() {
		super();
	}
	
	/* WARNING! METHOD BELOW REQUIRED ADDITIONAL TEST BECAUSE ONLY SOME PARTS OF ITS HAD BEEN TESTED */
	
	/** 
	 This method used for division TaskData set onto subsets.
	 */
	public void divideOntoSubsets(TaskData set, int resoursesCount) {
		/* Next expression is used for computing chunk size (portion of the processing elements per one resource) */
		int chunk = (int) (Math.ceil(set.getCountOfElements() / (double) resoursesCount)); 
		int countOfProcessedElements = 0;
		/* Next for operator is used for creating subsets for all resources */
		for (int i = 0; i < resoursesCount; i++) {
			TaskData taskData = new TaskData();
			/* High limit of the range is used for the next iteration. Low limit is value of countOfProcessedElements variable.
			   Therefore we have processing window. Range of it is highLimit - countOfProcessedElements = chunk value */
			int highLimit;
			/* Next if operator used for moving high limit of the window range */
			if (set.getCountOfElements() - countOfProcessedElements < chunk * 2)
				highLimit = set.getCountOfElements(); // used when residue of the unprocessed elements of the set is less then chunk size
			else
				highLimit = chunk + countOfProcessedElements; // used when residue of the unprocessed elements of the set is greater then chunk size
			/* Next for operator is used for moving elements from the set into required subset */
			for (int j = countOfProcessedElements; countOfProcessedElements < highLimit; j++) {
				taskData.addElement(set.getElementByIndex(j));
			}
			subsets.add(taskData);
			/* Next expression used for moving low limit of the window range */
			countOfProcessedElements = highLimit;
		}
	}
	
	/**
	 This method allows to get subsets count.
	 */
	public int getCountOfElements() {
		return subsets.size();
	}
	
	/**
	 This method allows to get access to the required subset by its index.
	 */
	public void getSubsetByIndex(int index) {
		this.subsets.get(index);
	}
}