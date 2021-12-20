FROM tomcat:8
LABEL app=my-app
RUN ls -l
COPY target/*.war /usr/local/tomcat/webapps/myweb.war
# dummy commit
