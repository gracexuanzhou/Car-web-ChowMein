$(function() {
    initTimeText();
    validateRule();
});
function initTimeText() {
    $("#expiryDate").datetimepicker({
        format: 'yyyy-mm-dd',
        startView: 2,
        minView: 2,
        todayHighlight: true,
        language: 'zh-CN',
        autoclose: true,
        clearBtn: true,
        endDate: new Date()
    }).on('hide', function (event) {
        event.preventDefault();
        event.stopPropagation();
        var startTime = event.date;
        $('#endTime').datetimepicker('setStartDate', startTime);
    });
}

$.validator.setDefaults({
    submitHandler : function() {
        save();
    }
});
function save() {
    $.ajax({
        cache : true,
        type : "POST",
        url : "/customer/comment/save",
        data : $('#commentForm').serialize(), // 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("网络超时");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.layer.msg("操作成功");
                parent.reLoad();
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#commentForm").validate({
        rules : {
            content : {
                required : true
            }
        },
        messages : {
            content : {
                required : icon + "请输入评论内容"
            }
        }
    })
}