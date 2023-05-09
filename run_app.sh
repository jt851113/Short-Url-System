#!/bin/bash

# 執行mvn package指令
mvn package -Dmaven.test.skip

# 執行Java程式
sudo nohup java -jar target/ShortUrlSystem-0.0.1-SNAPSHOT.war &

