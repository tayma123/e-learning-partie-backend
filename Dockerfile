FROM tomcat:8
LABEL app=my-app
COPY target/*.war C:\Program Files\ApacheSoftwareFoundation\Tomcat8.5\webapps\myweb.war
# dummy commit
