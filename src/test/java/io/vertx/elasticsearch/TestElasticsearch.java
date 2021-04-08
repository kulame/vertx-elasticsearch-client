package io.vertx.elasticsearch;

import io.vertx.core.Vertx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;

import io.vertx.elasticsearch.client.Elasticsearch;

@ExtendWith(VertxExtension.class)
public class TestElasticsearch {
  
  @Test
  void test_helloworld(Vertx vertx, VertxTestContext testContext) throws Throwable {
      System.out.println("hello world");
      String uri = "elasticsearch://localhost:9200";
      Elasticsearch es = Elasticsearch.createClient(vertx,uri);
      System.out.println(es);
      testContext.completeNow();
  }

}
