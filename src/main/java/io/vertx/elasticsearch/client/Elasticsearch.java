package io.vertx.elasticsearch.client;
import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.Vertx;
import io.vertx.core.Handler;
import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.elasticsearch.client.impl.ElasticsearchClient;
import java.util.List;

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


    @Fluent
    default Elasticsearch connect(Handler<AsyncResult<ElasticsearchConnection>> handler){
      connect().onComplete(handler);
      return this;
    }

    Future<ElasticsearchConnection> connect();

    void close();

    @Fluent
    default Elasticsearch send(Request command, Handler<AsyncResult<@Nullable Response>> onSend){
        send(command).onComplete(onSend);
        return this; 
    }

    Future<@Nullable Response> send(Request command);

    @Fluent
    default Elasticsearch batch(
      List<Request> commands, 
      Handler<AsyncResult<List<@Nullable Response>>> onSend)
    {
      batch(commands).onComplete(onSend);
      return this;
    }

    Future<List<@Nullable Response>> batch(List<Request> commands);
    
}
