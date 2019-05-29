package by.it.udalyou.at25;


import java.util.*;

public class Buyer extends Thread implements IBuyer{

    Buyer(long namber){
        super("Byer №"+namber+" ");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }



    @Override
    public void enterToMarket() {
        System.out.println(this+" enter to the Market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+" started to choose goods");
        int timeOut = Util.random(500, 2000);
        System.out.println(this+"weit "+ timeOut+"seconds ");
        Util.sleep(timeOut);
        System.out.println(this+" stoped to choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this+" go out from the Market");
      //  Dispetcher.buyerCounter--;
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
        double sum=0;
        //определение колличества покупок

        int rd=Util.random(4)+1;
        System.out.println(this+"берет : "+rd+" ед.товара");

        Map<String, Double> good = Util.getGoods();//
          //System.out.println(good);//

        Set<Map.Entry<String, Double>> sgoods=Util.getGoods().entrySet();
        //System.out.println(sgoods);
        List<String> keyList = new ArrayList<String>(Util.getGoods().keySet());
        //определение слкчайным образом что покупается
               for (int i = 1; i <= rd; i++) {

            int randIndex = new Random().nextInt(keyList.size());
            String randKey = keyList.get(randIndex);

            Double randValue = good.get(randKey);
                            sum=sum+randValue;
            System.out.print(randKey + " ");
        }
        System.out.println();
        System.out.printf("%-10s%-6.2f%-5s%n","Всего на сумму : ",sum,"у.е.");
                    }


          @Override
    public String toString() {
        return getName();
    }


}
