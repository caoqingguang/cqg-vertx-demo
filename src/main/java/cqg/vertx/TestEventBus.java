package cqg.vertx;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.MessageConsumer;

/**
 * Created by caoqingguang on 2017/2/15.
 */
public class TestEventBus {

  public static void main(String[] args) throws InterruptedException {
    SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
    String ch1="channel-cqg-1";
    String ch2="channel-cqg-2";
    Vertx vertx = Vertx.vertx(new VertxOptions());
    System.out.println(vertx);
    new Thread(()->{
      MessageConsumer<Object> consumer = vertx.eventBus().localConsumer(ch1);
      consumer.handler(msg->{
        System.out.println(sdf.format(new Date())+"--ch1- body:"+msg.body());
      });
    }).start();
    Thread.sleep(1000);
    System.out.println("start");
    vertx.eventBus().send(ch1,"test msg01");
    vertx.eventBus().send(ch2,"test msg02");
    System.out.println("over");
  }
}
