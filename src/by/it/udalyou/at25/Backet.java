package by.it.udalyou.at25;

public class Backet  extends Thread implements IUseBacket{
    public Backet(long namber) {
        super(namber+" ");
    }

    @Override
    public String toString() {
        return "Backet{}";
    }

    @Override
    public void takeBacket() {

        int timeOut = Util.random(100, 200);
         Util.sleep(timeOut);
        System.out.println(this+" take the backet");
    }

    @Override
    public void putGoodsToBacket() {

        int timeOut = Util.random(100, 200);
        Util.sleep(timeOut);
        System.out.println(this+" put doods in the backet");
    }

}
