package io.vertx.elasticsearch.client;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.Handler;
import io.vertx.core.Future;
import io.vertx.core.AsyncResult;

@VertxGen
public interface ElasticsearchConnection extends ReadStream<Response>{

    /**
    * {@inheritDoc}
    */
    @Fluent
    @Override
    ElasticsearchConnection exceptionHandler(Handler<Throwable> handler);


    @Fluent
    @Override
    ElasticsearchConnection handler(Handler<Response> handler);

    @Fluent
    @Override
    ElasticsearchConnection pause();


    @Fluent
    @Override
    ElasticsearchConnection resume();

    @Fluent
    @Override
    ElasticsearchConnection fetch(long amount);

    @Fluent
    @Override
    ElasticsearchConnection endHandler(@Nullable Handler<Void> endHandler);

    @Fluent
    default ElasticsearchConnection send(Request command, Handler<AsyncResult<@Nullable Response>> onSend){
        send(command).onComplete(onSend);
        return this;
    }

    Future<@Nullable Response> send(Request command);

    void close();

    boolean pendingQueueFull();
}
