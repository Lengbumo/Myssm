/**
 * 公共的JS文件
 */
var my = my || {};
my.window = my.window || {};

(function($){
	// 非空判断
	$.isNull = function(_val) {
		var _str = $.trim(_val);

		var flag = true;
		if (_str != null && _str != '' && typeof (_str) != "undefined") {
			flag = false;
		}
		
		return flag;
	};
	
	// 非空判断
	$.isNotNull = function(_val) {
		var _str = $.trim(_val);

		var flag = false;
		if (_str != null && _str != '' && typeof (_str) != "undefined") {
			flag = true;
		}
		
		return flag;
	};
	
	// 判断是个是数字
	$.isInteger = function(obj) {
		return typeof obj === 'number' && obj % 1 === 0;
	};
	
	// 数字格式化
	$.numFormatter = function(_val, len) {
		_val = $.isNull(_val) ? 0 : _val;
		
		if (!isNum(_val)) {
			_val = 0;
		}

		if (!isNum(len)) {
			len = 3;
		}

		// _val = _val.substring(0,1) == '.' ? '0.' + _val : _val;
		// _val.toFixed(len)
		return parseFloat(_val).toFixed(len);
	};
	
	// 仅供 datagird行编辑使用
	$.paserNumber = function(e, len) {
		$(e.target).bind("keyup",function(){  
        	var quantity = e.target.val();
           	var reg = /\s/; 

			if (isNaN(quantity)) {
				// $.iMessager.alert('操作提示', "请输入数字！", 'messager-error');
				e.target.val("");
				return;
			}
			if (!(reg.exec(quantity) == null)) { // 判断开头空格
				// $.iMessager.alert('操作提示', "请输入数字！", 'messager-error');
				e.target.val("");
				return;
			}
			//e.target.val($.numFormatter(quantity, len));
        });
	};
	
	/**得到当前时间 格式（yyyy-MM-dd HH:MM:SS） */
	$.nowdate = function getNowFormatDate() {
	    var date = new Date();
	    var seperator1 = "-";
	    var seperator2 = ":";
	    
	    var month = date.getMonth() + 1;
	    if (month >= 1 && month <= 9) {
	        month = "0" + month;
	    }
	    
	    var strDate = date.getDate();
	    if (strDate >= 0 && strDate <= 9) {
	        strDate = "0" + strDate;
	    }
	    
	    var hours = date.getHours();
	    if (hours >= 0 && hours <= 9) {
	    	hours = "0" + hours;
	    }
	    
	    var minutes = date.getMinutes();
	    if (minutes >= 0 && minutes <= 9) {
	    	minutes = "0" + minutes;
	    }
	    
	    var seconds = date.getSeconds();
	    if (seconds >= 0 && seconds <= 9) {
	    	seconds = "0" + seconds;
	    }
	    
	    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
	            + " " + hours + seperator2 + minutes + seperator2 + seconds;
	    return currentdate;
	};
	
	/**判断目标对象是否为数字(空判断为非数) */
	$.isNum = function isNum(target) {
		if (!isNaN(target) && !isNullOrEmpty(target)) {
			return true;
		} else {
			return false;
		}
	};
	
	/**判断是否为空 */
	$.isNullOrEmpty = function isNullOrEmpty(target) {
		var isNull = false;
		if (typeof (target) == 'undefined' || target == null || target == "") {
			isNull = true;
		}
		return isNull;
	}
	
	/**num表示要四舍五入的数,v表示要保留的小数位数 */
	$.formatterDecimal = function (num, v){
		if (!isNum(num)) {// 非数时返回空
			num = "0.00";
		}

		if (!isNum(v)) {
			v = 2;
		}

		var vv = Math.pow(10, v);
		var result = Math.round(num * vv) / vv;
		return result.toFixed(v);
	};
	
	/**两数相加 */
	$.dataAdd = function(_p1, _p2) {
		return _p1*1.0 + _p2*1.0;
	};
	
	/**批量相加 */
	$.dataAddBatch = function(_data) {
		var _val = 0;
		$.each(_data, function(index, v) {
			_val = _val * 1.0 + v * 1.0;
		});

		return _val;
	};
	
	/**两数相减*/
	$.dataSub = function(_p1, _p2) {
		if($.isNull(_p2)) {
			return _p1*1.0;
		}
		
		return _p1*1.0 - $.formatterDecimal(_p2)*1.0;
	};
	
	// 验证输入内容必须是数字
	$.isInteger = function(_val) {
		var _num = $.trim(_val);
		
		reg = /^[-+]?\d*$/;
		if(!reg.test(_num)) {
			return false;
		}
		
		return true;
	};
	
	// 获取固定参数
	$.getFormParams = function() {
		var _slFormParams = $('#sprams').attr('params');
		if ($.isNull(_slFormParams)) {
			return null;
		}
		
		return _slFormParams;
	};
	
	// 生成随机数
	$.puuid = function() {
		var num = 10;
        var len = num || 10, str = "", arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 0];
        for (var i = 0; i < len; i++) str += arr[Math.round(Math.random() * (arr.length - 1))];
        return str;
    };
    
    // 子页面关闭父页面layer弹出框
	$.closeLayer = function() {
		parent.layer.close(parent.layer.getFrameIndex(window.name));
	};
	
	// 解决window.onresize 多次触发的问题
    $.debounce = function (func, threshold, execAsap) { 
    	var timeout; 
    	console.log(1);
    	return function debounced () { 
    		var obj = this, args = arguments; 
    		function delayed () { 
    			if (!execAsap) 
    			func.apply(obj, args); 
    			timeout = null; 
    		}; 
    		if (timeout) {
    			clearTimeout(timeout); 
    		} else if (execAsap) {
    			func.apply(obj, args); 
    		}
    		timeout = setTimeout(delayed, threshold || 100); 
		};
	};
	
	/**
	  * 如： 传输页面：window.location.href = "xxx.html?obj="+
	  * encodeURIComponent(JSON.stringify(obj)); 接收页面：requestParam =
	  * getRequestParam(); data = JSON.parse(decodeURIComponent(requestParam.obj));
	  */
	 $.getRequestParam = function getRequestParam() {
	 	var urlInfo = window.location.href;
	 	var argsIndex = urlInfo.indexOf("?");
	 	var args = urlInfo.substring((argsIndex + 1)).split("&");
	 	var argsInfo = "{";
	 	for ( var i = 0; i < args.length; i++) {
	 		var argResult = args[i].split("=");
	 		argsInfo = argsInfo + "'" + argResult[0] + "':'" + argResult[1] + "'";
	 		if (i != args.length - 1) {
	 			argsInfo += ',';
	 		}
	 	}
	 	argsInfo += "}";
	 	return eval('(' + argsInfo + ')');
	 }
	
})(jQuery);