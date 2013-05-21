/**
 */
package org.jboss.jca.adapters.sap.model.spi;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Connection Request Info Store</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStore#getConnectionRequestInfos <em>Connection Request Infos</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getConnectionRequestInfoStore()
 * @model
 * @generated
 */
public interface ConnectionRequestInfoStore extends EObject {

	/**
	 * Returns the value of the '<em><b>Connection Request Infos</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connection Request Infos</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection Request Infos</em>' map.
	 * @see org.jboss.jca.adapters.sap.model.spi.SpiPackage#getConnectionRequestInfoStore_ConnectionRequestInfos()
	 * @model mapType="org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfoStoreEntry<org.eclipse.emf.ecore.EString, org.jboss.jca.adapters.sap.model.spi.ConnectionRequestInfo>"
	 * @generated
	 */
	EMap<String, ConnectionRequestInfo> getConnectionRequestInfos();
} // ConnectionRequestInfoStore
