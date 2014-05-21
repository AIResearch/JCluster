package com.airesearch.jcluster.server.procnode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;

public class ComputingNode {

	private JFrame frame;
	private JTextField dispNodeIPField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComputingNode window = new ComputingNode();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ComputingNode() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 157);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		dispNodeIPField = new JTextField();
		dispNodeIPField.setBounds(10, 43, 414, 20);
		frame.getContentPane().add(dispNodeIPField);
		dispNodeIPField.setColumns(10);

		JLabel lblDispatchingNodeIp = new JLabel("Dispatching node IP");
		lblDispatchingNodeIp.setBounds(10, 18, 134, 14);
		frame.getContentPane().add(lblDispatchingNodeIp);

		JButton btnConnect = new JButton("Connect");
		btnConnect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnConnectMouseClisked(arg0);
			}
		});
		btnConnect.setBounds(10, 74, 89, 23);
		frame.getContentPane().add(btnConnect);
	}

	protected void btnConnectMouseClisked(MouseEvent arg0) {
		String name = "";
		if (dispNodeIPField.getText().equals("")) {
			name = "rmi://localhost/EngineService";
		} else {
			name = "rmi://" + dispNodeIPField.getText() + "/ConnectService";
		}

		String port = null;
		ICompute engine;
		try {
			engine = (ICompute) Naming.lookup(name);
			port = engine.connect(InetAddress.getLocalHost().toString())
					.toString();
		} catch (Exception e) {
			System.err.println("ComputeEngine exception: " + e.getMessage());
			e.printStackTrace();
		}
		System.setProperty("java.security.policy", "rmi.policy");
		name = "rmi://localhost:" + port + "/EngineService";
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}
		try {
			LocateRegistry.createRegistry(Integer.valueOf(port.toString()));
			engine = new Compute();
			Naming.rebind(name, engine);
			System.out.println("Compute Engine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
