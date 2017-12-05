package com.sucide.mips.mipssimulator;

/**
 * Created by new on 30/11/17.
 */

public class R_instructions {

    String op_r;
    String rd_r;
    String rs_r;
    String rt_r;
    int Itemid;
    //    public TodoItem(String s, boolean b){
//        title=s;
//        check=b;
//    }
    public R_instructions (String Cop_r , String Crd_r , String Crs_r ,String Crt_r){
        op_r = Cop_r;
        rd_r = Crd_r;
        rs_r = Crs_r;
        rt_r = Crt_r;

    }

    public String getOp_r() {
        return op_r;
    }

    public void setOp_r(String op_r) {
        this.op_r = op_r;
    }

    public String getRd_r() {
        return rd_r;
    }

    public void setRd_r(String rd_r) {
        this.rd_r = rd_r;
    }

    public String getRs_r() {
        return rs_r;
    }

    public void setRs_r(String rs_r) {
        this.rs_r = rs_r;
    }

    public String getRt_r() {
        return rt_r;
    }

    public void setRt_r(String rt_r) {
        this.rt_r = rt_r;
    }

    public int getItemid() {
        return Itemid;
    }

    public void setItemid(int itemid) {
        Itemid = itemid;
    }
}
