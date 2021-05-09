# talk

The Project is a chatting application developed in Java SE language executed on single standalone java application using loopback address concept.

Two Java APIs used for graphic user interface are:
1. Java Swing
2. Abstract Window Toolkit

Software Interfaces used are:
1. Java Core
2. Socket Programming

The project is divided into modules:
1. Server
2. Client

A Server is a program which provides services to other programs on the same or different machine. Client requests the server and server responds by granting the clients request.
A server program listens to a specific port waiting for connection request from a client. When connection request arrives a dedicated connection is established over which client and server
communicate.

In this project, one user involved in the chatting acts a client(user1) and initiates the chat by sending message. This client's machine is assinged a local port number and binds a socket to it
with its IP address. Client writes (sends messages) using data output stream and reads the messages received from the server(user2) through data input stream.

The other user involved in chatting acts as a server(user2) and waits for the message from client. As soon as the connection request from client arrives, the server gets a new port number 
so that it continues to listen for other connection requests on the original port. The server also binds a socket to it new local port and communicates by reading client messages through 
data input stream and writes to the client(user1) through data output stream.





