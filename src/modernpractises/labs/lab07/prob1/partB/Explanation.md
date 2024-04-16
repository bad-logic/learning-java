

Explanation:<br>
 we can see on main method that when checking if the lists are equal
we are calling `listsAreEqual` method which sees if the elements of 
one lists is also the element of another list using `contains` method 
provided by the list interface.

On looking in the implementation of contains method we can find out that
it uses `equals` method to return the `contains` result.

For this to work we need to override equals method in our Employee class.
but we can see that we have not overriden the equals method. even though we can
see in the Employee class the below code:
```java

public boolean equals(Employee e) {
    return e.name.equals(name) && e.salary == salary;
}
    
```

The above is just an instance method for the Employee class. due to which the default 
implementation of equals method is used which is shown below
```java
public boolean equals(Object obj) {
    return (this == obj);
}
```

which checks for the memory only which results in every object becoming different. thus the false
result is shown in the output.

To solve this issue we can override the equals method in Employee class as below
```java

@Override
public boolean equals(Object obj) {
    if(obj == null) return false;
    if(this.getClass() != obj.getClass()) return false;
    Employee em = (Employee) obj;
    return em.name.equals(name) && em.salary == salary;
}

```
