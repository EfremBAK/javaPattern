import java.util.ArrayList;

public class MyHT {

    final static int initialTableSize;
    static {
        initialTableSize = 20;
    }
    private int tableSize;
    private ArrayList[] table;

    public MyHT(){
        this(initialTableSize);
    }
    public MyHT(int tableSize){
        this.tableSize= tableSize;
        table = new ArrayList[tableSize];
    }

    private class Entry{
        String key;
        String value;
        Entry(String key, String  value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return getKey() + ":" + getValue();
        }
        public String getKey(){
            return key;
        }
        public String getValue(){
            return value;
        }

    }

    private int hashFunction(int hashCode){
        return hashCode % tableSize;
    }

    public boolean add(String key, String value){
        if(key == null ) return false;

        int hashCOde = key.hashCode();

        int hashValue= hashFunction(hashCOde);

        Entry e = new Entry(key, value);

        if(table[hashValue] == null){
            table[hashValue] = new ArrayList<Entry>();
            table[hashValue].add(e);
            return true;
        }else {
            for(int i=0; i<table[hashValue].size(); i++){
                Entry b = (Entry) table[hashCOde].get(i);
                if(b.getKey().equals(key)){
//                    if(b.getValue().equals(value)){
//                        System.out.println("Error: you are trying to write a duplicate of already stored key and value");
//                        return false;
//                    }
                    return false;
                }else {
                    table[hashValue].add(e);
                    return true;
                }
            }
        }
        return true;
    }

    public String  getIt(String key){
        if(key == null) return null;
        String output = "";
        int hashCode = key.hashCode();
        int hashValue = hashFunction(hashCode);
        for(int i = 0; i<table[hashValue].size(); i++){
            Entry b = (Entry) table[hashValue].get(i);
            if(b.key.equals(key)){
               output+= (b.toString() +"  " + hashValue + "\n");
            }
        }return output;
    }

// 1) Print each index value in the hash table followed by all the key fields (names)
    //        of the entries stored at that index.
    public String printAll(){
        String output = "";
        for(int i=0; i<table.length; i++){
            if(table[i] != null){
                for(int j=0; j<table[i].size();j++){
                    Entry g = (Entry) table[i].get(j);
                    output+=(g.toString() + "\n");
                }
            }
        }
        return output;
    }

//    2) Write a method that counts the number of elements in the hash table by traversing the hash
//    table and the LinkedList chains.  Test it Thoroughly!
    public int ElemetCounter(){
        int count=0;
        for(int i=0; i<table.length; i++){
            if(table[i] != null){
                count+=table[i].size();
            }
        }return count;
    }
//    3) Write a method that returns the number of elements in the longest java.util.LinkedList chain.  Test it!

    public int longestChain(){
        int longest=0;
        int focusCount=0;
        for(int i=0; i<table.length; i++){
            if(table[i] != null){
                focusCount = table[i].size();
                if(focusCount>longest) longest = focusCount;
            }
        }return longest;
    }

//    4) Write a method that returns the number of array cells that are still empty.  Test it!

    public int emptyCells(){
        int count=0;
        for(int i=0; i<table.length; i++){
            if(table[i] == null) count++;
        }return count;
    }




}

