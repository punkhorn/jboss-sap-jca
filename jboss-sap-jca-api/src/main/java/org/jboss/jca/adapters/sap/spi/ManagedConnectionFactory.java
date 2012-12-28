package org.jboss.jca.adapters.sap.spi;

import javax.resource.spi.ResourceAdapterAssociation;

import org.jboss.jca.adapters.sap.cci.ConnectionSpec;

public interface ManagedConnectionFactory extends
		javax.resource.spi.ManagedConnectionFactory, ResourceAdapterAssociation {
	
	public ConnectionRequestInfo convertConnectionSpecToConnectionRequestInfo(ConnectionSpec connectionSpec);
	public ConnectionSpec convertConnectionRequestInfoToConnectionSpec(ConnectionRequestInfo connectionRequestInfo);

}
