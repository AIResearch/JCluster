package com.airesearch.jcluster.server.transport;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

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
	
	public ICompute getCompute() {
		ICompute compute = null;
		try {
			compute = (ICompute) Naming.lookup(this.RMIName);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		return compute;
	}

}
