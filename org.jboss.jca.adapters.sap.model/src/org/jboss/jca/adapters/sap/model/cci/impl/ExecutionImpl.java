/**
 */
package org.jboss.jca.adapters.sap.model.cci.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.jboss.jca.adapters.sap.model.cci.CciPackage;
import org.jboss.jca.adapters.sap.model.cci.Execution;
import org.jboss.jca.adapters.sap.model.cci.InteractionSpec;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl#getInteractionSpec <em>Interaction Spec</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl#getInputRecord <em>Input Record</em>}</li>
 *   <li>{@link org.jboss.jca.adapters.sap.model.cci.impl.ExecutionImpl#getOutputRecord <em>Output Record</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionImpl extends EObjectImpl implements Execution {
	/**
	 * The cached value of the '{@link #getInteractionSpec() <em>Interaction Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInteractionSpec()
	 * @generated
	 * @ordered
	 */
	protected InteractionSpec interactionSpec;

	/**
	 * The cached value of the '{@link #getInputRecord() <em>Input Record</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInputRecord()
	 * @generated
	 * @ordered
	 */
	protected MappedRecord inputRecord;

	/**
	 * The cached value of the '{@link #getOutputRecord() <em>Output Record</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutputRecord()
	 * @generated
	 * @ordered
	 */
	protected MappedRecord outputRecord;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackage.Literals.EXECUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionSpec getInteractionSpec() {
		if (interactionSpec != null && interactionSpec.eIsProxy()) {
			InternalEObject oldInteractionSpec = (InternalEObject)interactionSpec;
			interactionSpec = (InteractionSpec)eResolveProxy(oldInteractionSpec);
			if (interactionSpec != oldInteractionSpec) {
				InternalEObject newInteractionSpec = (InternalEObject)interactionSpec;
				NotificationChain msgs = oldInteractionSpec.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CciPackage.EXECUTION__INTERACTION_SPEC, null, null);
				if (newInteractionSpec.eInternalContainer() == null) {
					msgs = newInteractionSpec.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CciPackage.EXECUTION__INTERACTION_SPEC, null, msgs);
				}
				if (msgs != null) msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CciPackage.EXECUTION__INTERACTION_SPEC, oldInteractionSpec, interactionSpec));
			}
		}
		return interactionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionSpec basicGetInteractionSpec() {
		return interactionSpec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInteractionSpec(InteractionSpec newInteractionSpec, NotificationChain msgs) {
		InteractionSpec oldInteractionSpec = interactionSpec;
		interactionSpec = newInteractionSpec;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CciPackage.EXECUTION__INTERACTION_SPEC, oldInteractionSpec, newInteractionSpec);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInteractionSpec(InteractionSpec newInteractionSpec) {
		if (newInteractionSpec != interactionSpec) {
			NotificationChain msgs = null;
			if (interactionSpec != null)
				msgs = ((InternalEObject)interactionSpec).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CciPackage.EXECUTION__INTERACTION_SPEC, null, msgs);
			if (newInteractionSpec != null)
				msgs = ((InternalEObject)newInteractionSpec).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CciPackage.EXECUTION__INTERACTION_SPEC, null, msgs);
			msgs = basicSetInteractionSpec(newInteractionSpec, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.EXECUTION__INTERACTION_SPEC, newInteractionSpec, newInteractionSpec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedRecord getInputRecord() {
		if (inputRecord != null && inputRecord.eIsProxy()) {
			InternalEObject oldInputRecord = (InternalEObject)inputRecord;
			inputRecord = (MappedRecord)eResolveProxy(oldInputRecord);
			if (inputRecord != oldInputRecord) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CciPackage.EXECUTION__INPUT_RECORD, oldInputRecord, inputRecord));
			}
		}
		return inputRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedRecord basicGetInputRecord() {
		return inputRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInputRecord(MappedRecord newInputRecord) {
		MappedRecord oldInputRecord = inputRecord;
		inputRecord = newInputRecord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.EXECUTION__INPUT_RECORD, oldInputRecord, inputRecord));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedRecord getOutputRecord() {
		if (outputRecord != null && outputRecord.eIsProxy()) {
			InternalEObject oldOutputRecord = (InternalEObject)outputRecord;
			outputRecord = (MappedRecord)eResolveProxy(oldOutputRecord);
			if (outputRecord != oldOutputRecord) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CciPackage.EXECUTION__OUTPUT_RECORD, oldOutputRecord, outputRecord));
			}
		}
		return outputRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MappedRecord basicGetOutputRecord() {
		return outputRecord;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutputRecord(MappedRecord newOutputRecord) {
		MappedRecord oldOutputRecord = outputRecord;
		outputRecord = newOutputRecord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CciPackage.EXECUTION__OUTPUT_RECORD, oldOutputRecord, outputRecord));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CciPackage.EXECUTION__INTERACTION_SPEC:
				return basicSetInteractionSpec(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CciPackage.EXECUTION__INTERACTION_SPEC:
				if (resolve) return getInteractionSpec();
				return basicGetInteractionSpec();
			case CciPackage.EXECUTION__INPUT_RECORD:
				if (resolve) return getInputRecord();
				return basicGetInputRecord();
			case CciPackage.EXECUTION__OUTPUT_RECORD:
				if (resolve) return getOutputRecord();
				return basicGetOutputRecord();
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
			case CciPackage.EXECUTION__INTERACTION_SPEC:
				setInteractionSpec((InteractionSpec)newValue);
				return;
			case CciPackage.EXECUTION__INPUT_RECORD:
				setInputRecord((MappedRecord)newValue);
				return;
			case CciPackage.EXECUTION__OUTPUT_RECORD:
				setOutputRecord((MappedRecord)newValue);
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
			case CciPackage.EXECUTION__INTERACTION_SPEC:
				setInteractionSpec((InteractionSpec)null);
				return;
			case CciPackage.EXECUTION__INPUT_RECORD:
				setInputRecord((MappedRecord)null);
				return;
			case CciPackage.EXECUTION__OUTPUT_RECORD:
				setOutputRecord((MappedRecord)null);
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
			case CciPackage.EXECUTION__INTERACTION_SPEC:
				return interactionSpec != null;
			case CciPackage.EXECUTION__INPUT_RECORD:
				return inputRecord != null;
			case CciPackage.EXECUTION__OUTPUT_RECORD:
				return outputRecord != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionImpl
