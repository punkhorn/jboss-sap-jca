<a id="installUnitTestPackage"></a>
### (Optional) Install Integration Test Package

The integration tests of the JCA connector project require that the `ZJBOSS_PACKAGE` package and all of its associated sub-objects be imported into the the SAP system used by the tests. To import the package, perform the following steps:

#### 1. Determine the Location of Transport Directory

The `ZJBOSS_PACKAGE` and all its associated sub-objects are provided in a transport request. This request is packaged as two files that need to be deployed to the `transport directory` of the SAP system into which the objects will be imported. To determine the location of the transport directory, run the SAP Directories Transaction (AL11) and scroll down to the entry `DIR_TRANS` in the table and note the directory location.

#### 2. Deploy the Command and Data Files of the Transport Request

The transport request is packaged in a command file and data file located respectively in the `cofiles` and `data` directories of the `<jboss-sap-jca-project-root-directory>/jboss-sap-jca-impl/src/test/resources/trans` directory. Copy these files to the corresponding sub-directories of the SAP system's transport directory. 

#### 3. Import the Transport Request into the SAP System

To import the transport request into the SAP System:

* Execute the Transport Management System Transaction (STMS).
* Select the `Overview` -> `Imports` menu item. 
* On the `Import Overview` screen , select the import queue to be used for the import and then select the `Import Queue` -> `Display` menu item. 
* On the `Import Queue` screen, select the `Extras` -> `Other Requests` -> `Add` menu item. 
* In the `Add Transport Request to Import Queue` dialog box select the `Transp. Request` text field and click the adjacent search box.
* In the `Transport requests` dialog box select the Request/Task with the corresponding number of the deployed command file and click the continue button.
* Back in the `Add Transport Request to Import Queue` dialog box click the continue button.
* Back on the `Import Queue` screen, select the newly added transport request and then select the `Request` -> `Import` menu item. 
* After the import has completed, the `ZJBOSS_PACKAGE` contents can be viewed in the `Object Navigator Transaction` (SE80) and should contain the following objects:

	* `ZJBOSS_PACKAGE`
		* Dictionary Objects
			* Database Tables
				* `ZJBOSS_COUNTERS`
			* Table Types
				* `ZJBOSS_TABLE`
			* Structures
				* `ZJBOSS_LINE_TYPE`
				* `ZJBOSS_STRUCTURE`
			* Data Elements
				* `ZJBOSS_BCD`
				* `ZJBOSS_BINARY`
				* `ZJBOSS_BINARY_ARRAY`
				* `ZJBOSS_CHAR`
				* `ZJBOSS_FLOAT`
				* `ZJBOSS_NUM`
		* Function Groups
			* `ZJBOSS_SAP_JCA_TEST_FG`
				* Function Modules
					* `ZJBOSS_COUNTERS_CREATE`
					* `ZJBOSS_COUNTERS_CREATE_UPDATE`
					* `ZJBOSS_COUNTERS_DELETE`
					* `ZJBOSS_COUNTERS_DELETE_UPDATE`
					* `ZJBOSS_COUNTERS_READ`
					* `ZJBOSS_COUNTERS_UPDATE`
					* `ZJBOSS_COUNTERS_UPDATE_UPDATE`
					* `ZJBOSS_GET_COUNTER`
					* `ZJBOSS_INCREMENT_COUNTER`
					* `ZJBOSS_PARAM_TEST`
					* `ZJBOSS_SET_COUNTER`
				* Dictionary Structures
					* `ZJBOSS_COUNTERS`
				* Fields
					* `COUNT`
					* `IT_ZJBOSS_COUNTERS_BUFFER`
					* `I_ZJBOSS_COUNTERS`
					* `WA_ZJBOSS_COUNTERS`
				* Subroutines
					* `BUFFERSAVE_COUNTERS`
				* Includes
					* `LZJBOSS_SAP_JCA_TEST_FGTOP`
					* `LZJBOSS_SAP_JCA_TEST_FGUXX`

<a id="configIntegrationTests"></a>
### (Optional) Configure Integration Tests

The integration tests use the configuration files located in the `<jboss-sap-jca-project-root-directory>/jboss-sap-jca-impl/src/test/resources/META-INF/` directory to connect to the SAP system where the `ZJBOSS_PARAM_TEST` function module was installed. Modify the XXXX-ironjacamar.xml files with values appropriate for your SAP System for the following connection parameters:

* *ashost* - the hostname or ip address of SAP system
* *sysnr* - the system number of SAP system
* *client* - the client number used to connect to SAP system
* *user* - the user name used to connect to SAP system
* *passwd* - the password used to connect to SAP system
* *lang* - the language to use for connection session
