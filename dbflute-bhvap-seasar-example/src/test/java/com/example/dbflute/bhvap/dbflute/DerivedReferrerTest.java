package com.example.dbflute.bhvap.dbflute;

import java.util.Date;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.cbean.SubQuery;

import com.example.dbflute.bhvap.unit.AppContainerTestCase;
import com.example.dbflute.mysql.dbflute.cbean.MemberCB;
import com.example.dbflute.mysql.dbflute.cbean.MemberLoginCB;
import com.example.dbflute.mysql.dbflute.exbhv.MemberBhvAp;
import com.example.dbflute.mysql.dbflute.exentity.Member;
import com.example.dbflute.mysql.dbflute.nogen.entity.MemberAp;

public class DerivedReferrerTest extends AppContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Component) */
    private MemberBhvAp memberBhvAp;

    // ===================================================================================
    //                                                                     DerivedReferrer
    //                                                                     ===============
    public void test_sepcify_derivedReferrer_entityAp_basic() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().min(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setMobileLoginFlg_Equal_False();
            }
        }, MemberAp.ALIAS_firstLoginDatetime);

        // ## Act ##
        ListResultBean<MemberAp> memberList = memberBhvAp.selectApList(cb);

        // ## Assert ##
        assertNotSame(0, memberList.size());
        boolean existsLoginDatetime = false;
        boolean existsNullLoginDatetime = false;
        for (MemberAp member : memberList) {
            String memberName = member.getMemberName();
            Date firstLoginDatetime = member.getFirstLoginDatetime();
            if (firstLoginDatetime != null) {
                existsLoginDatetime = true;
            } else {
                existsNullLoginDatetime = true;
            }
            log("memberName=" + memberName + ", firstLoginDatetime=" + firstLoginDatetime);
            assertNull(member.getLatestLoginDatetime());
        }
        assertTrue(existsLoginDatetime);
        assertTrue(existsNullLoginDatetime);
    }

    public void test_sepcify_derivedReferrer_entityAp_internalUnique() {
        // ## Arrange ##
        MemberCB cb = new MemberCB();
        cb.specify().derivedMemberLoginList().min(new SubQuery<MemberLoginCB>() {
            public void query(MemberLoginCB subCB) {
                subCB.specify().columnLoginDatetime();
                subCB.query().setMobileLoginFlg_Equal_False();
            }
        }, MemberAp.ALIAS_firstLoginDatetime);

        // ## Act ##
        memberBhvAp.selectApList(cb);
        ListResultBean<Member> memberList = memberBhvAp.selectList(new MemberCB());

        // ## Assert ##
        for (Member member : memberList) {
            log(member.getMemberId() + ": " + member.getClass());
            assertEquals(Member.class, member.getClass());
            assertNotSame(MemberAp.class, member.getClass());
        }
    }
}
