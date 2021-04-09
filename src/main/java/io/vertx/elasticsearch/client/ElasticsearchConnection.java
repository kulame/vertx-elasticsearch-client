package io.vertx.elasticsearch.client;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.Nullable;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.streams.ReadStream;
import io.vertx.core.Handler;


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

    void close();


}