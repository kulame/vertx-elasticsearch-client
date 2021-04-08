package io.vertx.elasticsearch.client.impl;

import io.vertx.core.Vertx;
import io.vertx.elasticsearch.client.Elasticsearch;
import io.vertx.elasticsearch.client.ElasticsearchOptions;

public class ElasticsearchClient extends BaseElasticsearchClient implements Elasticsearch{

    public ElasticsearchClient(Vertx vertx, ElasticsearchOptions options){
        super(vertx, options);
    }
}
