# 🧠 LRU Cache Implementation in Java

This project implements an **LRU (Least Recently Used) Cache** in Java using a **custom Doubly Linked List** and a **HashMap** for efficient O(1) access and update operations.

---

## 🔍 What is an LRU Cache?

An **LRU Cache** discards the **least recently used items first** when the cache reaches its limit. It is often used in memory management systems to ensure the most relevant or recently accessed data stays available.

---

## 📂 Features

- ✅ O(1) time complexity for `getValue` and `insertKeyValue` operations
- ✅ Uses `HashMap` for O(1) key lookup
- ✅ Custom **Doubly Linked List** with `prev` and `next` pointers
- ✅ Dummy `head` and `tail` nodes to eliminate edge case null checks
- ✅ Handles cache eviction automatically when capacity is full
- ✅ Tracks the most recently used item

---

## 🧱 Implementation Details

- **Custom `Node` class** stores the key, value, and `prev`/`next` pointers for doubly linked list traversal.
- **`HashMap<String, Node>`** provides O(1) direct access to any node.
- **Dummy `head` node** always points to the most recently used item.
- **Dummy `tail` node** always points just after the least recently used item.
- **`removeNode()`** — detaches a node from its current position in O(1).
- **`addToFront()`** — inserts a node right after head (most recent position) in O(1).
- If a key is accessed or updated, it is moved to the front of the list.
- If capacity is full, the node just before `tail` (LRU item) is evicted.

---

## 🚀 Usage

```java
LRUCache lru = new LRUCache(3);          // Create LRU Cache with capacity 3
lru.insertKeyValue("mango", 10);         // Insert key-value pairs
lru.insertKeyValue("apple", 20);
lru.insertKeyValue("banana", 30);
System.out.println(lru.mostRecentKey()); // Outputs: banana

lru.insertKeyValue("mango", 40);         // Update mango — moves to front
System.out.println(lru.mostRecentKey()); // Outputs: mango

Integer val = lru.getValue("mango");     // Access mango (most recent)
if (val != null) {
    System.out.println("Order of Mango " + val); // 40
}

lru.insertKeyValue("guava", 20);         // Evicts least recently used item

if (lru.getValue("apple") == null) {
    System.out.println("apple doesn't exist");
}
```

---

## 🧠 Doubly Linked List Structure

```
[HEAD] <-> [most recent] <-> [...] <-> [least recent] <-> [TAIL]
```

- Insertions and updates always go next to `HEAD`
- Evictions always happen from next to `TAIL`
- `prev` and `next` pointers allow O(1) removal from any position

---

## 🛠️ Requirements

- Java 8 or higher
- Any standard Java compiler (javac / IntelliJ IDEA / Eclipse / VS Code)

---

## 💻 How to Run

```bash
javac LRUCache.java
java LRUCache
```

---

## 📌 Example Output

```
banana
mango
Order of Mango 40
apple doesn't exist
```

---

## 📚 Concepts Covered

- Custom Doubly Linked List (`prev` / `next` pointers)
- `HashMap` for O(1) node lookup
- Cache design pattern (LRU eviction policy)
- OOP in Java (classes, encapsulation, helper methods)
- Dummy head/tail technique for clean pointer manipulation

---

## 📃 License

This project is open source and free to use under the [MIT License](https://opensource.org/licenses/MIT).
