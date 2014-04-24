package com.airesearch.jcluster.server.transport;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMICompute extends UnicastRemoteObject implements ICompute {

	private static final long serialVersionUID = 6410533976351266908L;

	protected RMICompute() throws RemoteException {
		super();
	}
	
}
