package com.example.dbflute.guice.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.guice.dbflute.allcommon.*;
import com.example.dbflute.guice.dbflute.exentity.customize.*;

/**
 * The DB meta of SqlApSubDirectoryCheck. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class SqlApSubDirectoryCheckDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final SqlApSubDirectoryCheckDbm _instance = new SqlApSubDirectoryCheckDbm();
    private SqlApSubDirectoryCheckDbm() {}
    public static SqlApSubDirectoryCheckDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgMemberName(), "memberName");
        setupEpg(_epgMap, new EpgMemberStatusName(), "memberStatusName");
    }
    public PropertyGateway findPropertyGateway(String propertyName)
    { return doFindEpg(_epgMap, propertyName); }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity e) { return ((SqlApSubDirectoryCheck)e).getMemberId(); }
        public void write(Entity e, Object v) { ((SqlApSubDirectoryCheck)e).setMemberId(cti(v)); }
    }
    public static class EpgMemberName implements PropertyGateway {
        public Object read(Entity e) { return ((SqlApSubDirectoryCheck)e).getMemberName(); }
        public void write(Entity e, Object v) { ((SqlApSubDirectoryCheck)e).setMemberName((String)v); }
    }
    public static class EpgMemberStatusName implements PropertyGateway {
        public Object read(Entity e) { return ((SqlApSubDirectoryCheck)e).getMemberStatusName(); }
        public void write(Entity e, Object v) { ((SqlApSubDirectoryCheck)e).setMemberStatusName((String)v); }
    }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "SqlApSubDirectoryCheck";
    protected final String _tablePropertyName = "sqlApSubDirectoryCheck";
    protected final TableSqlName _tableSqlName = new TableSqlName("SqlApSubDirectoryCheck", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, "会員ID", false, "memberId", Integer.class, false, false, "INTEGER", 10, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberName = cci("MEMBER_NAME", "MEMBER_NAME", null, "会員名称", false, "memberName", String.class, false, false, "VARCHAR", 200, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberStatusName = cci("MEMBER_STATUS_NAME", "MEMBER_STATUS_NAME", null, "会員ステータス名称", false, "memberStatusName", String.class, false, false, "VARCHAR", 50, 0, null, false, null, null, null, null, null);

    public ColumnInfo columnMemberId() { return _columnMemberId; }
    public ColumnInfo columnMemberName() { return _columnMemberName; }
    public ColumnInfo columnMemberStatusName() { return _columnMemberStatusName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnMemberName());
        ls.add(columnMemberStatusName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() {
        throw new UnsupportedOperationException("The table does not have primary key: " + getTableDbName());
    }
    public boolean hasPrimaryKey() { return false; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.guice.dbflute.exentity.customize.SqlApSubDirectoryCheck"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<SqlApSubDirectoryCheck> getEntityType() { return SqlApSubDirectoryCheck.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public SqlApSubDirectoryCheck newMyEntity() { return new SqlApSubDirectoryCheck(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptPrimaryKeyMap((SqlApSubDirectoryCheck)e, m); }
    public void acceptAllColumnMap(Entity e, Map<String, ? extends Object> m)
    { doAcceptAllColumnMap((SqlApSubDirectoryCheck)e, m); }
    public Map<String, Object> extractPrimaryKeyMap(Entity e) { return doExtractPrimaryKeyMap(e); }
    public Map<String, Object> extractAllColumnMap(Entity e) { return doExtractAllColumnMap(e); }
}
