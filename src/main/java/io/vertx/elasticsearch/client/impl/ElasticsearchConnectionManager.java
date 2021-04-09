package io.vertx.elasticsearch.client.impl;

import io.vertx.core.Vertx;
import io.vertx.core.net.impl.clientconnection.Lease;
import io.vertx.core.net.impl.clientconnection.ConnectionManager;
import io.vertx.elasticsearch.client.ElasticsearchConnection;
import io.vertx.elasticsearch.client.ElasticsearchOptions;
import io.vertx.elasticsearch.client.Request;
import java.util.Objects;
public class ElasticsearchConnectionManager {

    private final Vertx vertx;
    private final ElasticsearchOptions options;
    private final ConnectionManager<ConnectionKey,Lease<ElasticsearchConnection>> pooledConnectionManager;

    ElasticsearchConnectionManager(Vertx vertx, ElasticsearchOptions options){
        this.vertx = vertx;
        this.options = options;
    }

    static class ConnectionKey{
        private final String string;
        private final Request setup;

        ConnectionKey(String string, Request setup){
            this.string = string;
            this.setup = setup;
        }

        @Override
        public boolean equals(Object o){
            if(this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ConnectionKey that = (ConnectionKey) o;
            return Objects.equals(string, that.string) && Objects.equals(setup, that.setup);
        }

        @Override
        public int hashCode(){
            return Objects.hash(string, setup);
        }
    }
}
