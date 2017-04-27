package com.viewpagergrod.viewpagergrid;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TextView txt_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        txt_selected = (TextView) findViewById(R.id.txt_selected);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                txt_selected.setText(position + 1 + "/" + viewPager.getAdapter().getCount());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //
        List<DummyData> data = getData();
        int pages = data.size() / 8 + 1;
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        for (int page = 0; page < pages; page++) {
            List<DummyData> subList = getSubList(data, page);
            adapter.addFrag(DummyFragment.newInstance(subList, page), null);
            for (int j = 0; j < subList.size(); j++) {
                Log.i("Ramesh", "Page: " + page + " ; Data -  " + subList.get(j).title);
            }
        }

        viewPager.setAdapter(adapter);
        txt_selected.setText(1 + "/" + viewPager.getAdapter().getCount());
    }

    public static List<DummyData> getData() {
        List<DummyData> dummyDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            dummyDatas.add(new DummyData("position " + i));
        }
        return dummyDatas;
    }

    public List<DummyData> getSubList(List<DummyData> mainList, int pageNo) {
//        int pages = mainList.size() / 8;
        int fromPos = pageNo * 8;
        List<DummyData> data = mainList.subList(fromPos, Math.min(fromPos + 8, mainList.size()));
        List<DummyData> finaldata = new ArrayList<>(data);
        return finaldata;
    }


}
