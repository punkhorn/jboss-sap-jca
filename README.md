#JBoss SAP JCA Connector

The JBoss SAP JCA Connector is an integration component for the JBoss® AS 7 server providing access to SAP® Enterprise Information Systems.  Through this connector, application components deployed in JBoss such as session beans and servlets can access data residing in an SAP system.

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
	
5. SAP Netweaver AS ABAP server, to run the JCA connector.
	* A trial version of the SAP Netweaver server can be downloaded from the [SAP Software Download Catalog](http://www.sdn.sap.com/irj/scn/downloads).

<a id="building"></a>
Building
-----------------------

To build the JBoss SAP JCA Connector project you will need to perform the following steps:

* [Install JCo Library](#installJco2Repo): Install JCo library into local Maven repository.
* [Build Project](#buildProject): Build project artifacts. 

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
* Create the the module native library directory  `<jboss-as-root-directory>/modules/com/sap/conn/jco/main/lib/<osname>-<cpuname>/`.
	* Where `<osname>` corresponds to the operating system JBoss AS is installed on; is one of : `linux`, `macosx`, or `win`.
	* Where `<cpuname>` corresponds to the CPU architecture of the machine JBoss AS is installed on; is one of : `i686` or `x86_64`.
	
* Copy the SAP Java Connector native library into the module native library directory.

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

<a id="deployJcaConnector"></a>
### Deploy JBoss SAP JCA Connector

Deploy the JCA connector to your JBoss AS7 server. From the directory `<jboss-sap-jca-project-root-directory>/jboss-sap-jca-impl` execute the following command:

				mvn jboss-as:deploy

<a id="license"></a>
## License

* [GNU Lesser General Public License Version 2.1](http://www.gnu.org/licenses/lgpl-2.1-standalone.html)

