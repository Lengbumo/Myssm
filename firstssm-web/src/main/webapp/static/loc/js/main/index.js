layui.use(['layer', 'form', 'jquery'], function () {
    var layer = layui.layer; //弹层
    var form = layui.form; //表格
    var $ = layui.jquery;

    initchgSelect();

    // 监听切换语言
    form.on('select(chgLangSelect)', function(data){
        var value = $("#chglang").children('option:selected').val();
        setCookie("language", value);
        location.reload();
    });

    // 根据cookie获取语言
    function initchgSelect() {
        var value = getCookie("language");
        if ($.isNotNull(value)) {
            $("#chglang option[value='"+value+"']").prop("selected",true);
        } else {
            $("#chglang option[value=ch]").prop("selected",true);
        }
        form.render("select");
    }
});