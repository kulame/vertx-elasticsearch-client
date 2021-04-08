package io.vertx.elasticsearch.client;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.NetClientOptions;
import java.util.List;
import java.util.ArrayList;
public class ElasticsearchOptions {
    private List<String> endpoints;

    private void init(){
        this.endpoints = ArrayList<>();
    }

    public ElasticsearchOptions(){
        init();
    }

    public ElasticsearchOptions addConnectionString(String connectionString){
        this.endpoints.add(connectionString);
        return this;
    }
}
