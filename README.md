
Online Compiler
===================
> **Note:**

> - Download and extract the folder
> - Open Eclipse in Java EE Prespective
> - File-->Import-->Existing Maven Projects
> - In Root Directory click browse and select onlinecompiler-java directory and click ok
> - Click Finish
> - In Project Explorer
Right click jbosswildfly-->Run As --> Maven clean
Right click jbosswildfly-->Run As --> Maven install
> - The generated war is placed in 
[INFO] Building war: onlinecompiler-java/target/jbosswildfly-1.0.war

How to Run Tomcat and deploy the war file
-------------

> - Download the tomcat http://redrockdigimark.com/apachemirror/tomcat/tomcat-8/v8.5.13/bin/apache-tomcat-8.5.13-windows-x64.zip
> - Extract the tomcat zip file
> - Open the extracted folder 
> - go to webapps directory and place the generated warfile (jbosswildfly-1.0.war)
> - go to bin directory --> In the Address Bar present in the Top,type cmd --Command Prompt will open 
> - Enter startup.bat --> Tomcat will start
> - Open Browser and type http://localhost:8080/jbosswildfly-1.0
> - Enter the username and password as keerthana and keerthana123

How to Deploy the application in OpenShift
-------------


> - Instal OpenShift client tools 
> - Login to the OpenShift Webportal https://openshift.redhat.com/app/login?then=%2Fapp%2Fconsole
> - Click Add Application
> - Select WildFly Application Server 9
> - In Public URL give name as onlinecompiler
> - Click Create Application and wait for 2 minutes
> - For making changes following commands are used. (Replace git clone url with the url shown after the application gets created)
> - git clone ssh://58e5981c0c1e66264700001a@onlinecompiler-ksrit.rhcloud.com/~/git/onlinecompiler.git/
> - cd onlinecompiler/
> - git add .
> - git commit -m 'My changes'
> - git push

