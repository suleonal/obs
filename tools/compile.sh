cd  /sule/projects/obs_backend/tools/

cp ../obs_client_api/pom.xml obs_client_api/


JAVA_HOME="/usr/lib/jvm/java-11-openjdk-amd64"
export JAVA_HOME

cd obs_client_api/

mvn install -DskipTests
