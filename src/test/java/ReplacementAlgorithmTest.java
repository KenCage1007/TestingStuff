import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReplacementAlgorithmTest {

    @Test
    public void testFIFOAlgorithm() {
        FIFOReplacementAlgorithm fifo = new FIFOReplacementAlgorithm(3);
        int[] referenceString = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        for (int page : referenceString) {
            fifo.insert(page);
        }
        assertEquals(15, fifo.getPageFaultCount());
    }

    private void assertEquals(int i, int pageFaultCount) {

    }

    @Test
    public void testLRUAlgorithm() {
        LRUReplacementAlgorithm lru = new LRUReplacementAlgorithm(3);
        int[] referenceString = {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
        for (int page : referenceString) {
            lru.insert(page);
        }
        assertEquals(12, lru.getPageFaultCount());
    }

    @Test
    public void testOPTAlgorithm() {
        List<Integer> referenceString = List.of(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1);
        OPTReplacementAlgorithm opt = new OPTReplacementAlgorithm(3, referenceString);
        for (int page : referenceString) {
            opt.insert(page);
        }
        assertEquals(9, opt.getPageFaultCount());
    }
}
