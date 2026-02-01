package com.sneha.buyingPower.buyingPower;

import com.google.gson.Gson;
import com.sneha.authenticationService.TokenValidationResponse;
import com.sneha.buyingPower.userIdentification.UserIdentificationService;
import com.sneha.buyingPower.userIdentification.ValidateUserResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class BuyingPowerService {

//    private final UserIdentificationService userIdentificationService;
    private final ComputationDataService computationDataService;
    private final ComputationService computationService;
    private final OkHttpClient client = new OkHttpClient();

    private final Gson gson = new Gson();
    BuyingPowerService( ComputationService computationService, ComputationDataService computationDataService) {
        this.computationDataService = computationDataService;
        this.computationService = computationService;
        //this.userIdentificationService = userIdentificationService;
    }

    int getBuyingPower(String userId) throws Exception {

        boolean isUserValid = validateUserId(userId);
        System.out.println("user valid " + isUserValid);
        if(!isUserValid){
            throw new Exception("User Id is not valid");
        }


        ComputationData computationData = computationDataService.computeData(userId);
        int result = computationService.computeData(computationData);
        return result;
    }

    private boolean validateUserId(String userId) throws Exception {
        String url = String.format("http://localhost:8080/userIdentificationService/validate-user/%s", userId);

        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            ValidateUserResponse validationResponse = gson.fromJson(response.body().string(), ValidateUserResponse.class);
            return validationResponse.isResponse();
        } catch (Exception e) {
            throw new Exception("There was issue while calling User Identification Service");
        }
    }
}
