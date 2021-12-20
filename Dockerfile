FROM tomcat:8
LABEL app=my-app
COPY target/*.war C:\Program Files\Apache Software Foundation\Tomcat 8.5\webappsmyweb.war
# dummy commit
