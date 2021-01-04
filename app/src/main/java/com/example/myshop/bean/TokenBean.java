package com.example.myshop.bean;

public class TokenBean {

    /**
     * errno : 0
     * errmsg :
     * data : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjoiN2I5NjU2NTYtNzBlYi00NzI2LWI0YTctYzUyMzY2ODYxNDg1IiwicmFuZG9tIjoidDVqbHpvaTBpMCIsImlhdCI6MTYwOTc0MDgzMH0.iaKTkuDvYT3Xhnvs_khdywe4ZHBd2DkRfWAIpUo89U8
     */

    private int errno;
    private String errmsg;
    private String data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
