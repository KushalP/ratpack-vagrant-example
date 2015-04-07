package my.app;

import ratpack.server.RatpackServer;

public class Main {
    public static void main(String... args) throws Exception {
        RatpackServer.start(server -> server
            .handlers(chain -> chain
                .handler("foo", ctx -> ctx.render("from the foo handler"))
                .handler("bar", ctx -> ctx.render("from the bar handler"))
                .handler(ctx -> ctx.promise((f) ->
                                    new Thread(() -> f.success("Hello World!")).start()
                                ).then(ctx::render))
            )
        );
    }
}
