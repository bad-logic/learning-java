## Explain why it is that we don’t need eager loading anymore and the Application still works with lazy loading ?

At first when we are loading everything eagerly we had all values from Account object 
and referencing any values was possible. but now when we make everything load lazily
hibernate returns the proxy of the lazy references and when we try to reference the object 
that were tagged to load lazily we get an error if the db context session is not active.

Annotating the methods or class with @Transactional keeps the session context active 
within the scope of that method thus giving hibernate the power to fetch again from the database.

Thus adding Transactional annotation, keeps the context session active making sure we could lazily load values from 
the database when needed. Therefore we do not need to have eager loading anymore.