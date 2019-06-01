package by.it.ikasabutskaya.at27;

import java.util.HashMap;

class Goods {


    private HashMap<String, Double> goods = new HashMap<>();

    Goods(){
        goods.put("apple", 1.50);
        goods.put("milk", 2.30);
        goods.put("banana", 1.75);
        goods.put("toasts", 1.16);
        goods.put("bread", 0.90);
        goods.put("juice", 3.11);
        goods.put("cake", 10.99);
        goods.put("tea", 3.65);
        goods.put("coffee", 5.85);
        goods.put("cheese", 2.20);
    }

    String getGood() {

        int number = Util.random(goods.size());
        for (String good : goods.keySet()) {
            if(number == 1)
            return good;
            number--;
        }
        return null;
    }
}
