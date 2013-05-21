package org.jboss.jca.adapters.sap.util;

import javax.resource.ResourceException;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.jboss.jca.adapters.sap.model.cci.IndexedRecord;
import org.jboss.jca.adapters.sap.model.cci.MappedRecord;
import org.jboss.jca.adapters.sap.model.cci.Record;
import org.jboss.jca.adapters.sap.model.cci.impl.CciPackageImpl;

import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoRecord;
import com.sap.conn.jco.JCoRecordMetaData;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoTable;

public class RecordUtil {
	
	/**
	 * The namespace URI for GenModel Annotations.
	 */
	public static final String GenNS_URI = "http://www.eclipse.org/emf/2002/GenModel";

	/**
	 * The key for documentation detail of GenModel Annotation. 
	 */
	public static final String GenNS_DOCUMENTATION_KEY = "documentation";

	/**
	 * The common prefix of all package namespace URI's of packages derived from this package.
	 */
	public static final String JBOSS_SAP_URI_PREFIX = "http://sap.adapters.jca.jboss.org/";

	/**
	 * The namespace URI for the JBoss SAP JCA Common Client Interface package.
	 */
	public static final String CciNS_URI = CciPackageImpl.eNS_URI;

	/**
	 * Details key for a {@link Record} entry annotation providing the description of the underlying JCo data field represented by the annotated record entry. The details value is the description of the record entry and its underlying JCo data field. 
	 */
	public static final String CciNS_DESCRIPTION_KEY = "description";

	/**
	 * Details key for a {@link Record} entry annotation providing the fully-qualified Java classname of the annotated record entry. The details value is the fully-qualified Java classname of the record entry. 
	 */
	public static final String CciNS_CLASS_NAME_OF_FIELD_KEY = "classNameOfField";

	/**
	 * Details key for a {@link Record} entry annotation indicating the table, structure or data element name of the underlying JCo data field represented by the annotated record entry. The details value is the name of the table, structure or data element of the underlying JCo data field. The details values is <code>null</code> if the data element name is unavailable. 
	 */
	public static final String CciNS_RECORD_TYPE_NAME_KEY = "recordTypeName";

	/**
	 * Details key for a {@link Record} entry annotation providing the JCo data type of the underlying data field represented by the annotated record entry. The details value is the JCo data type of the underlying data field represented by the record entry. 
	 */
	public static final String CciNS_TYPE_KEY = "type";

	/**
	 * Details key for a {@link Record} entry annotation providing the String representation of the JCo data type of the underlying data field represented by the annotated record entry. The details value is the String representation of the JCo data type of the underlying data field represented by the record entry. 
	 */
	public static final String CciNS_TYPE_AS_STRING_KEY = "typeAsString";

	/**
	 * Details key for a {@link Record} entry annotation providing the length of the underlying data field for Unicode layout represented by the annotated record entry. The details value is the length of the underlying data field for Unicode layout represented by the record entry. 
	 */
	public static final String CciNS_UNICODE_BYTE_LENGTH_KEY = "unicodeByteLength";

	/**
	 * Details key for a {@link Record} entry annotation providing the byte length of the underlying data field for Non-Unicode layout represented by the annotated record entry. The details value is the byte length of the underlying data field for Non-Unicode layout represented by the record entry. 
	 */
	public static final String CciNS_BYTE_LENGTH_KEY = "byteLength";

	/**
	 * Details key for a {@link Record} entry annotation providing the max length of the underlying data field represented by the annotated record entry. The details value is the max length of the underlying data field represented by the record entry.
	 * 
	 * <ul>
	 * <li><p>For character based data element types the length is the char length.
	 * <li><p>For <em><b>STRING</b></em> and <em><b>XSTRING</b></em> data element types the length is <em><b>0</b></em>.</li> 
	 * <li><p>For <em><b>STRUCTURE</b></em> and <em><b>TABLE</b></em> data element types the length is <em><b>0</b></em>.</li>
	 * <li><p>For numerical based data element types the length is the byte length.
	 * </ul> 
	 */
	public static final String CciNS_LENGTH_KEY = "length";

	/**
	 * Details key for a {@link Record} entry annotation providing the number of decimals in the the underlying data field represented by the annotated record entry. The details value is the number of decimals in the the underlying data field represented by the record entry.
	 * 
	 * <p>The details value is possibly non-zero only for record entries whose underlying data field has the JCo data type <em><b>BCD</b></em> or <em><b>FLOAT</b></em>.
	 */
	public static final String CciNS_DECIMALS_KEY = "decimals";

	/**
	 * Details key for a {@link Record} entry annotation providing the default value of the annotated record entry. The details value is the default value of the record entry.
	 */
	public static final String CciNS_DEFAULT_KEY = "default";

	/**
	 * Details key for a {@link Record} entry annotation providing the field name in an underlying JCo structure or table represented by the annotated record entry. The details value is the name of the field in the underlying JCo structure or table if the JCo parameter represented by the entry is defined by referencing that field. The details values is <code>null</code> otherwise. 
	 */
	public static final String CciNS_RECORD_FIELD_NAME_KEY = "recordFieldName";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry represents an underlying JCo <code>ABAP Object</code>. The details value is <code>true</code> if the record entry represents an <code>ABAP Object</code>; <code>false</code> otherwise. 
	 */
	public static final String CciNS_IS_ABAP_OBJECT_KEY = "isAbapObject";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry represents an underlying <code>TYPE1</code> JCo structure. The details value is <code>true</code> if the record entry represents a <code>TYPE1</code> structure; <code>false</code> otherwise. 
	 */
	public static final String CciNS_IS_NESTED_TYPE1_STRUCTURE_KEY = "isNestedType1Structure";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry is a <em><b>structure</b></em> type entry; i.e. is a {@link MappedRecord}. The details value is <code>true</code> if the record entry is a {@link MappedRecord}; <code>false</code> otherwise. 
	 */
	public static final String CciNS_IS_STRUCTURE_KEY = "isStructure";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the annotated record entry is a <em><b>table</b></em> type entry; i.e. is an {@link IndexedRecord}. The details value is <code>true</code> if the record entry is a {@link IndexedRecord}; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_TABLE_KEY = "isTable";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>import</b></em> parameter. The details value is <code>true</code> if the underlying data field is an import parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_IMPORT_KEY = "isImport";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>export</b></em> parameter. The details value is <code>true</code> if the underlying data field is an export parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_EXPORT_KEY = "isExport";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is a <em><b>changing</b></em> parameter. The details value is <code>true</code> if the underlying data field is a changing parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_CHANGING_KEY = "isChanging";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>exception</b></em>. The details value is <code>true</code> if the underlying data field is an exception; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_EXCEPTION_KEY = "isException";

	/**
	 * Details key for a {@link Record} entry annotation indicating whether the underlying data field represented by the annotated record entry is an <em><b>optional</b></em> parameter. The details value is <code>true</code> if the underlying data field is an optional parameter; <code>false</code> otherwise.	 
	 */
	public static final String CciNS_IS_OPTIONAL_KEY = "isOptional";
	
	public static final String RECORDS = "records";

	private RecordUtil() {}
	
	/**
	 * Create a {@link org.jboss.jca.adapters.sap.model.cci.Record} instance whose repository type is designated by the given record name.
	 * 
	 * @param connectionName - The connection name of the sap repository to retrieve meta-data from.
	 * @param recordname - The record name designating the type of record to create.
	 * @return A {@link org.jboss.jca.adapters.sap.model.cci.Record} instance of the designated type. 
	 * @throws ResourceException If factory fails to create instance. 
	 * 
	 */
	public static Record createRecord(String connectionName, String recordname) throws ResourceException {

		// Parse the passed record name.
		RecordUtil.RecordName recordName = getRecordName(recordname);
		if (recordName == null) 
			return null;
		
		// Build namespace URI for package of record.
		String nsURI = getNsUri(connectionName, recordName.functionModuleName);
		if (nsURI == null)
			return null;
		
		// Get package of record.
		EPackage ePackage = getEPackage(connectionName, nsURI);
		if (ePackage == null)
			return null;

		// Get the record's eClass
		EClassifier eClassifier = ePackage.getEClassifier(recordName.recordTypeName);
		if (!(eClassifier instanceof EClass))
			return null;

		// Check that it is a Record class.
		EClass eClass = (EClass) eClassifier;
		EObject eObject = ePackage.getEFactoryInstance().create(eClass);
		if (!(eObject instanceof Record))
			return null;

		Record record = (Record) eObject;
		record.setRecordName(recordname);

		return record;

	}

	/**
	 * Parsed Record Name structure.
	 */
	public static class RecordName {
		public String functionModuleName;
		public String recordTypeName;
	}
	
	public static RecordName getRecordName(String recordName) {
		/* recordName is of the form <functionModuleName>.<recordTypeName>*/
		/* Parse out function module name from record name */
		int index = recordName.lastIndexOf(".");
		if (index == -1)
			/* No function module name prefix so can't lookup package */
			return null;

		RecordName returnRecordName = new RecordName();
		
		returnRecordName.functionModuleName = recordName.substring(0, index);
		returnRecordName.recordTypeName = recordName.substring(index + 1, recordName.length());
		return returnRecordName;
	}

	public static String getNsUri(String connectionName, String functionModuleName) {

		JCoRepository repository = getRepository(connectionName);
		if (repository == null) 
			return null;

		return JBOSS_SAP_URI_PREFIX  + repository.getName() + "/" + functionModuleName;
	}

	public static EPackage getEPackage(String connectionName, String nsURI) {
		// Check whether the requested package has already been built.
		EPackage ePackage = (EPackage) EPackage.Registry.INSTANCE.get(nsURI);
		if (ePackage != null) {
			return ePackage;
		}

		// Retrieve the destination's repository.
		JCoRepository repository;
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(connectionName);
			repository = destination.getRepository();
		} catch (JCoException e1) {
			return null;
		}
		
		if (nsURI.startsWith(JBOSS_SAP_URI_PREFIX + repository.getName())) {
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

	public static EFactory getEFactory(String connectionName, String nsURI) {
		EPackage ePackage = getEPackage(connectionName, nsURI);
		if (ePackage != null)
			return ePackage.getEFactoryInstance();
		return null;
	}

	/**
	 * @param clazz
	 * @param jcoListMetaData
	 */
	public static void addAnnotation(EModelElement modelElement, String source, String key, String value) {
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
	public static void addListMetaData(EClass eClass, JCoListMetaData jcoListMetaData) {
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
	
	public static EClass getMappedRecordClass(EPackage ePackage, JCoRecordMetaData jcoRecordMetaData) {
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
	public static EClass getIndexedRecordClass(EPackage ePackage, JCoRecordMetaData jcoRecordMetaData) {
		EClassifier  eClassifier = ePackage.getEClassifier(jcoRecordMetaData.getName() + "_TABLE");
		if (!(eClassifier instanceof EClass)) {
			
			// Create super type for indexed record subclass: IndexeRecord<R extends MappedRecord>
			EGenericType indexedRecordGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			indexedRecordGenericType.setEClassifier(CciPackageImpl.eINSTANCE.getIndexedRecord());
			
			// Create type parameter for record type: R extends MappedRecord
			EGenericType recordEntryGenericType = EcoreFactory.eINSTANCE.createEGenericType();
			EClass recordType = getMappedRecordClass(ePackage, jcoRecordMetaData);
			recordEntryGenericType.setEClassifier(recordType);
			
			// Add type parameter to super type.
			indexedRecordGenericType.getETypeArguments().add(recordEntryGenericType);
			
			// Create indexed record subclass and add to package
			eClassifier = EcoreFactory.eINSTANCE.createEClass();
			ePackage.getEClassifiers().add(eClassifier);
			eClassifier.setName(jcoRecordMetaData.getName() + "_TABLE");
			((EClass)eClassifier).getEGenericSuperTypes().add(indexedRecordGenericType);
			
			
		}
		return (EClass) eClassifier;
	}
	
	/**
	 * Populate the given {@link EClass} with structural features and annotations derived from the meta-data of the given {@link JCoRecordMetaData}.
	 * 
	 * @param eClass - the {@link EClass} populated with meta-data.
	 * @param jcoRecordMetaData - the {@link JCoRecordMetaData} from which the meta-data is derived.
	 */
	public static void addRecordMetaData(EClass eClass, JCoRecordMetaData jcoRecordMetaData) {
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
	public static EClassifier getEDataType(int jcoDataType) {
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

	public static Object getValue(EObject object, EStructuralFeature feature) {
		try {
			Object value = object.eGet(feature);
			if (value == null && feature instanceof EReference) {
				EClass eClass = ((EReference)feature).getEReferenceType();
				value = eClass.getEPackage().getEFactoryInstance().create(eClass);
				setValue(object, feature, value);
			}
			return value;
		} catch (Throwable exception) {
			return null;
		}
	}
	
	public static void setValue(EObject object, EStructuralFeature feature, Object value) {
		try {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(object);
			if (editingDomain == null) {
				object.eSet(feature, value);
			} else {
				Command setCommand = SetCommand.create(editingDomain, object, feature, value);
				editingDomain.getCommandStack().execute(setCommand);
			}
		} catch (Throwable exception) {
		}
	}
	
	public static void extractJCoRecordIntoMappedRecord(JCoRecord jcoRecord, MappedRecord mappedRecord) {
		if (jcoRecord == null || mappedRecord == null) 
			return;
		
		EClass eClass = mappedRecord.eClass();
		JCoFieldIterator iterator = jcoRecord.getFieldIterator();
		while(iterator.hasNextField()) {
			JCoField field = iterator.nextField();
			EStructuralFeature feature = eClass.getEStructuralFeature(field.getName());
			Object value = getValue(mappedRecord, feature);
			if (field.isStructure()) {
				if (value == null || !(value instanceof MappedRecord))
					continue;
				extractJCoRecordIntoMappedRecord(field.getStructure(), (MappedRecord)value);
			} else if (field.isTable()) {
				if (value == null || !(value instanceof IndexedRecord<?>))
					continue;
				extractJCoTableIntoIndexedRecord((JCoTable) field.getTable(), (IndexedRecord<?>) value);
			} else {
				setValue(mappedRecord, feature, field.getValue());
			}
		}
	}

	public static void fillJCoRecordFromMappedRecord(MappedRecord eObject, JCoRecord jcoRecord) {
		if (jcoRecord == null || eObject == null) 
			return;

		EClass eClass = eObject.eClass();
		JCoFieldIterator iterator = jcoRecord.getFieldIterator();
		while(iterator.hasNextField()) {
			JCoField field = iterator.nextField();
			EStructuralFeature feature = eClass.getEStructuralFeature(field.getName());
			Object value = getValue(eObject, feature);
			if (field.isStructure()) {
				if (value == null || !(value instanceof MappedRecord))
					continue;
				fillJCoRecordFromMappedRecord((MappedRecord)value, field.getStructure());
			} else if (field.isTable()) {
				if (value == null || !(value instanceof IndexedRecord))
					continue;
				fillJCoTableFromIndexedRecord((IndexedRecord<?>) value, field.getTable());
			} else {
				field.setValue(value);
			}
		}
		
	}
	
	public static void extractJCoTableIntoIndexedRecord(JCoTable jcoTable, IndexedRecord<?> indexedRecord) {
		if (indexedRecord == null || jcoTable == null) 
			return;
		
		EStructuralFeature feature = indexedRecord.eClass().getEStructuralFeature(RECORDS);
		if (feature == null || !(feature instanceof EReference)) {
			return;
		}
		EClass rowType = ((EReference)feature).getEReferenceType();
		@SuppressWarnings("unchecked")
		EList<MappedRecord> records = (EList<MappedRecord>) getValue(indexedRecord, feature);
		
		jcoTable.firstRow();
		for (int i = 0; i < jcoTable.getNumRows(); i++, jcoTable.nextRow()) {
			MappedRecord newRow = (MappedRecord) rowType.getEPackage().getEFactoryInstance().create(rowType);
			records.add(newRow);
			extractJCoRecordIntoMappedRecord(jcoTable, newRow);
		}
	}
	
	public static void fillJCoTableFromIndexedRecord(IndexedRecord<?> indexedRecord, JCoTable jcoTable) {
		if (indexedRecord == null || jcoTable == null) 
			return;
		
		EStructuralFeature feature = indexedRecord.eClass().getEStructuralFeature(RECORDS);
		@SuppressWarnings("unchecked")
		EList<MappedRecord> records = (EList<MappedRecord>) getValue(indexedRecord, feature);
		for (MappedRecord row: records) {
			jcoTable.appendRow();
			fillJCoRecordFromMappedRecord(row, (JCoRecord) jcoTable);
		}
	}
	
	protected  static JCoRepository getRepository(String connectionName) {
		JCoRepository repository;
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(connectionName);
			repository = destination.getRepository();
		} catch (JCoException e1) {
			return null;
		}
		return repository;
	}
	
}
