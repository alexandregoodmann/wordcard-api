clear
cd wordcard-api
sudo mvn clean install -DskipTests=true
sleep 7
cd ..
cd wordcard
sudo ng build
sleep 7
cd ..
sudo docker-compose up --build
