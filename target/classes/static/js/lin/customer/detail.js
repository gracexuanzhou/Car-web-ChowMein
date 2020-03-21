
var prefix = "/"
$(function() {
});
function pay() {
    layer.open({
        type : 2,
        title : '支付',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '320px' ],
        content :  '/goods/pay/'+$("#gid").val() // iframe的url
    });
}