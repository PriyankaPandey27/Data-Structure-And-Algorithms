/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package binarytree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author admin
 */
 class FiringList {

    //public static Node root;
     public static int finalsum=Integer.MIN_VALUE;

    public static void main(String[] args) {

        Node root=new Node("E1",5,100);
        root.children.add(new Node("E2",3,50));
        root.children.add(new Node("E3",3,40));
        root.children.add(new Node("E14",4,50));
        root.children.add(new Node("E4",5,50));
        root.children.get(0).children.add(new Node("E5",3,10));
        root.children.get(0).children.add(new Node("E6",5,20));
        root.children.get(0).children.add(new Node("E7",4,20));
        root.children.get(0).children.add(new Node("E8",4,30));
        root.children.get(3).children.add(new Node("E9",5,22));
        root.children.get(3).children.add(new Node("E10",2,30));
        root.children.get(3).children.add(new Node("E11",3,40));
        root.children.get(3).children.get(0).children.add(new Node("E12",3,10));
        root.children.get(3).children.get(0).children.add(new Node("E13",3,12));

        printLevelorder(root);
       // calculateSavings(root, 2);
        checkManager(root,"E1", 2);



    }

    public static void printLevelorder(Node m)
    {
        if(m==null)
            return;

        Queue<Node> q=new LinkedList<Node>();
        q.add(m);
        while(!q.isEmpty())
        {
            int n=q.size();
            while(n>0)
            {
                Node p=q.remove();
                System.out.print(p.Id.toString() + " ");

                for(Node d:p.children)
                    q.add(d);
                n--;
            }
            System.out.println("");
        }

    }


    public static void checkManager(Node root,String id,int rating)
    {
           if(root.children==null)
               return;
           int saving=0;
           if(root.getId().equalsIgnoreCase(id))
           {
              // System.out.println("children " + root.getId().toString());
                saving=calculateSavings(root, rating,saving);
                System.out.println("Total savings after firing " + saving);
           }
           else
           {
               //checkManager(, rating);
               int n=root.children.size();
           //System.out.println("children size " + n);
           if(n>0)
           {
            for(int j=0;j<n;j++)
            {
               // System.out.println("children " + root.children.get(j).getId().toString());
                checkManager(root.children.get(j),id, rating);
            }
           }
           }

               

    }


    public static int calculateSavings(Node node,int rating,int sum)
    {
        if(node.children==null)
            return -1;
           int count=rating;
          // System.out.println("children inside " + node.getId().toString());
           ArrayList<RateSal> r=new ArrayList<RateSal>();
            for(Node d:node.children)
            {
                r.add(new RateSal(d.getRating(),d.getSal()));
            }

            Collections.sort(r, RateSal.salComparator);
            int i=0;
            while(count>0 && i<r.size())
            {
                sum+=r.get(i).sal;
                if(finalsum<sum)
                    finalsum=sum;
               // System.out.println("sum inside " + sum);
                i++;
                count--;
            }
           int n=node.children.size();
           if(n>0)
           {
            for(int j=0;j<n;j++)
            {
                //System.out.println("children " + root.children.get(j).getId().toString());
                calculateSavings(node.children.get(j), rating,finalsum);
            }
           }
           return finalsum;
    }

}








class Node
{
    String Id;
    int rating;
    int sal;
    ArrayList<Node> children;

    public Node(String Id, int rating, int sal) {
        this.Id = Id;
        this.rating = rating;
        this.sal = sal;
        children=new ArrayList<Node>();
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }



}


class RateSal
{
    int rating;
    int sal;

    public RateSal(int rating, int sal) {
        this.rating = rating;
        this.sal = sal;
    }

      public static final Comparator<RateSal> ratingComparator=new Comparator<RateSal>(){

        @Override
        public int compare(RateSal o1, RateSal o2) {
//            System.out.println("year o1 " + o1.getYear()+" year o2" + o2.getYear());
//            System.out.println("result " + (o1.getYear()-o2.getYear()));
            return o1.rating-o2.rating;
        }

    };

     public static final Comparator<RateSal> salComparator=new Comparator<RateSal>(){

        public int compare(RateSal o1, RateSal o2) {

            if(o1.rating==o2.rating)
            return o2.sal-o1.sal;
            else
            return ratingComparator.compare(o1, o2);
        }

    };

}

