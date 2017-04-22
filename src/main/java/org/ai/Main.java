package org.ai;

import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        LoggerFactory.getLogger(Main.class).debug("Hello World!!!");


        port(Integer.valueOf(System.getenv("PORT")));
        get("/bot", new TelegramBotHandler());
        get("/hello", (req, res) -> "Hello World");
        post("/test", new Test());
        get("/test", new Test());

        post("/kursBot", new KursBot());
        get("/kursBot", (req, res) -> "ok");

    }

    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) throws Exception {
            return "ok, test";
        }
    }

}
