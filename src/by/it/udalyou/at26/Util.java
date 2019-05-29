package by.it.udalyou.at26;

import java.util.*;

class Util {

    private Util() {
    }
private static Random rnd=new Random();
    static int random (int start, int stop){
        //return (int) (Math.random()*(stop-start-1))+start;
        int delta=(stop-start);
        return rnd.nextInt(delta)+start;
}
static int random(int max){
    return random(0,max);
}
    static void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut/ Dispetcher.K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static Map<String,Double> goods;
    public static Map<String, Double> getGoods() {
        goods = new HashMap<>();
        goods.put("хлеб",1.0);goods.put("печенье",1.7);goods.put("пряники",1.2);
        goods.put("батон",1.3);goods.put("торт",8.2);goods.put("булочка",1.5);
        goods.put("сыр",9.0);goods.put("сырок",0.5);goods.put("йогурт",1.8);
        goods.put("молоко",0.9);goods.put("сметана",2.9);goods.put("кефир",1.3);
        goods.put("колбаса",7.0);goods.put("ветчина",11.0);goods.put("мясо",8.6);
        goods.put("яблоки",1.2);goods.put("бананы",2.2);goods.put("апельсины",3.4);
        goods.put("вода",1.4);goods.put("вино",12.0);goods.put("пиво",2.3);

        return goods;
    }

    Set<Map.Entry<String, Double>> sgoods=goods.entrySet();
    List<String> keyList = new ArrayList<String>(goods.keySet());



}
