import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OPTReplacementAlgorithm extends ReplacementAlgorithm {
    private List<Integer> frames;
    private List<Integer> referenceString;

    public OPTReplacementAlgorithm(int pageFrameCount, List<Integer> referenceString) {
        super(pageFrameCount);
        this.frames = new ArrayList<>(pageFrameCount);
        this.referenceString = referenceString;
    }

    @Override
    public void insert(int pageNumber) {
        if (!frames.contains(pageNumber)) {
            if (frames.size() < pageFrameCount) {
                frames.add(pageNumber);
            } else {
                int furthest = -1;
                int indexToReplace = -1;
                for (int i = 0; i < frames.size(); i++) {
                    int frame = frames.get(i);
                    int nextUse = referenceString.subList(referenceString.indexOf(pageNumber) + 1, referenceString.size()).indexOf(frame);
                    if (nextUse == -1 || nextUse > furthest) {
                        furthest = nextUse;
                        indexToReplace = i;
                    }
                }
                frames.set(indexToReplace, pageNumber);
            }
            pageFaultCount++;
        }
    }
}
