/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Record;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Record</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordImpl#getRecordName <em>Record Name</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.RecordImpl#getRecordDescription <em>Record Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RecordImpl extends EObjectImpl implements Record {
	/**
	 * The default value of the '{@link #getRecordName() <em>Record Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordName()
	 * @generated
	 * @ordered
	 */
	protected static final String RECORD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecordName() <em>Record Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordName()
	 * @generated
	 * @ordered
	 */
	protected String recordName = RECORD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getRecordDescription() <em>Record Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String RECORD_DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRecordDescription() <em>Record Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRecordDescription()
	 * @generated
	 * @ordered
	 */
	protected String recordDescription = RECORD_DESCRIPTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.RECORD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordName() {
		return recordName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordName(String newRecordName) {
		String oldRecordName = recordName;
		recordName = newRecordName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.RECORD__RECORD_NAME, oldRecordName, recordName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getRecordDescription() {
		return recordDescription;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRecordDescription(String newRecordDescription) {
		String oldRecordDescription = recordDescription;
		recordDescription = newRecordDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.RECORD__RECORD_DESCRIPTION, oldRecordDescription, recordDescription));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackage.RECORD__RECORD_NAME:
				return getRecordName();
			case CciPackage.RECORD__RECORD_DESCRIPTION:
				return getRecordDescription();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CciPackage.RECORD__RECORD_NAME:
				setRecordName((String)newValue);
				return;
			case CciPackage.RECORD__RECORD_DESCRIPTION:
				setRecordDescription((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CciPackage.RECORD__RECORD_NAME:
				setRecordName(RECORD_NAME_EDEFAULT);
				return;
			case CciPackage.RECORD__RECORD_DESCRIPTION:
				setRecordDescription(RECORD_DESCRIPTION_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CciPackage.RECORD__RECORD_NAME:
				return RECORD_NAME_EDEFAULT == null ? recordName != null : !RECORD_NAME_EDEFAULT.equals(recordName);
			case CciPackage.RECORD__RECORD_DESCRIPTION:
				return RECORD_DESCRIPTION_EDEFAULT == null ? recordDescription != null : !RECORD_DESCRIPTION_EDEFAULT.equals(recordDescription);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (recordName: ");
		result.append(recordName);
		result.append(", recordDescription: ");
		result.append(recordDescription);
		result.append(')');
		return result.toString();
	}

} //RecordImpl
