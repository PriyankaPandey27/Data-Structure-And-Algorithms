/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
public class LinkedListProduct {

    public static void main(String[] args) {

        MultiplyLinkedListNumber list = new MultiplyLinkedListNumber(9);
                 list.insertAtEnd(9);
                 list.insertAtEnd(9);

                 //create the second list
                 MultiplyLinkedListNumber list1 = new MultiplyLinkedListNumber(1);
                 list1.insertAtEnd(2);
                 list1.insertAtEnd(3);

                 //call the multiply method
                 MultiplyLinkedListNumber l= new MultiplyLinkedListNumber();
                 Node result = l.multiply(list, list1);

                 //print the list
                 result.display();

    }



}




class MultiplyLinkedListNumber{
         //Tree
        public Node head;
        public MultiplyLinkedListNumber(int x)
        {
            head.data=x;
        }

    MultiplyLinkedListNumber() {

    }

               //Utility to insert new node at the end of given list
               public void insertAtEnd(int data){
                      Node newNode = new Node(data);
                      Node n = head;
                      while(n.next != null){
                             n = n.next;
                      }
                      n.next = newNode;
               }

               //Utility function to print the given list
               public void display(){
                     Node temp = head;

                     while(temp != null){
                           if(temp.next !=null)
                                System.out.print(temp.data+"->");
                           else
                                System.out.print(temp.data);
                           temp = temp.next;
                     }
               }


         //Function to multiply two given lists
         //return resulted list
         public Node multiply(Node head, Node head1){
                //Base Condition
                if(head == null || head1 == null)
                       return null;

                int number = getNumber(head);  //convert one list into number

                //traverse the second list and multiply the number with the current element of the list and store in the new list.
                Node current = head1; Node result = null;
                while(current != null){
                        if(result == null){
                               result = new Node(current.data * number);
                        }else{
                               //multiply current element with the "number" and store in the new list node
                               Node temp = new Node(current.data * number);
                               temp.next = result;
                               result = temp;
                        }
                        current = current.next;
                }
                return process(result);
         }

         //Utility function
         public Node process(Node list){
                 Node head = list;
                 int carry = 0, i = 0;
                 //traverse the given list
                 while(head != null && head.next != null){
                         i = head.data;
                         head.data = (carry + i)%10;
                         carry = (i+carry)/10;
                         head = head.next;
                  }
                  head.data = head.data + carry;
                  return reverse(list);
         }

         //Utility function to reverse the given list
         //Ex: Input : 1->2->3
         //Output : 3->2->1
         public Node reverse(Node list){
                if(list == null)
                      return null;

                Node current = list, previous = null, forward;
                while(current != null){
                       forward = current.next;
                       current.next = previous;
                       previous = current;
                       current = forward;
                }
                return previous;
         }

         //Utility function to convert list into number
         //Ex : Input = 1->2->3
         //Output = 123
         public int getNumber(Node head){
                 int number = 0;
                 while(head != null){
                        number = 10*number + head.data;
                        head = head.next;
                 }
                 return number;
          }
         }
          class Node{
               int data;
               Node next = null;

               public Node(int data){
                      this.data = data;
               }
          }
