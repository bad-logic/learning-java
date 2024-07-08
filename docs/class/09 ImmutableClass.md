## Immutable Class

A class is immutable if the data it stores cannot be modified once initialized.

Java’s String and number classes (such as Integer, Double, BigInteger), as well as
LocalDate, are immutable. Immutable classes provide good building blocks for creating
more complex objects.

Guidelines for creating an immutable class
- All fields should be private and final. This keeps internals private and prevents data from
changing once the object is created.
- Provide getters but no setters for all fields. Not providing setters is essential for making
the class immutable.
- Make the class final.
- Make sure that getters do not return mutable objects.