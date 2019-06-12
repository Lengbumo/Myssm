layui.use(['form', 'layedit', 'laydate', 'upload', 'jquery'], function () {	
	var form = layui.form;
	var laydate= layui.laydate;
	var upload = layui.upload;
    var $ = layui.jquery;
	
    //获取传参
    var data =JSON.parse(decodeURIComponent($.getRequestParam().obj));
    
});
