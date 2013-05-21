/**
 */
package org.jboss.sap.rfc;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.jboss.sap.rfc.RfcFactory
 * @model kind="package"
 * @generated
 */
public interface RfcPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "rfc";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sap.jboss.org/rfc";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "rfc";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RfcPackage eINSTANCE = org.jboss.sap.rfc.impl.RfcPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.jboss.sap.rfc.impl.RepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.sap.rfc.impl.RepositoryImpl
	 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getRepository()
	 * @generated
	 */
	int REPOSITORY = 0;

	/**
	 * The feature id for the '<em><b>Destination Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__DESTINATION_NAME = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__NAME = 1;

	/**
	 * The feature id for the '<em><b>Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY__GROUPS = 2;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPOSITORY_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.jboss.sap.rfc.impl.GroupImpl <em>Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.sap.rfc.impl.GroupImpl
	 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getGroup()
	 * @generated
	 */
	int GROUP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Repository</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__REPOSITORY = 2;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP__FUNCTIONS = 3;

	/**
	 * The number of structural features of the '<em>Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUP_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.jboss.sap.rfc.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.sap.rfc.impl.FunctionImpl
	 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__DESCRIPTION = 1;

	/**
	 * The feature id for the '<em><b>Group</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__GROUP = 2;

	/**
	 * The feature id for the '<em><b>Request</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__REQUEST = 3;

	/**
	 * The feature id for the '<em><b>Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__RESPONSE = 4;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 5;


	/**
	 * The meta object id for the '{@link org.jboss.sap.rfc.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.sap.rfc.impl.TableImpl
	 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 3;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 0;


	/**
	 * The meta object id for the '{@link org.jboss.sap.rfc.impl.StructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.jboss.sap.rfc.impl.StructureImpl
	 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getStructure()
	 * @generated
	 */
	int STRUCTURE = 4;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURE_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.jboss.sap.rfc.Repository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see org.jboss.sap.rfc.Repository
	 * @generated
	 */
	EClass getRepository();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.sap.rfc.Repository#getDestinationName <em>Destination Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Destination Name</em>'.
	 * @see org.jboss.sap.rfc.Repository#getDestinationName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_DestinationName();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.sap.rfc.Repository#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.jboss.sap.rfc.Repository#getName()
	 * @see #getRepository()
	 * @generated
	 */
	EAttribute getRepository_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.sap.rfc.Repository#getGroups <em>Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Groups</em>'.
	 * @see org.jboss.sap.rfc.Repository#getGroups()
	 * @see #getRepository()
	 * @generated
	 */
	EReference getRepository_Groups();

	/**
	 * Returns the meta object for class '{@link org.jboss.sap.rfc.Group <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Group</em>'.
	 * @see org.jboss.sap.rfc.Group
	 * @generated
	 */
	EClass getGroup();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.sap.rfc.Group#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.jboss.sap.rfc.Group#getName()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.sap.rfc.Group#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.jboss.sap.rfc.Group#getDescription()
	 * @see #getGroup()
	 * @generated
	 */
	EAttribute getGroup_Description();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.sap.rfc.Group#getRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Repository</em>'.
	 * @see org.jboss.sap.rfc.Group#getRepository()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Repository();

	/**
	 * Returns the meta object for the containment reference list '{@link org.jboss.sap.rfc.Group#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see org.jboss.sap.rfc.Group#getFunctions()
	 * @see #getGroup()
	 * @generated
	 */
	EReference getGroup_Functions();

	/**
	 * Returns the meta object for class '{@link org.jboss.sap.rfc.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see org.jboss.sap.rfc.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.sap.rfc.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.jboss.sap.rfc.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.jboss.sap.rfc.Function#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.jboss.sap.rfc.Function#getDescription()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Description();

	/**
	 * Returns the meta object for the container reference '{@link org.jboss.sap.rfc.Function#getGroup <em>Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Group</em>'.
	 * @see org.jboss.sap.rfc.Function#getGroup()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Group();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.sap.rfc.Function#getRequest <em>Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Request</em>'.
	 * @see org.jboss.sap.rfc.Function#getRequest()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Request();

	/**
	 * Returns the meta object for the containment reference '{@link org.jboss.sap.rfc.Function#getResponse <em>Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Response</em>'.
	 * @see org.jboss.sap.rfc.Function#getResponse()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Response();

	/**
	 * Returns the meta object for class '{@link org.jboss.sap.rfc.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see org.jboss.sap.rfc.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for class '{@link org.jboss.sap.rfc.Structure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see org.jboss.sap.rfc.Structure
	 * @generated
	 */
	EClass getStructure();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RfcFactory getRfcFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.jboss.sap.rfc.impl.RepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.sap.rfc.impl.RepositoryImpl
		 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getRepository()
		 * @generated
		 */
		EClass REPOSITORY = eINSTANCE.getRepository();

		/**
		 * The meta object literal for the '<em><b>Destination Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__DESTINATION_NAME = eINSTANCE.getRepository_DestinationName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPOSITORY__NAME = eINSTANCE.getRepository_Name();

		/**
		 * The meta object literal for the '<em><b>Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPOSITORY__GROUPS = eINSTANCE.getRepository_Groups();

		/**
		 * The meta object literal for the '{@link org.jboss.sap.rfc.impl.GroupImpl <em>Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.sap.rfc.impl.GroupImpl
		 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getGroup()
		 * @generated
		 */
		EClass GROUP = eINSTANCE.getGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__NAME = eINSTANCE.getGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GROUP__DESCRIPTION = eINSTANCE.getGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Repository</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__REPOSITORY = eINSTANCE.getGroup_Repository();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GROUP__FUNCTIONS = eINSTANCE.getGroup_Functions();

		/**
		 * The meta object literal for the '{@link org.jboss.sap.rfc.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.sap.rfc.impl.FunctionImpl
		 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__DESCRIPTION = eINSTANCE.getFunction_Description();

		/**
		 * The meta object literal for the '<em><b>Group</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__GROUP = eINSTANCE.getFunction_Group();

		/**
		 * The meta object literal for the '<em><b>Request</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__REQUEST = eINSTANCE.getFunction_Request();

		/**
		 * The meta object literal for the '<em><b>Response</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__RESPONSE = eINSTANCE.getFunction_Response();

		/**
		 * The meta object literal for the '{@link org.jboss.sap.rfc.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.sap.rfc.impl.TableImpl
		 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '{@link org.jboss.sap.rfc.impl.StructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.jboss.sap.rfc.impl.StructureImpl
		 * @see org.jboss.sap.rfc.impl.RfcPackageImpl#getStructure()
		 * @generated
		 */
		EClass STRUCTURE = eINSTANCE.getStructure();

	}
	
	/**
	 * Details key for a parameter list entry annotation providing the description of the underlying JCo data field represented by the annotated parameter list entry. The details value is the description of the parameter list entry and its underlying JCo data field. 
	 */
	public static final String RfcNS_DESCRIPTION_KEY = "description";

	/**
	 * Details key for a parameter list entry annotation providing the fully-qualified Java classname of the annotated parameter list entry. The details value is the fully-qualified Java classname of the parameter list entry. 
	 */
	public static final String RfcNS_CLASS_NAME_OF_FIELD_KEY = "classNameOfField";

	/**
	 * Details key for a parameter list entry annotation indicating the table, structure or data element name of the underlying JCo data field represented by the annotated parameter list entry. The details value is the name of the table, structure or data element of the underlying JCo data field. The details values is <code>null</code> if the data element name is unavailable. 
	 */
	public static final String RfcNS_RECORD_TYPE_NAME_KEY = "recordTypeName";

	/**
	 * Details key for a parameter list entry annotation providing the JCo data type of the underlying data field represented by the annotated parameter list entry. The details value is the JCo data type of the underlying data field represented by the parameter list entry. 
	 */
	public static final String RfcNS_TYPE_KEY = "type";

	/**
	 * Details key for a parameter list entry annotation providing the String representation of the JCo data type of the underlying data field represented by the annotated parameter list entry. The details value is the String representation of the JCo data type of the underlying data field represented by the parameter list entry. 
	 */
	public static final String RfcNS_TYPE_AS_STRING_KEY = "typeAsString";

	/**
	 * Details key for a parameter list entry annotation providing the length of the underlying data field for Unicode layout represented by the annotated parameter list entry. The details value is the length of the underlying data field for Unicode layout represented by the parameter list entry. 
	 */
	public static final String RfcNS_UNICODE_BYTE_LENGTH_KEY = "unicodeByteLength";

	/**
	 * Details key for a parameter list entry annotation providing the byte length of the underlying data field for Non-Unicode layout represented by the annotated parameter list entry. The details value is the byte length of the underlying data field for Non-Unicode layout represented by the parameter list entry. 
	 */
	public static final String RfcNS_BYTE_LENGTH_KEY = "byteLength";

	/**
	 * Details key for a parameter list entry annotation providing the max length of the underlying data field represented by the annotated parameter list entry. The details value is the max length of the underlying data field represented by the parameter list entry.
	 * 
	 * <ul>
	 * <li><p>For character based data element types the length is the char length.
	 * <li><p>For <em><b>STRING</b></em> and <em><b>XSTRING</b></em> data element types the length is <em><b>0</b></em>.</li> 
	 * <li><p>For <em><b>STRUCTURE</b></em> and <em><b>TABLE</b></em> data element types the length is <em><b>0</b></em>.</li>
	 * <li><p>For numerical based data element types the length is the byte length.
	 * </ul> 
	 */
	public static final String RfcNS_LENGTH_KEY = "length";

	/**
	 * Details key for a parameter list entry annotation providing the number of decimals in the the underlying data field represented by the annotated parameter list entry. The details value is the number of decimals in the the underlying data field represented by the parameter list entry.
	 * 
	 * <p>The details value is possibly non-zero only for record entries whose underlying data field has the JCo data type <em><b>BCD</b></em> or <em><b>FLOAT</b></em>.
	 */
	public static final String RfcNS_DECIMALS_KEY = "decimals";

	/**
	 * Details key for a parameter list entry annotation providing the default value of the annotated parameter list entry. The details value is the default value of the parameter list entry.
	 */
	public static final String RfcNS_DEFAULT_KEY = "default";

	/**
	 * Details key for a parameter list entry annotation providing the field name in an underlying JCo structure or table represented by the annotated parameter list entry. The details value is the name of the field in the underlying JCo structure or table if the JCo parameter represented by the entry is defined by referencing that field. The details values is <code>null</code> otherwise. 
	 */
	public static final String RfcNS_RECORD_FIELD_NAME_KEY = "recordFieldName";

	/**
	 * Details key for a parameter list entry annotation indicating whether the annotated parameter list entry represents an underlying JCo <code>ABAP Object</code>. The details value is <code>true</code> if the parameter list entry represents an <code>ABAP Object</code>; <code>false</code> otherwise. 
	 */
	public static final String RfcNS_IS_ABAP_OBJECT_KEY = "isAbapObject";

	/**
	 * Details key for a parameter list entry annotation indicating whether the annotated parameter list entry represents an underlying <code>TYPE1</code> JCo structure. The details value is <code>true</code> if the parameter list entry represents a <code>TYPE1</code> structure; <code>false</code> otherwise. 
	 */
	public static final String RfcNS_IS_NESTED_TYPE1_STRUCTURE_KEY = "isNestedType1Structure";

	/**
	 * Details key for a parameter list entry annotation indicating whether the annotated parameter list entry is a <em><b>structure</b></em> type entry; i.e. is a {@link MappedRecord}. The details value is <code>true</code> if the parameter list entry is a {@link MappedRecord}; <code>false</code> otherwise. 
	 */
	public static final String RfcNS_IS_STRUCTURE_KEY = "isStructure";

	/**
	 * Details key for a parameter list entry annotation indicating whether the annotated parameter list entry is a <em><b>table</b></em> type entry; i.e. is an {@link IndexedRecord}. The details value is <code>true</code> if the parameter list entry is a {@link IndexedRecord}; <code>false</code> otherwise.	 
	 */
	public static final String RfcNS_IS_TABLE_KEY = "isTable";

	/**
	 * Details key for a parameter list entry annotation indicating whether the underlying data field represented by the annotated parameter list entry is an <em><b>import</b></em> parameter. The details value is <code>true</code> if the underlying data field is an import parameter; <code>false</code> otherwise.	 
	 */
	public static final String RfcNS_IS_IMPORT_KEY = "isImport";

	/**
	 * Details key for a parameter list entry annotation indicating whether the underlying data field represented by the annotated parameter list entry is an <em><b>export</b></em> parameter. The details value is <code>true</code> if the underlying data field is an export parameter; <code>false</code> otherwise.	 
	 */
	public static final String RfcNS_IS_EXPORT_KEY = "isExport";

	/**
	 * Details key for a parameter list entry annotation indicating whether the underlying data field represented by the annotated parameter list entry is a <em><b>changing</b></em> parameter. The details value is <code>true</code> if the underlying data field is a changing parameter; <code>false</code> otherwise.	 
	 */
	public static final String RfcNS_IS_CHANGING_KEY = "isChanging";

	/**
	 * Details key for a parameter list entry annotation indicating whether the underlying data field represented by the annotated parameter list entry is an <em><b>exception</b></em>. The details value is <code>true</code> if the underlying data field is an exception; <code>false</code> otherwise.	 
	 */
	public static final String RfcNS_IS_EXCEPTION_KEY = "isException";

	/**
	 * Details key for a parameter list entry annotation indicating whether the underlying data field represented by the annotated parameter list entry is an <em><b>optional</b></em> parameter. The details value is <code>true</code> if the underlying data field is an optional parameter; <code>false</code> otherwise.	 
	 */
	public static final String RfcNS_IS_OPTIONAL_KEY = "isOptional";


} //RfcPackage
