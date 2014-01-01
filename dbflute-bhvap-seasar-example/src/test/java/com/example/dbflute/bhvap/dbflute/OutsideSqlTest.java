package com.example.dbflute.bhvap.dbflute;

import java.util.List;

import org.seasar.dbflute.cbean.PagingResultBean;

import com.example.dbflute.bhvap.unit.AppContainerTestCase;
import com.example.dbflute.mysql.dbflute.exbhv.MemberBhv;
import com.example.dbflute.mysql.dbflute.exbhv.MemberBhvAp;
import com.example.dbflute.mysql.dbflute.exbhv.pmbean.AppPlainMemberPmb;
import com.example.dbflute.mysql.dbflute.exbhv.pmbean.BhvApPurchaseMaxPriceMemberPmb;
import com.example.dbflute.mysql.dbflute.exbhv.pmbean.BhvApSimpleMemberPmb;
import com.example.dbflute.mysql.dbflute.exentity.customize.AppPlainMember;
import com.example.dbflute.mysql.dbflute.exentity.customize.BhvApPurchaseMaxPriceMember;
import com.example.dbflute.mysql.dbflute.exentity.customize.BhvApSimpleMember;

public class OutsideSqlTest extends AppContainerTestCase {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** The behavior of Member. (Injection Component) */
    private MemberBhv memberBhv;
    private MemberBhvAp memberBhvAp;

    // ===================================================================================
    //                                                                          OutsideSql
    //                                                                          ==========
    // -----------------------------------------------------
    //                                                  List
    //                                                  ----
    public void test_outsideSql_selectList_bqp_byExclass() {
        // ## Arrange ##
        String path = MemberBhvAp.PATH_selectBhvApSimpleMember;
        BhvApSimpleMemberPmb pmb = new BhvApSimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");
        Class<BhvApSimpleMember> entityType = BhvApSimpleMember.class;

        // ## Act ##
        List<BhvApSimpleMember> memberList = memberBhv.outsideSql().selectList(path, pmb, entityType);

        // ## Assert ##
        assertNotSame(0, memberList.size());
        log("{BhvApSimpleMember}");
        for (BhvApSimpleMember entity : memberList) {
            Integer memberId = entity.getMemberId();
            String memberName = entity.getMemberName();
            String memberStatusName = entity.getMemberStatusName();
            log("    " + memberId + ", " + memberName + ", " + memberStatusName);
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("S"));
        }
    }

    public void test_outsideSql_selectList_bqp_byImpl() {
        // ## Arrange ##
        String path = MemberBhvAp.PATH_selectBhvApSimpleMember;
        BhvApSimpleMemberPmb pmb = new BhvApSimpleMemberPmb();
        pmb.setMemberName_PrefixSearch("S");
        Class<BhvApSimpleMember> entityType = BhvApSimpleMember.class;

        // ## Act ##
        List<BhvApSimpleMember> memberList = memberBhvAp.outsideSql().selectList(path, pmb, entityType);

        // ## Assert ##
        assertNotSame(0, memberList.size());
        log("{BhvApSimpleMember}");
        for (BhvApSimpleMember entity : memberList) {
            Integer memberId = entity.getMemberId();
            String memberName = entity.getMemberName();
            String memberStatusName = entity.getMemberStatusName();
            log("    " + memberId + ", " + memberName + ", " + memberStatusName);
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("S"));
        }
    }

    // -----------------------------------------------------
    //                                                Paging
    //                                                ------
    @SuppressWarnings("unchecked")
    public void test_outsideSql_manualPaging_bqp() {
        // ## Arrange ##
        String path = MemberBhvAp.PATH_selectBhvApPurchaseMaxPriceMember;
        BhvApPurchaseMaxPriceMemberPmb pmb = new BhvApPurchaseMaxPriceMemberPmb();
        pmb.enablePagingCountLater();
        Class<BhvApPurchaseMaxPriceMember> entityType = BhvApPurchaseMaxPriceMember.class;

        // ## Act ##
        int pageSize = 3;
        pmb.paging(pageSize, 1);// 1st page
        PagingResultBean<BhvApPurchaseMaxPriceMember> page1 = memberBhvAp.outsideSql().manualPaging().selectPage(path,
                pmb, entityType);

        pmb.paging(pageSize, 2);// 2st page
        PagingResultBean<BhvApPurchaseMaxPriceMember> page2 = memberBhvAp.outsideSql().manualPaging().selectPage(path,
                pmb, entityType);

        pmb.paging(pageSize, 3);// 3st page
        PagingResultBean<BhvApPurchaseMaxPriceMember> page3 = memberBhvAp.outsideSql().manualPaging().selectPage(path,
                pmb, entityType);

        pmb.paging(pageSize, page1.getAllPageCount());// latest page
        PagingResultBean<BhvApPurchaseMaxPriceMember> lastPage = memberBhvAp.outsideSql().manualPaging().selectPage(
                path, pmb, entityType);

        // ## Assert ##
        showPage(page1, page2, page3, lastPage);
        assertEquals(3, page1.size());
        assertEquals(3, page2.size());
        assertEquals(3, page3.size());
        assertNotSame(page1.get(0).getMemberId(), page2.get(0).getMemberId());
        assertNotSame(page2.get(0).getMemberId(), page3.get(0).getMemberId());
        assertEquals(1, page1.getCurrentPageNumber());
        assertEquals(2, page2.getCurrentPageNumber());
        assertEquals(3, page3.getCurrentPageNumber());
        assertEquals(page1.getAllRecordCount(), page2.getAllRecordCount());
        assertEquals(page2.getAllRecordCount(), page3.getAllRecordCount());
        assertEquals(page1.getAllPageCount(), page2.getAllPageCount());
        assertEquals(page2.getAllPageCount(), page3.getAllPageCount());
        assertFalse(page1.isExistPrePage());
        assertTrue(page1.isExistNextPage());
        assertTrue(lastPage.isExistPrePage());
        assertFalse(lastPage.isExistNextPage());
    }

    // -----------------------------------------------------
    //                                                 Plain
    //                                                 -----
    public void test_outsideSql_selectList_plain() {
        // ## Arrange ##
        String path = "plainsql/member/selectAppPlainMember.sql";
        AppPlainMemberPmb pmb = new AppPlainMemberPmb();
        pmb.setMemberName("S");
        Class<AppPlainMember> entityType = AppPlainMember.class;

        // ## Act ##
        List<AppPlainMember> memberList = memberBhv.outsideSql().selectList(path, pmb, entityType);

        // ## Assert ##
        assertNotSame(0, memberList.size());
        log("{AppPlainMember}");
        for (AppPlainMember entity : memberList) {
            Integer memberId = entity.getMemberId();
            String memberName = entity.getMemberName();
            String memberStatusName = entity.getMemberStatusName();
            log("    " + memberId + ", " + memberName + ", " + memberStatusName);
            assertNotNull(memberId);
            assertNotNull(memberName);
            assertNotNull(memberStatusName);
            assertTrue(memberName.startsWith("S"));
        }
    }
}
