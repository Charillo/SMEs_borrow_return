package phromphong.smes_borrow_return;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BorrowReturnActivity extends AppCompatActivity {
    private OPPMSService service;
    private BorrowReturnActivity activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow_retuen);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/SMEs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(OPPMSService.class);
        activity = this;

        service.getOPPMSData().enqueue(new Callback<OPPMSDAO>() {
            @Override
            public void onResponse(retrofit2.Call<OPPMSDAO> call, Response<OPPMSDAO> response) {
                //Log.d("RESPONSE : ","SUCCESS");

                    for(int i=0;i<response.body().details.size();i++){
                        Log.d("data",response.body().details.get(i).borrow_id);


                        //String data_jds[] = {response.body().details.get(i).borrow_code};

                        MyAdapter adapter = new MyAdapter(activity,response.body().details);
                        ListView listView = (ListView)findViewById(R.id.tvlistview1);
                        listView.setAdapter(adapter);
                        //TextView tvName = (TextView)findViewById(R.id.tvchk);
                        //tvName.setText(response.body().details.get(i).borrow_code);





                    }

            }

            @Override
            public void onFailure(retrofit2.Call<OPPMSDAO> call, Throwable t) {
                Log.d("RESPONSE ::",t.getMessage());
            }
        });

    }
}
