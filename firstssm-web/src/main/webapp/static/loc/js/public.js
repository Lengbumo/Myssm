/**
 * 通用JS 
 */
var public_closeTimeout = 1000;// 关闭窗口时间
var public_closeTimeout_error = 2000;// 关闭窗口时间
var public_shade = 0.3;// 遮罩
var public_anim = 3;// 动画模式

var PubUtil = function() {

};
PubUtil.prototype = {

	// 消息提示
	msg : function(text, layer, icon, callback,time) {
		if(time==null){
			time = public_closeTimeout;
		}
		layer.msg(text, {
			icon : icon,
			closeBtn: 1 ,   // 是否显示关闭按钮
			shade : public_shade,
			time : time
		// 2秒关闭（如果不配置，默认是3秒）
		}, function() {
			callback();
		});
	},
	load : function(body, array) {
		var inputArray = body.find("input[type='text']");// 取到所有的input text
		var telArray = body.find("input[type='tel']");// 取到所有的input text
		var hidden= body.find("input[type='hidden']");// 取到所有的input text
		var textarea= body.find("input[type='textarea']");// 取到所有的input text
		var textarea2= body.find("textarea");// 取到所有的input text
		var selectArray = body.find("select"); // 取得所有select
		$.merge(inputArray, telArray);
		$.merge(inputArray, hidden);
		$.merge(inputArray, textarea);
		$.merge(inputArray, textarea2);
		$.merge(inputArray, selectArray);
		
		inputArray.each(function() {
			var input = $(this);// 循环中的每一个input元素
			var name = input.attr("name");
			if (array[name] != "") {
				input.val(array[name]);
			}
		});
	},
	//将form表单元素的值序列化成对象
	serializeObject: function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (o[this['name']]) {
				o[this['name']] = o[this['name']] + "," + this['value'];
			} else {
				o[this['name']] = this['value'];
			}
		});
		return o;
	},
	//获取ID集合
	idList : function(_rows) {
		if(_rows == null || _rows.length <= 0) {
			return;
		}
		// GET VALUE
		var _pdata = new Array();
		if (_rows.id) {
			_pdata.push({'id' : _rows.id});
		} else {
			$.each(_rows, function(id, value) {
				_pdata.push({'id' : value.id});
			});
		}
		return _pdata;
	}
	
};

var pubUtil = new PubUtil();
