drop table ers_reimbursement_type cascade; 
drop table ers_user_roles cascade; 
drop table ers_users cascade; 
drop table ers_reimbursement_status cascade; 
drop table ers_reimbursement cascade; 

create table ers_reimbursement(
	reimb_id serial primary key,
	reimb_amount numeric,
	reimb_submitted date,
	reimb_resolved date,
	reimb_description varchar(250),
	reimb_author int references ers_users(ers_users_id) default(1),
	reimb_resolver int references ers_users(user_role_id) default(1),
	reimb_status_id int references ers_reimbursement_status(reimb_status_id) default(1),
	reimb_type_id int references ers_reimbursement_type(reimb_type_id) default(1)
)

create table ers_users(
	ers_users_id serial primary key,
	ers_username varchar(50) unique,
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150) unique,
	user_role_id int references ers_user_roles(ers_user_role_id)
)

create table ers_reimbursement_status(     --READ ONLY
	reimb_status_id serial primary key,
	reimb_status varchar(10)
)

create table ers_reimbursement_type(    --READ ONLY
	reimb_type_id serial primary key, 
	reimb_type varchar(10)
)

create table ers_user_roles(	--READ ONLY
	ers_user_role_id serial primary key,
	user_role varchar(10)
)

select * from ers_users where ers_users_id = 1
select * from ers_user_roles;
select * from ers_reimbursement_type;
select * from ers_reimbursement_status;
select * from ers_users;
select * from ers_reimbursement;

---------------------------------Password Hashing function---------------------------------------------------------------------

drop function hash_password;  
drop trigger hash_pass

create or replace function hash_password()
returns trigger as $$
	begin 
		if(new.ers_password=old.ers_password)then 
			return new;
		end if;
	new.ers_password:=
	md5(new.ers_username||new.ers_password||'tires');
	return new;
	end;
$$ language plpgsql;

create trigger hash_pass 
before insert or update on ers_users
for each row 
execute function hash_password();

---------------------------------------Procedure for User submitted claims----------------------------------------------------------

drop procedure user_submitted_claim;

create or replace procedure user_submitted_claim(reimbAmt numeric, submitdate date ,descrip varchar, typeid int, reimbauthor int)
	language sql as $$
	insert into ers_reimbursement (reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
	values (default, reimbAmt, submitdate, '2000-10-10', descrip, reimbauthor, 1, 1, typeid);

$$;

----------------------------------------------MISC--------------------------------------------------------------------


CREATE OR REPLACE VIEW projectone.requests_filtered_by_status
AS SELECT ers_reimbursement.reimb_id,
    ers_reimbursement.reimb_amount,
    ers_reimbursement.reimb_submitted,
    ers_reimbursement.reimb_resolved,
    ers_reimbursement.reimb_description,
    ers_reimbursement.reimb_reciept,
    ers_reimbursement.reimb_author,
    ers_reimbursement.reimb_resolver,
    ers_reimbursement.reimb_status_id,
    ers_reimbursement.reimb_type_id
   FROM projectone.ers_reimbursement
  ORDER BY ers_reimbursement.reimb_status_id;
