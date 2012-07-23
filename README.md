#JBoss SAP JCA Connector

The JBoss SAP JCA Connector is an integration component for the JBoss AS 7 server providing access to SAP Enterprise Information Systems.  Through this connector, application components deployed in JBoss such as session beans and servlets can access data residing in an SAP system.

Be sure to read through this entire document before attempting to build, deploy and work with this connector. It contains the following information:

* [System Requirements](#requirements) List of software required to build and deploy this JCA connector.
* [Building](#building): Instructions for building this JCA Connector.
* [Deploying](#deploying): Instructions for deploying the JCA Connector to the JBoss AS 7 server.
* [License](#license): License

<a id="requirements"></a>
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

<a id="building"></a>
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

<a id="installUnitTestPackage"></a>
### (Optional) Install Unit Test Package

The unit tests of the JCA connector project require that the `ZJBOSS_PACKAGE` package and all of its associated sub-objects be imported into the the SAP system used by the tests. This step can be skipped if the unit are not run during the build. To import the package, perform the following steps:

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
						* `ZJBOSS_GET_COUNTER`
						* `ZJBOSS_INCREMENT_COUNTER`
						* `ZJBOSS_PARAM_TEST`
						* `ZJBOSS_SET_COUNTER`
					* Fields
						* `COUNT`
					* Includes
						* `LZJBOSS_SAP_JCA_TEST_FGTOP`
						* `LZJBOSS_SAP_JCA_TEST_FGUXX`

<a id="configUnitTests"></a>
### (Optional) Configure Unit Tests

The unit tests use the configuration files located in the `<jboss-sap-jca-project-root-directory>/jboss-sap-jca-impl/src/test/resources/META-INF/` directory to connect to the SAP system where the `ZJBOSS_PARAM_TEST` function module was installed. This step can be skipped if the unit are not run during the build. Modify the XXXX-ironjacamar.xml files with values appropriate for your SAP System for the following connection parameters:

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

Execute this command to build and install the project artifacts without running the unit tests: 

		mvn -Dmaven.test.skip=true clean install

<a id="deploying"></a>
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

				mvn jboss-as:deploy

<a id="license"></a>
## License

* [GNU Lesser General Public License Version 2.1](http://www.gnu.org/licenses/lgpl-2.1-standalone.html)

