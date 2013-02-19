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

import static org.jboss.jca.adapters.sap.cci.CciPackage.*;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.jboss.jca.adapters.sap.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.cci.MappedRecord;

import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoRecordMetaData;
import com.sap.conn.jco.JCoRepository;

/**
 * Package Registry for JBoss SAP JCA Connector
 * 
 * This class dynamically creates Ecore package definitions on demand which
 * describes the data structures required to invoke a specific remote function
 * module. An Ecore package is created on demand for each remote function module
 * defined in a connected SAP instance.
 * 
 * @author William Collins
 * 
 */
public class CciPackageRegistryImpl implements Registry {

	private static final String GenNS_URI = "http://www.eclipse.org/emf/2002/GenModel";

	private static final String GenNS_DOCUMENTATION_KEY = "documentation";

	/**
	 * The {@link JCoRepository} providing the source of package meta-data.
	 */
	private JCoRepository repository;
	
	/**
	 * Construct a {@link Registry} using the given {@link JCoRepository} to create required packages on demand.
	 * 
	 * @param repository - the {@link JCoRepository} used to provide package meta-data.
	 */
	public CciPackageRegistryImpl(JCoRepository repository) {
		this.repository = repository;
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return EPackage.Registry.INSTANCE.size();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		return EPackage.Registry.INSTANCE.isEmpty();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsKey(Object key) {
		return EPackage.Registry.INSTANCE.containsKey(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean containsValue(Object value) {
		return EPackage.Registry.INSTANCE.containsValue(value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object get(Object key) {
		return EPackage.Registry.INSTANCE.get(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object put(String key, Object value) {
		return EPackage.Registry.INSTANCE.put(key, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object remove(Object key) {
		return EPackage.Registry.INSTANCE.remove(key);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void putAll(Map<? extends String, ? extends Object> m) {
		EPackage.Registry.INSTANCE.putAll(m);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clear() {
		EPackage.Registry.INSTANCE.clear();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> keySet() {
		return EPackage.Registry.INSTANCE.keySet();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Object> values() {
		return EPackage.Registry.INSTANCE.values();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<java.util.Map.Entry<String, Object>> entrySet() {
		return EPackage.Registry.INSTANCE.entrySet();
	}

	@Override
	public EPackage getEPackage(String nsURI) {
		EPackage ePackage = (EPackage) EPackage.Registry.INSTANCE.get(nsURI);
		if (ePackage == null && nsURI.startsWith(JBOSS_SAP_URI_PREFIX + repository.getName())) {
			int prefixLength = JBOSS_SAP_URI_PREFIX.length() + repository.getName().length() + 1; // Length of "http://sap.adapters.jca.jboss.org/<repo-name>/" prefix.
			String functionModuleName = nsURI.substring(prefixLength);
			EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
			JCoFunctionTemplate functionTemplate;
			try {
				functionTemplate = repository.getFunctionTemplate(functionModuleName);
			} catch (JCoException e) {
				return null;
			}
			JCoListMetaData importParameterListMetaData = functionTemplate.getImportParameterList();
			JCoListMetaData changingParameterListMetaData = functionTemplate.getChangingParameterList();
			JCoListMetaData tableParameterListMetaData = functionTemplate.getTableParameterList();
			JCoListMetaData exportParameterListMetaData = functionTemplate.getExportParameterList();

			// Create and initialize package
			ePackage = ecoreFactory.createEPackage();
			ePackage.setName(functionModuleName);
			ePackage.setNsPrefix(functionModuleName);
			ePackage.setNsURI(nsURI);
			
			// Create Input Record Class
			EClass inputRecordClass = ecoreFactory.createEClass();
			ePackage.getEClassifiers().add(inputRecordClass);
			inputRecordClass.setName("INPUT_RECORD");
			inputRecordClass.getESuperTypes().add(CciPackageImpl.eINSTANCE.getMappedRecord());
			addListMetaData(inputRecordClass, importParameterListMetaData);
			addListMetaData(inputRecordClass, changingParameterListMetaData);
			addListMetaData(inputRecordClass, tableParameterListMetaData);
			addAnnotation(inputRecordClass, GenNS_URI, GenNS_DOCUMENTATION_KEY, "Input Record for "
					+ functionModuleName);

			// Create Output Record
			EClass outputRecordClass = ecoreFactory.createEClass();
			ePackage.getEClassifiers().add(outputRecordClass);
			outputRecordClass.setName("OUTPUT_RECORD");
			outputRecordClass.getESuperTypes().add(CciPackageImpl.eINSTANCE.getMappedRecord());
			addListMetaData(outputRecordClass, exportParameterListMetaData);
			addListMetaData(outputRecordClass, changingParameterListMetaData);
			addListMetaData(outputRecordClass, tableParameterListMetaData);
			addAnnotation(outputRecordClass, GenNS_URI, GenNS_DOCUMENTATION_KEY, "Output Record for "
					+ functionModuleName);

			// Register Package
			EPackage.Registry.INSTANCE.put(nsURI, ePackage);
		}
		return ePackage;
	}

	@Override
	public EFactory getEFactory(String nsURI) {
		EPackage ePackage = getEPackage(nsURI);
		if (ePackage != null)
			return ePackage.getEFactoryInstance();
		return null;
	}

	/**
	 * @param clazz
	 * @param jcoListMetaData
	 * @generated NOT
	 */
	private void addAnnotation(EModelElement modelElement, String source, String key, String value) {
		EAnnotation annotation = modelElement.getEAnnotation(source);
		if (annotation == null) {
			annotation = EcoreFactory.eINSTANCE.createEAnnotation();
			annotation.setSource(source);
			annotation.setEModelElement(modelElement);
		}
		annotation.getDetails().put(key, value);
	}

	/**
	 * Populate the given {@link EClass} with structural features and annotations derived from the meta-data of the given {@link JCoListMetaData}.
	 * 
	 * @param eClass - the {@link EClass} populated with meta-data.
	 * @param jcoListMetaData - the {@link JCoListMetaData} from which the meta-data is derived.
	 */
	private void addListMetaData(EClass eClass, JCoListMetaData jcoListMetaData) {
		if (jcoListMetaData == null)
			return;

		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
		EPackage ePackage = eClass.getEPackage();
		for (int i = 0; i < jcoListMetaData.getFieldCount(); i++) {
			EStructuralFeature structuralFeature;
			if (jcoListMetaData.isStructure(i)) {
				JCoRecordMetaData jcoRecordMetaData = jcoListMetaData.getRecordMetaData(i);
				EClass mappedRecordClass = getMappedRecordClass(ePackage, jcoRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				reference.setEType(mappedRecordClass);
				reference.setContainment(true);
				structuralFeature = reference;
				addAnnotation(structuralFeature, CciNS_URI, CciNS_CLASS_NAME_OF_FIELD_KEY,
						MappedRecord.class.getName());
			} else if (jcoListMetaData.isTable(i)) {
				JCoRecordMetaData jcoRecordMetaData = jcoListMetaData.getRecordMetaData(i);
				EClass indexedRecordClass = getIndexedRecordClass(ePackage, jcoRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				reference.setEType(indexedRecordClass);
				reference.setContainment(true);
				structuralFeature = reference;
				addAnnotation(structuralFeature, CciNS_URI, CciNS_CLASS_NAME_OF_FIELD_KEY,
						IndexedRecord.class.getName());
			} else {
				EAttribute attribute = ecoreFactory.createEAttribute();
				attribute.setEType(getEDataType(jcoListMetaData.getType(i)));
				structuralFeature = attribute;
				addAnnotation(structuralFeature, CciNS_URI, CciNS_CLASS_NAME_OF_FIELD_KEY,
						jcoListMetaData.getClassNameOfField(i));
			}
			structuralFeature.setName(jcoListMetaData.getName(i));
			if (!jcoListMetaData.isOptional(i))
				structuralFeature.setLowerBound(1);
			if (jcoListMetaData.getDefault(i) != null)
				structuralFeature.setDefaultValueLiteral(jcoListMetaData.getDefault(i));
			addAnnotation(structuralFeature, GenNS_URI, GenNS_DOCUMENTATION_KEY, jcoListMetaData.getDescription(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_DESCRIPTION_KEY,
					jcoListMetaData.getDescription(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_TYPE_KEY,
					Integer.toString(jcoListMetaData.getType(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_TYPE_AS_STRING_KEY,
					jcoListMetaData.getTypeAsString(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_RECORD_TYPE_NAME_KEY,
					jcoListMetaData.getRecordTypeName(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_LENGTH_KEY,
					Integer.toString(jcoListMetaData.getLength(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_BYTE_LENGTH_KEY,
					Integer.toString(jcoListMetaData.getByteLength(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_UNICODE_BYTE_LENGTH_KEY,
					Integer.toString(jcoListMetaData.getUnicodeByteLength(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_DECIMALS_KEY,
					Integer.toString(jcoListMetaData.getDecimals(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_DEFAULT_KEY, jcoListMetaData.getDefault(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_RECORD_FIELD_NAME_KEY,
					jcoListMetaData.getRecordFieldName(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_ABAP_OBJECT_KEY,
					Boolean.toString(jcoListMetaData.isAbapObject(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_NESTED_TYPE1_STRUCTURE_KEY,
					Boolean.toString(jcoListMetaData.isNestedType1Structure(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_STRUCTURE_KEY,
					Boolean.toString(jcoListMetaData.isStructure(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_TABLE_KEY,
					Boolean.toString(jcoListMetaData.isTable(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_IMPORT_KEY,
					Boolean.toString(jcoListMetaData.isImport(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_EXPORT_KEY,
					Boolean.toString(jcoListMetaData.isExport(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_CHANGING_KEY,
					Boolean.toString(jcoListMetaData.isChanging(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_OPTIONAL_KEY,
					Boolean.toString(jcoListMetaData.isOptional(i)));
			eClass.getEStructuralFeatures().add(structuralFeature);
		}
	}
	
	/**
	 * @generated NOT
	 */
	private EClass getMappedRecordClass(EPackage ePackage, JCoRecordMetaData jcoRecordMetaData) {
		EClassifier  eClassifier = ePackage.getEClassifier(jcoRecordMetaData.getName());
		if (!(eClassifier instanceof EClass)) {
			// Create Mapped Record Subclass
			eClassifier = EcoreFactory.eINSTANCE.createEClass();
			ePackage.getEClassifiers().add(eClassifier);
			eClassifier.setName(jcoRecordMetaData.getName());
			((EClass)eClassifier).getESuperTypes().add(CciPackageImpl.eINSTANCE.getMappedRecord());
			addRecordMetaData(((EClass)eClassifier), jcoRecordMetaData);
		}
		return (EClass) eClassifier;
	}
	
	/**
	 * Create and return an {@link EClass} deriving from {@link IndexedRecord} and representing the {@link JCoTable}  
	 * @param ePackage
	 * @param jcoRecordMetaData
	 * @return
	 */
	private EClass getIndexedRecordClass(EPackage ePackage, JCoRecordMetaData jcoRecordMetaData) {
		EClassifier  eClassifier = ePackage.getEClassifier(jcoRecordMetaData.getName() + "_TABLE");
		if (!(eClassifier instanceof EClass)) {
			// Create Indexed Record Subclass
			eClassifier = EcoreFactory.eINSTANCE.createEClass();
			ePackage.getEClassifiers().add(eClassifier);
			eClassifier.setName(jcoRecordMetaData.getName() + "_TABLE");
			((EClass)eClassifier).getESuperTypes().add(CciPackageImpl.eINSTANCE.getIndexedRecord());
			
			// Set Record Type
			EClass recordType = getMappedRecordClass(ePackage, jcoRecordMetaData);
			EReference recordTypeAttribute = EcoreFactory.eINSTANCE.createEReference();
			recordTypeAttribute.setName("recordType");
			recordTypeAttribute.setEType(recordType);
			recordTypeAttribute.setContainment(true);
			((EClass)eClassifier).getEStructuralFeatures().add(recordTypeAttribute);
			
		}
		return (EClass) eClassifier;
	}
	
	/**
	 * Populate the given {@link EClass} with structural features and annotations derived from the meta-data of the given {@link JCoRecordMetaData}.
	 * 
	 * @param eClass - the {@link EClass} populated with meta-data.
	 * @param jcoRecordMetaData - the {@link JCoRecordMetaData} from which the meta-data is derived.
	 */
	private void addRecordMetaData(EClass eClass, JCoRecordMetaData jcoRecordMetaData) {
		EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;	
		EPackage ePackage = eClass.getEPackage();
		for (int i = 0; i < jcoRecordMetaData.getFieldCount(); i++) {
			EStructuralFeature structuralFeature;
			if (jcoRecordMetaData.isStructure(i)) {
				JCoRecordMetaData jcoSubRecordMetaData = jcoRecordMetaData.getRecordMetaData(i);
				EClass structureClass = getMappedRecordClass(ePackage, jcoSubRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				structuralFeature = reference;
				reference.setEType(structureClass);
				reference.setContainment(true);
				addAnnotation(structuralFeature, CciNS_URI, CciNS_CLASS_NAME_OF_FIELD_KEY, MappedRecord.class.getName());
			} else if (jcoRecordMetaData.isTable(i)) {
				JCoRecordMetaData jcoSubRecordMetaData = jcoRecordMetaData.getRecordMetaData(i);
				EClass tableClass = getIndexedRecordClass(ePackage, jcoSubRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				structuralFeature = reference;
				reference.setEType(tableClass);
				reference.setContainment(true);
				addAnnotation(structuralFeature, CciNS_URI, CciNS_CLASS_NAME_OF_FIELD_KEY, IndexedRecord.class.getName());
			} else {
				EAttribute attribute = ecoreFactory.createEAttribute();
				structuralFeature = attribute;
				attribute.setEType(getEDataType(jcoRecordMetaData.getType(i)));
				addAnnotation(structuralFeature, CciNS_URI, CciNS_CLASS_NAME_OF_FIELD_KEY, jcoRecordMetaData.getClassNameOfField(i));
			}
			structuralFeature.setName(jcoRecordMetaData.getName(i));
			addAnnotation(structuralFeature, GenNS_URI, GenNS_DOCUMENTATION_KEY, jcoRecordMetaData.getDescription(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_DESCRIPTION_KEY, jcoRecordMetaData.getDescription(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_TYPE_KEY, Integer.toString(jcoRecordMetaData.getType(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_TYPE_AS_STRING_KEY, jcoRecordMetaData.getTypeAsString(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_RECORD_TYPE_NAME_KEY, jcoRecordMetaData.getRecordTypeName(i));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_LENGTH_KEY, Integer.toString(jcoRecordMetaData.getLength(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_BYTE_LENGTH_KEY, Integer.toString(jcoRecordMetaData.getByteLength(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_UNICODE_BYTE_LENGTH_KEY, Integer.toString(jcoRecordMetaData.getUnicodeByteLength(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_DECIMALS_KEY, Integer.toString(jcoRecordMetaData.getDecimals(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_ABAP_OBJECT_KEY, Boolean.toString(jcoRecordMetaData.isAbapObject(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_NESTED_TYPE1_STRUCTURE_KEY, Boolean.toString(jcoRecordMetaData.isNestedType1Structure(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_STRUCTURE_KEY, Boolean.toString(jcoRecordMetaData.isStructure(i)));
			addAnnotation(structuralFeature, CciNS_URI, CciNS_IS_TABLE_KEY, Boolean.toString(jcoRecordMetaData.isTable(i)));
			eClass.getEStructuralFeatures().add(structuralFeature);
			
		}
	}

	/**
	 * Return the {@link EClassifier} corresponding to the given JCo data type.
	 * 
	 * @param jcoDataType - the JCo data type.
	 * @return the {@link EClassifier} corresponding to the given JCo data type.
	 */
	private EClassifier getEDataType(int jcoDataType) {
		switch (jcoDataType) {

		case JCoMetaData.TYPE_INT:
		case JCoMetaData.TYPE_INT1:
		case JCoMetaData.TYPE_INT2:
			return EcorePackage.Literals.EINT;

		case JCoMetaData.TYPE_CHAR:
			return EcorePackage.Literals.ESTRING;

		case JCoMetaData.TYPE_NUM:
			return EcorePackage.Literals.ESTRING;

		case JCoMetaData.TYPE_BCD:
			return EcorePackage.Literals.EBIG_DECIMAL;

		case JCoMetaData.TYPE_DATE:
			return EcorePackage.Literals.EDATE;

		case JCoMetaData.TYPE_TIME:
			return EcorePackage.Literals.EDATE;

		case JCoMetaData.TYPE_FLOAT:
			return EcorePackage.Literals.EDOUBLE;

		case JCoMetaData.TYPE_BYTE:
			return EcorePackage.Literals.EBYTE_ARRAY;

		case JCoMetaData.TYPE_STRING:
			return EcorePackage.Literals.ESTRING;

		case JCoMetaData.TYPE_XSTRING:
			return EcorePackage.Literals.EBYTE_ARRAY;

		case JCoMetaData.TYPE_DECF16:
			return EcorePackage.Literals.EBIG_DECIMAL;

		case JCoMetaData.TYPE_DECF34:
			return EcorePackage.Literals.EBIG_DECIMAL;

		case JCoMetaData.TYPE_STRUCTURE:
			return CciPackageImpl.Literals.MAPPED_RECORD;

		case JCoMetaData.TYPE_TABLE:
			return CciPackageImpl.Literals.INDEXED_RECORD;

		default:
			return EcorePackage.Literals.EBYTE_ARRAY;
		}
	}
}
