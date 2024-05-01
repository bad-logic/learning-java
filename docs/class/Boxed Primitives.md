## Boxed Primitives

- process of encapsulating primitive data types within their corresponding wrapper classes.
- Java provides immutable wrapper classes for all primitive types:

| primitives | Wrapper Class |
| --- | --- |
| short | Short |
| byte | Byte |
| int | Integer |
| long | Long |
| char | Character |
| boolean | Boolean |
| float | Float |
| double | Double |

### AutoBoxing: 
- Default promotion of primitive type to wrapper type.

```java

Integer a = Integer.valueOf(5);
Integer b = 8;
int c = b.intValue();

```