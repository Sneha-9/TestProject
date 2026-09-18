package com.sneha.asyncExample.exampleOne;

import java.util.ArrayList;
import java.util.List;

public class LocalDBTwo implements Database{
    List<Data> dataList = new ArrayList<>();
    @Override
    public void add(Data data) {
         //throw new RuntimeException();
        dataList.add(data);
    }
}
