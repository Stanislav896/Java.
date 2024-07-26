import java.util.ArrayList;
import java.util.List;

// Реализовать класс Market и
// все методы, которые он
// обязан реализовывать.
// Методы из интерфейса
// QueueBehaviour, имитируют
// работу очереди,
// MarketBehaviour – помещает и
// удаляет человека из очереди,
// метод update – обновляет
// состояние магазина
// (принимает и отдает заказы)

public class Market implements MarketBehaviour, QueueBehaviour{

    private List<Actor> actors = new ArrayList<Actor>();
    private List<Human> queue = new ArrayList<>();



    public List<Actor> getActors() {
        return actors;
    }

    public List<Human> getQueue() {
        return queue;
    }

    @Override
    public  void acceptToMarket(Actor actor) {
        actors.add(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        actors.remove(0);
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
//        getQueue().getFirst().setTakeOrder(false);
        if (getQueue().getFirst().isTakeOrder){

            System.out.println("Если "+getQueue().getFirst().getName()+" получил свой заказ, то выходит из очереди");
            System.out.println(getQueue().getFirst().isTakeOrder);
            System.out.println("И "+getQueue().getFirst().getName()+" покидает магазин");
            releaseFromQueue();
            releaseFromMarket(actors);

        }

    }

    @Override
    public void giveOrders() {
        if (getQueue().getFirst().isMakeOrder){

            getQueue().getFirst().setTakeOrder(true);
            System.out.println("Если "+getQueue().getFirst().getName()+" сделал заказ, то он его получает");
            System.out.println(getQueue().getFirst().isTakeOrder);

        }
    }

    @Override
    public void releaseFromQueue() {
       queue.removeFirst();
        
    }

    @Override
    public void takeInQueue(Actor actor) {
       queue.addLast((Human) actor);
        
    }

    @Override
    public void takeOrders() {
        getQueue().getFirst().setMakeOrder(true);
        System.out.println(getQueue().getFirst().getName()+" Делает заказ");
        System.out.println(getQueue().getFirst().isMakeOrder);

    }


}