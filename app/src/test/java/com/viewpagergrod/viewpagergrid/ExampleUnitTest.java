package com.viewpagergrod.viewpagergrid;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {

        //
        List<DummyData> data = getData();
        int pages = data.size() / 8 + 1;
        for (int i = 0; i < pages; i++) {
            List<DummyData> subList = getSubList(data, i);
            for (int j = 0; j < subList.size(); j++) {
                System.out.println(subList.get(j));
            }
        }
        assertEquals(4, 2 + 2);

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
        int toPos = pageNo * 8;
        return mainList.subList(pageNo * 8, Math.min(toPos, mainList.size()));

    }
}