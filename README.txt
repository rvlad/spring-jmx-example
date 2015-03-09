Monitoring by Newrelic:

	For monitoring the server metrics, install the server monitor package following the next steps:
	
		echo deb http://apt.newrelic.com/debian/ newrelic non-free >> /etc/apt/sources.list.d/newrelic.list
		wget -O- https://download.newrelic.com/548C16BF.gpg | apt-key add -
		apt-get update


		-- Install the server monitor package
		apt-get install newrelic-sysmond

		-- Set the license_key obtained from newrelic web page
		nrsysmond-config --set license_key=9e63604fb8be432ac2b1ce4ca6ff9dd2f6a3d8e1

		-- Start the service
		/etc/init.d/newrelic-sysmond start


	For monitoring the application metrics, install the newrelic-java-3.14.0.zip.
	Modify the settings in newrelic.yml, including the correct license key and the application name.
	Add to application launching script the java agent property (Setting the installation path of newrelic package):
		-If is launched from eclipse, set to the run configuration's VM arguments the next param
			-javaagent:newrelic/newrelic.jar
		
		-If is launched form command line, include this param in the execution line.
			java -javaagent:/home/naevatec/newrelic/newrelic.jar -jar clearslide-desktop-sharing-server-1.0.0-20150302-SNAPSHOT.jar
			
	For JMX monitoring add the corresponding .yml file to extensions dir, including the correct JMX component definition.
	
	After runs the application, you will be able to configure a new dashboard in the newrelic web for showing the chart with JMX metrics.