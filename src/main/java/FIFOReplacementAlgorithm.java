import java.util.LinkedList;
import java.util.Queue;

public class FIFOReplacementAlgorithm extends ReplacementAlgorithm {
    private Queue<Integer> queue;

    public FIFOReplacementAlgorithm(int pageFrameCount) {
        super(pageFrameCount);
        this.queue = new LinkedList<>();
    }

    @Override
    public void insert(int pageNumber) {
        if (!queue.contains(pageNumber)) {
            if (queue.size() == pageFrameCount) {
                queue.poll();
            }
            queue.add(pageNumber);
            pageFaultCount++;
        }
    }
}
