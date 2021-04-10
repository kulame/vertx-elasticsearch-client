package io.vertx.elasticsearch.client.impl;

import io.vertx.elasticsearch.client.ElasticsearchConnection;
import io.vertx.elasticsearch.client.ElasticsearchOptions;
import io.vertx.core.net.impl.clientconnection.ConnectionListener;
import io.vertx.elasticsearch.client.impl.types.ErrorType;
import io.vertx.elasticsearch.client.Response;
import io.vertx.core.Vertx;
import io.vertx.core.impl.VertxInternal;
import io.vertx.core.Promise;
import io.vertx.core.Handler;
import io.vertx.core.Future;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.net.NetSocket;
import java.util.Queue;

import io.vertx.elasticsearch.client.Request;
import io.vertx.elasticsearch.client.Response;

public class ElasticsearchStandaloneConnection implements ElasticsearchConnection, ParserHandler{
    private static final String BASE_ADDRESS = "io.vertx.elasticsearch";
    private final ConnectionListener<ElasticsearchConnection> listener;
    private final VertxInternal vertx;
    private final ContextInternal context;
    private final EventBus eventBus;
    private final NetSocket netSocket;
    private final ArrayQueue waiting;

    private Handler<Throwable> onException;
    private Handler<Void> onEnd;
    private Handler<Response> onMessage;
    private Runnable onEvict;
    private boolean isValid;

    public ElasticsearchStandaloneConnection(Vertx vertx, ContextInternal context, ConnectionListener<ElasticsearchConnection> connectionListener, NetSocket netSocket, ElasticsearchOptions options){
        this.listener = connectionListener;
        this.vertx = (VertxInternal)vertx;
        this.eventBus = vertx.eventBus();
        this.context = context;
        this.netSocket = netSocket;
        this.waiting = new ArrayQueue(options.getMaxWaitingHandlers());
        this.isValid = true;
    }

    void forceClose(){
        listener.onEvict();
        if(onEvict != null){
            onEvict.run();
            onEvict = null;
        }
        netSocket.close();
    }

    public boolean isValid(){
        return isValid;
    }

    @Override
    public void close(){

    }

    @Override
    public boolean pendingQueueFull(){
        return waiting.isFull();
    }
 
    @Override
    public ElasticsearchConnection exceptionHandler(Handler<Throwable> handler){
        this.onException = handler;
        return this;
    }

    @Override
    public ElasticsearchConnection  endHandler(Handler<Void> handler){
        this.onEnd = handler;
        return this;
    }

    
    ElasticsearchConnection  evictHandler(Runnable handler){
        this.onEvict = handler;
        return this;
    }

    @Override
    public ElasticsearchConnection handler(Handler<Response> handler){
        this.onMessage = handler;
        return this;
    }

    @Override
    public ElasticsearchConnection pause(){
        netSocket.pause();
        return this;
    }

    @Override 
    public ElasticsearchConnection resume(){
        netSocket.resume();
        return this;
    }

    @Override
    public ElasticsearchConnection fetch(long size){
        return this;
    }

    @Override
    public Future<Response> send(final Request request){
        final Promise<Response> promise = vertx.promise();
        return promise.future();
    }




    

    
}
