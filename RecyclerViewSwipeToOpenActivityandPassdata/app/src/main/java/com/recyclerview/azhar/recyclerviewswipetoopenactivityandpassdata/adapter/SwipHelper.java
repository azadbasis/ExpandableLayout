package com.recyclerview.azhar.recyclerviewswipetoopenactivityandpassdata.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by Azhar on 5/1/2017.
 */

public class SwipHelper extends ItemTouchHelper.SimpleCallback {

    CustomAdapter customAdapter;

    public SwipHelper(int dragDirs, int swipeDirs) {
        super(dragDirs, swipeDirs);
    }

    public SwipHelper( CustomAdapter customAdapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.RIGHT);
        this.customAdapter = customAdapter;
    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
      customAdapter.openDialoguFragment();
    }
}
