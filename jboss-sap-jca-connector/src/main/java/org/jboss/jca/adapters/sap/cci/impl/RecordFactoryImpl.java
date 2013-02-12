/**
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
 * 
 */
package org.jboss.jca.adapters.sap.cci.impl;

import static org.jboss.jca.adapters.sap.cci.CciPackage.JBOSS_SAP_URI_PREFIX;

import javax.resource.ResourceException;
import javax.resource.cci.Record;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.MappedRecord;
import org.jboss.jca.adapters.sap.cci.RecordFactory;

import com.sap.conn.jco.JCoRepository;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Record Factory</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RecordFactoryImpl extends EObjectImpl implements RecordFactory {
	/**
	 * @generated NOT
	 */
	private JCoRepository repository;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RecordFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CciPackageImpl.Literals.RECORD_FACTORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public MappedRecord createMappedRecord(String recordName) throws ResourceException {

		EObject eObject = createRecord(recordName);
		if (eObject == null || !CciPackageImpl.eINSTANCE.getCCIMappedRecord().isInstance(eObject))
			return null;

		return (MappedRecord) eObject;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IndexedRecord createIndexedRecord(String recordName) throws ResourceException {
		EObject eObject = createRecord(recordName);
		if (eObject == null || !CciPackageImpl.eINSTANCE.getCCIIndexedRecord().isInstance(eObject))
			return null;

		return (IndexedRecord) eObject;
	}

	private CciPackageRegistryImpl registry;

	/**
	 * {@inheritDoc}
	 *  
	 * @generated NOT
	 */
	public EPackage.Registry getPackageRegistry() throws ResourceException {
		if (repository == null)
			throw ExceptionBundle.EXCEPTIONS.failedToAccessMetaDataRepository();

		if (registry == null) {
			registry = new CciPackageRegistryImpl(repository);
		}
		return registry;
	}

	/**
	 * @generated NOT
	 */
	public JCoRepository getRepository() {
		return repository;
	}

	/**
	 * @generated NOT
	 */
	public void setRepository(JCoRepository repository) {
		this.repository = repository;
	}

	/**
	 * @generated NOT
	 */
	protected EObject createRecord(String recordName) throws ResourceException {

		/* Parse out function module name from record name */
		int index = recordName.lastIndexOf(".");
		if (index == -1)
			/* No function module name prefix so can't lookup package */
			return null;
		String functionModuleName = recordName.substring(0, index);
		recordName = recordName.substring(index + 1, recordName.length());

		String nsURI = JBOSS_SAP_URI_PREFIX  + repository.getName() + "/" + functionModuleName;
		EPackage ePackage = getPackageRegistry().getEPackage(nsURI);
		EClassifier eClassifier = ePackage.getEClassifier(recordName);
		if (!(eClassifier instanceof EClass))
			return null;

		EClass eClass = (EClass) eClassifier;
		EObject eObject = ePackage.getEFactoryInstance().create(eClass);
		if (!(eObject instanceof Record))
			return null;

		Record record = (Record) eObject;
		record.setRecordName(recordName);

		return eObject;

	}


} // RecordFactoryImpl
