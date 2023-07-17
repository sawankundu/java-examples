package JavaTheory;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMapCode {
    static class HashMap<K, V>{
        private class Node{
            K key;
            V value;
            public Node(K key, V value){
                this.key = key;
                this.value = value;
            }
        }

        private int n;
        private int N;
        private LinkedList<Node> arr[];

        public HashMap(){
            this.N = 4;
            this.arr = new LinkedList[N];
            for(int i=0;i<N;i++){
                this.arr[i] = new LinkedList<>();
            }
        }

        private int hashFunc(K key) { // 0 to N-1
            int index = key.hashCode(); //it can be + or -
            return Math.abs(index) % N;
        }

        private int searchInLL(K key, int index) {
            LinkedList<Node> ll = arr[index];
            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }
            return -1;
        }

        private void reHash(){
            LinkedList<Node> oldArray[] = arr;
            arr = new LinkedList[N*2];

            for(int i=0;i<N*2;i++){
                arr[i] = new LinkedList<>();
            }

            for(int i=0; i<oldArray.length ; i++){
                LinkedList<Node> ll = oldArray[i];
                for(int j=0; j< ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key, V value){
            int index = hashFunc(key);
            int di = searchInLL(key, index);

            if(di == -1){ // if doesn't exist
                arr[index].add(new Node(key, value));
                n++;
            }else{ // if exist
                Node node = arr[index].get(di);
                node.value = value;
            }

            double lambda = (double) n/N;
            if(lambda > 2.0){
                //reHashing
                reHash();
            }
        }

        public V get(K key){
            int index = hashFunc(key);
            int di = searchInLL(key, index);

            if(di == -1){ // if doesn't exist
                return null;
            }else{ // if exist
                Node node = arr[index].get(di);
                return node.value;
            }
        }

        public boolean containsKey(K key){
            int index = hashFunc(key);
            int di = searchInLL(key, index);

            if(di == -1){ // if doesn't exist
                return false;
            }else{ // if exist
                return true;
            }
        }

        public V remove(K key){
            int index = hashFunc(key);
            int di = searchInLL(key, index);

            if(di == -1){ // if doesn't exist
                return null;
            }else{ // if exist
                Node node = arr[index].remove(di);
                n--;
                return node.value;
            }
        }

        public boolean isEmpty(){
            return n == 0;
        }

        public ArrayList<K> keySet(){
            ArrayList<K> ans = new ArrayList<>();
            for(int i=0; i<arr.length; i++){
                LinkedList<Node> ll = arr[i];
                for(int j=0; j< ll.size(); j++){
                    Node node = ll.get(j);
                    ans.add(node.key);
                }
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("India", 100);
        hm.put("Pakistan", 67);
        hm.put("US", 656);
        hm.put("Uk", 323);

        ArrayList<String> keys = hm.keySet();
        for(String s : keys){
            System.out.println(s + " " + hm.get(s));
        }

        hm.remove("Uk");
        System.out.println(hm.get("Uk"));
    }
}
