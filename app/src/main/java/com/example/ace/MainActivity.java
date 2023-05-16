package com.example.ace;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private OxfordApiInterface oxfordApiInterface;
    private EditText searchEditText;
    private Button searchButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OxfordApiInterface service = OxfordApiClient.getAPIClient().create(OxfordApiInterface.class);

        searchEditText = findViewById(R.id.et_search);
        searchButton = findViewById(R.id.btn_search);
        resultTextView = findViewById(R.id.tv_result);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = searchEditText.getText().toString().trim();
                if(!word.isEmpty()){
                    getDefinition(word);
                }
            }
        });
    }
    private void getDefinition(String word){
        Call<OxfordDictionaryResponse> call = oxfordApiInterface.getDefinition("en-gb", "ace");
        call.enqueue(new Callback<OxfordDictionaryResponse>() {
            @Override
            public void onResponse(Call<OxfordDictionaryResponse> call, Response<OxfordDictionaryResponse> response) {
                if (response.isSuccessful()) {
                    OxfordDictionaryResponse dictionaryResponse = response.body();
                }
            }

            @Override
            public void onFailure(Call<OxfordDictionaryResponse> call, Throwable t) {

            }
        });
    }
}