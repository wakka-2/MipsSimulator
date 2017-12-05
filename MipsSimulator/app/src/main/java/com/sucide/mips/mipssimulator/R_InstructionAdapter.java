package com.sucide.mips.mipssimulator;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by new on 28/11/17.
 */

public class R_InstructionAdapter extends RecyclerView.Adapter<R_InstructionAdapter.ViewHolder>{


    ViewGroup viewGroup;
    List <R_instructions> R_instrcution_data ;
    int num_of_instructions;
    private Context mcontext ;

    public R_InstructionAdapter (Context context , List<R_instructions>InstructionsList){
        R_instrcution_data=InstructionsList;
        mcontext = context ;
    }

    @Override
    public R_InstructionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.r_type_viewholder, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemLayout);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.r_op_holder.setText("" + R_instrcution_data.get(position).op_r);
        holder.r_rd_holder.setText("" + R_instrcution_data.get(position).rd_r);
        holder.r_rs_holder.setText("  " + R_instrcution_data.get(position).rs_r);
        holder.r_rt_holder.setText(R_instrcution_data.get(position).rt_r);



    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView r_op_holder;
        TextView r_rd_holder;
        TextView r_rs_holder;
        TextView r_rt_holder;
        public ViewHolder(View itemView) {
            super(itemView);

            r_op_holder = (TextView) itemView.findViewById(R.id.r_op_holder);
            r_rd_holder = (TextView) itemView.findViewById(R.id.r_rd_holder);
            r_rs_holder = (TextView) itemView.findViewById(R.id.r_rs_holder);
            r_rt_holder = (TextView) itemView.findViewById(R.id.r_rt_holder);
        }
    }

    @Override
    public int getItemCount() {
        return R_instrcution_data.size();
    }
}
