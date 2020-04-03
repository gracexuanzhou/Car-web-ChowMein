
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});

var menuIds;
$(function() {
    validateRule();
});
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/merchant/save",
		data : $('#goodsAddForm').serialize(), // 你的formid
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
	$("#goodsAddForm").validate({
		rules : {
			brandName : {
				required : true
			},
			typeName : {
				required : true
			},
			price : {
				required : true
			},
			place : {
				required : true
			}
		},
		messages : {
			brandName : {
				required : icon + "请输入品牌名称"
			},
			typeName : {
				required : icon + "请输入型号"
			},
			price : {
				required : icon + "请输入价格"
			},
			place : {
				required : icon + "请输入产地"
			}
		}
	});
}