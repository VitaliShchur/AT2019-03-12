package by.it.ikasabutskaya.at25;

public class Buyer extends Thread implements IBuyer {

    Buyer(long number) {
        super("Buyer № " + number + " ");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the Market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + "started to choose goods");
        int timeout = Util.random(500, 2000);
        System.out.println(this + "wait " + timeout + " seconds");
        Util.sleep(timeout);
        System.out.println(this + "finished to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + "out from the Market");
        Dispatcher.buyerCounter--;
    }

    @Override
    public String toString() {
        return getName();
    }
}
