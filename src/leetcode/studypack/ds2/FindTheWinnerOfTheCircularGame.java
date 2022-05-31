package ds2;

class Node2 {
    int val;
    Node2 next;
    public Node2(int val, Node2 next) {
        this.val = val;
        this.next = next;
    }
}
public class FindTheWinnerOfTheCircularGame {

    public int findTheWinner(int n, int k) {
        Node2 head = new Node2(1, null);
        Node2 curr = head;

        for(int i=2; i<=n; i++) {
            curr.next = new Node2(i, null);
            curr = curr.next;
        }

        curr.next = head;
        Node2 prev = curr;
        curr = head;

        int deleted = 0;
        while(deleted != n-1) {
            int t = 1;
            while (t < k) {
                prev = curr;
                curr = curr.next;
                t++;
            }
            prev.next = curr.next;
            curr = curr.next;
            deleted++;
        }

        return curr.val;
    }

    public int findTheWinner2(int n, int k) {
        return josephus(n, k) + 1;
    }

    public static int josephus(int n, int k) {
        if(n==1)
            return 0;

        return (josephus(n-1, k) + k) % n;
    }

    public static int josephus2(int n, int k) {
        int result = 0;
        for(int i=1; i<=n; i++) {
            result = (result + k) % i;
        }
        return result + 1;
    }
}
