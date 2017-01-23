/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package amazon;

/**
 *
 * @author admin
 */
class CircularTour {

    public static void main(String[] args) {

        PetrolPump arr[] = {new PetrolPump(6, 4), new PetrolPump(3, 6), new PetrolPump(7, 3)};
        System.out.println("the strt point  " + printTour(arr, arr.length));



    }//O(N)

    public static int printTour(PetrolPump a[],int n)
    {
        int strt=0;
        int end=1;
        int currPetrol= a[strt].petrol-a[end].distance;
        while(strt!=end || currPetrol<0)
        {
            while(currPetrol<0 && strt!=end)
            {
                currPetrol-=a[strt].petrol-a[strt].distance;
                strt=(strt+1)%n;

                if(strt==0)
                    return -1;
            }

            currPetrol+=a[end].petrol-a[end].distance;
            end=(end+1)%n;
        }
        return strt;
    }



}

class PetrolPump
{
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }

}