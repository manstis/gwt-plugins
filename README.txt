Example of cross-GWT application communication

running
cd ./plugincommon
mvn clean install

cd ./pluginserver
mvn clean install

cd ./plugin
mvn clean install

deploy ./plugin/target/plugin-0.0.1-SNAPSHOT.war

deploy ./pluginserver/target/server-0.0.1-SNAPSHOT.war

browse to http://localhost:8080/server-0.0.1-SNAPSHOT/
(or whatever port your web-server is configured to use)
