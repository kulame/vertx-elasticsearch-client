package io.vertx.elasticsearch.client.impl.types;

import io.vertx.elasticsearch.client.Response;


public final class ErrorType extends Throwable implements Response {
    public static ErrorType create(String message){
        return new ErrorType(message);
    }

    private ErrorType(String message){
        super(message, null, false, false);
        
    }


    
    
}
