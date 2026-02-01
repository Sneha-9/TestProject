package com.sneha.buyingPower.buyingPower;

import com.google.gson.Gson;
import com.sneha.buyingPower.cibilScore.CibilScoreResponse;
import com.sneha.buyingPower.cibilScore.CibilScoreService;
import com.sneha.buyingPower.collateral.CollateralEntry;
import com.sneha.buyingPower.collateral.CollateralResponse;
import com.sneha.buyingPower.collateral.CollateralService;
import com.sneha.buyingPower.income.IncomeEntry;
import com.sneha.buyingPower.income.IncomeResponse;
import com.sneha.buyingPower.income.IncomeService;
import com.sneha.buyingPower.loan.LoanEntry;
import com.sneha.buyingPower.loan.LoanResponse;
import com.sneha.buyingPower.loan.LoanService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.List;


public class ComputationDataService {

    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();

    ComputationData computeData(String userId) throws Exception {
        int cibilScore = getCibilScore(userId);
        List<IncomeEntry> incomes = getIncomeEntry(userId);
        List<LoanEntry> loans = getLoanEntry(userId);
        List<CollateralEntry> collaterals = getCollateralEntry(userId);

        return new ComputationData(userId, cibilScore, incomes, loans, collaterals);
    }

  private List<IncomeEntry> getIncomeEntry(String userId) throws Exception {
        String url = String.format("http://localhost:8080/incomeService/userdata/%s", userId);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            IncomeResponse incomeResponse = gson.fromJson(response.body().string(), IncomeResponse.class);
            return incomeResponse.getIncomeEntries();
        } catch (Exception e) {
            throw new Exception("There was issue while calling Income Service");
        }
    }

    private List<LoanEntry> getLoanEntry(String userId) throws Exception {
        String url = String.format("http://localhost:8080/loanService/userdata/%s", userId);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            LoanResponse loanResponse = gson.fromJson(response.body().string(), LoanResponse.class);
            return loanResponse.getLoanEntryList();
        } catch (Exception e) {
            throw new Exception("There was issue while calling Loan Service");
        }
    }

    private List<CollateralEntry> getCollateralEntry(String userId) throws Exception {
        String url = String.format("http://localhost:8080/collateralService/userdata/%s", userId);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            CollateralResponse collateralResponse = gson.fromJson(response.body().string(), CollateralResponse.class);
            return collateralResponse.getCollateralEntries();
        } catch (Exception e) {
            throw new Exception("There was issue while calling Collateral Service");
        }
    }

    private int getCibilScore(String userId) throws Exception {
        String url = String.format("http://localhost:8080/cibilScoreService/userdata/%s", userId);

        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            CibilScoreResponse cibilScoreResponse = gson.fromJson(response.body().string(), CibilScoreResponse.class);
            return cibilScoreResponse.getCibilScore();
        } catch (Exception e) {
            throw new Exception("There was issue while calling Cibil Service");
        }
    }

}
