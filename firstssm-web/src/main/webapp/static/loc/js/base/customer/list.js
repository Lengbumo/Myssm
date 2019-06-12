layui.use(['laydate', 'laypage', 'layer', 'table', 'carousel', 'upload', 'element', 'jquery'], function () {	
    var laydate = layui.laydate; //日期
    var laypage = layui.laypage; //分页
    var layer = layui.layer; //弹层
    var table = layui.table; //表格
    var carousel = layui.carousel; //轮播
    var upload = layui.upload; //上传
    var element = layui.element; //元素操作
    var $ = layui.jquery;
	
	var index = layer.load(1);//开启进度条
    //绑定table
    table.render({
        elem: '#tableList',//table id
        url: my.window.ctxPath + '/myssm/manager/customer/page',
        method: 'POST', //方式
        page: true,//是否开启分页
        limits: [10, 20, 30, 60, 90, 100],
        limit: 20, //默认采用20
        cellMinWidth: 100,
        height : "full-125",
        even: true, //开启隔行背景
        id: 'searchID',
        request: {
            pageName: 'currentPage', //页码的参数名称，默认：page
            limitName: 'limit' //每页数据量的参数名，默认：limit
        },
        done: function (res, curr, count) {
            //加载后回调
        	layer.close(index);//关闭
        },
        cols: [[ //标题栏
        	{type:'numbers',width:50},
            {type: 'checkbox'},
            {field: 'clsId', title: 'ID', minWidth: 100, align: 'center', sort: true},                
            {field: 'clsCode', title: '客户大类编码', minWidth: 100, align: 'center', sort: true},                
            {field: 'cusCode', title: '客户编码', minWidth: 100, align: 'center', sort: true},                
            {field: 'cusName', title: '客户名称', minWidth: 100, align: 'center', sort: true},                
            {field: 'cusNamee', title: '英文名称', minWidth: 100, align: 'center', sort: true},                
            {field: 'cusDescr', title: '中文描述', minWidth: 100, align: 'center', sort: true},                
            {field: 'cusDescre', title: '英文描述', minWidth: 100, align: 'center', sort: true},                
            {field: 'easyCode', title: '助记码',  align: 'center', sort: true},                
            {field: 'cusType', title: '客户类型', minWidth: 100, align: 'center', sort: true},                
            {field: 'country', title: '国家',  align: 'center', sort: true},                
            {field: 'province', title: '省份',  align: 'center', sort: true},                
            {field: 'city', title: '城市',  align: 'center', sort: true},                
            {field: 'district', title: '区县',  align: 'center', sort: true},                
            {field: 'address', title: '地址',  align: 'center', sort: true},                
            {field: 'fullAddress', title: '地址全称', minWidth: 100, align: 'center', sort: true},                
            {field: 'zip', title: '邮政编码', minWidth: 100, align: 'center', sort: true},                
            {field: 'contact', title: '联系人',  align: 'center', sort: true},                
            {field: 'contactTel', title: '电话',  align: 'center', sort: true},                
            {field: 'contactMobile', title: '手机',  align: 'center', sort: true},                
            {field: 'contactFax', title: '传真',  align: 'center', sort: true},                
            {field: 'contactTitle', title: '职位',  align: 'center', sort: true},                
            {field: 'contactEmail', title: '电子邮件地址', minWidth: 100, align: 'center', sort: true},                
            {field: 'remark', title: '描述',  align: 'center', sort: true},                
            {field: 'createdBy', title: '创建人',  align: 'center', sort: true},                
            {field: 'createdDate', title: '创建日期', minWidth: 175, align: 'center', sort: true},                
            {field: 'modifiedBy', title: '修改人',  align: 'center', sort: true},                
            {field: 'modifiedDate', title: '修改时间', minWidth: 175, align: 'center', sort: true},                
            {fixed: 'right', title: '操作', width: 180, align: 'center', toolbar: '#toobar'}
        ]]
    });

    //监听工具条
    table.on('tool(tableList)', function (obj) { //注：tool是工具条事件名，table是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data, //获得当前行数据
            layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'detail') {
            openDetail(data);
        }
        if (layEvent === 'update') {
            openUpdate(data);
        } else if (layEvent === 'del') {
            openDelete(data.uuid);
        }
    });
    
    //监听行单击事件（单击事件为：rowDouble）
    table.on('row(tableList)', function(obj){
      var data = obj.data;
      
      layer.alert(JSON.stringify(data.id), {
        title: '当前行数据ID：'
      });
      
      //标注选中样式
      obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });

});
