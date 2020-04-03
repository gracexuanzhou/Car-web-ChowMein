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
    validateRule();
    $.ajax({
        cache : true,
        type : "POST",
        url : "/customer/order/pay",
        data : $('#payForm').serialize(), // 你的formid
        async : false,
        error : function(request) {
            parent.layer.alert("网络超时");
        },
        success : function(data) {
            if (data.code == 0) {
                parent.parent.layer.msg("操作成功");
                parent.layer.closeAll();
            } else {
                parent.layer.alert(data.msg)
            }

        }
    });

}
function validateRule() {
    var icon = "<i class='fa fa-times-circle'></i> ";
    $("#payForm").validate({
        rules : {
            cardName : {
                required : true
            },
            cardNo : {
                required : true,
                maxlength:18,
                minlength:16
            },
            passWord : {
                required : true
            },
            expiryDate : {
                required : true
            },
            securityCode : {
                required : true,
                maxlength:3,
                minlength:3
            }
        },
        messages : {
            cardName : {
                required : icon + "请输入姓名"
            },
            cardNo : {
                required : icon + "请输入卡号",
                maxlength: $.validator.format("最多可以输入 {0} 个字符"),
                minlength: $.validator.format("最少要输入 {0} 个字符")
            },
            passWord : {
                required : icon + "请输入密码"
            },
            expiryDate : {
                required : icon + "请输入有效期"
            },
            securityCode : {
                required : icon + "请输入验证码",
                maxlength: $.validator.format("最多可以输入 {0} 个字符"),
                minlength: $.validator.format("最少要输入 {0} 个字符")
            }
        }
    })
}