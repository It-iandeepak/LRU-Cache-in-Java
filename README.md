# 🧠 LRU Cache Implementation in Java

This project implements an **LRU (Least Recently Used) Cache** in Java using a combination of a **LinkedList** and a **HashMap** for efficient O(1) access and update operations.

---

## 🔍 What is an LRU Cache?

An **LRU Cache** discards the **least recently used items first** when the cache reaches its limit. It is often used in memory management systems to ensure the most relevant or recently accessed data stays available.

---

## 📂 Features

- ✅ O(1) time complexity for `getValue` and `insertKeyValue` operations
- ✅ Uses `HashMap` and `LinkedList` from Java Collections Framework
- ✅ Handles cache eviction automatically when capacity is full
- ✅ Tracks the most recently used item

---

## 🧱 Implementation Details

- **`LinkedList<Node>`** maintains the order of usage (front = most recent).
- **`HashMap<String, ListIterator<Node>>`** provides O(1) lookup of nodes.
- **Custom class `Node`** stores the key-value pair.
- If a key is accessed or updated, it moves to the front of the list.

---

## 🚀 Usage

```java
LRUCache lru = new LRUCache(3);          // Create LRU Cache with capacity 3
lru.insertKeyValue("mango", 10);         // Insert key-value pairs
lru.insertKeyValue("apple", 20);
lru.insertKeyValue("banana", 30);
System.out.println(lru.mostRecentKey()); // Outputs: banana

lru.insertKeyValue("mango", 40);
System.out.println(lru.mostRecentKey()); // Outputs: mango (updated = moved to front)

Integer val = lru.getValue("mango");     // Access mango (now most recent)
if (val != null) {
    System.out.println("Order of Mango " + val); // 40
}

lru.insertKeyValue("guava", 20);         // Evicts least recently used item

if (lru.getValue("apple") == null) {
    System.out.println("apple doesn't exist");
}
```

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

- Java Collections Framework: `LinkedList`, `HashMap`, `ListIterator`
- Cache design pattern
- OOP in Java (classes, encapsulation)

---

## 📃 License

This project is open source and free to use under the [MIT License](https://opensource.org/licenses/MIT).
