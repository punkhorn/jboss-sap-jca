package org.jboss.sap.rfc.util;

import static org.jboss.sap.rfc.RfcPackage.RfcNS_BYTE_LENGTH_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_CLASS_NAME_OF_FIELD_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_DECIMALS_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_DEFAULT_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_DESCRIPTION_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_ABAP_OBJECT_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_CHANGING_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_EXPORT_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_IMPORT_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_NESTED_TYPE1_STRUCTURE_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_OPTIONAL_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_STRUCTURE_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_IS_TABLE_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_LENGTH_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_RECORD_FIELD_NAME_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_RECORD_TYPE_NAME_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_TYPE_AS_STRING_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_TYPE_KEY;
import static org.jboss.sap.rfc.RfcPackage.RfcNS_UNICODE_BYTE_LENGTH_KEY;
import static org.jboss.sap.rfc.RfcPackage.eNS_URI;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
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
import org.jboss.sap.rfc.Function;
import org.jboss.sap.rfc.Group;
import org.jboss.sap.rfc.Repository;
import org.jboss.sap.rfc.RfcFactory;
import org.jboss.sap.rfc.RfcPackage;
import org.jboss.sap.rfc.Structure;
import org.jboss.sap.rfc.Table;

import com.sap.conn.jco.JCoContext;
import com.sap.conn.jco.JCoDestination;
import com.sap.conn.jco.JCoDestinationManager;
import com.sap.conn.jco.JCoException;
import com.sap.conn.jco.JCoField;
import com.sap.conn.jco.JCoFieldIterator;
import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoFunctionTemplate;
import com.sap.conn.jco.JCoListMetaData;
import com.sap.conn.jco.JCoMetaData;
import com.sap.conn.jco.JCoRecord;
import com.sap.conn.jco.JCoRecordMetaData;
import com.sap.conn.jco.JCoRepository;
import com.sap.conn.jco.JCoRequest;
import com.sap.conn.jco.JCoResponse;
import com.sap.conn.jco.JCoTable;

public class RfcUtil {
	
	public static final String ROW = "row";

	public static final String GenNS_URI = "http://www.eclipse.org/emf/2002/GenModel";

	public static final String GenNS_DOCUMENTATION_KEY = "documentation";

	private static final String STEXT_PARAM = "STEXT";
	private static final String FUNCTIONS_TABLE = "FUNCTIONS";
	private static final String FUNCNAME_PARAM = "FUNCNAME";
	private static final String RFC_FUNCTION_SEARCH_FUNCTION = "RFC_FUNCTION_SEARCH";
	private static final String GROUPS_TABLE = "GROUPS";
	private static final String GROUPNAME_PARAM = "GROUPNAME";
	private static final String RFC_GROUP_SEARCH_FUNCTION = "RFC_GROUP_SEARCH";

	private RfcUtil() {}
	
	public static Repository getRepository(String destinationName) {
		Repository repository = null;
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
			repository = RfcFactory.eINSTANCE.createRepository();
			String name = destination.getRepository().getName();
			repository.setName(name);
			repository.setDestinationName(destinationName);
		} catch (JCoException e) {
		}
		return repository; 
	}
	
	public static List<Group> getGroups(String destinationName, String groupFilter) {
		List<Group> groups = new ArrayList<Group>();
		
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
			JCoFunction function = destination.getRepository().getFunction(	RFC_GROUP_SEARCH_FUNCTION);
			function.getImportParameterList().setValue(GROUPNAME_PARAM, groupFilter);
			function.execute(destination);
			JCoTable jcoGroups = function.getTableParameterList().getTable(GROUPS_TABLE);

		
			if (jcoGroups.getNumRows() > 0) {
				jcoGroups.firstRow();
				do {
					Group group = RfcFactory.eINSTANCE.createGroup();
					String groupName = jcoGroups.getString(GROUPNAME_PARAM);
					group.setName(groupName);
					String groupDescription = jcoGroups.getString(STEXT_PARAM);
					group.setDescription(groupDescription);
					
					groups.add(group);
				} while (jcoGroups.nextRow());
			}

		} catch (Exception e) {
		}
		return groups;
	}
	
	public static List<Function> getFunctions(String destinationName, String functionNameFilter, String groupNameFilter) {
		List<Function> functions = new ArrayList<Function>();
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
			JCoFunction jcoFunction = destination.getRepository().getFunction(RFC_FUNCTION_SEARCH_FUNCTION);
			jcoFunction.getImportParameterList().setValue(FUNCNAME_PARAM, functionNameFilter);
			jcoFunction.getImportParameterList().setValue(GROUPNAME_PARAM, groupNameFilter);
			jcoFunction.execute(destination);
			JCoTable sapFunctions = jcoFunction.getTableParameterList().getTable(FUNCTIONS_TABLE);
			
			if (sapFunctions.getNumRows() > 0) {
				sapFunctions.firstRow();
				do {
					Function function = RfcFactory.eINSTANCE.createFunction();
					String functionName = sapFunctions.getString(FUNCNAME_PARAM);
					function.setName(functionName);
					String functionDescription = sapFunctions.getString(STEXT_PARAM);
					function.setDescription(functionDescription);
					functions.add(function);
				} while (sapFunctions.nextRow());
			}
		} catch (JCoException e) {
			// Assume No Function Found
		}
		return functions;
	}
	
	public static Structure executeFunction(JCoDestination destination, String functionName, Structure request) {
		try {
			JCoRequest jcoRequest = destination.getRepository().getRequest(functionName);
			fillStructure(request, jcoRequest);
			JCoResponse jcoResponse = jcoRequest.execute(destination);
			Structure response = getResponse(destination, functionName);
			extractStructure(jcoResponse, response);
			return response;
		} catch (JCoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Structure executeFunction(String destinationName, String functionName, Structure request) {
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
			JCoRequest jcoRequest = destination.getRepository().getRequest(functionName);
			fillStructure(request, jcoRequest);
			JCoResponse jcoResponse = jcoRequest.execute(destination);
			Structure response = getResponse(destinationName, functionName);
			extractStructure(jcoResponse, response);
			return response;
		} catch (JCoException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void beginTransaction(String destinationName) throws JCoException {
		JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
		JCoContext.begin(destination);
	}
	
	public static void commitTransaction(String destinationName) throws JCoException {
		JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
		JCoRequest request = destination.getRepository().getRequest("BAPI_TRANSACTION_COMMIT");
		request.setValue("WAIT", "X");
		request.execute(destination);
		JCoContext.end(destination);
	}
	
	public static void rollbackTransaction(String destinationName) throws JCoException {
		JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
		JCoRequest request = destination.getRepository().getRequest("BAPI_TRANSACTION_ROLLBACK");
		request.execute(destination);
		JCoContext.end(destination);
	}
	
	public static void beginTransaction(JCoDestination destination) throws JCoException {
		JCoContext.begin(destination);
	}
	
	public static void commitTransaction(JCoDestination destination) throws JCoException {
		JCoRequest request = destination.getRepository().getRequest("BAPI_TRANSACTION_COMMIT");
		request.setValue("WAIT", "X");
		request.execute(destination);
		JCoContext.end(destination);
	}
	
	public static void rollbackTransaction(JCoDestination destination) throws JCoException {
		JCoRequest request = destination.getRepository().getRequest("BAPI_TRANSACTION_ROLLBACK");
		request.execute(destination);
		JCoContext.end(destination);
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
	
	public static void extractStructure(JCoRecord jrecord, Structure eObject) {
		if (jrecord == null || eObject == null) 
			return;
		
		EClass eClass = eObject.eClass();
		JCoFieldIterator iterator = jrecord.getFieldIterator();
		while(iterator.hasNextField()) {
			JCoField field = iterator.nextField();
			EStructuralFeature feature = eClass.getEStructuralFeature(field.getName());
			Object value = getValue(eObject, feature);
			if (field.isStructure()) {
				if (value == null || !(value instanceof EObject))
					continue;
				extractStructure(field.getStructure(), (Structure)value);
			} else if (field.isTable()) {
				if (value == null || !(value instanceof EObject))
					continue;
				extractTable((JCoTable) field.getTable(), (Table) value);
			} else {
				setValue(eObject, feature, field.getValue());
			}
		}
	}

	public static void fillStructure(Structure eObject, JCoRecord jcoRecord) {
		if (jcoRecord == null || eObject == null) 
			return;

		EClass eClass = eObject.eClass();
		JCoFieldIterator iterator = jcoRecord.getFieldIterator();
		while(iterator.hasNextField()) {
			JCoField field = iterator.nextField();
			EStructuralFeature feature = eClass.getEStructuralFeature(field.getName());
			Object value = getValue(eObject, feature);
			if (field.isStructure()) {
				if (value == null || !(value instanceof Structure))
					continue;
				fillStructure((Structure)value, field.getStructure());
			} else if (field.isTable()) {
				if (value == null || !(value instanceof Table))
					continue;
				fillTable((Table) value, field.getTable());
			} else {
				field.setValue(value);
			}
		}
		
	}
	
	public static void extractTable(JCoTable jcoTable, Table table) {
		if (table == null || jcoTable == null) 
			return;
		
		EStructuralFeature feature = table.eClass().getEStructuralFeature(ROW);
		if (feature == null || !(feature instanceof EReference)) {
			return;
		}
		EClass rowType = ((EReference)feature).getEReferenceType();
		@SuppressWarnings("unchecked")
		EList<Structure> records = (EList<Structure>) getValue(table, feature);
		
		jcoTable.firstRow();
		for (int i = 0; i < jcoTable.getNumRows(); i++, jcoTable.nextRow()) {
			Structure newRow = (Structure) rowType.getEPackage().getEFactoryInstance().create(rowType);
			records.add(newRow);
			extractStructure(jcoTable, newRow);
		}
	}
	
	public static void fillTable(Table table, JCoTable jcoTable) {
		if (table == null || jcoTable == null) 
			return;
		
		EStructuralFeature feature = table.eClass().getEStructuralFeature(ROW);
		@SuppressWarnings("unchecked")
		EList<Structure> records = (EList<Structure>) getValue(table, feature);
		for (Structure row: records) {
			jcoTable.appendRow();
			fillStructure(row, (JCoRecord) jcoTable);
		}
	}
	
	public static Structure getRequest(String destinationName, String functionModuleName) {
		return	(Structure) getInstance(destinationName, functionModuleName, "Request");
	}
	
	public static Structure getResponse(String destinationName, String functionModuleName) {
		return (Structure) getInstance(destinationName, functionModuleName, "Response");
	}
	
	public static Structure getResponse(JCoDestination destination, String functionModuleName) {
		return (Structure) getInstance(destination, functionModuleName, "Response");
	}
	
	public static EObject getInstance(String destinationName, String functionModuleName, String eClassName) {
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
			JCoRepository repository = destination.getRepository();
			String nsURI = eNS_URI + "/"  + repository.getName() + "/" + functionModuleName;
			
			EPackage ePackage = getEPackage(destinationName, nsURI);
			EClassifier classifier = ePackage.getEClassifier(eClassName);
			if (!(classifier instanceof EClass))
				return null;

			EClass eClass = (EClass) classifier;
			EObject eObject = ePackage.getEFactoryInstance().create(eClass);
			
			return eObject;
		} catch (JCoException e) {
			return null;
		}
	}

	public static EObject getInstance(JCoDestination destination, String functionModuleName, String eClassName) {
		try {
			JCoRepository repository = destination.getRepository();
			String nsURI = eNS_URI + "/"  + repository.getName() + "/" + functionModuleName;
			
			EPackage ePackage = getEPackage(destination, nsURI);
			EClassifier classifier = ePackage.getEClassifier(eClassName);
			if (!(classifier instanceof EClass))
				return null;

			EClass eClass = (EClass) classifier;
			EObject eObject = ePackage.getEFactoryInstance().create(eClass);
			
			return eObject;
		} catch (JCoException e) {
			return null;
		}
	}

	public static  EPackage getEPackage(String destinationName, String nsURI) {
		
		// Check whether the requested package has already been built.
		EPackage ePackage = (EPackage) EPackage.Registry.INSTANCE.get(nsURI);
		if (ePackage != null) {
			return ePackage;
		}

		// Retrieve the destination's repository.
		JCoRepository repository;
		try {
			JCoDestination destination = JCoDestinationManager.getDestination(destinationName);
			repository = destination.getRepository();
		} catch (JCoException e1) {
			return null;
		}
		
		// Check whether the requested package is defined by the destination's repository. 
		if (nsURI.startsWith(eNS_URI + "/" + repository.getName())) {
			
			// Extract the function module name from the URI.
			int prefixLength = eNS_URI.length() + repository.getName().length() + 2; // Length of "http://sap.jboss.org/<repo-name>/" prefix.
			String functionModuleName = nsURI.substring(prefixLength);
			
			// Retrieve the function module's meta-data. 
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
			EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
			ePackage = ecoreFactory.createEPackage();
			ePackage.setName(functionModuleName);
			ePackage.setNsPrefix(functionModuleName);
			ePackage.setNsURI(nsURI);
			
			// Create Request Class
			EClass requestClass = ecoreFactory.createEClass();
			ePackage.getEClassifiers().add(requestClass);
			requestClass.setName("Request");
			requestClass.getESuperTypes().add(RfcPackage.eINSTANCE.getStructure());
			addListMetaData(requestClass, importParameterListMetaData);
			addListMetaData(requestClass, changingParameterListMetaData);
			addListMetaData(requestClass, tableParameterListMetaData);
			addAnnotation(requestClass, GenNS_URI, GenNS_DOCUMENTATION_KEY, "Request for "
					+ functionModuleName);

			// Create Response Class
			EClass responseClass = ecoreFactory.createEClass();
			ePackage.getEClassifiers().add(responseClass);
			responseClass.setName("Response");
			responseClass.getESuperTypes().add(RfcPackage.eINSTANCE.getStructure());
			addListMetaData(responseClass, exportParameterListMetaData);
			addListMetaData(responseClass, changingParameterListMetaData);
			addListMetaData(responseClass, tableParameterListMetaData);
			addAnnotation(responseClass, GenNS_URI, GenNS_DOCUMENTATION_KEY, "Response for "
					+ functionModuleName);

			// Register Package
			EPackage.Registry.INSTANCE.put(nsURI, ePackage);
		}
		return ePackage;
	}

	public static  EPackage getEPackage(JCoDestination destination, String nsURI) {
		
		// Check whether the requested package has already been built.
		EPackage ePackage = (EPackage) EPackage.Registry.INSTANCE.get(nsURI);
		if (ePackage != null) {
			return ePackage;
		}

		// Retrieve the destination's repository.
		JCoRepository repository;
		try {
			repository = destination.getRepository();
		} catch (JCoException e1) {
			return null;
		}
		
		// Check whether the requested package is defined by the destination's repository. 
		if (nsURI.startsWith(eNS_URI + "/" + repository.getName())) {
			
			// Extract the function module name from the URI.
			int prefixLength = eNS_URI.length() + repository.getName().length() + 2; // Length of "http://sap.jboss.org/<repo-name>/" prefix.
			String functionModuleName = nsURI.substring(prefixLength);
			
			// Retrieve the function module's meta-data. 
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
			EcoreFactory ecoreFactory = EcoreFactory.eINSTANCE;
			ePackage = ecoreFactory.createEPackage();
			ePackage.setName(functionModuleName);
			ePackage.setNsPrefix(functionModuleName);
			ePackage.setNsURI(nsURI);
			
			// Create Request Class
			EClass requestClass = ecoreFactory.createEClass();
			ePackage.getEClassifiers().add(requestClass);
			requestClass.setName("Request");
			requestClass.getESuperTypes().add(RfcPackage.eINSTANCE.getStructure());
			addListMetaData(requestClass, importParameterListMetaData);
			addListMetaData(requestClass, changingParameterListMetaData);
			addListMetaData(requestClass, tableParameterListMetaData);
			addAnnotation(requestClass, GenNS_URI, GenNS_DOCUMENTATION_KEY, "Request for "
					+ functionModuleName);

			// Create Response Class
			EClass responseClass = ecoreFactory.createEClass();
			ePackage.getEClassifiers().add(responseClass);
			responseClass.setName("Response");
			responseClass.getESuperTypes().add(RfcPackage.eINSTANCE.getStructure());
			addListMetaData(responseClass, exportParameterListMetaData);
			addListMetaData(responseClass, changingParameterListMetaData);
			addListMetaData(responseClass, tableParameterListMetaData);
			addAnnotation(responseClass, GenNS_URI, GenNS_DOCUMENTATION_KEY, "Response for "
					+ functionModuleName);

			// Register Package
			EPackage.Registry.INSTANCE.put(nsURI, ePackage);
		}
		return ePackage;
	}

	/**
	 * @param clazz
	 * @param jcoListMetaData
	 * @generated NOT
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
				EClass structureClass = getStructureClass(ePackage, jcoRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				reference.setEType(structureClass);
				reference.setContainment(true);
				structuralFeature = reference;
				addAnnotation(structuralFeature, eNS_URI, RfcNS_CLASS_NAME_OF_FIELD_KEY,
						EObject.class.getName());
			} else if (jcoListMetaData.isTable(i)) {
				JCoRecordMetaData jcoRecordMetaData = jcoListMetaData.getRecordMetaData(i);
				EClass tableClass = getTableClass(ePackage, jcoRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				reference.setEType(tableClass);
				reference.setContainment(true);
				structuralFeature = reference;
				addAnnotation(structuralFeature, eNS_URI, RfcNS_CLASS_NAME_OF_FIELD_KEY,
						EObject.class.getName());
			} else {
				EAttribute attribute = ecoreFactory.createEAttribute();
				attribute.setEType(getEDataType(jcoListMetaData.getType(i)));
				structuralFeature = attribute;
				addAnnotation(structuralFeature, eNS_URI, RfcNS_CLASS_NAME_OF_FIELD_KEY,
						jcoListMetaData.getClassNameOfField(i));
			}
			structuralFeature.setName(jcoListMetaData.getName(i));
			if (!jcoListMetaData.isOptional(i))
				structuralFeature.setLowerBound(1);
			if (jcoListMetaData.getDefault(i) != null)
				structuralFeature.setDefaultValueLiteral(jcoListMetaData.getDefault(i));
			addAnnotation(structuralFeature, GenNS_URI, GenNS_DOCUMENTATION_KEY, jcoListMetaData.getDescription(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_DESCRIPTION_KEY,
					jcoListMetaData.getDescription(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_TYPE_KEY,
					Integer.toString(jcoListMetaData.getType(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_TYPE_AS_STRING_KEY,
					jcoListMetaData.getTypeAsString(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_RECORD_TYPE_NAME_KEY,
					jcoListMetaData.getRecordTypeName(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_LENGTH_KEY,
					Integer.toString(jcoListMetaData.getLength(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_BYTE_LENGTH_KEY,
					Integer.toString(jcoListMetaData.getByteLength(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_UNICODE_BYTE_LENGTH_KEY,
					Integer.toString(jcoListMetaData.getUnicodeByteLength(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_DECIMALS_KEY,
					Integer.toString(jcoListMetaData.getDecimals(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_DEFAULT_KEY, jcoListMetaData.getDefault(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_RECORD_FIELD_NAME_KEY,
					jcoListMetaData.getRecordFieldName(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_ABAP_OBJECT_KEY,
					Boolean.toString(jcoListMetaData.isAbapObject(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_NESTED_TYPE1_STRUCTURE_KEY,
					Boolean.toString(jcoListMetaData.isNestedType1Structure(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_STRUCTURE_KEY,
					Boolean.toString(jcoListMetaData.isStructure(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_TABLE_KEY,
					Boolean.toString(jcoListMetaData.isTable(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_IMPORT_KEY,
					Boolean.toString(jcoListMetaData.isImport(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_EXPORT_KEY,
					Boolean.toString(jcoListMetaData.isExport(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_CHANGING_KEY,
					Boolean.toString(jcoListMetaData.isChanging(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_OPTIONAL_KEY,
					Boolean.toString(jcoListMetaData.isOptional(i)));
			eClass.getEStructuralFeatures().add(structuralFeature);
		}
	}
	
	public static EClass getStructureClass(EPackage ePackage, JCoRecordMetaData jcoRecordMetaData) {
		
		// Check package to see if structure class has already been defined.
		EClassifier  structureClass = ePackage.getEClassifier(jcoRecordMetaData.getName());
		
		// Build structure class if not already built.
		if (!(structureClass instanceof EClass)) {

			structureClass = EcoreFactory.eINSTANCE.createEClass();
			ePackage.getEClassifiers().add(structureClass);
			structureClass.setName(jcoRecordMetaData.getName());
			addRecordMetaData(((EClass)structureClass), jcoRecordMetaData);
			((EClass)structureClass).getESuperTypes().add(RfcPackage.eINSTANCE.getStructure());
		}
		return (EClass) structureClass;
	}

	/**
	 * Create and return an {@link EClass} deriving from {@link IndexedRecord} and representing the {@link JCoTable}  
	 * @param ePackage
	 * @param jcoRecordMetaData
	 * @return
	 */
	public static EClass getTableClass(EPackage ePackage, JCoRecordMetaData jcoRecordMetaData) {
		
		// Check package to see if table class has already been defined.
		EClassifier  tableClass = ePackage.getEClassifier(jcoRecordMetaData.getName() + "_TABLE");
		
		// Build table class if not already built.
		if (!(tableClass instanceof EClass)) {
			
			// Create table class and add to package
			tableClass = EcoreFactory.eINSTANCE.createEClass();
			ePackage.getEClassifiers().add(tableClass);
			tableClass.setName(jcoRecordMetaData.getName() + "_TABLE");
			EClass rowStructureClass = getStructureClass(ePackage, jcoRecordMetaData);
			EReference reference = EcoreFactory.eINSTANCE.createEReference();
			reference.setEType(rowStructureClass);
			reference.setContainment(true);
			reference.setName(ROW);
			reference.setLowerBound(0);
			reference.setUpperBound(-1);
			((EClass)tableClass).getEStructuralFeatures().add(reference);
			((EClass)tableClass).getESuperTypes().add(RfcPackage.eINSTANCE.getTable());
		}
		return (EClass) tableClass;
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
				EClass structureClass = getStructureClass(ePackage, jcoSubRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				structuralFeature = reference;
				reference.setEType(structureClass);
				reference.setContainment(true);
				addAnnotation(structuralFeature, eNS_URI, RfcNS_CLASS_NAME_OF_FIELD_KEY, EObject.class.getName());
			} else if (jcoRecordMetaData.isTable(i)) {
				JCoRecordMetaData jcoSubRecordMetaData = jcoRecordMetaData.getRecordMetaData(i);
				EClass tableClass = getTableClass(ePackage, jcoSubRecordMetaData);
				EReference reference = ecoreFactory.createEReference();
				structuralFeature = reference;
				reference.setEType(tableClass);
				reference.setContainment(true);
				addAnnotation(structuralFeature, eNS_URI, RfcNS_CLASS_NAME_OF_FIELD_KEY, EObject.class.getName());
			} else {
				EAttribute attribute = ecoreFactory.createEAttribute();
				structuralFeature = attribute;
				attribute.setEType(getEDataType(jcoRecordMetaData.getType(i)));
				addAnnotation(structuralFeature, eNS_URI, RfcNS_CLASS_NAME_OF_FIELD_KEY, jcoRecordMetaData.getClassNameOfField(i));
			}
			structuralFeature.setName(jcoRecordMetaData.getName(i));
			addAnnotation(structuralFeature, GenNS_URI, GenNS_DOCUMENTATION_KEY, jcoRecordMetaData.getDescription(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_DESCRIPTION_KEY, jcoRecordMetaData.getDescription(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_TYPE_KEY, Integer.toString(jcoRecordMetaData.getType(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_TYPE_AS_STRING_KEY, jcoRecordMetaData.getTypeAsString(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_RECORD_TYPE_NAME_KEY, jcoRecordMetaData.getRecordTypeName(i));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_LENGTH_KEY, Integer.toString(jcoRecordMetaData.getLength(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_BYTE_LENGTH_KEY, Integer.toString(jcoRecordMetaData.getByteLength(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_UNICODE_BYTE_LENGTH_KEY, Integer.toString(jcoRecordMetaData.getUnicodeByteLength(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_DECIMALS_KEY, Integer.toString(jcoRecordMetaData.getDecimals(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_ABAP_OBJECT_KEY, Boolean.toString(jcoRecordMetaData.isAbapObject(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_NESTED_TYPE1_STRUCTURE_KEY, Boolean.toString(jcoRecordMetaData.isNestedType1Structure(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_STRUCTURE_KEY, Boolean.toString(jcoRecordMetaData.isStructure(i)));
			addAnnotation(structuralFeature, eNS_URI, RfcNS_IS_TABLE_KEY, Boolean.toString(jcoRecordMetaData.isTable(i)));
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
			return EcorePackage.Literals.EOBJECT;

		case JCoMetaData.TYPE_TABLE:
			return EcorePackage.Literals.EOBJECT;

		default:
			return EcorePackage.Literals.EBYTE_ARRAY;
		}
	}
}
