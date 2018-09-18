package com.example.asifkhan.androidexpandablelistview.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.asifkhan.androidexpandablelistview.R;
import com.example.asifkhan.androidexpandablelistview.adapters.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> parent_title;
    private HashMap<String,List<String>> child_title;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;

    private static String PARENT_TITLE_ONE="Parent One";
    private static String PARENT_TITLE_TWO="Parent Two";
    private static String PARENT_TITLE_THREE="Parent Three";
    private static String PARENT_TITLE_FOUR="Parent Four";

    private static String CHILD_TITLE_ONE="Child One";
    private static String CHILD_TITLE_TWO="Child Two";
    private static String CHILD_TITLE_THREE="Child Three";
    private static String CHILD_TITLE_FOUR="Child Four";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar)findViewById(R.id.toolbar));
        parent_title=new ArrayList<>();
        child_title=new HashMap<>();
        expandableListAdapter=new ExpandableListAdapter(parent_title,child_title,this);
        expandableListView=(ExpandableListView)findViewById(R.id.expandable_list_view);
        getExpandableList();
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setGroupIndicator(null);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int i) {
                Toast.makeText(MainActivity.this, parent_title.get(i)+" expanded", Toast.LENGTH_SHORT).show();
            }
        });
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
                Toast.makeText(MainActivity.this, parent_title.get(i)+" -> "+child_title.get(parent_title.get(i)).get(i1), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    // getting expandable list view
    private void getExpandableList() {
        parent_title.add(PARENT_TITLE_ONE);
        parent_title.add(PARENT_TITLE_TWO);
        parent_title.add(PARENT_TITLE_THREE);
        parent_title.add(PARENT_TITLE_FOUR);

        // parent one
        List<String> parent_one=new ArrayList<>();
        parent_one.add(CHILD_TITLE_ONE);
        parent_one.add(CHILD_TITLE_TWO);
        parent_one.add(CHILD_TITLE_THREE);
        parent_one.add(CHILD_TITLE_FOUR);

        // parent two
        List<String> parent_two=new ArrayList<>();
        parent_two.add(CHILD_TITLE_ONE);
        parent_two.add(CHILD_TITLE_TWO);
        parent_two.add(CHILD_TITLE_THREE);
        parent_two.add(CHILD_TITLE_FOUR);

        // parent three
        List<String> parent_three=new ArrayList<>();
        parent_three.add(CHILD_TITLE_ONE);
        parent_three.add(CHILD_TITLE_TWO);
        parent_three.add(CHILD_TITLE_THREE);
        parent_three.add(CHILD_TITLE_FOUR);

        // parent four
        List<String> parent_four=new ArrayList<>();
        parent_four.add(CHILD_TITLE_ONE);
        parent_four.add(CHILD_TITLE_TWO);
        parent_four.add(CHILD_TITLE_THREE);
        parent_four.add(CHILD_TITLE_FOUR);

        // adding all the child with the respective parent
        child_title.put(PARENT_TITLE_ONE,parent_one);
        child_title.put(PARENT_TITLE_TWO,parent_two);
        child_title.put(PARENT_TITLE_THREE,parent_three);
        child_title.put(PARENT_TITLE_FOUR,parent_four);
    }
}
