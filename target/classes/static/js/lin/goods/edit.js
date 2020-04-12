var menuIds;
$(function() {
	validateRule();
});
$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
function update() {
    var role = $('#goodsUpdateForm').serialize();
	$.ajax({
		cache : true,
		type : "POST",
		url : "/merchant/update",
		data : role, // 你的formid
		async : false,
		error : function(request) {
			alert("Connection error");
		},
		success : function(r) {
			if (r.code == 0) {
				parent.layer.msg(r.msg);
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.msg(r.msg);
			}

		}
	});
}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#goodsUpdateForm").validate({
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