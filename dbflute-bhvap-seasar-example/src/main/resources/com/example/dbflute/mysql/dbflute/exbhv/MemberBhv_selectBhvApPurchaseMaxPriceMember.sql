/*
 [df:title]
 Manual Paging Example for Application Behavior
 
 [df:description]
 This SQL uses 'SQL_CALC_FOUND_ROWS & FOUND_ROWS()'.
*/
-- #df:entity#

-- !df:pmb extends SPB!
-- !!Integer memberId!!
-- !!String memberName:likeContain!!

/*IF pmb.isPaging()*/
select SQL_CALC_FOUND_ROWS
       member.MEMBER_ID
     , member.MEMBER_NAME
     , (select max(purchase.PURCHASE_PRICE)
          from PURCHASE purchase
         where purchase.MEMBER_ID = member.MEMBER_ID
       ) as PURCHASE_MAX_PRICE
     , memberStatus.MEMBER_STATUS_NAME
  from MEMBER member
    left outer join MEMBER_STATUS memberStatus
      on member.MEMBER_STATUS_CODE = memberStatus.MEMBER_STATUS_CODE
 /*BEGIN*/
 where
   /*IF pmb.memberId != null*/
   member.MEMBER_ID = /*pmb.memberId*/3
   /*END*/
   /*IF pmb.memberName != null*/
   and member.MEMBER_NAME like /*pmb.memberName*/'%v%'
   /*END*/
 /*END*/
 order by PURCHASE_MAX_PRICE desc, member.MEMBER_ID asc
 limit /*$pmb.pageStartIndex*/80, /*$pmb.fetchSize*/20
-- ELSE select FOUND_ROWS()
/*END*/