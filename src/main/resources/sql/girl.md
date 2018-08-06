sample
===
* 注释

	select #use("cols")# from girl  where  #use("condition")#

cols
===
	id,age,cup_size

updateSample
===
	
	id=#id#,age=#age#,cup_size=#cupSize#

condition
===

	1 = 1  
	@if(!isEmpty(id)){
	 and id=#id#
	@}
	@if(!isEmpty(age)){
	 and age=#age#
	@}
	@if(!isEmpty(cupSize)){
	 and cup_size=#cupSize#
	@}
	
	