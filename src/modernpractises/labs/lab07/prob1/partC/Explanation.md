Explanation:<Br>

The Employee class is used as a key to store the object in the hashmap in `removeDuplicates` 
method. Hashmap implementation uses hashcode and hash value to determine the slot in the hashtable
for the storage of the object.

since Employee does not have hashCode method overridden, the default implementation will be used
to get the hashcode. which will yield different hashcode for object with same name and salary, 
thus resulting in inconsistent result for the `containsKey` method.

solution would be to override the `hashCode` method like so

```java

@Override
public int hashCode() {
    return Objects.hash(name, salary);
}
    
```