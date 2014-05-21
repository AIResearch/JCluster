package com.airesearch.jcluster.server.procnode;

import java.io.Serializable;

public interface ITask extends Serializable {
	Object execute();
}
