#!/bin/bash
CURRENT_PID=$(pgrep -f pickandlol-0.0.1-SNAPSHOT.jar)
 echo "$CURRENT_PID"
 if [ -z $CURRENT_PID ]; then
         echo "no process"
 else
         echo "kill $CURRENT_PID"
         kill -9 $CURRENT_PID
         sleep 3
 fi

 JAR_PATH="/home/ec2-user/cicd/build/libs/pickandlol-0.0.1-SNAPSHOT.jar"
 echo "jar path : $JAR_PATH"
 chmod +x $JAR_PATH

SECRET_PATH="/home/ec2-user/cicd/src/main/resources/application-secret.properties"
if [ ! -f "$SECRET_PATH" ]; then
    echo "application-secret.properties not found!"
    exit 1
fi

nohup java -jar $JAR_PATH --spring.config.additional-location=file:$SECRET_PATH &
echo "jar file deploy success"
