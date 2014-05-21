package com.airesearch.jcluster.server.procnode;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICompute extends Remote {
	public Object executeTask(ITask t) throws RemoteException;
	public Object connect(String adr) throws RemoteException;
}
