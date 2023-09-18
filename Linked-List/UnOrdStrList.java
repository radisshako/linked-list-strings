/** 
 * A class that defines and intialises a linked list of unordered strings.
 * Contains an inner class called StrNode that defines a list item,
 * consisting of a key for the string value and a next StrNode pointing to
 * the next item in the list. Allows items to be added, removed.
 * Returns whether the list is empty or has the value specified, it also contains
 * a function to display all the keys of the items to the console
 */
public class UnOrdStrList{
    /* a Head StrNode pointing to head of the linked list */
    private StrNode head;
    /* an int storing the length of the linked list */
    private int length;

    /*an inner class of UnOrdStrList
     * key holds the string value
     * next holds a link to another StrNode
      */
    private class StrNode{
        String key;
        StrNode next;

        /*Initialises a StrNode to the key passed in and
         * sets next to null
         */
        public StrNode(String s){
            key = s;
            next = null;
        }
    }
    

    /*Initialises an UnOrdStrList setting the head to null,
     and length to 0*/
    public UnOrdStrList(){
        head = null;
        length = 0;
    }


    /*adds to the head of the list a new StrNode 
     * with the String s as its key. Sets it to point
     * to the existing head, then 
     * makes new StrNode the head,
     * increments length by 1
     * returns void
     */
    public void add(String s){
        StrNode newStrNode = new StrNode(s);
        newStrNode.next = head;
        head = newStrNode;
        length++;
    }

    /*Returns a boolean value if the linked list
     * contains a node whose string value is the same as
     * s, and returns false otherwise
     */
    public boolean has(String s){
        //declare a temporary StrNode to traverse the linked list
        StrNode current = head;
        //While the StrNode is not null
        while(current != null){
            //if the key of the current item is the same as s
            if(current.key.equals(s)){
                return true;
            }
            //shift current along to the next item
            current = current.next;
        }
        //If no matching item is found return false
        return false;
    }


    /*Finds the first StrNode whose string value is s
     * and removes that StrNode, without affecting the 
     * the order of the remaining nodes in the list. If the list 
     * has no node with that value, the list is unchanged,
     * decrements length by 1 if an item is removed
     * Returns void
     */
    public void remove(String s){
        //if the list is empty do nothing
        if(head == null){
            return;
        }
        //If the head is what is to be removed
        if(head.key.equals(s)){
            //Create a temporary StrNode pointing to head
            StrNode temporary = head;
            //head takes on the value of the next field
            head = head.next;
            //set temporary StrNode to point to null
            temporary.next = null;
            //reduce the length of the list by one
            length--;
            return;
        }
        //Set current node to the head of the list
        StrNode current = head;
        //While the next node isnt null
        while(current.next != null){
            //if key of the next node = s
            if(current.next.key.equals(s)){
                //bypass the next node, by setting the next pointer to the node after 
                //the following node
                current.next = current.next.next;
                //decrement the length by 1
                length--;
                return;
            }
            //otherwise move to the next item in the list
            current = current.next;
        }
        

    }

    /*Returns an int of the number of nodes in the linked list
     * returns zero if the list is empty
     */
    public int length(){
        return length;
    }


    /*Returns a boolean true if length is zero 
     * False if not
     */
    public boolean isEmpty(){
        if(length == 0){
            return true;
        }
        return false;
    }


    /*For each node in the list, prints to the screen,
     * its string data value on a line by itself.
     * All values are printed in the order they appear in the list
     * returns void
     */
    public void dump(){
        //temporary node to traverse the linked list from the head
        StrNode current = head;
        //while current isn't null
        while(current != null){
            //print out the current nodes key value
            System.out.println(current.key);
            //move the current node along the list to the next item
            current = current.next;
        }
    }
}
