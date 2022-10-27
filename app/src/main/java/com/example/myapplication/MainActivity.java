package com.example.myapplication;

import android.content.ClipData;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static String JSON_URL = "https://run.mocky.io/v3/5110609b-4b9c-4c02-9c72-f15353aed19b";
    private SearchView searchView;
    List<ResturantModelClass> resturantList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });

        resturantList = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);

        GetData getData = new GetData();
        getData.execute();

    }

    public class GetData extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;

                try{
                    url = new URL(JSON_URL);
                    urlConnection = (HttpURLConnection) url.openConnection();

                    InputStream is = urlConnection.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int data = isr.read();
                    while(data != -1) {
                        current += (char) data;
                        data = isr.read();
                    }
                    return current;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("deals");
                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    ResturantModelClass model = new ResturantModelClass();
                    model.setName(jsonObject1.getString("name"));
                    model.setDeal(jsonObject1.getString("deals"));
                    model.setImg(jsonObject1.getString("img"));
                    //model.setExpirationDate(jsonObject1.getString("expiration date"));

                    resturantList.add(model);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            //adapter = new Adaptery(resturantList);
            PutDataIntoRecyclerView(resturantList);
            //recyclerView.setAdapter(adapter);
        }
    }
    private void PutDataIntoRecyclerView(List<ResturantModelClass> resturantList) {
        Adaptery adaptery = new Adaptery(this, resturantList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adaptery);

    }

    private void filterList(String text) {
        List<ResturantModelClass> filteredList = new ArrayList<>();
        for (ResturantModelClass item: resturantList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        else {
            Adaptery adaptery = new Adaptery(this, resturantList);
            adaptery.setFilteredList(filteredList);
            System.out.println("filtered list" + filteredList.get(0).getName());
        }
    }
}
