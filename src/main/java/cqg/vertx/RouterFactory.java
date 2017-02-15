package cqg.vertx;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by caoqingguang on 2017/2/15.
 */
public class RouterFactory {

  static Router genRouter(Vertx vertx){
    Router router = Router.router(vertx);
    router.route(HttpMethod.GET,"/hello").handler(new RouterHandlerImpl());
    return router;

  }

  static class RouterHandlerImpl implements Handler<RoutingContext> {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void handle(RoutingContext event) {
      event.response().end(sdf.format(new Date()));
    }
  }

}
