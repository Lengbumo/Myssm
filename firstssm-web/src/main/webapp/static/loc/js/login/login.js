layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    $(".loginBody .seraph").click(function(){
        layer.msg("这只是做个样式，至于功能，你见过哪个后台能这样登录的？还是老老实实的找管理员去注册吧",{
            time:5000
        });
    })

    isFireFox();
    
    //登录按钮
    form.on("submit(login)",function(obj){
    	if (isFireFox() == 'yes') {
    		console.log();
        	return;
    	}
    	$(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
    	$.ajax({
            type: 'POST',
            url: my.window.ctxPath + '/myssm/login/in',
            data: $('#loginForm').serialize(),
            dataType : "json",
            success: function (data) {
            	if (data.rs) {
                	window.location.href = my.window.ctxPath + "/myssm/manager/index";
                } else {
                	layer.msg(data.message,{
                        time:5000
                    });
                	$('#verifycode').val("");
                	changeValidateCode();
                	$("#loginSub").text("登录").attr("disabled",false).removeClass("layui-disabled");
                }
            },
            error: function () {
            	console.log("error");
            	$("#loginForm")[0].reset();
                layui.form.render();
                layer.msg("系统异常",{
                    time:5000
                });
                changeValidateCode();
                $("#loginSub").text("登录").attr("disabled",false).removeClass("layui-disabled");
            }
        });
    	
    	
        /*setTimeout(function(){
            window.location.href = my.window.ctxPath + "/myssm/manager/index";
        },1000);*/
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
    
})

// 修改验证码
function changeValidateCode() {
	var obj = $('#Login_code_img');
	var timenow = new Date().getTime();
	var url = my.window.ctxPath + "/myssm/getRadomCode?d=" + timenow;
	$(obj).attr("src", url);
}

// 获取浏览器类型
function getOs() {  
	var OsObject = "";  
   	if(navigator.userAgent.indexOf("MSIE")>0) {  
        return "MSIE";  
   	}  
   	if(isFirefox=navigator.userAgent.indexOf("Firefox")>0){  
        return "Firefox";  
   	}  
   	if(isSafari=navigator.userAgent.indexOf("Safari")>0) {  
        return "Safari";  
   	}   
   	if(isCamino=navigator.userAgent.indexOf("Camino")>0){  
        return "Camino";  
   	}  
   	if(isMozilla=navigator.userAgent.indexOf("Gecko/")>0){  
        return "Gecko";  
   	}  
}

// 是否是火狐浏览器
function isFireFox() {
	var flag = 'no';
	if (getOs() == "Firefox") {
    	layer.msg("系统检测到您使用的是火狐浏览器,由于兼容问题,请暂更换其他浏览器T_T");
    	flag = 'yes';
	}
	return flag;
}
