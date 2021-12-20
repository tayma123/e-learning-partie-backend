FROM tomcat:8
LABEL app=my-app
COPY target/*.war \Program Files\ApacheSoftwareFoundation\Tomcat8.5\webapps\myweb.war
# dummy commit
