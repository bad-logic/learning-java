## Object Class

> It is a special class defined by java. All other classes are subclasses of
> this Object class. This means that a reference variable of type Object can refer to an object of
> any other class. Object defines the following methods which are available to all classes.


| Method                                                                                          | Purpose                                                           |
|-------------------------------------------------------------------------------------------------|-------------------------------------------------------------------|
| Object clone()                                                                                  | creates a new object that is the same as the object being cloned  | 
| boolean equals(Object object)                                                                   | determines whether one object is equal to another                 | 
| void finalize()                                                                                 | called before an unused object is recycled. (depcreted by JDK 9 ) |
| Class<?> getClass()                                                                             | obtains the class of an object at runtime |
| int hashCode()                                                                                  | returns the hashcode associated with the invoking object | 
| void notify()                                                                                   | resumes execution of a thread waiting on invoking object |
| void notifyAll()                                                                                | resumes execution of all threads waiting on invoking object |
| String toString()                                                                               | returns a string that describes the object | 
| void wait() <br> void wait(long milliseconds) <br>void wait(long milliseconds, int nanoseconds) | waits on another thread of execution|
  
> The class getClass(), notify(), notifyAll() and wait() are declared as final, others can be overridden.



