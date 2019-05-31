package by.it.udalyou.at27;



import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

class QueueBuyers {

   private QueueBuyers() {

   }

   private static final BlockingDeque<Buyer> QUEUE
         =new LinkedBlockingDeque<>(30);
//private static final ArrayBlockingQueue QUEUE=new ArrayBlockingQueue(30);
  static void add (Buyer buyer) throws InterruptedException {

      System.out.println(buyer+"встал в очередь "+QUEUE.size()+"-ым");
     while (QUEUE.size()>=30){
          Util.sleep(10);
      }
       QUEUE.addLast(buyer);

   }
  static Buyer extract() {

      try {
          return QUEUE.pollFirst(10, TimeUnit.MILLISECONDS);
      } catch (InterruptedException e) {
          e.printStackTrace();
          return null;
      }

  }

}
