import java.util.Map;

public interface QueueBehaviour {
    void takeInQueue(Actor actor);
    void takeOrders();
    Map<String, Integer> giviOrders();
    void releaseFromQueue();
    
}
