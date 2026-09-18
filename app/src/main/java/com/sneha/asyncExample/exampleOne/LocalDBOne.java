package com.sneha.asyncExample.exampleOne;

import java.util.ArrayList;
import java.util.List;

public class LocalDBOne implements Database{
    List<Data> dataList = new ArrayList<>();


    @Override
    public void add(Data data) {
        dataList.add(data);
    }
}
