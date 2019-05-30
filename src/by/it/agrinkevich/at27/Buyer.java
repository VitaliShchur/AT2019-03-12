package by.it.agrinkevich.at27;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBasket {


    private boolean waiting = false;

    public void setWaiting(boolean waiting) {
        this.waiting = waiting;
    }

    final static HashMap<Good, Integer> goodNPrice=new HashMap<Good, Integer>() {
        {
            put(new Good("Apple"), 20);
            put(new Good("Peach"), 30);
            put(new Good("Orange"), 40);
            put(new Good("Banana"), 50);
        }
    };

    private Basket basket;


    Buyer(long number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
        addToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to Market");
    }

    @Override
    public void takeBasket() {
        System.out.println(this + "started to take baskets ");
        int timeout = Util.random(100, 200);
        System.out.println(this + "wait " + timeout + " seconds");
        Util.sleep(timeout);
        this.basket=new Basket();
        System.out.println(this + "finished to take baskets ");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods ");
        int timeout = Util.random(500, 2000);
        System.out.println(this + "wait " + timeout + " seconds");
        Util.sleep(timeout);
        System.out.println(this + "finished to choose goods ");
    }

    @Override
    public void addToQueue() {
        QueueBuyers.add(this);
        synchronized (this){
            waiting = true;
            while (waiting){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Override
    public void putGoodsToBasket() {
        System.out.println(this + "started to put goods to basket ");
        int timeout = Util.random(100, 200);
        int count = Util.random(1,5);
        basket.getGoods().addAll(getRandomSubSet(count));
        System.out.println(this + "wait " + timeout + " seconds");
        Util.sleep(timeout);
        System.out.println(this + "finished to put goods to basket ");
        System.out.println(this + "has " + this.basket.getGoods().size() + " : " + this.basket.getGoods());
    }

    @Override
    public void goOut() {
        System.out.println(this + "out from the Market");
        Dispatcher.buyerOut();
    }

    @Override
    public String toString() {
        return getName();
    }


    private Collection<Good> getRandomSubSet(int subSetSize){
        List<Good> goods =new ArrayList<>(goodNPrice.keySet());
        Set<Good> subSet = new HashSet<>(subSetSize);
        for (int i = 0; i < subSetSize; i++) {
            Collections.shuffle(goods);
            subSet.add(goods.get(0));
        }
        return subSet;
    }
}
