package cqg.vertx;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.Router;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {

        Vertx vertx = Vertx.vertx(new VertxOptions());
        Router router = RouterFactory.genRouter(vertx);
        for(int i=1;i<10;i++){
            vertx.createHttpServer(new HttpServerOptions()
              .setMaxInitialLineLength(65535)
              .setMaxHeaderSize(65535)
              .setTcpKeepAlive(true)
              .setTcpNoDelay(true)
              .setAcceptBacklog(4096)
              .setUsePooledBuffers(true))
              .requestHandler(router::accept)
              .listen(10010);
        }

    }
}
