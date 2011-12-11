# UpCloo Java SDK

***The java SDK is actually completely unstable and you have to 
consider this library as it is, unstable.***

## Example of usage

In the follow quick example is used ```java.util.List```

```java
Manager manager = Manager.getInstance();
manager.setCredential("username", "password", "sitekey");

//Create new document or update
Doc doc = new Doc();
doc.setId("14");
doc.setTitle("This is my title")

//Index new contents
manager.index(doc);

//Retrive results
List<Base> doc = manager.get("14");
```

## Requirements 

This library needs different library listed below. 

 * Apache HTTP Client