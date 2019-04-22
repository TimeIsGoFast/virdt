(function ($) {
$.fn.myDataTableUtil = function (table_id, url, url_type, columns) {
	var tables = $(table_id).dataTable({
		responsive: true,
	    serverSide: true,
	    processing: true,
		ajax:{
			url: url,
			type: url_type,
			data: function(d){
				var param = {};
                param.page = d.start/10+1;
                param.row = d.length;
                param.draw = d.draw;
                param.search = d.search.value;
                return param;
			},
           "dataType" : "json",
           "dataFilter": function (json) {//json是服务器端返回的数据
               json = JSON.parse(json);
               var returnData = {};
               returnData.draw = json.draw;
               returnData.recordsTotal = json.total;//返回数据全部记录
               returnData.recordsFiltered = json.total;//后台不实现过滤功能，每次查询均视作全部结果
               returnData.data = json.list;//返回的数据列表
               return JSON.stringify(returnData);//这几个参数都是datatable需要的，必须要
           }
		},
		columnDefs: [{"defaultContent": "",
            "targets": "_all"}],
		columns: columns,
	});
	return tables;
};
})(jQuery);