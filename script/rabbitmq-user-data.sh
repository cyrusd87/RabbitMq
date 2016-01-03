#!/bin/sh
#cat <<EOF > /etc/apt/sources.list.d/rabbitmq.list
#deb http://www.rabbitmq.com/debian/ testing main
#EOF

curl https://www.rabbitmq.com/rabbitmq-signing-key-public.asc -o /tmp/rabbitmq-signing-key-public.asc
apt-key add /tmp/rabbitmq-signing-key-public.asc
rm /tmp/rabbitmq-signing-key-public.asc

apt-get -qy update
apt-get -qy install rabbitmq-server

#Issues with hostname

#sudo -s # become root
#echo "rabbit" > /etc/hostname
#echo "127.0.0.1 rabbit" >> /etc/hosts
#hostname -F /etc/hostname

#If hostname changes you should restart RabbitMQ

echo "Stop the RabbitMQ server"
rabbitmqctl stop

echo "Start the RabbitMQ server"
/etc/init.d/rabbitmq-server restart


#Enable the management console
#rabbitmq-plugins enable rabbitmq_management


echo "Stop the RabbitMQ server"
rabbitmqctl stop

echo "Start the RabbitMQ server"
/etc/init.d/rabbitmq-server restart