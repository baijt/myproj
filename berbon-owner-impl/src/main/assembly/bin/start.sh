#!/bin/bash
cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf
#
SERVER_PORT=`sed '/jetty.port/!d;s/.*=//' conf/config.properties | tr -d '\r'`
APP_NAME=`sed '/app.name/!d;s/.*=//' conf/config.properties | tr -d '\r'`
LOGS_PATH=`sed '/log.path/!d;s/.*=//' conf/config.properties | tr -d '\r'`
MAIN_CLASS=`sed '/app.main.class/!d;s/.*=//' conf/config.properties | tr -d '\r'`

if [ -z "$APP_NAME" ]; then
    APP_NAME=`hostname`
fi

LOG_FILE=$LOGS_PATH/$APP_NAME.log

echo "LogfilePath:$LOG_FILE";

PIDS=`ps aux | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $APP_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi

if [ -n "$SERVER_PORT" ]; then
    SERVER_PORT_COUNT=`netstat -tln | grep $SERVER_PORT | wc -l`
    if [ $SERVER_PORT_COUNT -gt 0 ]; then
        echo "ERROR: The $APP_NAME port $SERVER_PORT already used!"
        exit 1
    fi
fi

LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'|tr "\n" ":"`

JAVA_OPTS="-Djava.awt.headless=true -Djava.net.preferIPv4Stack=true -Dfile.encoding=UTF-8 -DappName=$SERVER_NAME"
JAVA_DEBUG_OPTS=""
if [ "$1" = "debug" ]; then
    JAVA_DEBUG_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=n"
fi
JAVA_JMX_OPTS=""
if [ "$1" = "jmx" ]; then
    JAVA_JMX_OPTS="-Dcom.sun.management.jmxremote.port=1099 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
fi
JAVA_MEM_OPTS=""
BITS=`java -version 2>&1 | grep -i 64-bit`
if [ -n "$BITS" ]; then
    JAVA_MEM_OPTS="-server -Xmx512m -Xms512m -Xmn256m -XX:PermSize=128m -Xss256k -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+CMSParallelRemarkEnabled -XX:+UseCMSCompactAtFullCollection -XX:LargePageSizeInBytes=128m -XX:+UseFastAccessorMethods -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70"
else
    JAVA_MEM_OPTS="-server -Xmx512m -Xms512m -XX:PermSize=128m -XX:SurvivorRatio=2 -XX:+UseParallelGC"
fi
JAVA_GC_OPTS=""
JAVA_GC_OPTS="-Xloggc:$LOGS_PATH/gc.log -XX:+PrintGCDetails"
echo "java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $JAVA_GC_OPTS -classpath $CONF_DIR:$LIB_JARS $MAIN_CLASS";
echo -e "Starting the $APP_NAME ...\c"

nohup java $JAVA_OPTS $JAVA_MEM_OPTS $JAVA_DEBUG_OPTS $JAVA_JMX_OPTS $JAVA_GC_OPTS -classpath $CONF_DIR:$LIB_JARS $MAIN_CLASS &>/dev/null &

COUNT=0
while [ $COUNT -lt 1 ]; do    
    echo -e ".\c"
    sleep 1 
    if [ -n "$SERVER_PORT" ]; then
        COUNT=`netstat -an | grep $SERVER_PORT | wc -l`
    else
    	COUNT=`ps aux | grep java | grep "$DEPLOY_DIR" | awk '{print $2}' | wc -l`
    fi
    if [ $COUNT -gt 0 ]; then
        break
    fi
done

echo "OK!"
PIDS=`ps aux | grep java | grep "$DEPLOY_DIR" | awk '{print $2}'`
echo "PID: $PIDS"
echo "STDOUT: $LOG_FILE"
tail -100f $LOG_FILE
