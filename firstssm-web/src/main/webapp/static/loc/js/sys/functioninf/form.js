layui.use(['form', 'layedit', 'laydate', 'upload', 'jquery'], function () {	
	var form = layui.form;
	var laydate= layui.laydate;
	var upload = layui.upload;
    var $ = layui.jquery;
	var data = '';
    
	initData();
	initSelect();
	
    // 获取传参
    function initData() {
    	if (!$.isNull($("#id").val())) {
        	// 获取传参
        	data =JSON.parse(decodeURIComponent($.getRequestParam().obj));
        } 
    }
    
    // 初始化菜单下拉框
    function initSelect() {
        if (!$.isNull($("#id").val())) {
        	// 获取传参
        	data =JSON.parse(decodeURIComponent($.getRequestParam().obj));
        	pbInitComCombox($,form,'operationMenuSelect','menuId', data.menuId);
        } else {
        	pbInitComCombox($,form,'operationMenuSelect','menuId');
        }
    }
    
    // 监听提交
    form.on('submit(btnSubmit)', function(data){
    	var index = layer.load(1);//开启进度条
    	var formValues = $("#dform").serialize();
        $.ajax({
			url : my.window.ctxPath + '/myssm/manager/functioninf/save',
			data :formValues,
			type:'POST',
			dataType : 'json',
			success : function(res) {
				layer.close(index);//关闭   
				if (res.rs) {
					pubUtil.msg('保存成功',layer,1,function(){
						$("#close").click();
					},500);
				} else {
					pubUtil.msg(res.message,layer,2,function(){
						
					},5*1000);
				}
			}
		});
    	return false;
    });
    
});
