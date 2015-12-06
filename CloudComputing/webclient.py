#!/usr/bin/env python   
# import sys for handling command line argument  
# import socket for network communications  
import sys, socket


def simulateClient(num):
	# hard-wire the port number for safety's sake  
	# then take the names of the host and file from the command line  
	port = 8080  
	#host = sys.argv[1]  
	#filename = sys.argv[2]   

	host = 'localhost'  
	filename = '/CloudComputing/healthreport'

	# create a socket object called 'c'  
	c = socket.socket(socket.AF_INET, socket.SOCK_STREAM)   

	# connect to the socket  
	c.connect((host, port))   

	# create a file-like object to read  
	fileobj = c.makefile('r', 0)   

	# Ask the server for the file  
	fileobj.write("GET "+filename+" HTTP/1.0\n\n")   

	# read the lines of the file object into a buffer, buff  
	buff = fileobj.readlines()   

	# step through the buffer, printing each line  
	for line in buff:  
		print line

	c.close()
	fileName = "/home/ubuntu/myfile" + str(num)
	f = open(fileName,'w')

	for line in buff:
		f.write(line)
	f.close()


rep = int(sys.argv[1])
for num in range(0,rep):
	simulateClient(num);


