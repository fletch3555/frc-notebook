package com.plnyyanks.frcnotebook.datatypes;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.plnyyanks.frcnotebook.adapters.EventListArrayAdapter;

/**
 * Created by phil on 3/1/14.
 */
public class ListElement implements ListItem {
    private final String str1,key;
    private View view;
    private boolean selected=false;

    public ListElement(String text1,String key) {
        this.str1 = text1;
        this.key = key;
    }

    @Override
    public int getViewType() {
        return EventListArrayAdapter.ItemType.LIST_ITEM.ordinal();
    }

    @Override
    public View getView(LayoutInflater inflater, View convertView) {
        if(view == null){
            view = (View) inflater.inflate(android.R.layout.simple_list_item_1, null);

            TextView text1 = (TextView) view.findViewById(android.R.id.text1);
            text1.setText(str1);
            text1.setSelected(selected);
            if(text1.isSelected()){
                text1.setBackgroundResource(android.R.color.holo_blue_light);
            }else{
                text1.setBackgroundResource(android.R.color.transparent);
            }
        }
        return view;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public String getKey(){
        return key;
    }
}
