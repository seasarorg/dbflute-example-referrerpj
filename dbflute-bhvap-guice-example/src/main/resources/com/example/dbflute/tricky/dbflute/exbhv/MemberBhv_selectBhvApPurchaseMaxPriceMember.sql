/*
 [df:title]
 Manual Paging Example for Application Behavior
 
 [df:description]
 Use limit, offset.
*/
-- #df:entity#

-- !df:pmb extends SPB!
-- !!Integer memberId!!
-- !!String memberName:likeContain!!

/*IF pmb.isPaging()*/
select member.MEMBER_ID
     , member.MEMBER_NAME
     , (select max(purchase.PURCHASE_PRICE)
          from PURCHASE purchase
         where purchase.MEMBER_ID = member.MEMBER_ID
       ) as PURCHASE_MAX_PRICE
     , memberStatus.MEMBER_STATUS_NAME
-- ELSE select count(*)
/*END*/
  from MEMBER member
    /*IF pmb.isPaging()*/
    left outer join MEMBER_STATUS memberStatus
      on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
    /*END*/
 /*BEGIN*/where
   /*IF pmb.memberId != null*/
   member.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and member.MEMBER_NAME like /*pmb.memberName*/'%v%'
   /*END*/
 /*END*/
 /*IF pmb.isPaging()*/
 order by PURCHASE_MAX_PRICE desc, member.MEMBER_ID asc
 /*END*/
 /*IF pmb.isPaging()*/
 limit /*$pmb.fetchSize*/20 offset /*$pmb.pageStartIndex*/80
 /*END*/