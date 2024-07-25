#!/bin/bash

# 현재 실행 중인 프로세스 확인
CURRENT_PID=$(pgrep -f .jar)
echo "Current PID: $CURRENT_PID"
if [ -z "$CURRENT_PID" ]; then
    echo "No process is currently running."
else
    echo "Killing process $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 3
fi

# 포트 사용 상태 확인
PORT=8080
if lsof -i:$PORT; then
    echo "Port $PORT is in use, killing process using it."
    fuser -k $PORT/tcp
    sleep 3
fi

# JAR 파일 경로 설정
JAR_PATH="/home/ec2-user/cicd/build/libs/pickandlol-0.0.1-SNAPSHOT.jar"
echo "JAR path: $JAR_PATH"
chmod +x $JAR_PATH

# 애플리케이션 비밀 파일 경로 설정
SECRET_PATH="/home/ec2-user/cicd/src/main/resources/application-secret.properties"
if [ ! -f "$SECRET_PATH" ]; then
    echo "application-secret.properties not found!"
    exit 1
fi

# 서버 시작
nohup java -jar $JAR_PATH --spring.config.additional-location=file:$SECRET_PATH >> /home/ec2-user/cicd/deploy.log 2>> /home/ec2-user/cicd/deploy_err.log &

# 서버가 시작되었는지 확인
if [ $? -eq 0 ]; then
    echo "Jar file deployed successfully."
else
    echo "Jar file deployment failed."
    exit 1
fi