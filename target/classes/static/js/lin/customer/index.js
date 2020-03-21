
var prefix = "/"
$(function() {


    load();
});
function load() {
    var param = {};
    param.pageSize = 100;
    param.pageNumber = 0;
    $.ajax({
        url: "/customer/goods/All",
        data:param,
        success: function(data){
            var html = buildHtml(data);
            $("#content").html(html);
        }});
}

function buildHtml(data) {
    var html = "";
    if(data.rows.length > 0){
        var list = data.rows;
        for(var i = 0;i<list.length;i++){
            var goods= list[i];
            html += '<div class="bigPic bigPic1 j-list"><div class="thBig"><p class="pic">';
            html += '<a href="javascript:void(0);" onclick="detail('+goods.id+')">';
            html += '<img width="180" height="135" alt="'+goods.brandName+'" title="'+goods.brandName+'" src="//img.pcauto.com.cn/images/upload/upc/tx/auto5/1805/09/c38/86361379_1525848320541_180x135.jpg"></a></p>';
            html +=  '<p class="tit"><a href="javascript:void(0);" title="'+goods.brandName+'" onclick="detail('+goods.id+')">'+goods.brandName+'-'+goods.typeName+'</a></p>';
            html += '<p class="pri"><span class="red">'+goods.price+'元</span></p>';
            html += '<p></p></div></div>'
        }
    }
    return html;
}
function reLoad() {
    var opt = {
        query : {
            goodsCatalogId : $('.chosen-select').val(),
        }
    }
    $('#exampleTable').bootstrapTable('refresh', opt);
}
function add() {
    layer.open({
        type : 2,
        title : '增加',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '800px', '520px' ],
        content :  '/goods/add' // iframe的url
    });
}
function detail(id) {
    layer.open({
        type : 2,
        title : '详情',
        maxmin : true,
        shadeClose : false, // 点击遮罩关闭层
        area : [ '1000px', '420px' ],
        content : '/goods/detail/' + id // iframe的url
    });
}
function remove(id) {
    layer.confirm('确定要删除选中的记录？', {
        btn : [ '确定', '取消' ]
    }, function() {
        $.ajax({
            url : "/merchant/remove",
            type : "post",
            data : {
                'id' : id
            },
            success : function(r) {
                if (r.code == 0) {
                    layer.msg(r.msg);
                    reLoad();
                } else {
                    layer.msg(r.msg);
                }
            }
        });
    })
}