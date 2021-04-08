package io.vertx.elasticsearch.client.impl;

import io.vertx.core.Vertx;

import io.vertx.elasticsearch.client.Elasticsearch;
import io.vertx.elasticsearch.client.ElasticsearchOptions;

public abstract class BaseElasticsearchClient implements Elasticsearch{
    protected final Vertx vertx;

    public BaseElasticsearchClient(Vertx vertx, ElasticsearchOptions options){
        this.vertx = vertx;
    }
    
}
