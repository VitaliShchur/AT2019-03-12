package by.it.ikasabutskaya.at27;

class Util {

   // private static Random rnd=new Random();

    private Util() {
    }

    static int random(int start, int stop) {
        return start + (int) (Math.random() * (1 + stop - start));
    }

    static int random(int max) {
        return random(1, max);
    }

    static void sleep(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
