package com.recyclerview.azhar.recyclerviewmodelcrudopenactivity.data;

import java.util.ArrayList;

/**
 * Created by Azhar on 5/5/2017.
 */

public class CRUD {


    ArrayList<SpaceCraft> spaceCraftArrayList;

    public CRUD(ArrayList<SpaceCraft> spaceCraftArrayList) {
        this.spaceCraftArrayList = spaceCraftArrayList;
    }


    //Add

    public boolean addData(SpaceCraft spaceCraft) {

        try {
            spaceCraftArrayList.add(spaceCraft);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    //delete
    public boolean deleteData(int position) {
        try {
            spaceCraftArrayList.remove(position);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //update
    public boolean updateData(int position, SpaceCraft spaceCraft) {

        try {
            spaceCraftArrayList.remove(position);
            spaceCraftArrayList.add(position, spaceCraft);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    //get all data
    public ArrayList<SpaceCraft> getSpaceCraftArrayList() {

        return spaceCraftArrayList;
    }
}
