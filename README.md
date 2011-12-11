# UpCloo Java SDK

***The java SDK is actually completely unstable and you have to 
consider this library as it is, unstable.***

## Example of usage

In the follow quick example is used ```java.util.List```

```java
Manager manager = Manager.getInstance();
manager.setCredential("username", "password", "sitekey");
```

### Indexing contents

Consider that ```document``` is an instace of ```com.upcloo.client.model.indexer.Doc```.

```java
Doc document = new Doc();
document.setId("35897");
document.setTitle("This is the title");

manager.index(document);
```

### Retriving contents

Consider that ```documents``` is an instance of ```com.upcloo.client.model.getter.Docs``` 

```java
Docs documents  = manager.get("35897");
```

## Requirements 

This library needs different library listed below. 

 * Apache HTTP Client
 
Under ```lib``` folder you can see the complete dependency list.
 
## Running tests

If you want run tests simply using ```junit```. All tests are 
under ```tests``` folder.