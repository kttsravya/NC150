package LeetCode.AirBnb;

// step 1: maintain a pointers that indicate where we have traversed until
// step 2: create a method call advanceToNext() method which checks if current iterator points to valid value, it not
//........ it advances to next valid value.
// step 3: when hasNext() is called, it returns true, if iterator points to valid value, otherwise traverse to next valid value
//... by calling advanceToNext() method.
// step 4: next() method calls advanceToNext() first to get to valid position and returns it and increment the position by one.

import java.util.NoSuchElementException;

public class Flatten2DVector {
    int[][] vec = null;
    int row = 0;
    int col = 0;
    boolean isEmpty = false;
    public static void main(String[] args){
        Flatten2DVector ft = new Flatten2DVector(new int[][]{{}});
        System.out.println(ft.hasNext());
    }

    public Flatten2DVector(int[][] vec){
        this.vec = vec;
    }

    // it moves to next valid position, if current position is invalid.
    // ohterwise, it does nothing.
    public void advanceToNext(){
        while(row < vec.length && col == vec[row].length){
            col = 0;
            row ++;
        }
    }

    public int next(){
        if(! hasNext()) throw new NoSuchElementException();
        // incrementing col to next position after returning valid position
        /*int currentCol = col;
        this.col = this.col + 1;*/
        return this.vec[row][col++];
    }

    private boolean isValid(int row) {
        if(row == this.vec.length || row == -1 || this.isEmpty){
            return false;
        }
        return true;
    }

    public boolean hasNext(){
      advanceToNext();
      return row < vec.length;
    }
}
