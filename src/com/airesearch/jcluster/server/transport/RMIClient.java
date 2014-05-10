package com.airesearch.jcluster.server.transport;

import java.rmi.Naming;

/**
 This class implements the client part of RMI client-server technology
 is used by Transport class.
 */
public class RMIClient extends RMITransport {

	private String RMIName = "";

	public String getRMIName() {
		return RMIName;
	}

	public void setRMIName(String rMIName) {
		RMIName = rMIName;
	}

	public RMIClient() {
		super();
	}
	
	/**
	 This method used for returning the Compute object
	 */
	public ICompute getCompute() {
		ICompute compute = null;
		try {
			compute = (ICompute) Naming.lookup(this.RMIName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compute;
	}

}
