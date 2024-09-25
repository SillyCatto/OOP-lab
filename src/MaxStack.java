import java.util.Stack;

public class MaxStack {
    private final Stack<Integer> st;
    private final Stack<Integer> helperStack;

    MaxStack(){
        st = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int val){
        st.push(val);

        if (st.size() == 1){
            helperStack.push(val);
            return;
        }

        if (val > helperStack.peek()){
            helperStack.push(val);
        } else {
            helperStack.push(helperStack.peek());
        }
    }

    public int getMax(){
        return helperStack.peek();
    }
}
