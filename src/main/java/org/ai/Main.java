package org.ai;

import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;

import static spark.Spark.*;

public class Main {

    public static void main(String[] args) throws IOException {

        port(Integer.valueOf(System.getenv("PORT")));
        get("/bot", new TelegramBotHandler());
        get("/hello", (req, res) -> "Hello World");
        post("/test", new Test());
        get("/test", new Test());

        post("/kursBot", new KursBot());

    }

    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) throws Exception {
            return "ok, test";
        }
    }

}
