Explanation:<br>

From the code we can see all the hashCode and equals methods are overridden, but in the 
implementation of the `removeDuplicates` method we are mutating the value of the employees 
if they already exists in the hashmap. since the mutated property is also the part of 
the hashCode generation, the objects will generate different hashCodes after the mutation.

Solution would be to not allow the mutation if the properties are used in hashcode generation.
we could use the final keyword to make it immutable and remove the setter methods.