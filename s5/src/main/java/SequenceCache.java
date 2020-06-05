import java.util.HashMap;
import java.util.Map;

public class SequenceCache {
    private Map<Integer, Worker> cache = new HashMap<>();

    public int length(int value){
        if(!cache.containsKey(value))
            cache.put(value, new Worker(value));

        Worker worker = cache.get(value);
        return worker.sequence();
    }
}
