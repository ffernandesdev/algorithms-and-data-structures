# Heap

## Definition

Heaps are essentially binary trees that follow three specific rules:

1. Nodes in a Heap must be filled in a specific order: from left to right
2. The ordering property: Parent is either smaller (min heap) or larger (max heap) than its children
2. Swaps between a child and parent are the mechanism used for maintaining Heap structure during insertion/deletion operations.

There are two types of Heap: Min Heap and Max Heap.

# Min Heap

## Definition

By definition, in a Min Heap, the value at the parent or root node must be smaller than the value of its children.
That means that, looking down the tree, the elements get bigger and bigger.

Take the following array of integers as an example:

[6, 3, 4, 7, 1, 8 ,5]

The expected Min Heap is:

        1
       / \
      3   4
     / \ / \
    7  6 8  5

The PriorityQueue class in Java implement Heaps. By default, the Min Heap is implemented by this class.

```java
PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>();
```

# Max Heap

## Definition

The Max Heap is the inverse of the Min Heap, which means that the value at the parent or root node must be bigger than the value of its children.
If we look down the tree, the elements get smaller and smaller.

Taking the same array of integers as an example, the expected Max Heap is:


        8
       / \
      6   7
     / \ / \
    3  1 4  5

We can also use the PriorityQueue class in Java for the Max Heap, but since it implements a Min Heap by default, we need to use Collections.reverOrder() to implement the Max Heap.

```java
PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>(
                Collections.reverseOrder());
```