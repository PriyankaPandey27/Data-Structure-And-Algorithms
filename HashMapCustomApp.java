/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package customhashmap;

public class HashMapCustomApp {
     
    public static void main(String[] args) {
           HashMapCustom<String, Integer> hashMapCustom = new HashMapCustom<String, Integer>();
           hashMapCustom.put("abc", 12);
           hashMapCustom.put("abc", 100);
           hashMapCustom.put("nikki", 121);
          // hashMapCustom.put(29, 150);
//           hashMapCustom.put(30, 151);
//           hashMapCustom.put(33, 15);
//           hashMapCustom.put(35, 89);
// 
//           System.out.println("value corresponding to key 21="
//                        + hashMapCustom.get("nikki"));
//           System.out.println("value corresponding to key 29="
//                        + hashMapCustom.get("nikki"));
//// 
////           System.out.print("Displaying : ");
////           hashMapCustom.display();
//// 
//           System.out.println("\n\nvalue corresponding to key 21 removed: "
//                        + hashMapCustom.remove(21));
//           
//            System.out.println("value corresponding to key 21="
//                        + hashMapCustom.get(21));
            
           System.out.println("value corresponding to key 51 removed: "
                        + hashMapCustom.remove("nikki"));
               System.out.println("value corresponding to key 29="
                        + hashMapCustom.get("nikki"));
// 
//           System.out.print("Displaying : ");
//           hashMapCustom.display();
 
    }
}
 
