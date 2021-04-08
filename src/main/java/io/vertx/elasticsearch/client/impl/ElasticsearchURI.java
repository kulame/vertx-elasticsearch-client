package io.vertx.elasticsearch.client.impl;
import io.vertx.core.net.SocketAddress;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class ElasticsearchURI {
  private static final String DEFAULT_HOST = "localhost";

  private static final int DEFAULT_PORT = 9200;
  private final String connectionString;
  private final SocketAddress socketAddress;
  private final String user;
  private final String password;
  private final Map<String,String> params;
  
  
  public ElasticsearchURI(String connectionString){
    this.connectionString = connectionString;
  }
}
