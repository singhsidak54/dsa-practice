package daily.sep24;

public class Day30DesignAStackWithIncrementOperation {
    class CustomStack {
        int[] stack;
        int top;
        public CustomStack(int maxSize) {
            this.stack = new int[maxSize];
            this.top = -1;
        }

        public void push(int x) {
            if(this.top == this.stack.length - 1) return;
            this.top++;
            this.stack[this.top] = x;
        }

        public int pop() {
            if(top >= 0) {
                int ele = this.stack[this.top];
                this.top--;
                return ele;
            }
            return -1;
        }

        public void increment(int k, int val) {
            int max = Math.max(k, this.top);
            for(int i=max; i>=0; i--) {
                this.stack[i] += val;
            }
        }
    }

    static class CustomStackLazy {

        int[] stack, increment;
        int top;
        public CustomStackLazy(int maxSize) {
            this.stack = new int[maxSize];
            this.increment = new int[maxSize];
            this.top = -1;
        }

        public void push(int x) {
            if(this.top == this.stack.length - 1) return;
            this.top++;
            this.stack[this.top] = x;
        }

        public int pop() {
            if(this.top < 0) return -1;
            int ele = this.stack[this.top] + this.increment[this.top];

            if(this.top > 0) {
                this.increment[this.top - 1] += this.increment[this.top];
            }

            this.increment[this.top] = 0;
            this.top--;
            return ele;
        }

        public void increment(int k, int val) {
            int max = Math.min(k - 1, this.top);
            this.increment[max] += val;
        }
    }

    public static void main(String[] args) {
        CustomStackLazy obj = new CustomStackLazy(3);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.increment(5, 100);
        System.out.println(obj.pop());
    }
}