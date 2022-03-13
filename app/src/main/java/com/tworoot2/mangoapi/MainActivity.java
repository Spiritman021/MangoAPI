package com.tworoot2.mangoapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.tworoot2.mangoapi.API_Controllers.API_Controller;
import com.tworoot2.mangoapi.API_Interfaces.API_Interface;
import com.tworoot2.mangoapi.Adapters.Career_Adapter;
import com.tworoot2.mangoapi.Models.CC_Model;
import com.tworoot2.mangoapi.Models.CareerModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recV;
    Spinner spinner;
    ArrayList<String> getCountryName = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    ArrayList<CC_Model> getCCModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner);
        getCountry();


        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 1);
        recV = (RecyclerView) findViewById(R.id.recView);
        recV.setHasFixedSize(true);
        recV.setLayoutManager(layoutManager);


        getCareer();

    }

    private void getCareer() {
        Call<List<CareerModel>> call = API_Controller
                .getInstance()
                .getApi()
                .getCareers("a17cb83a87f9ebd9888206cae684f2acab61c4f2");

        call.enqueue(new Callback<List<CareerModel>>() {
            @Override
            public void onResponse(Call<List<CareerModel>> call, Response<List<CareerModel>> response) {

                if (response.isSuccessful()) {

//                    Toast.makeText(getApplicationContext(), "responded", Toast.LENGTH_SHORT).show();


                    List<CareerModel> responseModel = response.body();


                    Career_Adapter adapter = new Career_Adapter(MainActivity.this, responseModel);
                    recV.setAdapter(adapter);



                }
            }

            @Override
            public void onFailure(Call<List<CareerModel>> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Error : " + t.getMessage(), Toast.LENGTH_SHORT).show();

                Log.d("failureResponseMessage", t.getMessage());

            }
        });
    }

    private void getCountry() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl(API_Controller.url).addConverterFactory(ScalarsConverterFactory.create()).build();
        API_Interface apiInterface = retrofit.create(API_Interface.class);
        Call<String> call = apiInterface.getCountry("a17cb83a87f9ebd9888206cae684f2acab61c4f2");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Successful" + response.message(), Toast.LENGTH_SHORT).show();
                    try {

                        getCountryName.clear();
                        getCCModel.clear();

                        String getResponse = response.body().toString();

                        JSONArray jsonArray1 = new JSONArray(getResponse);

                        for (int i = 0; i < jsonArray1.length(); i++) {

                            JSONObject jsonObject = jsonArray1.getJSONObject(i);
                            String cName = jsonObject.getString("name");


                            CC_Model ccModel = new CC_Model();
                            ccModel.setName(cName);

                            getCCModel.add(ccModel);

                        }

                        getCountryName.add("----Select Country----");
                        for (int i = 0; i < getCCModel.size(); i++) {

                            getCountryName.add(getCCModel.get(i).getName());

                        }


                        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item, getCountryName);

                        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                        arrayAdapter.notifyDataSetChanged();

                        spinner.setAdapter(arrayAdapter);




                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.d("JSONError", e.getMessage());
                    }

                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Fail" + t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }

}