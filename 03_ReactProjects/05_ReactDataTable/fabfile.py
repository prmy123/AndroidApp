#!/usr/bin/python
from fabric import *
import base64
import paramiko

#env.use_ssh_config = False
#env.hosts = ["vm1527.ut1.omniture.com"]
#env.user = "root"
#env.password = "greed#2Olm!"
#env.port = 22

@task
def paramikoexample(ctx):
	client = paramiko.SSHClient()
	client.set_missing_host_key_policy(paramiko.AutoAddPolicy())
	client.connect('ip-10-27-10-200.ut1.adobe.net', username='root', password='greed#2Olm',port='22')
	stdin, stdout, stderr = client.exec_command('cat /proc/meminfo')
	for line in stdout:
		print('... ' + line.strip('\n'))
	stdin, stdout, stderr = client.exec_command('ps -ef | grep java')
	for line in stdout:
		print('... ' + line.strip('\n'))
	client.close()

@task
def getAEMauthorStatus(ctx):
	print("Migration Complete...!")
	pass

@task
def getntpdStatusAEM(ctx):
	with Connection(host="vm1527.ut1.omniture.com",user="root",port='22',connect_kwargs={"key_filename": "./id_rsa.pub",},) as c:
		c.run("uptime")
		c.run("ls -ltr")
	pass
	#with Connection(host="vm1527.ut1.omniture.com",user="root",port='22') as c:
	#	c.run("uptime")
	#	c.run("ls -ltr")
	#pass

@task
def getMongodbStatus(ctx):
    pass

@task(default=True)
def getntpdStatusMongo(ctx):
    if not provisioned:
        provision()
    push()
    migrate()