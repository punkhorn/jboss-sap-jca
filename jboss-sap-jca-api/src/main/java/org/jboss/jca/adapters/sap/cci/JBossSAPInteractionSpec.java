/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.jca.adapters.sap.cci;

import javax.resource.cci.InteractionSpec;

/**
 * Implements the {@link InteractionSpec } interface for the JBoss SAP JCA Connector.
 * 
 * @author William Collins
 *
 * @version $Id: $
 */
public class JBossSAPInteractionSpec implements InteractionSpec {

	private static final long serialVersionUID = -5280290826397929911L;
	
	private String functionName;
	
	private int interactionVerb = SYNC_SEND_RECEIVE;
	
	private int executionTimeout;

	/**
	 * FunctionName: name of ABAP function
	 * 
	 * @return Function Name
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * Sets FunctionName: name of ABAP function
	 * 
	 * @param functionName - the function name
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * InteractionVerb: mode of interaction with an EIS instance: SYNC_SEND, SYNC_SEND_RECEIVE, SYNC_RECEIVE 
	 * 
	 * <p>NB: currently not used.
	 *  
	 * @return InteractionVerb
	 */
	public int getInteractionVerb() {
		return interactionVerb;
	}

	/**
	 * Sets InteractionVerb: mode of interaction with an EIS instance: SYNC_SEND, SYNC_SEND_RECEIVE, SYNC_RECEIVE 
	 * 
	 * <p>NB: currently not used.
	 *  
	 * @param interactionVerb - the interaction verb
	 */
	public void setInteractionVerb(int interactionVerb) {
		switch (interactionVerb) {
		case SYNC_RECEIVE:
			this.interactionVerb = SYNC_RECEIVE;
			return;
		case SYNC_SEND:
			this.interactionVerb = SYNC_SEND;
			return;
		case SYNC_SEND_RECEIVE:
		default:
			this.interactionVerb = SYNC_SEND_RECEIVE;
			return;
		}
	}

	/**
	 * ExecutionTimeout: the number of milliseconds an Interaction will wait for an EIS to execute the specified function
	 * 
	 * <p>NB: currently not used.
	 *  
	 * @return ExecutionTimeout
	 */
	public int getExecutionTimeout() {
		return executionTimeout;
	}

	/**
	 * Sets ExecutionTimeout: the number of milliseconds an Interaction will wait for an EIS to execute the specified function
	 *  
	 * <p>NB: currently not used.
	 *  
	 * @param executionTimeout - the execution timeout
	 */
	public void setExecutionTimeout(int executionTimeout) {
		this.executionTimeout = executionTimeout;
	}

}
