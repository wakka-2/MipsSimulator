package com.sucide.mips.mipssimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner instruction_type_spinner ;
    Button add_instruction_button ;
    EditText r_op;
    EditText r_rd;
    EditText r_rs;
    EditText r_rt;
    EditText i_op;
    EditText i_rs;
    EditText i_rt;
    EditText i_offset;
    RecyclerView instructions_recycler_view;
    LinearLayout r_type_layout ;
    LinearLayout i_type_layout ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize ui components
        instruction_type_spinner = (Spinner) findViewById(R.id.instruction_type_spinner);
        add_instruction_button = (Button) findViewById(R.id.add_instruction_button);
        r_op = (EditText) findViewById(R.id.r_op);
        r_rd = (EditText) findViewById(R.id.r_rd);
        r_rs = (EditText) findViewById(R.id.r_rs);
        r_rt = (EditText) findViewById(R.id.r_rt);
        i_op = (EditText) findViewById(R.id.i_op);
        i_rs = (EditText) findViewById(R.id.i_rs);
        i_rt = (EditText) findViewById(R.id.i_rt);
        i_offset = (EditText) findViewById(R.id.i_offset);
        instructions_recycler_view = (RecyclerView) findViewById(R.id.instruction_recycler_view);
        r_type_layout = (LinearLayout) findViewById(R.id.r_type_layout);
        i_type_layout = (LinearLayout) findViewById(R.id.i_type_layout);

        // initialize spinner
        String [] instruction_types = {"R","I"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instruction_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        instruction_type_spinner.setAdapter(adapter);

        instruction_type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(instruction_type_spinner.getSelectedItem().toString().equals("R")){
                    r_type_layout.setVisibility(View.VISIBLE);
                    i_type_layout.setVisibility(View.GONE);
                }
                else if(instruction_type_spinner.getSelectedItem().toString().equals("I")){
                    r_type_layout.setVisibility(View.GONE);
                    i_type_layout.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                r_type_layout.setVisibility(View.GONE);
                i_type_layout.setVisibility(View.GONE);

            }
        });
    }
}
