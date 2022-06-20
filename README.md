## Server 

```
mvn compile exec:java -Dexec.mainClass="vtp2022.workshop6.ServerApp" -Dexec.args="12345 /Users/kennethphang/Projects/sdf-workshop6/cookie_file.txt"

```

## Client


```
mvn compile exec:java -Dexec.mainClass="vtp2022.workshop6.ClientApp" -Dexec.args="0.0.0.0:12345"

```