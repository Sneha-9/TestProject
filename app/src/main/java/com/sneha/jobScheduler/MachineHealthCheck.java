package com.sneha.jobScheduler;

import com.google.gson.Gson;

import com.sneha.jobScheduler.machine.MachineHealthResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.ArrayList;
import java.util.List;

//MR. NIKHIL SONI COMMENT: RENAME
public class MachineHealthCheck {
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    MachineHealth getData(List<MachineRegistry> machineList) throws Exception {
        //make api calls to list of machines and returns 2 list of machines: 1 list working machine
        // another non-working machines;
        List<MachineRegistry> serviceable = new ArrayList<>();
        List<MachineRegistry> nonserviceable = new ArrayList<>();

        for(MachineRegistry m : machineList){

              boolean resp = getMachineHealth(m.getUrl());
              if(resp){
                  serviceable.add(new MachineRegistry(m.getId(),m.getMemorySupported(),"Serviceable", m.getUrl()));
              }
              else{
                  nonserviceable.add(new MachineRegistry(m.getId(),m.getMemorySupported(),"Down",m.getUrl()));
              }


        }
         return new MachineHealth(serviceable,nonserviceable);
    }

    private boolean getMachineHealth(String urlM) throws Exception {
        String url = String.format(urlM);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            MachineHealthResponse result = gson.fromJson(response.body().string(), MachineHealthResponse.class);
            return result.isResponse();
        } catch (Exception e) {
            throw new Exception("There was issue while calling Machine Service");
        }
    }
}
