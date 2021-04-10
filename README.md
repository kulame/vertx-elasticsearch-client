# vertx-elasticsearch-client

The Vert.x Elasticsearch client provides an asynchronous API to interact with a [Elasticsearch](https://www.elastic.co/)

# Note 

This project should be considered as an "alpha" release. It is substantially API complete, but there are still some areas that need more work. do not use it on production environment.

# Building

To launch your tests:
```
./mvnw clean test
```

To package your application:
```
./mvnw clean package
```

To run your application:
```
./mvnw clean compile exec:java
```


# exmaple

```
    Vertx vertx = Vertx.vertx();
    ElasticsearchClient client = ElasticsearchClient.createClient(vertx,"elasticsearch://localhost:9200");
    client.index("service")
        .addQuery(dsl)
        .send(ar ->{
            if(ar.succeeded(){
                Response resp = ar.result();
            })
            else{
                ar.cause.printStackTrace();
            }
        })


```
# Help

* https://vertx.io/docs/[Vert.x Documentation]
* https://stackoverflow.com/questions/tagged/vert.x?sort=newest&pageSize=15[Vert.x Stack Overflow]
* https://groups.google.com/forum/?fromgroups#!forum/vertx[Vert.x User Group]
* https://gitter.im/eclipse-vertx/vertx-users[Vert.x Gitter]

