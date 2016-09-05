/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package MemoryConflict;

import java.util.Comparator;

/**
 *
 * @author admin
 */
public class Thread {

    int id,mryblock,time;
    char access;

    public Thread(int id, int mryblock, int time, char access) {
        this.id = id;
        this.mryblock = mryblock;
        this.time = time;
        this.access = access;
    }

    public char getAccess() {
        return access;
    }

    public int getId() {
        return id;
    }

    public int getMryblock() {
        return mryblock;
    }

    public int getTime() {
        return time;
    }

    public void setAccess(char access) {
        this.access = access;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMryblock(int mryblock) {
        this.mryblock = mryblock;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public static final Comparator<Thread> memoryBlock=new Comparator<Thread>(){

        public int compare(Thread o1, Thread o2) {
            if(o1.mryblock==o2.mryblock)
            {
               return o1.time-o2.time;

            }
            else
                return o1.mryblock-o2.mryblock;
        }

    };
}
