package com.sucide.mips.mipssimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

        // initialize spinner
        String [] instruction_types = {"R","I"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instruction_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        instruction_type_spinner.setAdapter(adapter);

    }
}
