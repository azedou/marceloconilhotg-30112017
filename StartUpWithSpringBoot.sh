echo Starting application
cd \parent
echo "mvn clean install" inside parent folder
mvn clean install
echo DONE
cd ..
cd \backend
echo "mvn spring-boot:run" inside backend folder
mvn spring-boot:run