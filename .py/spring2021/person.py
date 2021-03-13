class Person:
    #constructor
    def __init__(self, addr, client): # 'self' is like a 'this' method
        self.addr = addr
        self.client = client
        self.name = None

    def __set__name__(self, name):
        self.name = name

    # this is a get method?
    def __repr__(self):
        return f"Person({self.addr}, {self.name})"
