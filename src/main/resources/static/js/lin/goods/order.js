
var prefix = "/"
$(function() {
	

	load();
});
function load() {
	$('#exampleTable')
		.bootstrapTable(
			{
				method : 'get', // 服务器数据的请求方式 get or post
				url : prefix + "merchant/order/All", // 服务器数据的加载地址
					showRefresh : true,
					showToggle : true,
					showColumns : true,
				iconSize : 'outline',
				toolbar : '#exampleToolbar',
				striped : true, // 设置为true会有隔行变色效果
				dataType : "json", // 服务器返回的数据类型
				pagination : true, // 设置为true会在底部显示分页条
				// queryParamsType : "limit",
				// //设置为limit则会发送符合RESTFull格式的参数
				singleSelect : false, // 设置为true将禁止多选
				// contentType : "application/x-www-form-urlencoded",
				// //发送到服务器的数据编码类型
				pageSize : 10, // 如果设置了分页，每页数据条数
				pageNumber : 1, // 如果设置了分布，首页页码
				search : false, // 是否显示搜索框
				showColumns : true, // 是否显示内容下拉框（选择显示的列）
				sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
				queryParams : function(params) {
					return {
						//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                        pageSize: params.limit,
                        pageNumber: params.pageNumber,
						// name:$('#searchName').val(),
						//type : $('#searchName').val(),
					};
				},
				// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
				// queryParamsType = 'limit' ,返回参数必须包含
				// limit, offset, search, sort, order 否则, 需要包含:
				// pageSize, pageNumber, searchText, sortName,
				// sortOrder.
				// 返回false将会终止请求
				columns : [
					{
						field : 'userName',
						title : '顾客'
					},
					{
						field : 'createTimeStr',
						title : '下单时间'
					},
					{
						field : 'brandName',
						title : '品牌'
					},
					{
						field : 'typeName',
						title : '型号'
					},
					{
						field : 'price',
						title : '价格'
					},
					{
						field: 'daysStr',
						title: '取货日期'
					},
					{
						field : 'status',
						title : '状态',
						formatter: function (value, row, index) {
							if (value== 0) {
								return '待收货';
							}else if(value== 1){
								return '待评价';
							}else{
								return '已完成';
							}
						}
					}
					 ]
			});
}

function changeDateFormat(cellval) {
	var dateVal = cellval + "";
	if (cellval != null) {
		var date = new Date(parseInt(dateVal.replace("/Date(", "").replace(")/", ""), 10));
		var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();

		var hours = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		var minutes = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
		var seconds = date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();

		return date.getFullYear() + "-" + month + "-" + currentDate + " " + hours + ":" + minutes + ":" + seconds;
	}
}


function reLoad() {
	var opt = {
		query : {
			goodsCatalogId : $('.chosen-select').val(),
		}
	}
	$('#exampleTable').bootstrapTable('refresh', opt);
}
function pinglun(id) {
	layer.open({
		type : 2,
		title : '评论',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content :  '/comment/'+id // iframe的url
	});
}
function shouhuo(id) {
	layer.confirm('确定要收货？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : "/customer/order/receive",
			type : "post",
			data : {
				'id' : id,
				'status':1
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