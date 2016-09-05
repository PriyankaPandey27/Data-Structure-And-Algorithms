/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package flatteningofLL;

/**
 *
 * @author admin
 */
public class LLFlattening {

    public static void main(String[] args) {
        Node l30=new Node(30,null,null);
        Node l8=new Node(8,null,l30);
        Node l7=new Node(7,null,l8);
        Node l20=new Node(20,null,null);
        Node l50=new Node(50,null,null);
        Node l22=new Node(22,null,l50);
        Node l45=new Node(45,null,null);
        Node l40=new Node(40,null,l45);
        Node l35=new Node(35,null,l40);
        Node l28=new Node(28,null,l35);
        Node l19=new Node(19,l28,l22);
        Node l10=new Node(10,l19,l20);
        Node l5=new Node(5,l10,l7);

//        l5=flatten(l5);
//        displayLL1(l5);
        flatten2(l5);
        displayLL2(l5);

        ///  to print 5->10->19->28->7->20->22->35->8->50->40->30->45


    }


    public static void display(Node root)
    {
        if(root==null)
            return;

        System.out.print(root.x + " ");
        display(root.down);
        display(root.next);
    }

    public static void displayLL2(Node root2)
    {
        Node temp=root2;
        while(temp!=null)
        {
            System.out.print(temp.x + " ");
            temp=temp.next;
        }
    }
    
    public static void displayLL1(Node root1)
    {
        Node temp=root1;
        while(temp!=null)
        {
            System.out.print(temp.x + " ");
            temp=temp.down;
        }
    }

//    public static Node flatten(Node root)
//    {
//        Node temp=root;
//        Node tmp=null;
//        Node prev=null;
//
//        while(temp.next!=null && temp.down!=null || prev!=null|| (temp.down!=null && temp.next==null))
//        {
//            if(temp.down.x<temp.next.x && temp.next!=null && temp.down!=null)
//            {
//                prev=temp.next;
//                temp.next=null;
//                while(temp.down!=null && temp.down.x < prev.x)
//                {
//                tmp=temp.down.down;
//
//                temp.next=temp.down;
//                temp.down=null;
//                temp=temp.next;
//                }
//                tmp.next=null;
//                temp.next=prev;
//                temp=temp.next;
//                prev=null;
//            }
//
//            if(temp.next.x<temp.down.x && temp.next.down.x>temp.down.x)
//            {
//                prev=temp.next.next;
//                temp.next.next=null;
//                temp.next.next=temp.down;
//                temp.down=null;
//                temp=temp.next;
//            }
//
//            if(temp.next.x<temp.down.x && temp.next.x<prev.x && temp.next.x<tmp.x)
//            {
//                temp.next=temp.down;
//                temp.down=null;
//                temp=temp.next;
//            }
//
//            if(prev.x>temp.x && prev.x<tmp.x)
//            {
//                prev.next=tmp;
//                tmp=temp.down;
//                temp.down=null;
//                temp.next=prev;
//                prev=null;
//                temp=temp.next;
//
//
//            }
//            if(temp.next.x<temp.down.x)
//            {
//                temp.next=temp.down;
//                temp.down=null;
//                temp=temp.next;
//            }
//
//            if(temp.down!=null && temp.down.x<tmp.x)
//            {
//            while(temp.down!=null)
//            {
//                temp.next=temp.down;
//                temp.down=null;
//                temp=temp.next;
//            }
//
//            temp.next=tmp;
//            tmp.next=null;
//            }
//
//        }
//
//        return root;
//    }



    public static Node merge(Node a,Node b)
    {
        if(a==null)
            return b;
        if(b==null)
            return a;

        Node result;
        if(a.x<b.x)
        {
            result=a;
            result.down=merge(a.down, b);
        }
        else
        {
            result=b;
            result.down=merge(a, b.down);
        }

        return result;
    }


    public static Node flatten(Node root)
    {
        if(root==null||root.next==null)
            return root;

        root.next=flatten(root.next);
        root=merge(root, root.next);
        return root;
    }

    public static void flatten2(Node root)
    {
        if(root==null)
            return;

        Node tail=root;
        Node cur=root;
        Node tmp=null;

        if(root.next!=null)
        {

        while(tail.next!=null)
        {
            tail=tail.next;
        }

        while(cur!=tail)
        {

            if(cur.down!=null)
            {
                tmp=cur.down;
                tail.next=cur.down;
                while(tmp.next!=null)
                {
                    tmp=tmp.next;
                }
                tail=tmp;
            }
            cur=cur.next;
        }
        }
        else
        {
            while(cur!=null)
            {
                cur.next=cur.down;
                cur=cur.next;
            }
        }


    }

}
