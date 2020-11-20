package LinkedList;

public class SingleLL {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);

        list.displayList();
        while(!list.isEmpty()){
            list.deleteFirst();
            list.displayList();
            System.out.println("");
        }
    }
}

class LLNode{
    int iData;
    LLNode next;
    LLNode(int id){
        iData = id;
    }

    public void show(){
        System.out.println(iData);
    }
}

class LinkList{
    LLNode first;
    LinkList(){
        first = null;
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id){
        LLNode node = new LLNode(id);
        node.next = first;
        first = node;
    }

    public void deleteFirst(){
        first = first.next;
    }

    public void displayList(){
        LLNode current = first;
        while (current != null){
            current.show();
            current = current.next;
        }
    }
}