package by.it.ikasabutskaya.at27;

public interface IBuyer {
        void enterToMarket(); //вошел в магазин (мгновенно)
        void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
        void enterQueue();
        void goOut(); //отправился на выход(мгновенно)
}