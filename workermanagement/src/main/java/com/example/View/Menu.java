package com.example.View;


import java.util.ArrayList;
import com.example.Common.Library;

/**
 *
 * @author ACER
 * @param <T>
 */
public abstract class Menu<Thing> {

    protected String title;
    protected ArrayList<Thing> mChon;
    Library l = new Library();

    public Menu() {
        mChon = new ArrayList<>();
    }

    @SuppressWarnings("unchecked")
    public Menu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String string : mc) {
            mChon.add((Thing) string);
        }
    }

    //-------------------------------------------
    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + "." + mChon.get(i));
        }
        System.out.println("--------------------------------");
    }
//-------------------------------------------

    public int getSelected() {
        display();
        return l.getInt("Enter your choice", 1, mChon.size());
    }
//-------------------------------------------

    public abstract void execute(int n);
//-------------------------------------------

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n > mChon.size()) {
                break;
            }
        }
    }

}

