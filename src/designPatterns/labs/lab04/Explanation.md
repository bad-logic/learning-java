a. Explain how the Factory pattern can help here to solve this problem.

Answer: In our current implementation we are creating the dao object inside the account service
which means if we want to switch to real database we need to make changes to account service
class which violates the open closed principle. 

To solve this problem we need to outsource the object creation to some factory abstract class
that way we can inject this factory class object through constructor to the services that utilizes them
in our case Account service. services that needs the database or mock implementation will ask the 
factory object for the DAO implementation which could be real database or mock. this way we can switch 
between the real database and mock database at runtime. This gives us more flexibility and decoupling 
between DAO object and the account service class.

The factory abstract class provides an interface for requesting the object but will defer the object
creation logic to its subclasses which has control over what object to instantiate and return.
In main we will store the factory subclasses as Factory class reference, this gives us the flexibility
to include any subclasses of the Factory class. This is known as Program to interface or program to supertype.

This way in main we achieve dynamism to switch between real database factory and mock factory at runtime.