import javax.swing.*;

public class TestEmployee {

    public static void main(String[] args) {
        //create student objects
        Student chris = new Student("Chris", 19, "CS", 2025);
        Student john = new Student("John", 20, "DS", 2026);
        Student bill = new Student("Bill", 17, "Math", 2027);
        Student mona = new Student("Mona", 30, "Physics", 2034);
        Student tom = new Student("Tom", 18, "Physics", 2034);

        //create StudentLinkedList from Student objects
        StudentLinkedList list = new StudentLinkedList();
        list.insertNode(chris);
        list.insertNode(bill);
        list.insertNode(john);
        list.insertNode(bill);
        list.insertNode(mona);
        list.insertNode(tom);

        //asks user which function they would like to perform
        String[] options = {"Remove after", "Copy", "Remove Duplicate", "Max"};
        int choice = JOptionPane.showOptionDialog(null, list.printList()+"\nWhat function would you like to perform on the list", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        //different function operations
        if(choice==0){
            Object[] nodes = list.getNodes().toArray();
            int nodeOpt = JOptionPane.showOptionDialog(null, "Which node would you like to delete after", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, nodes, nodes[0]);
            list.removeAfter(nodes[nodeOpt].toString());
            JOptionPane.showMessageDialog(null, "New List:\n"+list.printList());
        }//remove after
        else if(choice==1){
            StudentLinkedList list2 = new StudentLinkedList();
            list2 = list.copy();
            JOptionPane.showMessageDialog(null, "List 1:\n"+list.printList());
            JOptionPane.showMessageDialog(null, "List 2:\n"+list2.printList());
        }//copy
        else if(choice==2){
            JOptionPane.showMessageDialog(null, "List:\n"+list.printList());
            list.removeDuplicate("Bill");
            JOptionPane.showMessageDialog(null, "List without duplicates:\n"+list.printList());
        }//remove duplicate
        else{
            JOptionPane.showMessageDialog(null, "Maximum Age of Students: "+list.max());
        }//max
    }
}
