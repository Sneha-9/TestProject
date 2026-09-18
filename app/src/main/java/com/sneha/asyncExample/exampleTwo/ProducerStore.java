package com.sneha.asyncExample.exampleTwo;

import java.util.ArrayList;

public class ProducerStore {
    private ArrayList<Data> arrayList = new ArrayList<>();

    void add(Data data){
        arrayList.add(data);
    }
    Data get(int idx){
        return arrayList.get(idx);
    }
}
