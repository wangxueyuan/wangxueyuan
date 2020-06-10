package jvm;

public class MyLock {

    private static class Node{
        Thread thread;
        Node pre;
        Node next;
        public Node() {

        }
        public Node(Thread thread, Node pre) {
            this.thread=thread;
            this.pre=pre;
        }
    }

    private volatile Node head;
    private volatile Node tail;
}
