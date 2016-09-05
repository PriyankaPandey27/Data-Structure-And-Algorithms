/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author admin
 */
public class BestSellingPrice {
 
    
    static Map<Integer,ArrayList<Integer>> prod=new HashMap<Integer,ArrayList<Integer>>();
    static ArrayList<Integer> blacklist = new ArrayList<Integer>() ;
    public static void main(String[] args) {

        addProduct(1);
        addProduct(2);
        addProduct(3);
        addProduct(4);
        printProd();

        addPurchase(1, 22);
        addPurchase(1, 22);
        addPurchase(1, 23);
        addPurchase(2, 22);
        addPurchase(1, 22);
        addPurchase(3, 24);
        addPurchase(3, 25);
        addPurchase(3, 25);
       addPurchase(4, 22);

        addPurchase(3, 25);

        addPurchase(2, 24);
        addPurchase(2, 25);
        addPurchase(2, 26);
        addPurchase(3, 24);

        addPurchase(3, 24);
        addPurchase(3, 24);
        addPurchase(3, 24);
        printProd();


        returnProduct(3, 24);
        returnProduct(2, 24);
//        printProd();
//
        blackListUser(22);
//        addPurchase(2, 22);
        printProd();



    }



    public static void addPurchase(Integer prodId,Integer userId)
    {
        //System.out.println("product  " + prodId + " user " + userId);

        //blacklist.add(userId);
       // System.out.println("");

        if(!blacklist.contains(userId))
        {
            //System.out.println("inside blacklist");
         if(prod.get(prodId)!=null)
         {
             //System.out.println("inside key");
             if(prod.get(prodId).size()==0)
             {
               //  System.out.println("inside size");
               prod.get(prodId).add(userId);
             }
             else
             {
                 boolean flag= false ;
                 ArrayList<Integer> res=prod.get(prodId);
                 for(Integer r:res)
                 {
                     //System.out.println("res  " + r + " user " + userId);
                     if(r==userId)
                     {
                         flag =true;
//                     prod.get(prodId).remove(userId);
                     break;
                     }
                     
                 }
                 if(!flag)
                 {
                     prod.get(prodId).add(userId);
                 }
                 
//                  prod.get(prodId).add(userId);
             }
               

              
          }
        }
        else
        {
           System.out.println("userid is blacklisted");
        }
    }

    public static void addProduct(Integer prodId)
    {

        
        if(prod.get(prodId)==null)
            prod.put(prodId, new ArrayList<Integer>());
     



    }

    public static void returnProduct(Integer prodId,Integer userId)
    {
         if(prod.get(prodId)==null)
         {
             System.out.println("cant initiate return on this product as it has not been purchased");
         }
         if(prod.get(prodId)!=null)
         {

               ArrayList<Integer> res=prod.get(prodId);
                 for(Integer r:res)
                 {
                    // System.out.println("res  " + r + " user " + userId);
                     if(r==userId)
                     {
                     prod.get(prodId).remove(userId);
                     break;
                     }

                 }
         }
    }

    public static void blackListUser(int userId)
    {

        blacklist.add(userId);
       for(Map.Entry<Integer, ArrayList<Integer>> entry : prod.entrySet())
       {
          ArrayList<Integer> res=entry.getValue();
                 for(Integer r:res)
                 {
                    // System.out.println("res  " + r + " user " + userId);
                     if(r==userId)
                     {
                     prod.get(entry.getKey()).remove(r);
                     break;
                     }

                 }
       }
    }

    public static void printProd()
    {
      //  System.out.println("size " + blacklist.size());
       for(Map.Entry<Integer, ArrayList<Integer>> entry : prod.entrySet())
       {
           if(entry.getKey()!=null)
           {
               System.out.println("key ::: " + entry.getKey() );
               ArrayList<Integer> res=prod.get(entry.getKey());
               for(Integer u : res)
               {
                   System.out.println(u + " ");
               }
           }
           System.out.println("");
       }
    }

}
