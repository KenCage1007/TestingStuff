import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of page frames: ");
        int pageFrameCount = scanner.nextInt();

        List<List<Integer>> referenceStrings = List.of(
                List.of(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1),
                List.of(8, 1, 0, 7, 3, 0, 3, 4, 5, 3, 5, 2, 0, 6, 8, 4, 8, 1, 5, 3),
                List.of(4, 6, 4, 8, 6, 3, 6, 0, 5, 9, 2, 1, 0, 4, 6, 3, 0, 6, 8, 4)
        );

        for (int npf : List.of(3, 5, 7)) {
            for (List<Integer> referenceString : referenceStrings) {
                System.out.println("Reference String: " + referenceString);
                runAlgorithm(new FIFOReplacementAlgorithm(npf), referenceString, "FIFO");
                runAlgorithm(new LRUReplacementAlgorithm(npf), referenceString, "LRU");
                runAlgorithm(new OPTReplacementAlgorithm(npf, referenceString), referenceString, "OPT");
            }

            List<Integer> randomReferenceString = generateRandomReferenceString(15, 0, 9);
            System.out.println("Random Reference String: " + randomReferenceString);
            runAlgorithm(new FIFOReplacementAlgorithm(npf), randomReferenceString, "FIFO");
            runAlgorithm(new LRUReplacementAlgorithm(npf), randomReferenceString, "LRU");
            runAlgorithm(new OPTReplacementAlgorithm(npf, randomReferenceString), randomReferenceString, "OPT");
        }
    }

    private static void runAlgorithm(ReplacementAlgorithm algorithm, List<Integer> referenceString, String algorithmName) {
        for (int page : referenceString) {
            algorithm.insert(page);
        }
        System.out.println(algorithmName + " Page Faults: " + algorithm.getPageFaultCount());
    }

    private static List<Integer> generateRandomReferenceString(int size, int min, int max) {
        Random rand = new Random();
        List<Integer> referenceString = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            referenceString.add(rand.nextInt((max - min) + 1) + min);
        }
        return referenceString;
    }
}
