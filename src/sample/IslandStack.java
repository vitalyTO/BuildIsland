package sample;

public class IslandStack<T> implements MoveStackInterface<T> {
    protected final int maxSize = 4;
    protected T[] moveStack;
    protected int topIndex = -1;

    public IslandStack(){
        moveStack = (T[]) new Object[maxSize];
    }

    public IslandStack(int N){
        moveStack = (T[]) new Object[N];
    }

    public boolean isEmpty(){ //return true if stack is empty
        return topIndex==-1;
    }

    public boolean isFull(){ //return true if last index = stack size -1
        return (topIndex==moveStack.length-1);
    }

    public void push(T elem){
        if(!isFull()) {
            topIndex++;
            moveStack[topIndex]=elem;
        }
        else throw new StackOverflowError("Move Stack Is Full");
    }

    public void pop() { //removes element from the top if not empty
        try{ moveStack[topIndex] = null;topIndex--;}
        catch (Exception e){e.printStackTrace();}
    }

    public T top() { //returns elem from the top
        T topOfStack = null;
        try {topOfStack = moveStack[topIndex];}
        catch (Exception e){e.printStackTrace();}
        return topOfStack;
    }

    public T extract(int index) {
        T el = null;
        try {el = moveStack[index];}
        catch (Exception e){e.printStackTrace();}
        return el;
    }
}
