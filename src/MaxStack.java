import java.util.Stack;

public class MaxStack {
    Stack<Integer> st;

    MaxStack(){
        st = new Stack<>();
    }

    public void push(int val){
        st.push(val);
    }

    public void pop(){
        st.pop();
    }
}
