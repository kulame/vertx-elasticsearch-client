package io.vertx.elasticsearch.client;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Vertx;

import io.vertx.elasticsearch.client.impl.ElasticsearchClient;


@VertxGen
public interface Elasticsearch {
 // static Elasticsearch createClient(Vertx vertx){
  //}
    static Elasticsearch createClient(Vertx vertx){
       return createClient(vertx, new ElasticsearchOptions());
    } 

    /**
     * @param vertx
     * @param connectionString  elasticsearch connection string. eg elasticsearch://localhost:9200
     * @return
     */
    static Elasticsearch createClient(Vertx vertx, String connectionString){
        return createClient(vertx, new ElasticsearchOptions().setConnectionString(connectionString));
    }
  
    /**
     * 
     * @param vertx
     * @param options
     * @return
     */
    static Elasticsearch createClient(Vertx vertx, ElasticsearchOptions options){
        return new ElasticsearchClient(vertx,options);
    }
}
