# Page Replacement Algorithms

This repository contains implementations of three page-replacement algorithms: FIFO, LRU, and OPT (optimal). The goal of this project is to evaluate the performance of these algorithms using various configurations of page reference strings and page frames.

## Algorithm Performance

### Configurations Tested

1. **Reference String Size: 20, Number of Page Frames: 3**
   - Reference Strings: 
     - 7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1
     - 8,1,0,7,3,0,3,4,5,3,5,2,0,6,8,4,8,1,5,3
     - 4,6,4,8,6,3,6,0,5,9,2,1,0,4,6,3,0,6,8,4

2. **Generated Configurations**
   - Reference String Size (rss): 15
   - Number of Page Frames (npf): 3, 5, 7

### Best Performing Configuration and Algorithm

After testing all configurations and algorithms, the combination that performed the best was:

- **Algorithm:** OPT (Optimal)
- **Configuration:** Reference String Size: 15, Number of Page Frames: 7

### Analysis and Speculation

The OPT algorithm consistently performed the best because it replaces the page that will not be used for the longest period in the future. This foresight minimizes page faults better than FIFO and LRU, which do not consider future references.

**Reasoning:**
- **OPT Algorithm:** Knows future page requests and thus can make the most efficient replacement decisions, leading to the fewest page faults.
- **FIFO Algorithm:** Simply replaces the oldest page, which does not necessarily correlate with future needs, resulting in more page faults.
- **LRU Algorithm:** Replaces the least recently used page, which is a heuristic that performs well but cannot compete with the OPT algorithm's perfect knowledge of future requests.

### Big O Runtime Analysis

- **FIFO (First-In, First-Out):**
  - Time Complexity: O(1) for page insertion and O(1) for page replacement.
  - Space Complexity: O(n) where n is the number of page frames.

- **LRU (Least Recently Used):**
  - Time Complexity: O(n) for page replacement if implemented with a simple list, O(1) if implemented with a hash map and doubly linked list.
  - Space Complexity: O(n) where n is the number of page frames.

- **OPT (Optimal):**
  - Time Complexity: O(n*m) where n is the number of page frames and m is the number of pages in the reference string. This is due to the need to check the future reference string for every replacement.
  - Space Complexity: O(n) where n is the number of page frames.

The OPT algorithm, despite its higher time complexity due to the need to check future references, performs best in minimizing page faults. The trade-off is computational efficiency for better page fault performance.

### Conclusion

The optimal page replacement algorithm (OPT) performs the best in terms of minimizing page faults. However, it is not feasible for real-time systems due to its computational overhead. LRU offers a good balance and is more practical for real-world applications compared to FIFO.

## Author

- Your Name

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
