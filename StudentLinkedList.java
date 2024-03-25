import java.util.ArrayList;

public class StudentLinkedList {
    private StudentNode head;
    private StudentNode tail;

    //default constructor, no parameters: Head nad tail are null
    public StudentLinkedList(){
        head = null;
        tail = null;
    }

    //creates StudentNode from given student
    //adds StudentNode to LinkedList at end of list
    public void insertNode(Student student){
        StudentNode node = new StudentNode(student);
        if(head == null){
            head = node;
        }
        else {
            tail.setNext(node);
        }
        tail = node;
    }

    //looks for and returns a StudentNode in a list from a given key (String)
    public StudentNode searchNode(String name){
        StudentNode current = head;
        if(!current.getStudent().getName().equals(name)){
            while(current.getNext() != null){
                String sname = current.getNext().getStudent().getName();
                if(sname.equals(name)){
                    System.out.println("Prev    Node => " + current.getStudent().getName());
                    System.out.println("Current Node => " + current.getNext().getStudent().getName());
                    if(current.getNext().getNext()!=null)System.out.println("Next Node    => " + current.getNext().getNext().getStudent().getName());
                    return current.getNext();
                }
                else
                    current = current.getNext();
            }
        }
        return current;
    }

    //returns all of the nodes in a list in an ArrayList
    public ArrayList<String> getNodes(){
        ArrayList<String> nodes = new ArrayList<String>();
        StudentNode current = head;
        while(current.getNext()!=null){
            nodes.add(current.getStudent().getName());
            current=current.getNext();
        }
        nodes.add(current.getStudent().getName());
        return nodes;
    }

    //deletes a node in a linked list and relinks the nodes before and after it
    //given a key (String)
    public void deleteNode(String name){
        StudentNode current = head;
        if(!current.getStudent().getName().equals(name)){
            while(current.getNext() != null){
                String sname = current.getNext().getStudent().getName();
                if(sname.equals(name)){
//                    System.out.println("Prev    Node => " + current.getStudent().getName());
//                    System.out.println("Current Node => " + current.getNext().getStudent().getName());
//                    System.out.println("Next Node    => " + current.getNext().getNext().getStudent().getName());
                    current.setNext(current.getNext().getNext());
                    System.out.println("=====================");
                    break;
                }
                else
                    current = current.getNext();
            }
        }
    }

    //removes the node after the given node
    //uses deleteNode() function
    public void removeAfter(String key){
        StudentNode s = searchNode(key);
        if(s.getNext()!=null && s.getNext().getNext()!=null){
            deleteNode(s.getNext().getStudent().getName());
        }
    }

    //takes a key and removes all instances of said key in the linked list
    public void removeDuplicate(String key){
        StudentNode current = head;
            while(current.getNext() != null){
                String sName = current.getNext().getStudent().getName();
                if(sName.equals(key)){
                    current.setNext(current.getNext().getNext());
                }
                else
                    current = current.getNext();
            }
    }

    //returns the maximum age of students in a linked list
    public int max(){
        int max=0;
        StudentNode current = head;
        while(current.getNext() != null){
            if(current.getStudent().getAge() > max) max=current.getStudent().getAge();
            current=current.getNext();
        }

        return max;
    }

    //returns a StudentLinkedList with the exact Nodes as the original list
    public StudentLinkedList copy(){
        StudentLinkedList newList = new StudentLinkedList();
        StudentNode current = head;
        while(current.getNext()!=null) {
            newList.insertNode(current.getStudent());
            current=current.getNext();
        }
        newList.insertNode(tail.getStudent());
        return newList;
    }

    //returns a string with all of the names of the students
    public String printList(){
        String temp="";
        StudentNode current = head;
//        System.out.println("========Print Start=============");
        temp+=current.getStudent().getName()+"\n";
        while(current.getNext() != null){
            temp+=current.getNext().getStudent().getName()+"\n";
            current = current.getNext();
        }
//        System.out.println("========Print End=============");
        return temp;
    }

}