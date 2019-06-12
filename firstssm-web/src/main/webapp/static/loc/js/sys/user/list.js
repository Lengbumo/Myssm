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
        url: my.window.ctxPath + '/myssm/manager/user/page',
        method: 'POST', //方式
        page: true,//是否开启分页
        limits: [10, 20, 30, 60, 90, 100],
        limit: 20, //默认采用20
        cellMinWidth: 80,
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
            {field:'userCode', title:'用户编码',  align:'center', sort:true},
            {field:'userName', title:'用户名称',  align:'center', sort:true},
            {field:'userEname', title:'英文名称', minWidth:200, align:'center', sort:true},
            {field:'userDescr', title:'用户描述',  align:'center', sort:true},
            {field:'tel', title:'电话',  align:'center', sort:true},
            {field:'phone', title:'手机',  align:'center', sort:true},
            {field:'emial', title:'邮箱',  align:'center', sort:true},
			{field:'remark', title:'描述',  align:'center', sort:true},
            {field:'createdBy', title:'创建人',  align:'center', sort:true},
            {field:'createdDate', title:'创建日期', minWidth:175, align:'center', sort:true},
            {field:'modifiedBy', title:'修改人',  align:'center', sort:true},
            {field:'modifiedDate', title:'修改时间', minWidth:175, align:'center', sort:true},
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
        	var _pdata = new Array();
			_pdata.push({name:"_PARAM", value: JSONUtil.encode(pubUtil.idList(data))});
			openDelete(_pdata);
        }
    });
    
    // 给data-type绑定点击事件
    $('.layui-form-pane .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
    
    // 查询
    $('#searchParam').on('keydown', function (event) {
    	if (event.keyCode == 13) {
    		execSearch();
        }
    });
    
    // 查询
    $('#btnSearch').on('click', function () {
    	execSearch();
    });
    
    // 重置
    $('#btnRetSet').on('click', function () {
    	$("#searchform")[0].reset();
        layui.form.render();
    });
    
    // 新增
    $('#btnAdd').on('click', function () {
    	openAdd();
    });
    
    // 批量删除
    $('#btnDelAll').on('click', function () {
    	var checkStatus = table.checkStatus('pList');
        var data = checkStatus.data;
        if (data.length == 0) {
            pubUtil.msg("请至少选择一条要删除的记录", layer, 2, function () {
            });
            return;
        }
        var _pdata = new Array();
		_pdata.push({name:"_PARAM", value: JSONUtil.encode(pubUtil.idList(data))});
		openDelete(_pdata);
    });
    
    // 查询操作
    function execSearch() {
    	index = layer.load(1);//开启进度条
    	var searchform = pubUtil.serializeObject($("#searchform"));
    	table.reload('pList', {
    		page: {
                curr: 1 //重新从第 1 页开始
            },
            where: searchform
        });
    }
    
    // 新增操作
    function openAdd() {
    	var formIndex = layer.open({
            type: 2,
            title: '新增',
            shadeClose: false,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: public_shade,//是否有遮罩，可以设置成false
            maxmin: true, //开启最大化最小化按钮
            area: ['100%', '100%'],
            boolean: true,
            content: ['toForm', 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
                var body = layer.getChildFrame('body', lockIndex);
                //绑定解锁按钮的点击事件
                body.find('button#close').on('click', function () {
                    layer.close(lockIndex);
                    table.reload('pList');//刷新
                });
            }
        });
    	layer.full(formIndex);
        window.sessionStorage.setItem("formIndex",formIndex);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layer.full(window.sessionStorage.getItem("formIndex"));
        });
    }
    
    // 查看操作
    function openDetail(data) {
    	var viewIndex = layer.open({
            type: 2,
            title: '查看',
            shadeClose: false,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: public_shade,//是否有遮罩，可以设置成false
            maxmin: true, //开启最大化最小化按钮
            area: ['100%', '100%'],
            boolean: true,
            content: ['toView?obj=' + encodeURIComponent(JSON.stringify(data)), 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
                var body = layer.getChildFrame('body', lockIndex);
                //绑定解锁按钮的点击事件
                body.find('button#close').on('click', function () {
                    layer.close(lockIndex);
                });
                pubUtil.load(body, data);//填充表单
                body.find("input").attr("readonly", "readonly");
                body.find("select,:radio,:checkbox").attr("disabled", "disabled");
            }
        });
    	layer.full(viewIndex);
        window.sessionStorage.setItem("viewIndex",viewIndex);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layer.full(window.sessionStorage.getItem("viewIndex"));
        });
    }
    
    // 修改操作
    function openUpdate(data) {
    	var viewIndex = layer.open({
            type: 2,
            title: '查看',
            shadeClose: false,//点击遮罩关闭
            anim: public_anim,
            btnAlign: 'c',
            shade: public_shade,//是否有遮罩，可以设置成false
            maxmin: true, //开启最大化最小化按钮
            area: ['100%', '100%'],
            boolean: true,
            content: ['toEdit?id=' + data.id + '&obj=' + encodeURIComponent(JSON.stringify(data)), 'yes'], //iframe的url，no代表不显示滚动条
            success: function (layero, lockIndex) {
                var body = layer.getChildFrame('body', lockIndex);
                //绑定解锁按钮的点击事件
                body.find('button#close').on('click', function () {
                    layer.close(lockIndex);
                    table.reload('pList');//刷新
                });
            	pubUtil.load(body, data);//填充表单
            }
        });
    	layer.full(viewIndex);
        window.sessionStorage.setItem("viewIndex",viewIndex);
        //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
        $(window).on("resize",function(){
            layer.full(window.sessionStorage.getItem("viewIndex"));
        });
    }
    
    // 删除操作
    function openDelete(ids) {
        layer.open({
            title: '提示信息', //显示标题栏
            closeBtn: false,
            area: '300px;',
            icon: '3',
            shade: 0.5,
            id: 'layuidel', //设定一个id，防止重复弹出
            btn: ['删除', '关闭'],
            content: '您是否要删除当前选中的记录？',
            success: function (layero) {
                var btn = layero.find('.layui-layer-btn');
                btn.css('text-align', 'center');//居中
                btn.find('.layui-layer-btn0').on('click', function () {
                    var loadindex = layer.load(1);//开启进度条
                    $.ajax({
                        url: my.window.ctxPath + '/myssm/manager/user/bulkDelete',
                        data: ids,
                        type: 'POST',//默认以get提交，以get提交如果是中文后台会出现乱码
                        dataType: 'json',
                        success: function (r) {
                            layer.close(loadindex);//关闭进程对话框
                            if (r.rs) {
                                pubUtil.msg('删除成功', layer, 1, function () {
                                	table.reload('pList');
                                }, 500);
                            } else {
                                pubUtil.msg(r.message, layer, 2, function () {
                                }, 5 * 1000);
                            }
                        }
                    });
                });
            }
        });
    }

});
