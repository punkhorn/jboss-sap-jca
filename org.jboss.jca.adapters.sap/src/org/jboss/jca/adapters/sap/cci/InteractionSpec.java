package org.jboss.jca.adapters.sap.cci;

public interface InteractionSpec extends javax.resource.cci.InteractionSpec {
	/**
	 * Returns a string representing the name of an ABAP Function Module.
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @model
	 */
	String getFunctionName();

	/**
	 * Sets a string representing the name of an ABAP Function Module.
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 */
	void setFunctionName(String value);

	/**
	 * Returns an integer representing the mode of interaction with an EIS instance as specified by the InteractionSpec.
	 * The values of the interaction verb may be one of the following: SYNC_SEND, SYNC_SEND_RECEIVE, SYNC_RECEIVE
	 * <p>
	 * NB: currently not used.
	 * @return the value of the '<em>Interaction Verb</em>' attribute.
	 * @see #setInteractionVerb(int)
	 */
	int getInteractionVerb();

	/**
	 * Sets an integer representing the mode of interaction with an EIS instance as specified by the InteractionSpec.
	 * The values of the interaction verb may be one of the following: SYNC_SEND, SYNC_SEND_RECEIVE, SYNC_RECEIVE
	 * <p>
	 * NB: currently not used.
	 * @param value the new value of the '<em>Interaction Verb</em>' attribute.
	 * @see #getInteractionVerb()
	 */
	void setInteractionVerb(int value);

	/**
	 * Returns an integer representing the number of milliseconds an {@link Interaction} waits for an EIS to execute the specified function.
	 * <p>
	 * NB: currently not used.
	 * @return the value of the '<em>Execution Timeout</em>' attribute.
	 * @see #setExecutionTimeout(int)
	 */
	int getExecutionTimeout();

	/**
	 * Sets an integer representing the number of milliseconds an {@link Interaction} waits for an EIS to execute the specified function.
	 * <p>NB: currently not used.
	 * @param value the new value of the '<em>Execution Timeout</em>' attribute.
	 * @see #getExecutionTimeout()
	 */
	void setExecutionTimeout(int value);


}
