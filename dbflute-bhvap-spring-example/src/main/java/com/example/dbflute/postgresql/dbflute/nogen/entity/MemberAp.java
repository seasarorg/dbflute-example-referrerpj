package com.example.dbflute.postgresql.dbflute.nogen.entity;

import java.util.Date;

import com.example.dbflute.postgresql.dbflute.exentity.Member;

public class MemberAp extends Member {

    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    public static final String ALIAS_firstLoginDatetime = "FIRST_LOGIN_DATETIME";

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected Date _firstLoginDatetime;

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Date getFirstLoginDatetime() {
        return _firstLoginDatetime;
    }

    public void setFirstLoginDatetime(Date firstLoginDatetime) {
        _firstLoginDatetime = firstLoginDatetime;
    }
}
