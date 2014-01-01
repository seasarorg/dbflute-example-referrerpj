package com.example.dbflute.postgresql.dbflute.exbhv;

import org.seasar.dbflute.cbean.ListResultBean;

import com.example.dbflute.postgresql.dbflute.bsbhv.BsMemberBhvAp;
import com.example.dbflute.postgresql.dbflute.cbean.MemberCB;
import com.example.dbflute.postgresql.dbflute.nogen.entity.MemberAp;

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
