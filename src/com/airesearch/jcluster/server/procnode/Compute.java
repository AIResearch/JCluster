package com.airesearch.jcluster.server.procnode;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class Compute extends UnicastRemoteObject implements ICompute {

	private static final long serialVersionUID = -5613552362616510376L;
	private static final int DEFAULT_PORT = 1099;
	private Vector<String> servers = null;
	private int ports;

	public Compute() throws RemoteException {
		super();
		servers = new Vector<String>();
		ports = DEFAULT_PORT;
	}

	@Override
	public Object executeTask(ITask t) throws RemoteException {
		return t.execute();
	}

	@Override
	public Object connect(String adr) throws RemoteException {
		String st = adr.substring(0, adr.indexOf("/"));
		if (servers.size() != 0)
			for (int i = 0; i < servers.size(); i++) {
				if (servers.elementAt(i).equals(st))
					return ports;
			}
		servers.addElement(adr.substring(0, adr.indexOf("/")));
		servers.addElement(adr.substring(adr.indexOf("/") + 1, adr.length()));
		return ++ports;
	}

	public Vector<String> getServers() {
		return servers;
	}

}
