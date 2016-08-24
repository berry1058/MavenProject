package com.ourTestProjectFour;

import io.vertx.core.Vertx;

public class RunBasicVerticle {
    public static void main(String[] args) {
        Vertx.vertx().deployVerticle("java:com.ourTestProjectFour.BasicVerticle");
    }

}
