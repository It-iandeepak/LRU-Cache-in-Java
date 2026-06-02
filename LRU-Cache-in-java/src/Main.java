public class Main {
    public static void main(String []args){
        LRUCache lru = new LRUCache(3);
        lru.set("mango", 10);
        lru.set("apple", 20);
        lru.set("banana", 30);
        System.out.println(lru.getMostRecentKey());   // banana

        lru.set("mango", 50);                           // update, moves to front
        System.out.println(lru.getMostRecentKey());  //mango

        Integer val = lru.get("mango");
        if(null != val ){
            System.out.println("Order of mango : "+val);
        }

        lru.set("gauva", 100);
        if(null == lru.get("apple")){
            System.out.println("Apple does not exist.");
        }

    }
}
