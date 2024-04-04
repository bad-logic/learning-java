
output:
```shell
p1.equals(p2)? false
p2.equals(p1)? true
```

=> Explanation:

```java
public static void main(String[] args) {
    Person p1 = new PersonWithJob("Joe", 30000);
    Person p2 = new Person("Joe");
    System.out.println("p1.equals(p2)? " + p1.equals(p2));
    System.out.println("p2.equals(p1)? " + p2.equals(p1));
}
```
we can see two objects p1 and p2 are being created. 
let's analyse `p1.equals(p2)` 
This will call the equals method of p1 ( PersonWithJob )

```java
public boolean equals(Object aPersonWithJob) {
    if(aPersonWithJob == null) return false;
    if(!(aPersonWithJob instanceof PersonWithJob)) return false;
    PersonWithJob p = (PersonWithJob)aPersonWithJob;
    return this.getName().equals(p.getName()) && this.getSalary()==p.getSalary();
}
```
 we can see that the argument object p2 mapped to a parameter aPersonWithJob is an instance of Person 
 and will fail the check `aPersonWithJob instanceof PersonWithJob` resulting in false result.

now let's see another statement `p2.equals(p1)`
This will call the equals method of p2 ( Person )

```java
public boolean equals(Object aPerson) {
    if(aPerson == null) return false;
    if(!(aPerson instanceof Person)) return false;
    Person p = (Person)aPerson;
    return this.name.equals(p.name);
}
```
we can see that the argument object p1 mapped to a parameter aPerson is an instance of PersonWithJob, since 
PersonWithJob inherits from Person class it will pass the instance of check and since both 
p1 and p2 have same name it will result to true.