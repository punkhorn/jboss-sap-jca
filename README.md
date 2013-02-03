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

* [Install JCo Libraries](#installJco2Repo): Install JCo libraries into local Maven repository.
* [Build Project](#buildProject): Build project artifacts. 

<a id="installJco2Repo"></a>
### Install JCo Libraries

The JCA connector project requires the sapjco3 library jar and its native library be installed in your local Maven repository in order to build. Use this command to install the jar:

		mvn install:install-file -Dfile=<your-path-to>/sapjco3<your-version>.jar -DgroupId=com.sap.conn.jco -DartifactId=sapjco3 -Dversion=<your-version> -Dpackaging=jar

Use this command to install the native library:

		mvn install:install-file -Dfile=<your-path-to>/libsapjco3.<your-version>.<your-platform-package-type> -DgroupId=com.sap.conn.jco -DartifactId=sapjco3 -Dversion=<your-version> -Dpackaging=<your-platform-package-type> 

Where `<your-platform-package-type>` will correspond to the file extension of the native library and will be one of `dll`, `so`, or `jnilib`.

<a id="buildProject"></a>
### Build Project

Build and install the JCA connector project artifacts in your local Maven repository. From the root directory of the JBoss SAP JCA Connector project execute the following command to build, test and install the projects artifacts:

		mvn clean install

Execute this command to build and install the project artifacts without running the unit tests: 

		mvn -Dmaven.test.skip=true clean install

<a id="deploying"></a>
## Deploying

To deploy the JBoss SAP JCA Connector project you will need to perform the following steps:

* [Install JBoss AS7 Modules](#installModules): Install the JCo and JBoss SAP JCA Modules into JBoss AS7 to expose JCo library to JEE components.
* [Install JBoss SAP JCA Module](#installJcaModule): Install JBoss SAP JCA Module in JBoss AS7 to expose JBoss SAP JCA Common Client Interfaces to JEE components.
* [Deploy JBoss SAP JCA Connector](#deployJcaConnector): Deploy  the JBoss SAP JCA connector to JBoss AS7.

<a id="installModules"></a>
### Install JBoss AS7 Modules

The JBoss SAP JCA connector requires that the JCo library be exposed in the JBoss AS7 environment as a module in order to link to it at runtime. Similarly, the JBoss SAP JCA Connector Common Client Interfaces need to be exposed in the JBoss AS7 environment as a module in order for JEE components to link to them at runtime.

The directory structures and contents for both modules are created during the project build. To install the modules:

* Copy the **contents** of the  `<project.basedir>/jboss-sap-jca-connector/target/as7module` directory into the `<jboss-as-root-directory>/modules` directory. 

<a id="deployJcaConnector"></a>
### Deploy JBoss SAP JCA Connector

Deploy the JCA connector to your JBoss AS7 server. From the directory `<jboss-sap-jca-project-root-directory>/jboss-sap-jca-rar` execute the following command:

				mvn jboss-as:deploy

<a id="license"></a>
## License

* [GNU Lesser General Public License Version 2.1](http://www.gnu.org/licenses/lgpl-2.1-standalone.html)

