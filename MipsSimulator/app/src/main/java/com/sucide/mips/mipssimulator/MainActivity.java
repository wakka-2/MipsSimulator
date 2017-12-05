package com.sucide.mips.mipssimulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner instruction_type_spinner ;
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
    List<R_instructions>r_instructionsList;

    R_InstructionAdapter r_instructionAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize ui components
        r_instructionsList= new ArrayList<>();
        instruction_type_spinner = (Spinner) findViewById(R.id.instruction_type_spinner);
        r_op = (EditText) findViewById(R.id.r_op);
        r_rd = (EditText) findViewById(R.id.r_rd);
        r_rs = (EditText) findViewById(R.id.r_rs);
        r_rt = (EditText) findViewById(R.id.r_rt);
        i_op = (EditText) findViewById(R.id.i_op);
        i_rs = (EditText) findViewById(R.id.i_rs);
        i_rt = (EditText) findViewById(R.id.i_rt);
        i_offset = (EditText) findViewById(R.id.i_offset);
        r_type_layout = (LinearLayout) findViewById(R.id.r_type_layout);
        i_type_layout = (LinearLayout) findViewById(R.id.i_type_layout);

        // recycler view
        r_instructionAdapter=new R_InstructionAdapter(this,r_instructionsList);
        instructions_recycler_view = (RecyclerView) findViewById(R.id.instruction_recycler_view);
        instructions_recycler_view.setAdapter(r_instructionAdapter);

        // initialize spinner
        String [] instruction_types = {"choose type","R","I"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, instruction_types);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        instruction_type_spinner.setAdapter(adapter);

        instruction_type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if(instruction_type_spinner.getSelectedItem().toString().equals("choose type")) {
                    r_type_layout.setVisibility(View.GONE);
                    i_type_layout.setVisibility(View.GONE);
                    Toast toast=Toast.makeText(getApplicationContext(),"R-Type instruction chosen",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(instruction_type_spinner.getSelectedItem().toString().equals("R")){
                    r_type_layout.setVisibility(View.VISIBLE);
                    i_type_layout.setVisibility(View.GONE);
                    Toast toast=Toast.makeText(getApplicationContext(),"I-Type instruction chosen",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else if(instruction_type_spinner.getSelectedItem().toString().equals("I")) {
                    r_type_layout.setVisibility(View.GONE);
                    i_type_layout.setVisibility(View.VISIBLE);

                    Toast toast=Toast.makeText(getApplicationContext(),"choose instruction type",Toast.LENGTH_SHORT);
                    toast.show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                r_type_layout.setVisibility(View.GONE);
                i_type_layout.setVisibility(View.GONE);

            }
        });
    }

    public void add_instruction_button (View view){
        R_instructions r_instructions=new R_instructions(r_op.getText().toString(),r_rd.getText().toString(),r_rs.getText().toString(),r_rt.getText().toString());

        this.r_instructionsList.add(r_instructions);

        r_instructionAdapter.notifyDataSetChanged();
        Log.d("aa",""+r_instructionsList.size());





    }


}
