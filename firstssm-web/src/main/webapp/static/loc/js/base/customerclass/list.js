/*layui.use([ 'form', 'layer', 'jquery', 'laypage' ], function() {*/
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
        /*parseData: function(res){ //res 即为原始返回的数据
        	return {
              "code": 0, //解析接口状态
              "msg": "", //解析提示文本
              "count": res.count, //解析数据长度
              "data": res.data //解析数据列表
            };
        },*/
        method: 'POST', //方式
        page: true,//是否开启分页
        limits: [10, 20, 30, 60, 90, 100],
        limit: 20, //默认采用20
        cellMinWidth: 50,
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
            //noAuthTip(res);//无权限提示
        },
        cols: [[ //标题栏
        	{type:'numbers',width:50},
            {type: 'checkbox'},
            {field: 'cusCode', title: '客户编码', align: 'center'},
            {field: 'cusName', title: '客户名称', align: 'left'},
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
    
    //打开新增按钮
    /*function openAdd() {
        layer.open({
            type: 2,
            title: '新增',
            shadeClose: false,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: public_shade,//是否有遮罩，可以设置成false
            maxmin: true, //开启最大化最小化按钮
            //area: ['700px', '400px'],
            area: ['100%', '100%'],
            boolean: true,
            content: ['StudentAdd.jsp', 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
                var body = layer.getChildFrame('body', lockIndex);
                //绑定解锁按钮的点击事件
                body.find('button#close').on('click', function () {
                    layer.close(lockIndex);
                    location.reload();//刷新
                });
            }
        });
    }*/
    
    //打开查看按钮
    function openDetail(data) {
        layer.open({
            type: 2,
            title: '查看',
            shadeClose: false,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: public_shade,//是否有遮罩，可以设置成false
            maxmin: true, //开启最大化最小化按钮
            area: ['100%', '100%'],
            boolean: true,
            content: ['StudentDetail.jsp?obj=' + encodeURIComponent(JSON.stringify(data)), 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
                var body = layer.getChildFrame('body', lockIndex);
                //绑定解锁按钮的点击事件
                body.find('button#close').on('click', function () {
                    layer.close(lockIndex);
                    //location.reload();//刷新
                });

                pubUtil.load(body, data);//填充表单
                body.find("input").attr("readonly", "readonly");
            }
        });
    }
    
    //监听行单击事件（单击事件为：rowDouble）
    table.on('row(tableList)', function(obj){
      var data = obj.data;
      
      layer.alert(JSON.stringify(data.cusName), {
        title: '当前行数据：'
      });
      
      //标注选中样式
      obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
    });

});
