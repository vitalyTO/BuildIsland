package sample;

public interface MoveStackInterface<T> { //stack holding objects of type T
    void pop() throws Exception; //removes top element from the stack
    T top() throws Exception; //returns top element from this stack
    T extract(int index);
    void push(T elem); //insert elem
    boolean isFull(); //true if no more space left in the stack
    boolean isEmpty(); //true if stack is empty
}
