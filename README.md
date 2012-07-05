#JBoss SAP JCA Connector

The JBoss SAP JCA Connector is an integration component for the JBoss AS 7 server providing access to SAP Enterprise Information Systems.  Through this connector, application components deployed in JBoss such as session beans and servlets can access data residing in an SAP system.

Be sure to read through this entire document before attempting to build, deploy and work with this connector. It contains the following information:

* [System Requirements](#requirements) List of software required to build and deploy this JCA connector.
* [Building](#building): Instructions for building this JCA Connector.
* [Deploying](#deploying): Instructions for deploying the JCA Connector to the JBoss AS 7 server.

<a id"requirements"></a>
## System Requirements

To build, deploy and run this JCA connector, you will need the following:

1. Java 1.6, to run JBoss AS 7 and Maven. You can choose from the following:
	* OpenJDK
	* Oracle Java SE
	* Oracle JRockit

2. Maven 3.0.4 or newer, to build and deploy the JCA connector.
	* If you have not yet installed Maven, see the [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/index.html) for details.
	* if you have installed Maven, you can check the version by typing the following in a command line:
	
			mvn --version
			
3. The JBoss AS 7 distribution ZIP.
	* For information on how to install and run JBoss, please refer to the product documentation.
	
4. SAP Java Connector (JCo) libraries 3.0.8 or newer, to build and run the JCA connector
	* The JCo libraries can be downloaded from the [SAP Service Marketplace](https://service.sap.com/connectors).
	* For information on how to install the JCo libraries, please refer to the instructions below. 
	
5. SAP Netweaver AS ABAP server, to build (optional) and run the JCA connector.
	* A trial version of the SAP Netweaver server can be downloaded from the [SAP Software Download Catalog](http://www.sdn.sap.com/irj/scn/downloads).

<a id"building"></a>
Building
-----------------------

To build the JBoss SAP JCA Connector project you will need to perform the following steps:

* [Install JCo Library](#installJco2Repo): Install JCo library into local Maven repository.
* [Install Unit Test Function Module](#installFuncMod): (Optional) Install function module used by unit tests into your SAP system.
* [Configure Unit Tests](#configUnitTests): (Optional) Configure unit tests to connect to your SAP system.
* [Build Project](#buildProject): Build project artifacts. 

<a id="installJco2Repo"></a>
### Install JCo Library

The JCA connector project requires the sapjco3 library jar  be installed in your local Maven repository in order to build. Use this command to install the jar:

		mvn install:install-file -Dfile=<your-path-to>sapjco3<your-version>.jar -DgroupId=com.sap.conn.jco -DartifactId=sapjco3 -Dversion=<your-version> -Dpackaging=jar

<a id="installFuncMod"></a>
### (Optional) Install Unit Test Function Module

The unit tests of the JCA connector project require that the ZJBOSS\_PARAM\_TEST function module be installed and activated in the the SAP system used by the tests. This step can be skipped if the unit are not run during the build. To install the function module perform the following steps

#### 1. Create and Activate Data Elements and Structures.

The ZJBOSS\_PARAM\_TEST requires the following data elements and data structures be defined in the ABAP dictionary of the SAP system.

##### Data Elements:

Create and activate the following data elements using the ABAP Dictionary Transaction (SE11):

<table border="1" summary="">
<caption>ZJBOSS_PARAM_TEST Data Element Definitions</captions>
<tr><th>Data Element Name</th><th>Data Type</th><th>Length</th><th>Decimal Places</th></tr>
<tr><td>ZJBOSS_CHAR</td><td>CHAR</td><td>10</td></tr>
<tr><td>ZJBOSS_NUM</td><td>NUMC</td><td>10</td></tr>
<tr><td>ZJBOSS_BCD</td><td>DEC</td><td>16</td><td>14</td></tr>
<tr><td>ZJBOSS_BINARY</td><td>RAW</td><td>1</td></tr>
<tr><td>ZJBOSS_BINARY_ARRAY</td><td>RAW</td><td>10</td></tr>
</table>

##### The ZJBOSS_STRUCTURE Date Structure:

Create and activate the ZJBOSS\_STRUCTURE data structure using the ABAP Dictionary Transaction (SE11):

<table border="1" summary="">
<caption>ZJBOSS_STRUCTURE Structure Component Definitions</captions>
<tr><th>Component Name</th><th>Data Type</th></tr>
<tr><td>CHAR_PARAM</td><td>ZJBOSS_CHAR</td></tr>
<tr><td>NUM_PARAM</td><td>ZJBOSS_NUM</td></tr>
<tr><td>INT_PARAM</td><td>INT4</td></tr>
<tr><td>FLOAT_PARAM</td><td>FLTP</td></tr>
<tr><td>BCD_PARAM</td><td>ZJBOSS_BCD</td></tr>
<tr><td>BINARY_PARAM</td><td>ZJBOSS_BINARY</td></tr>
<tr><td>BINARY_ARRAY_PARAM</td><td>ZJBOSS_BINARY_ARRAY</td></tr>
<tr><td>DATE_PARAM</td><td>DATS</td></tr>
<tr><td>TIME_PARAM</td><td>TIMS</td></tr>
<tr><td>STRING_PARAM</td><td>STRING</td></tr>
</table>

##### The  ZJBOSS_LINE_TYPE Data Structure

Create and activate the ZJBOSS\_LINE\_TYPE data structure using the ABAP Dictionary Transaction (SE11):

<table border="1" summary="">
<caption>ZJBOSS_LINE_TYPE Structure Component Definitions</captions>
<tr><th>Component Name</th><th>Data Type</th></tr>
<tr><td>CHAR_PARAM</td><td>ZJBOSS_CHAR</td></tr>
<tr><td>NUM_PARAM</td><td>ZJBOSS_NUM</td></tr>
<tr><td>INT_PARAM</td><td>INT4</td></tr>
<tr><td>FLOAT_PARAM</td><td>FLTP</td></tr>
<tr><td>BCD_PARAM</td><td>ZJBOSS_BCD</td></tr>
<tr><td>BINARY_PARAM</td><td>ZJBOSS_BINARY</td></tr>
<tr><td>BINARY_ARRAY_PARAM</td><td>ZJBOSS_BINARY_ARRAY</td></tr>
<tr><td>DATE_PARAM</td><td>DATS</td></tr>
<tr><td>TIME_PARAM</td><td>TIMS</td></tr>
</table>

#### 2. Create and Activate the ZJBOSS_FUNCTION_GROUP.

The ZJBOSS\_FUNCTION\_GROUP function group will contain the function module created in the next step. Start the SAP Object Navigator Transaction (SE80):

* Select 'Function Group' in the drop down. 
* Enter 'ZJBOSS\_FUNCTION\_GROUP' in the text box below the drop down
* Select the browse icon to the right of the text box.
* In the 'Create Object' dialog box select 'Yes' to create the function group.
* In the 'Create Function Group' dialog box enter a description in the 'Short text' text field and select 'Save'.
* In the 'Create Object Directory Entry' dialog box select 'Local Object'.

#### 3. Create and Activate the ZJBOSS_PARAM_TEST

The ZJBOSS\_PARAM\_TEST function module is used to test the passing of parameters between the JBOSS SAP JCA Connection and the SAP system. Start the SAP Function Builder Transaction (SE11):

* Enter 'ZJBOSS\_PARAM\_TEST' in the 'Function Module' text box and select 'Create'.
* On the 'Create Function Module' dialog box enter 'ZJBOSS\_FUNCTION\_GROUP' in the 'Function group' text box and a description in the 'Short text' text box.
* If 'Information' dialog box appears select check box.

##### a. Create Import Parameters

* Select the 'Import' tab and create the following import parameters to the function module:

<table border="1" summary="">
<caption>ZJBOSS_PARAM_TEST Import Parameters</captions>
<tr><th>Parameter Name</th><th>Associated Type</th></tr>
<tr><td>IMPORT_CHAR_PARAM</td><td>ZJBOSS_CHAR</td></tr>
<tr><td>IMPORT_NUM_PARAM</td><td>ZJBOSS_NUM</td></tr>
<tr><td>IMPORT_INT_PARAM</td><td>I</td></tr>
<tr><td>IMPORT_FLOAT_PARAM</td><td>F</td></tr>
<tr><td>IMPORT_BCD_PARAM</td><td>ZJBOSS_BCD</td></tr>
<tr><td>IMPORT_BINARY_PARAM</td><td>ZJBOSS_BINARY</td></tr>
<tr><td>IMPORT_BINARY_ARRAY_PARAM</td><td>ZJBOSS_BINARY_ARRAY</td></tr>
<tr><td>IMPORT_DATE_PARAM</td><td>D</td></tr>
<tr><td>IMPORT_TIME_PARAM</td><td>T</td></tr>
<tr><td>IMPORT_STRING_PARAM</td><td>STRING</td></tr>
<tr><td>IMPORT_STRUCTURE_PARAM</td><td>ZJBOSS_STRUCTURE</td></tr>
</table>

##### b. Create Export Parameters

* Select the 'Export' tab and create the following export parameters to the function module:

<table border="1" summary="">
<caption>ZJBOSS_PARAM_TEST Export Parameters</captions>
<tr><th>Parameter Name</th><th>Associated Type</th></tr>
<tr><td>EXPORT_CHAR_PARAM</td><td>ZJBOSS_CHAR</td></tr>
<tr><td>EXPORT_NUM_PARAM</td><td>ZJBOSS_NUM</td></tr>
<tr><td>EXPORT_INT_PARAM</td><td>I</td></tr>
<tr><td>EXPORT_FLOAT_PARAM</td><td>F</td></tr>
<tr><td>EXPORT_BCD_PARAM</td><td>ZJBOSS_BCD</td></tr>
<tr><td>EXPORT_BINARY_PARAM</td><td>ZJBOSS_BINARY</td></tr>
<tr><td>EXPORT_BINARY_ARRAY_PARAM</td><td>ZJBOSS_BINARY_ARRAY</td></tr>
<tr><td>EXPORT_DATE_PARAM</td><td>D</td></tr>
<tr><td>EXPORT_TIME_PARAM</td><td>T</td></tr>
<tr><td>EXPORT_STRING_PARAM</td><td>STRING</td></tr>
<tr><td>EXPORT_STRUCTURE_PARAM</td><td>ZJBOSS_STRUCTURE</td></tr>
</table>

##### c. Create Changing Parameters

* Select the 'Changing' tab and create the following changing parameters to the function module:

<table border="1" summary="">
<caption>ZJBOSS_PARAM_TEST Changing Parameters</captions>
<tr><th>Parameter Name</th><th>Associated Type</th></tr>
<tr><td>CHANGING_CHAR_PARAM</td><td>ZJBOSS_CHAR</td></tr>
<tr><td>CHANGING_NUM_PARAM</td><td>ZJBOSS_NUM</td></tr>
<tr><td>CHANGING_INT_PARAM</td><td>I</td></tr>
<tr><td>CHANGING_FLOAT_PARAM</td><td>F</td></tr>
<tr><td>CHANGING_BCD_PARAM</td><td>ZJBOSS_BCD</td></tr>
<tr><td>CHANGING_BINARY_PARAM</td><td>ZJBOSS_BINARY</td></tr>
<tr><td>CHANGING_BINARY_ARRAY_PARAM</td><td>ZJBOSS_BINARY_ARRAY</td></tr>
<tr><td>CHANGING_DATE_PARAM</td><td>D</td></tr>
<tr><td>CHANGING_TIME_PARAM</td><td>T</td></tr>
<tr><td>CHANGING_STRING_PARAM</td><td>STRING</td></tr>
<tr><td>CHANGING_STRUCTURE_PARAM</td><td>ZJBOSS_STRUCTURE</td></tr>
</table>

##### d. Create Table Parameters

* Select the 'Tables' tab and create the following table parameter to the function module:

<table border="1" summary="">
<caption>ZJBOSS_PARAM_TEST Table Parameters</captions>
<tr><th>Parameter Name</th><th>Associated Type</th></tr>
<tr><td>TABLE_TABLE_PARAM</td><td>ZJBOSS_LINE_TYPE</td></tr>
</table>

##### e. Create Exceptions 

* Select the 'Exceptions' tab and create the following exceptions for the function module:

<table border="1" summary="">
<caption>ZJBOSS_PARAM_TEST Exceptions</captions>
<tr><th>Parameter Name</th><th>Short Text</th></tr>
<tr><td>CHANGING_CHAR_PARAM_EX</td><td>Did not receive expected CHANGING_CHAR_PARAM value</td></tr>
<tr><td>CHANGING_NUM_PARAM_EX</td><td>Did not receive expected CHANGING_NUM_PARAM value</td></tr>
<tr><td>CHANGING_INT_PARAM_EX</td><td>Did not receive expected CHANGING_INT_PARAM value</td></tr>
<tr><td>CHANGING_FLOAT_PARAM_EX</td><td>Did not receive expected CHANGING_FLOAT_PARAM value</td></tr>
<tr><td>CHANGING_BCD_PARAM_EX</td><td>Did not receive expected CHANGING_BCD_PARAM value</td></tr>
<tr><td>CHANGING_BINARY_PARAM_EX</td><td>Did not receive expected CHANGING_BINARY_PARAM value</td></tr>
<tr><td>CHANGING_BINARY_ARRAY_PARAM_EX</td><td>Did not receive expected CHANGING_BINARY_ARRAY_PARAM value</td></tr>
<tr><td>CHANGING_DATE_PARAM_EX</td><td>Did not receive expected CHANGING_DATE_PARAM value</td></tr>
<tr><td>CHANGING_TIME_PARAM_EX</td><td>Did not receive expected CHANGING_TIME_PARAM value</td></tr>
<tr><td>CHANGING_STRING_PARAM_EX</td><td>Did not receive expected CHANGING_STRING_PARAM value</td></tr>
<tr><td>CHANGING_STRUCTURE_CHAR_EX</td><td>Did not receive expected CHAR_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_NUM_EX</td><td>Did not receive expected NUM_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_INT_EX</td><td>Did not receive expected INT_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_FLOAT_EX</td><td>Did not receive expected FLOAT_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_BCD_EX</td><td>Did not receive expected BCD_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_BINARY_EX</td><td>Did not receive expected BINARY_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_BIN_ARRAY_EX</td><td>Did not receive expected BINARY_ARRAY_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_DATE_EX</td><td>Did not receive expected DATE_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_TIME_EX</td><td>Did not receive expected TIME_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
<tr><td>CHANGING_STRUCTURE_STR_EX</td><td>Did not receive expected STRING_PARAM value in CHANGING_STRUCTURE_PARAM</td></tr>
</table>

##### f. Enter Function Module Source Code

* Select the 'Source code' tab.
* Add the source code contained in the file *project-root-dir*/jboss-sap-jca-impl/src/test/resources/ZJBOSS_PARAM_TEST.txt.

##### g. Save and Activate Function Module

* Select 'Save' in the 'Function Module' menu to save your changes. 
* Select 'Activate' in the 'Function Module' menu to activate the function module

<a id="configUnitTests"></a>
### (Optional) Configure Unit Tests

The unit tests use the configuration files located in the *project-root-dir*/jboss-sap-jca-impl/src/test/resources/META-INF/ directory to connect to the SAP system where the ZJBOSS\_PARAM\_TEST function module was installed. This step can be skipped if the unit are not run during the build. Modify the XXXX-ironjacamar.xml files with values appropriate for your SAP System for the following connection parameters:

* *ashost* - the hostname or ip address of SAP system
* *sysnr* - the system number of SAP system
* *client* - the client number used to connect to SAP system
* *user* - the user name used to connect to SAP system
* *passwd* - the password used to connect to SAP system
* *lang* - the language to use for connection session

<a id="buildProject"></a>
### Build Project

Build and install the JCA connector project artifacts in your local Maven repository. From the root directory of the JBoss SAP JCA Connector project execute the following command to build, test and install the projects artifacts:

		mvn clean install

Execute this command to build and install the project artifacts without running the unit test: 

		mvn -Dmaven.test.skip=true clean install

<a id"deploying"></a>
## Deploying

To deploy the JBoss SAP JCA Connector project you will need to perform the following steps:

* [Install JCo Module](#installJcoModule): Install JCo Module in JBoss AS7 to expose JCo library to JEE components.
* [Install JBoss SAP JCA Module](#installJcaModule): Install JBoss SAP JCA Module in JBoss AS7 to expose JBoss SAP JCA Common Client Interfaces to JEE components.
* [Configure JBoss AS7 Native Library Path](#configNativeLibPath): Configure JBoss AS7 native library path in order for JBoss to load JCo native libraries. 
* [Deploy JBoss SAP JCA Connector](#deployJcaConnector): Deploy  the JBoss SAP JCA connector to JBoss AS7.

<a id="installJcoModule"></a>
### Install JCo Module

The JBoss SAP JCA connector requires that the JCo library be exposed in the JBoss AS7 environment as a module in order to link to it at runtime. To install the module:

* Create the module directory `<jboss-as-root-directory>/modules/com/sap/conn/jco/main`.
* In the module directory create the file **module.xml** with the following contents:

				<?xml version="1.0" encoding="UTF-8"?>
				<module xmlns="urn:jboss:module:1.1" name="com.sap.conn.jco">
				    <resources>
				        <resource-root path="sapjco3.jar"/>
				    </resources>
				</module>

* Copy the `sapjco3.jar` from you local Maven repository to the module directory.

<a id="installJcaModule"></a>
### Install JBoss SAP JCA Module

The JBoss SAP JCA connector Common Client Interfaces need to be exposed in the JBoss AS7 environment as a module in order for JEE components to link to them at runtime. To install the module:

* Create the module directory `<jboss-as-root-directory>/modules/org/jboss/jca/adapters/sap/main`.
* In the module directory create the file **module.xml** with the following contents:

				<?xml version="1.0" encoding="UTF-8"?>
				<module xmlns="urn:jboss:module:1.1" name="org.jboss.jca.adapters.sap">
				    <dependencies>
				        <module name="javax.resource.api" export="true"/>
				    </dependencies>
				    <resources>
				        <resource-root path="jboss-sap-jca-api-1.0.0-SNAPSHOT.jar"/>
				    </resources>
				</module>
* Copy the `jboss-sap-jca-api-1.0.0-SNAPSHOT.jar` from you local Maven repository to the module directory.

<a id="configNativeLibPath"></a>
### Configure JBoss AS7 Native Library Path

The native library path of the JBoss AS7 server needs to configured in order for the SAP Java Connector native library to loaded at runtime. To configure the native library path:

* Create the native library directory `<jboss-as-root-directory>/bin/native`.
* Copy the SAP Java Connector native library into the native library directory.
* Add the following line to the bottom of the `standalone.conf` file in the `<jboss-as-root-directory>/bin` directory:

				JAVA_OPTS="$JAVA_OPTS -Djava.library.path=<jboss-as-root-directory>/bin/native"

* Restart the JBoss AS7 server.

<a id="deployJcaConnector"></a>
### Deploy JBoss SAP JCA Connector

Deploy the JCA connector to your JBoss AS7 server. From the directory `<jboss-sap-jca-project-root-directory>/jboss-sap-jca-impl` execute the following command:

				mvn jboss-as:deploy;

## License

* [GNU Lesser General Public License Version 2.1](http://www.gnu.org/licenses/lgpl-2.1-standalone.html)

