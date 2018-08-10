sample
===
* 注释

	select #use("cols")# from user_role  where  #use("condition")#

cols
===
	user_id,role_id

updateSample
===
	
	user_id=#userId#,role_id=#roleId#

condition
===

	1 = 1  
	@if(!isEmpty(userId)){
	 and user_id=#userId#
	@}
	@if(!isEmpty(roleId)){
	 and role_id=#roleId#
	@}
	
	