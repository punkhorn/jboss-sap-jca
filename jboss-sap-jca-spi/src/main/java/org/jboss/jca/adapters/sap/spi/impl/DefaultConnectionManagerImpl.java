package org.jboss.jca.adapters.sap.spi.impl;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;

public class DefaultConnectionManagerImpl implements ConnectionManager {

	private static final long serialVersionUID = 8887310801431410521L;

	@Override
	public Object allocateConnection(ManagedConnectionFactory mcf,
			ConnectionRequestInfo cxRequestInfo) throws ResourceException {
		ManagedConnection mc = mcf.createManagedConnection(null, cxRequestInfo);
		Connection connection = (Connection) mc.getConnection(null, null);
		return connection;
	}

}
