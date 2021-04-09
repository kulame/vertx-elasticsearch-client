package io.vertx.elasticsearch.client;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClientOptions;
import java.util.List;
import java.util.ArrayList;
public class ElasticsearchOptions {
    private List<String> endpoints;
    private int maxWaitingHandlers;

    private void init(){
        this.endpoints = new ArrayList<>();
        this.maxWaitingHandlers = 2048;
    }

    public ElasticsearchOptions(){
        init();
    }

    public ElasticsearchOptions addConnectionString(String connectionString){
        this.endpoints.add(connectionString);
        return this;
    }

    public ElasticsearchOptions setConnectionString(String connectionString){
        this.endpoints.clear();
        this.endpoints.add(connectionString);
        return this;
    }

    public int getMaxWaitingHandlers(){
        return this.maxWaitingHandlers;
    }
}
