import java.util.LinkedHashMap;
import java.util.Map;

public class LRUReplacementAlgorithm extends ReplacementAlgorithm {
    private LinkedHashMap<Integer, Integer> cache;

    public LRUReplacementAlgorithm(int pageFrameCount) {
        super(pageFrameCount);
        this.cache = new LinkedHashMap<>(pageFrameCount, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > pageFrameCount;
            }
        };
    }

    @Override
    public void insert(int pageNumber) {
        if (!cache.containsKey(pageNumber)) {
            pageFaultCount++;
        }
        cache.put(pageNumber, 0);
    }
}
