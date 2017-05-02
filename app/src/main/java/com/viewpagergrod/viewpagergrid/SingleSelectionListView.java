package com.viewpagergrod.viewpagergrid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Ramesh on 02/05/17.
 */

public class SingleSelectionListView extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        setContentView(listView);
        listView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends BaseAdapter {
        int mSelectedPos = -1;

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(SingleSelectionListView.this).inflate(R.layout.layout_single_selection, parent, false);
            }
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedPos = position;
                    notifyDataSetChanged();
                }
            });
            RadioButton rb = (RadioButton) convertView.findViewById(R.id.rb);
            TextView title = (TextView) convertView.findViewById(R.id.txt_title);
            title.setText("Title #" + position);
            rb.setChecked(mSelectedPos == position);
            return convertView;
        }
    }
}
