# Author: @shazebs extends TechWithTim
# Date:   12/19/20
# Time:   4:16 PM

from socket import AF_INET, socket, SOCK_STREAM
from threading import Thread
import time
from person import Person

# GLOBAL CONSTANTS
HOST = 'localhost' #string variable
PORT = 5500 # int variable
ADDR = (HOST,PORT) # a list?
MAX_CONNECTIONS = 10
BUFSIZ = 512 # size of text?

# GLOBAL VARIABLES
persons = []
SERVER = socket(AF_INET, SOCK_STREAM) # object 'SERVER' references a method that passes two arguments?
SERVER.bind(ADDR) # set up server


def broadcast(msg, name):
    """
    send new messages to all clients
    :param msg: bytes["utf8"]
    :param name: str
    :return:
    """
    for person in persons: # enhanced for loop
        client = person.client
        client.send(bytes(name + ": ", "utf8") + msg)

# while true loop
def client_communication(person):
    """
    Thread to handle all messages from client
    :param person: Person
    :return: None
    """
    client = person.client

    # get persons name
    name = client.recv(BUFSIZ.decode("utf8"))
    msg = f"{name} has joined the chat!"
    broadcast(msg, name) #broadcast welcome message

    while True:
        try:
            msg = client.recv(BUFSIZ)
            print(f"{name}: ", msg.decode("utf8"))

            if msg ==  bytes("{quit}", "utf8"):
                broadcast(f"{name} has left the chat...", "")
                client.send(bytes("{quit}", "utf8"))
                client.close()
                persons.remove(person)
                break
            else:
                broadcast(msg, name)
        except Exception as e:
            print("[EXCEPTION]", e)
            break


def wait_for_connection(): # a prototype function call?
    """
    Wait for connection from new clients, start new thread once connected
    :param SERVER: SOCKET
    :return: None
    """
    run = True # a boolean object
    while run : # while loop testing boolean value of run
        try:
            client, addr = SERVER.accept() # 2 objects are initialized to the method call '.accept()' at the same time
            person = Person(addr, client) # a class object is created
            persons.append(person) # '.append()' to add to end of list object
            print(f"[CONNECTION] {addr} connected to the server at {time.time()}")
            Thread(target=client_communication, args=(person,)).start()
        except Exception as e:
            print("[EXCEPTION]", e)
            run = False

        print("SERVER CRASHED")



# Starts a new 'thread'
# IF STATEMENT ( no need for {} in python )
if __name__ == "--main--":
    SERVER.listen(5) # listen for 5 connections
    print("[STARTED]Waiting for connection...") # basic string output method
    ACCEPT_THREAD = Thread(target=wait_for_connection) # you need the comma to pass a 'tupple'
    ACCEPT_THREAD.start() # a thread is created using a '.start()' method call?
    ACCEPT_THREAD.join() # there is a '.join()' method call - perhaps to join thread?
    SERVER.close() # method call '.close()' ends a thread?




# Additional Notes:
# thread.start_new_thread(function,args[,kwargs])
# - Start a new thread and return its 'identifier.'
