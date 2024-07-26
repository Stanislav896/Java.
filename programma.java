public class programma {
    public  static void main(String[] args) {
        StringBuilder x;
        Market market1 = new Market();//создаем магазин
        for (int i = 0; i < 10; i++) {// создаем 10 покупателей
            x = new StringBuilder("human_" + i);
            Human human = new Human(x.toString());//
            market1.acceptToMarket(human);// запускаем их в магазин
        }
        System.out.println("Посетители магазина : "+market1.getActors());

        for (Actor human: market1.getActors()){// покупатели становятся в очередь
            market1.takeInQueue(human);
        }
        System.out.println("Очередь : "+market1.getQueue());
        while (!market1.getActors().isEmpty()){

            market1.update();
        }

        System.out.println("Посетители магазина : "+market1.getActors());
        System.out.println("Очередь : "+market1.getQueue());

    }
}