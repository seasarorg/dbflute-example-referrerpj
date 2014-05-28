package com.example.dbflute.bhvap.dbflute.bsentity.customize.dbmeta;

import java.util.List;
import java.util.Map;

import org.seasar.dbflute.DBDef;
import org.seasar.dbflute.Entity;
import org.seasar.dbflute.dbmeta.AbstractDBMeta;
import org.seasar.dbflute.dbmeta.PropertyGateway;
import org.seasar.dbflute.dbmeta.info.*;
import org.seasar.dbflute.dbmeta.name.*;
import com.example.dbflute.tricky.dbflute.allcommon.*;
import com.example.dbflute.bhvap.dbflute.exentity.customize.*;

/**
 * The DB meta of BhvApPurchaseMaxPriceMember. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class BhvApPurchaseMaxPriceMemberDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final BhvApPurchaseMaxPriceMemberDbm _instance = new BhvApPurchaseMaxPriceMemberDbm();
    private BhvApPurchaseMaxPriceMemberDbm() {}
    public static BhvApPurchaseMaxPriceMemberDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    {
        setupEpg(_epgMap, new EpgMemberId(), "memberId");
        setupEpg(_epgMap, new EpgMemberName(), "memberName");
        setupEpg(_epgMap, new EpgPurchaseMaxPrice(), "purchaseMaxPrice");
        setupEpg(_epgMap, new EpgMemberStatusName(), "memberStatusName");
    }
    public static class EpgMemberId implements PropertyGateway {
        public Object read(Entity et) { return ((BhvApPurchaseMaxPriceMember)et).getMemberId(); }
        public void write(Entity et, Object vl) { ((BhvApPurchaseMaxPriceMember)et).setMemberId((String)vl); }
    }
    public static class EpgMemberName implements PropertyGateway {
        public Object read(Entity et) { return ((BhvApPurchaseMaxPriceMember)et).getMemberName(); }
        public void write(Entity et, Object vl) { ((BhvApPurchaseMaxPriceMember)et).setMemberName((String)vl); }
    }
    public static class EpgPurchaseMaxPrice implements PropertyGateway {
        public Object read(Entity et) { return ((BhvApPurchaseMaxPriceMember)et).getPurchaseMaxPrice(); }
        public void write(Entity et, Object vl) { ((BhvApPurchaseMaxPriceMember)et).setPurchaseMaxPrice((String)vl); }
    }
    public static class EpgMemberStatusName implements PropertyGateway {
        public Object read(Entity et) { return ((BhvApPurchaseMaxPriceMember)et).getMemberStatusName(); }
        public void write(Entity et, Object vl) { ((BhvApPurchaseMaxPriceMember)et).setMemberStatusName((String)vl); }
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "BhvApPurchaseMaxPriceMember";
    protected final String _tablePropertyName = "bhvApPurchaseMaxPriceMember";
    protected final TableSqlName _tableSqlName = new TableSqlName("BhvApPurchaseMaxPriceMember", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnMemberId = cci("MEMBER_ID", "MEMBER_ID", null, null, String.class, "memberId", null, false, false, false, "null", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberName = cci("MEMBER_NAME", "MEMBER_NAME", null, null, String.class, "memberName", null, false, false, false, "null", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnPurchaseMaxPrice = cci("PURCHASE_MAX_PRICE", "PURCHASE_MAX_PRICE", null, null, String.class, "purchaseMaxPrice", null, false, false, false, "null", 2147483647, 0, null, false, null, null, null, null, null);
    protected final ColumnInfo _columnMemberStatusName = cci("MEMBER_STATUS_NAME", "MEMBER_STATUS_NAME", null, null, String.class, "memberStatusName", null, false, false, false, "null", 2147483647, 0, null, false, null, null, null, null, null);

    /**
     * MEMBER_ID: {null(2147483647), refers to MEMBER.MEMBER_ID}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberId() { return _columnMemberId; }
    /**
     * MEMBER_NAME: {null(2147483647), refers to MEMBER.MEMBER_NAME}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberName() { return _columnMemberName; }
    /**
     * PURCHASE_MAX_PRICE: {null(2147483647)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnPurchaseMaxPrice() { return _columnPurchaseMaxPrice; }
    /**
     * MEMBER_STATUS_NAME: {null(2147483647), refers to MEMBER_STATUS.MEMBER_STATUS_NAME}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnMemberStatusName() { return _columnMemberStatusName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnMemberId());
        ls.add(columnMemberName());
        ls.add(columnPurchaseMaxPrice());
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
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
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
    public String getEntityTypeName() { return "com.example.dbflute.bhvap.dbflute.exentity.customize.BhvApPurchaseMaxPriceMember"; }
    public String getConditionBeanTypeName() { return null; }
    public String getBehaviorTypeName() { return null; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<BhvApPurchaseMaxPriceMember> getEntityType() { return BhvApPurchaseMaxPriceMember.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Entity newEntity() { return newMyEntity(); }
    public BhvApPurchaseMaxPriceMember newMyEntity() { return new BhvApPurchaseMaxPriceMember(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((BhvApPurchaseMaxPriceMember)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((BhvApPurchaseMaxPriceMember)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
