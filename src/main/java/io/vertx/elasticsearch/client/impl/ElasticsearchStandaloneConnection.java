package io.vertx.elasticsearch.client.impl;

import io.vertx.elasticsearch.client.ElasticsearchConnection;
import io.vertx.elasticsearch.client.ElasticsearchOptions;
import io.vertx.core.net.impl.clientconnection.ConnectionListener;
import io.vertx.elasticsearch.client.impl.types.ErrorType;
import io.vertx.elasticsearch.client.Response;
import io.vertx.core.Vertx;
import io.vertx.core.Promise;
import io.vertx.core.Handler;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.impl.ContextInternal;
import io.vertx.core.net.NetSocket;
import java.util.Queue;
import java.util.ArrayDeque;

public class ElasticsearchStandaloneConnection implements ElasticsearchConnection, ParserHandler{
    private static final String BASE_ADDRESS = "io.vertx.elasticsearch";
    private final ConnectionListener<ElasticsearchConnection> listener;
    private final Vertx vertx;
    private final ContextInternal context;
    private final EventBus eventBus;
    private final NetSocket netSocket;
    private final ArrayDeque waiting;

    private Handler<Throwable> onException;
    private Handler<Void> onEnd;
    private Handler<Response> onMessage;
    private Runnable onEvict;
    private boolean isValid;

    public ElasticsearchStandaloneConnection(Vertx vertx, ContextInternal context, ConnectionListener<ElasticsearchConnection> connectionListener, NetSocket netSocket, ElasticsearchOptions options){
        this.listener = connectionListener;
        this.vertx = vertx;
        this.eventBus = vertx.eventBus();
        this.context = context;
        this.netSocket = netSocket;
        this.waiting = new ArrayDeque(options.getMaxWaitingHandlers());

        this.isValid = true;
    }

    

    
}
