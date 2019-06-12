/**
 * 下拉框的JS文件
 */
 function pbInitComCombox($,form,url,id,value){
	$.ajax({
		url : my.window.ctxPath + '/myssm/manager/combox/'+url,
		type:'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
		dataType : 'json',
		async: true,
		success : function(data) {
			$("#"+id).html("");
			$("#"+id).append('<option selected="" value="">请选择</option>');
			for(var i=0;i<data.length;i++){
				if(data[i].code==value){
					$("#"+id).append('<option selected="" value='+data[i].code+'>'+data[i].codeName+'</option>');
				}else{
					$("#"+id).append('<option value='+data[i].code+'>'+data[i].codeName+'</option>');
				}
			}
			form.render('select');//重新渲染
		}
	});
}
