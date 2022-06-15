package com.example.reviewfragmentrecycler.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.reviewfragmentrecycler.R;
import com.example.reviewfragmentrecycler.brodcast.BrodCast;
import com.example.reviewfragmentrecycler.modle.Word;
import com.example.reviewfragmentrecycler.room.WordViewModel;
import com.example.reviewfragmentrecycler.servies.ForgroundService;
import com.example.reviewfragmentrecycler.servies.TestService;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button btn_end,btn_start,btn_save;
    EditText ed_word;
    private WordViewModel wordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn_end=findViewById(R.id.end);
        btn_start=findViewById(R.id.start);
        btn_save=findViewById(R.id.btn_save);
        ed_word=findViewById(R.id.ed_word);



        wordViewModel=new ViewModelProvider(this).get(WordViewModel.class);


        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    wordViewModel.insert(new Word(ed_word.getText().toString()));
                    Toast.makeText(getApplicationContext(),"save",Toast.LENGTH_LONG).show();



            }
        });
        wordViewModel.getAllWords().observe(MainActivity2.this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                for (Word word:words){

                    Log.d("ttt","Word::"+word.getWord());
                    Log.d("ttt","id::"+word.getId());

                }

            }
        });

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity2.this, TestService.class);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    startService(intent);
                }else{
                    startService(intent);
                }
            }
        });

        btn_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(MainActivity2.this, TestService.class);
                stopService(intent1);
            }
        });
    }
}