import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market implements MarketBehaviour,QueueBehaviour {
    private List<Actor> queue;
    private List<Actor> visitors;
    private Map<String, Integer> orders = new HashMap<>();
    public String item;
    public int quantity;

    @Override
    public void takeInQueue(Actor actor) {
        queue.add(actor);
        System.out.println(actor.getName() + " has been added to the queue.");

    }

    @Override
    public void takeOrders() {
        if (orders.containsKey(item)) {
            orders.put(item, orders.get(item) + quantity);
        } else {
            orders.put(item, quantity);
        }

    }

    @Override
    public Map<String, Integer> giviOrders() {
        Map<String, Integer> givenOrders = new HashMap<>();

        for (Map.Entry<String, Integer> entry : orders.entrySet()) {
            givenOrders.put(entry.getKey(), entry.getValue());
        }

        orders.clear();

        return givenOrders;
        
    }

    @Override
    public void releaseFromQueue() {
        if (!queue.isEmpty()) {
            Actor releasedActor = queue.remove(0);
            System.out.println(releasedActor.getName() + " has been released from the queue.");
        } else {
            System.out.println("Queue is empty.");
        }
    }

    @Override
    public void acceptToMarket(Actor actor) {
        visitors.add(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actorlList) {
        visitors.removeAll(actorlList);
    }

    @Override
    public void update() {
        takeOrders();
        giviOrders();
       
    }
    
}
