package com.example.dbflute.sqlap.dbflute;

import java.io.File;
import java.io.IOException;

import org.seasar.dbflute.cbean.ListResultBean;
import org.seasar.dbflute.util.DfResourceUtil;
import org.seasar.dbflute.util.Srl;

import com.example.dbflute.guice.dbflute.exbhv.MemberBhv;
import com.example.dbflute.guice.dbflute.exbhv.pmbean.SqlApBasicMemberPmb;
import com.example.dbflute.guice.dbflute.exentity.customize.SqlApBasicMember;
import com.example.dbflute.sqlap.unit.ContainerTestCase;

/**
 * @author jflute
 */
public class SqlApBasicTest extends ContainerTestCase {

    private MemberBhv memberBhv;

    public void test_outputDirectory() throws IOException {
        File buildDir = DfResourceUtil.getBuildDir(SqlApBasicMemberPmb.class);
        String canonicalPath = buildDir.getCanonicalPath();
        log("canonicalPath: " + canonicalPath);
        assertFalse(Srl.contains(canonicalPath, "dbflute-guice-example"));
        assertTrue(Srl.contains(canonicalPath, "dbflute-sqlap-example"));
    }

    public void test_selectSimpleMember() {
        // ## Arrange ##
        SqlApBasicMemberPmb pmb = new SqlApBasicMemberPmb();
        pmb.setMemberName_PrefixSearch("S");

        // ## Act ##
        ListResultBean<SqlApBasicMember> memberList = memberBhv.outsideSql().selectList(pmb);

        // ## Assert ##
        assertNotSame(0, memberList.size());
        for (SqlApBasicMember member : memberList) {
            log(member.toString());
        }
    }
}
