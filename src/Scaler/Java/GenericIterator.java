package Scaler.Java;

import java.util.Iterator;
import java.util.Stack;

public class GenericIterator {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);

        // Make a call to display method as per question requirements here
        display(st);
    }

    // Write the display method as per requirements of question here
    public static void display(Iterable<?> data) {
        Iterator itr = data.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
