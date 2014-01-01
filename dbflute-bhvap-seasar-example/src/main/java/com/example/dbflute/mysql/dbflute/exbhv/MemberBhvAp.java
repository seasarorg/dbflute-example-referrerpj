/*
 * Copyright(c) DBFlute TestCo.,TestLtd. All Rights Reserved.
 */
package com.example.dbflute.mysql.dbflute.exbhv;

import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.mysql.dbflute.bsbhv.BsMemberBhvAp;
import com.example.dbflute.mysql.dbflute.cbean.MemberCB;
import com.example.dbflute.mysql.dbflute.nogen.entity.MemberAp;

/**
 * The behavior of member as implementation of an application.
 * <p>
 * You can implement your original methods here for your application.
 * This class remains when re-generating.
 * </p>
 * @author DBFlute(AutoGenerator)
 */
public class MemberBhvAp extends BsMemberBhvAp {

    public ListResultBean<MemberAp> selectApList(MemberCB cb) {
        return doSelectList(cb, MemberAp.class);
    }
}
