package by.it.udalyou.at26;

public class Cashier implements Runnable{


    public String name;

    public Cashier(long id) {
        this.name ="\t\tCashier № "+id+" " ;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        System.out.println(this+" opend");
        while (!Dispetcher.marketClosed()){
            Buyer buyer=QueueBuyers.extract();
            if (buyer!=null){
                System.out.println(this+" started sevis of "+buyer);
                Util.sleep(Util.random(2000,5000));
                synchronized (buyer){
                    buyer.notifyAll();
                }
                System.out.println(this+" stoped sevis of "+buyer);
            }
        else Util.sleep(100);
        }

        System.out.println(this+" closed");
    }
}
