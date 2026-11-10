# Comprehensive DSA Guide: Binary Trees, Max-Heaps, and Min-Heaps

---

## 1. Foundational Concept: Trees & Binary Trees

A **tree** is a non-linear, hierarchical data structure composed of nodes connected by edges, without any cycles.

### Key Terminology
* **Root**: The topmost node of the tree with no parent.
* **Parent & Child**: If a directed edge runs from node $A$ to node $B$, $A$ is the parent and $B$ is the child.
* **Leaf (External Node)**: A node with no children.
* **Depth of a Node**: Number of edges on the path from the root to that node.
* **Height of a Node**: Number of edges on the longest downward path from that node to a leaf.
* **Height of a Tree**: The height of its root node.

### Types of Binary Trees
1. **Full Binary Tree (Strict Binary Tree)**: Every node has either $0$ or $2$ children.
2. **Perfect Binary Tree**: All internal nodes have two children and all leaf nodes reside at the exact same depth.
3. **Complete Binary Tree (CBT)**:
   * All levels are completely filled except possibly the last level.
   * On the last level, all nodes are positioned as far left as possible.
   * *Significance*: A Complete Binary Tree can be efficiently represented as an array without wasting memory on null pointers.
4. **Balanced Binary Tree**: For every node, the height difference between its left and right subtrees (the balance factor) is at most $1$.

---

## 2. Array Representation of a Complete Binary Tree

Because heaps are complete binary trees, they are almost universally implemented using arrays rather than pointer-based linked structures.

### 0-Indexed Array Mapping
For a node located at index $i$:
* **Parent index**: $\lfloor \frac{i - 1}{2} \rfloor$
* **Left child index**: $2i + 1$
* **Right child index**: $2i + 2$

### 1-Indexed Array Mapping
For a node located at index $i$ (with index $0$ left unused):
* **Parent index**: $\lfloor \frac{i}{2} \rfloor$
* **Left child index**: $2i$
* **Right child index**: $2i + 1$

---

## 3. What is a Heap?

A **heap** is a specialized tree-based data structure that satisfies two fundamental conditions:
1. **Structural Invariant**: It must be a **Complete Binary Tree**.
2. **Heap-Order Invariant**:
   * **Max-Heap Property**: For every node $i$ other than the root:
     $$\text{key}(\text{parent}(i)) \ge \text{key}(i)$$
     The maximum element is always at the root.
   * **Min-Heap Property**: For every node $i$ other than the root:
     $$\text{key}(\text{parent}(i)) \le \text{key}(i)$$
     The minimum element is always at the root.

> **Crucial Difference Between BST and Heap:**
> * In a **Binary Search Tree (BST)**, the left child is strictly smaller than the parent, and the right child is strictly greater. This provides an ordered traversal in $O(n)$ and binary search in $O(\log n)$ on average.
> * In a **Heap**, there is no ordered relationship between sibling nodes (the left child could be greater or smaller than the right child). Heaps are designed for constant-time access to the extremum (min or max), not for arbitrary searches.

---

## 4. Core Heap Operations

### 4.1 Insertion (`push`)
1. Place the new element at the first available position on the last level (the end of the array) to maintain the Complete Binary Tree shape.
2. **Percolate Up (Sift-Up / Bubble-Up)**: Compare the element with its parent. If the heap invariant is violated, swap with the parent. Repeat until the invariant holds or the node reaches the root.
* **Time Complexity**: $O(\log n)$ (maximum swaps equal to tree height $h \approx \log_2 n$).

### 4.2 Extract Extremum (`extractMax` or `extractMin`)
1. Save the root element (this is the value to return).
2. Move the last element of the heap array to the root position.
3. Decrement the heap size by 1.
4. **Percolate Down (Sift-Down / Heapify)**: Compare the new root with its children. Swap with the larger child (in a Max-Heap) or smaller child (in a Min-Heap). Repeat until the heap invariant is satisfied.
* **Time Complexity**: $O(\log n)$.

### 4.3 Peek (`getMax` or `getMin`)
* Inspect index $0$.
* **Time Complexity**: $O(1)$.

### 4.4 Building a Heap from an Unordered Array (`buildHeap`)
Instead of inserting elements one-by-one ($n \times O(\log n) = O(n \log n)$), we can build a heap in-place in linear time using **Floyd's Algorithm**:
1. Leaves are inherently valid trivial heaps of size 1. In a complete binary tree of size $n$, leaf nodes start at index $\lfloor n / 2 \rfloor$.
2. Iterate backward from the last non-leaf node down to the root:
   $$\text{for } i = \lfloor n/2 \rfloor - 1 \text{ down to } 0: \text{ siftDown}(i)$$
* **Time Complexity**: $O(n)$.
* **Mathematical Intuition**: Most nodes reside near the bottom of the tree and sift down at most $0$ or $1$ levels, while very few nodes near the top sift down $\approx \log n$ levels. Summing across heights:
  $$\sum_{h=0}^{\lfloor\log n\rfloor} \frac{n}{2^{h+1}} \cdot O(h) = O(n)$$

---

## 5. Summary of Time and Space Complexities

| Operation | Array-Based Heap Complexity | Auxiliary Space |
| :--- | :--- | :--- |
| **Find Min / Max** | $O(1)$ | $O(1)$ |
| **Insert** | $O(\log n)$ | $O(1)$ |
| **Delete Min / Max** | $O(\log n)$ | $O(1)$ |
| **Arbitrary Search** | $O(n)$ | $O(1)$ |
| **Build Heap (`heapify`)**| $O(n)$ | $O(1)$ |
| **Heap Sort** | $O(n \log n)$ | $O(1)$ (In-place) |

---

## 6. Multiple Choice Practice Questions (MCQs)

---

### Question 1 (Basic - Tree Properties)
**Which of the following statements correctly defines a Complete Binary Tree of height $h$?**

- A) Every non-leaf node has exactly two children, and all leaves are at depth $h$.
- B) All levels are completely filled except possibly the last level, where nodes are filled from left to right.
- C) The height of the left subtree and the right subtree of any node differ by at most $1$.
- D) Every node has at most one child, forming a linked chain.

**Correct Answer:** **B**  
**Explanation:**  
* Option A describes a *Perfect Binary Tree*.  
* Option B correctly describes a *Complete Binary Tree*, which is the mandatory structural property of binary heaps.  
* Option C describes an *AVL / Height-Balanced Tree*.  
* Option D describes a *Degenerate (Skewed) Tree*.

---

### Question 2 (Basic - Array Indexing)
**In a 0-indexed array representation of a binary heap, what is the index of the parent of a node located at index $k$ ($k > 0$)?**

- A) $\lfloor k / 2 \rfloor$
- B) $\lfloor (k - 1) / 2 \rfloor$
- C) $2k + 1$
- D) $\lfloor (k + 1) / 2 \rfloor$

**Correct Answer:** **B**  
**Explanation:**  
In 0-indexed systems, children of index $i$ are at $2i + 1$ and $2i + 2$. Reversing this relationship yields $\lfloor (k - 1) / 2 \rfloor$ for any child $k$. Formula A ($\lfloor k / 2 \rfloor$) is only valid for 1-indexed heap representations.

---

### Question 3 (Basic - Min-Heap Invariant)
**Consider the following level-order traversal of an array: `[3, 8, 5, 12, 10, 9, 7]`. Does this array represent a valid Min-Heap?**

- A) Yes, it satisfies both the complete binary tree structure and the min-heap property.
- B) No, because $8 > 5$ at level 1.
- C) No, because the child $9$ is greater than its parent $5$.
- D) No, because the root is smaller than both of its children.

**Correct Answer:** **A**  
**Explanation:**  
Let us check the parent-child relationships:
* Root at index 0: `3` has children at index 1 (`8`) and index 2 (`5`). Both $3 \le 8$ and $3 \le 5$ hold.
* Node at index 1: `8` has children at index 3 (`12`) and index 4 (`10`). Both $8 \le 12$ and $8 \le 10$ hold.
* Node at index 2: `5` has children at index 5 (`9`) and index 6 (`7`). Both $5 \le 9$ and $5 \le 7$ hold.  
Because every parent is less than or equal to its children, it is a valid Min-Heap. The relative order between siblings ($8$ and $5$) does not matter in heaps.

---

### Question 4 (Moderate - Build Heap Complexity)
**What is the tightest worst-case time complexity of building a binary heap from an arbitrary unsorted array of $n$ elements using Floyd’s bottom-up `buildHeap` algorithm?**

- A) $O(\log n)$
- B) $O(n)$
- C) $O(n \log n)$
- D) $O(n^2)$

**Correct Answer:** **B**  
**Explanation:**  
Although inserting $n$ elements one by one takes $O(n \log n)$, bottom-up heapification takes $O(n)$ because the number of nodes at height $h$ is at most $\lceil n / 2^{h+1} \rceil$, and each sifts down at most $h$ steps. The geometric series $\sum \frac{h}{2^h}$ converges to a constant factor, yielding $O(n)$.

---

### Question 5 (Moderate - Heap Operations)
**Given a Max-Heap represented by the array `[50, 30, 40, 15, 10, 20, 35]`, an element with value `60` is inserted. What is the state of the array after the heap invariant is restored?**

- A) `[60, 50, 40, 30, 10, 20, 35, 15]`
- B) `[60, 30, 50, 15, 10, 20, 35, 40]`
- C) `[60, 50, 40, 15, 10, 20, 35, 30]`
- D) `[50, 60, 40, 15, 10, 20, 35, 30]`

**Correct Answer:** **A**  
**Explanation:**  
1. Insert `60` at the end (index 7): `[50, 30, 40, 15, 10, 20, 35, 60]`.
2. Parent of index 7 is $\lfloor (7-1)/2 \rfloor = 3$ (value `15`). Since $60 > 15$, swap them:  
   `[50, 30, 40, 60, 10, 20, 35, 15]`.
3. Parent of index 3 is $\lfloor (3-1)/2 \rfloor = 1$ (value `30`). Since $60 > 30$, swap them:  
   `[50, 60, 40, 30, 10, 20, 35, 15]`.
4. Parent of index 1 is $\lfloor (1-1)/2 \rfloor = 0$ (value `50`). Since $60 > 50$, swap them:  
   `[60, 50, 40, 30, 10, 20, 35, 15]`.

---

### Question 6 (Moderate - Min-Heap Deletion)
**Starting from the Min-Heap array `[4, 7, 6, 12, 10, 15, 8]`, we perform an `extractMin()` operation. What will the array look like after the extraction and subsequent sift-down?**

- A) `[6, 7, 8, 12, 10, 15]`
- B) `[7, 8, 6, 12, 10, 15]`
- C) `[6, 7, 15, 12, 10, 8]`
- D) `[7, 10, 6, 12, 8, 15]`

**Correct Answer:** **A**  
**Explanation:**  
1. The minimum element `4` at the root is removed.
2. The last element `8` (at index 6) is moved to root position 0: `[8, 7, 6, 12, 10, 15]`.
3. Compare `8` with its children `7` (index 1) and `6` (index 2). The smaller child is `6` at index 2. Since $6 < 8$, swap:  
   `[6, 7, 8, 12, 10, 15]`.
4. Node `8` now has only child `15` at index $2(2)+1 = 5$. Since $8 < 15$, the sift-down terminates. Result: `[6, 7, 8, 12, 10, 15]`.

---

### Question 7 (Basic to Moderate - Searching in a Heap)
**What is the worst-case time complexity to search for an arbitrary element $x$ in a binary Max-Heap of size $n$?**

- A) $O(1)$
- B) $O(\log n)$
- C) $O(n)$
- D) $O(n \log n)$

**Correct Answer:** **C**  
**Explanation:**  
Unlike a Binary Search Tree, a heap does not enforce an ordering relationship between the left and right subtrees. As a result, searching for an arbitrary value may require visiting all $n$ nodes in the worst case, giving $O(n)$ time complexity.

---

### Question 8 (Moderate - Non-Leaf Nodes Count)
**In a complete binary tree represented as an array of $n$ elements (0-indexed from $0$ to $n-1$), what is the index range of all internal (non-leaf) nodes?**

- A) $0$ to $\lfloor n / 2 \rfloor$
- B) $0$ to $\lfloor n / 2 \rfloor - 1$
- C) $\lfloor n / 2 \rfloor$ to $n - 1$
- D) $1$ to $\lfloor (n - 1) / 2 \rfloor$

**Correct Answer:** **B**  
**Explanation:**  
The leaves in a complete binary tree of size $n$ occupy indices from $\lfloor n / 2 \rfloor$ up to $n - 1$. Therefore, the internal (non-leaf) nodes occupy indices from $0$ up to $\lfloor n / 2 \rfloor - 1$. This boundary is crucial for setting up the loop in `buildHeap`.

---

### Question 9 (Moderate - Selection Problem with Heaps)
**To find the $k$-th largest element in an unsorted stream of $n$ numbers ($k \ll n$) with optimal space complexity $O(k)$, which data structure should you maintain?**

- A) A Max-Heap of size $n$
- B) A Max-Heap of size $k$
- C) A Min-Heap of size $k$
- D) A Min-Heap of size $n - k$

**Correct Answer:** **C**  
**Explanation:**  
By maintaining a **Min-Heap of size $k$**, the root always holds the smallest of the top $k$ largest elements seen so far. For every incoming element, if it is larger than the root, we pop the root and insert the new element. At the end, the root contains the $k$-th largest element. This uses only $O(k)$ extra space.

---

### Question 10 (Moderate - Heap Sort In-Place)
**When implementing the classic in-place Heap Sort algorithm to sort an array in ascending order, which heap structure is typically constructed first?**

- A) Min-Heap
- B) Max-Heap
- C) Binomial Heap
- D) Fibonacci Heap

**Correct Answer:** **B**  
**Explanation:**  
To sort an array in ascending order in-place:
1. Build a **Max-Heap**. The maximum element is at index 0.
2. Swap index 0 with the last index $n-1$ and reduce heap size by 1.
3. Sift-down the root and repeat.  
This naturally places the largest elements in their final positions at the end of the array without requiring extra memory.