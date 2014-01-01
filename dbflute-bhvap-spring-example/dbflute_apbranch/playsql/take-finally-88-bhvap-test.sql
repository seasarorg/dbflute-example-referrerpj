
-- #df:assertListExists#
-- check creating and loading data
select bhvap.*
  from BHVAP_TEST bhvap
;

drop table BHVAP_TEST
;

-- #df:assertListExists#
-- check called after loading data of library project
select status.*
  from MEMBER_STATUS status
;
