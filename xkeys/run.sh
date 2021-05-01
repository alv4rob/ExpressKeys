#!/bin/sh
while ! nc -z db 3306 ; do
    echo "Waiting for MySQL server to be available"
    sleep 2
done

exec java -Dspring.profiles.active=dockerembbed,oauth-security -jar xkeys_web-0.0.1-SNAPSHOT.jar