# REST Services with Spring V2

This exemplar project includes multiple domain classes and a relationship between those classes.

### Demonstration: Sample REST Requests
- Request 1. 

In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"name\":\"My Library\"}" http://localhost:8081/libraries
```
In MacOS/Linux,
```bash
curl -X POST -H "Content-Type:application/json" -d '{"name":"My Library"}' http://localhost:8081/libraries
```
which returns
```json
{"id":1,"name":"My Library"}
```

- Request 2.
  In Windows CMD,
```shell
curl -X POST -H "Content-Type:application/json" -d "{\"location\":\"Main Street nr 5\"}" http://localhost:8081/addresses
```
In MacOS/Linux,
```bash
curl -X POST -H "Content-Type:application/json" -d '{"location":"Main Street nr 5"}' http://localhost:8081/addresses
```
which returns 
```json
{"id":2,"location":"Main Street nr 5","library":null}
```

- Request 3.
```shell
curl -i -X PUT http://localhost:8081/libraries/1/address/2
```
which returns
```json
{"id":1,"name":"My Library"}
```

- Request 4.
```shell
curl -X GET http://localhost:8081/addresses/2
```
which returns
```json
{"id":2,"location":"Main Street nr 5","library":{"id":1,"name":"My Library"}}
```
_Note that the value of `"library"` has been updated from `null` to `{"id":1,"name":"My Library"}`._
