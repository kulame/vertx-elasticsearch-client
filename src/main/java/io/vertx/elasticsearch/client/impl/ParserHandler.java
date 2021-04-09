package io.vertx.elasticsearch.client.impl;
import io.vertx.elasticsearch.client.Response;

public interface ParserHandler {
   void handle(Response response);
   void fatal(Throwable t);
   void fail(Throwable t); 
}
