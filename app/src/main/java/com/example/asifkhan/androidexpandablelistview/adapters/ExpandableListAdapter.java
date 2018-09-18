package com.example.asifkhan.androidexpandablelistview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.asifkhan.androidexpandablelistview.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    private List<String> parent_list;
    private HashMap<String,List<String>> child_list;
    private Context context;

    public ExpandableListAdapter(List<String> parent_list, HashMap<String, List<String>> child_list, Context context) {
        this.parent_list = parent_list;
        this.child_list = child_list;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return parent_list.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return child_list.get(parent_list.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return parent_list.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_list.get(parent_list.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String parent_title=(String)getGroup(i);
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.parent_list,null);
        }
        TextView title=(TextView)view.findViewById(R.id.parent);
        title.setText(parent_title);
        return title;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String child_title=(String)getChild(i,i1);
        if(view==null){
            LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.child_list,null);
        }
        TextView title=(TextView)view.findViewById(R.id.child);
        title.setText(child_title);
        return title;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
