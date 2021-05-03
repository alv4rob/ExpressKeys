#!/bin/sh
while ! nc -z bd 3306 ; do
    echo "Esperando a que MySQL este disponible."
    sleep 2
done

exec java -Dspring.profiles.active=dockerembbed,oauth-security -jar xkeys_web-0.0.1-SNAPSHOT.jar