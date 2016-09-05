/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rectangleoverlap;

/**
 *
 * @author admin
 */
class RectangleOverlap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Coordinates l1= new Coordinates(0,10);
        Coordinates r1= new Coordinates(10,0);
        Coordinates l2= new Coordinates(5,5);
        Coordinates r2= new Coordinates(15,0);
        
        boolean r=overlap(l1, r1, l2, r2);
        if(r==false)
        {
            System.out.println("rectangle doesnt overlap");
        }
        else
        {
            System.out.println("rectangle overlaps");
        }



    }

    public static boolean overlap(Coordinates l1,Coordinates r1,Coordinates l2,Coordinates r2 )
    {
        if(l1.x>=l2.x&&l1.x<=r2.x&&l1.y>=r2.y&&l1.y<=l2.y )
            return true;
        else if(l2.x>=l1.x&&l2.x<=r1.x&&l2.y>=r1.y&&l2.y<=l1.y)
            return true;

        return false;

    }

   public boolean g4gOverlap(Coordinates l1, Coordinates r1, Coordinates l2, Coordinates r2)
{
    // If one rectangle is on left side of other
    if (l1.x > r2.x || l2.x > r1.x)
        return false;

    // If one rectangle is above other
    if (l1.y < r2.y || l2.y < r1.y)
        return false;

    return true;
}

}

class Coordinates
{
    int x;
    int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
