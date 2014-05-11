package com.airesearch.jcluster.server.transport;

import java.util.ArrayList;

/**
 This class used like a wrap for saving task data.
 */
public class TaskData {
	private ArrayList<Object> data = new ArrayList<Object>();
	
	public TaskData() {
		super();
	}
	
	/**
	 This method used for returning count of the elements of the set of data.
	 */
	public int getCountOfElements() {
		return data.size();
	}
	
	/**
	 This method allows to add new element to the set of data.
	 */
	public void addElement(Object data) {
		this.data.add(data);
	}
	
	/**
	 This method used for full clearing set of data.
	 */
	public void clearTaskData() {
		this.data.clear();
	}
	
	/**
	 This method allows to get access to the required element by its index.
	 */
	public Object getElementByIndex(int index) {
		return this.data.get(index);
	}
}
