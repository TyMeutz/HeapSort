package treeland;

/**
 *
 * @author ty.meutz
 * @param <E>
 */
public class TreeLand<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    
    // This method creates a heap from an array of objects
    public TreeLand(E[] objects){
        for (int i = 0; i < objects.length; i++){
            add(objects[i]);
        }
    }
    
    // Adds objects to the heap
    /**
     * Implements the heap sort algorithm from Java Programming 9th edition
     * by Daniel Lang
     * 
     * @param newObject 
     */
    private void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;
        
        while(currentIndex > 0){
            int parentIndex = (currentIndex - 1) / 2;
            //Swaps if current object is greater than its parent
            System.out.println("ParentIndex: "+parentIndex + "CurrentIndex: "+ currentIndex);
            if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
                E temp = list.get(currentIndex);
                list.set(currentIndex,list.get(parentIndex));
                list.set(parentIndex, temp);
            }else
                break; //The tree is a heap now
            currentIndex = parentIndex;
        }
    }
    
    
    /**
     * Removes the root from the heap. 
     * The method moves the last object to the root position and swaps it with the 
     * larger value if and only if its less than the larger value
     * @return 
     */
    public E remove(){
        if(list.isEmpty() ) return null;
        
        E removedObject = list.get(0); // root
        list.set(0, list.get(list.size() - 1)); // new root
        list.remove(list.size() - 1); // remove last
        
        int currentIndex = 0;
        while (currentIndex < list.size()){
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            
            //Find the maximum
            if(leftChildIndex >= list.size()) break; //The tree is a heap
                int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()){ 
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0){ //Compares two values
                    maxIndex = rightChildIndex;
                }
            }
            
            //Swaps with the larger value
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0){
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                
                currentIndex = maxIndex;
            }else break; //The tree is a heap
            
        }
        return removedObject;
    }
    
    /**
     * Returns the size of a list
     * 
     * @return list size
     */
    public int getSize(){
        //get number of nodes from a tree
        return list.size();
    }
}
