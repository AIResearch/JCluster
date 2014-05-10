package com.airesearch.jcluster.server.transport;

import java.util.ArrayList;

public class TaskData {
	private ArrayList<Object> data = new ArrayList<Object>();

	public int getCountOfElements() {
		return data.size();
	}
	
	public void addElement(Object data) {
		this.data.add(data);
	}
	
	public void clearTaskData() {
		this.data.clear();
	}
	
	public Object getElementByIndex(int index) {
		return this.data.get(index);
	}
}
