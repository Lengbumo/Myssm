<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../common/top.jsp"%>
    <script type="text/javascript" src="${CTX_PATH }/static/3rd/echarts/echarts-all.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/echarts/china.js"></script>
	<%-- <script src="//cdn.bootcss.com/echarts/4.0.2/echarts.min.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/echarts/china.js"></script> 
	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>--%>
	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/map/map.js"></script>
	
</head>

<body>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div class="" style="width: 100%;overflow: hidden;height: 100%; background-color: #f0f0f0;">
		<div id="container" style="width:1200px;height: 600px;margin: 0 auto;"></div>
	</div>
	
	<script type="text/javascript">
	var dom = document.getElementById("container");
	var myChart = echarts.init(dom);
	option = null;
	var pao1 = my.window.ctxPath + "/static/loc/images/my.ico";
	var pao2 = my.window.ctxPath + "/static/loc/images/my.ico";
	var pao3 = my.window.ctxPath + "/static/loc/images/my.ico";
	var pao4 = my.window.ctxPath + "/static/loc/images/my.ico";

	var geoCoordMap = {
		//"城市":[经度,纬度]
		//此处设置的位置决定气泡和name显示的位置
		"北京": [114.68, 40.66],
		"天津": [117.28, 39.88],
		"河北": [114.08, 38.68],
		"新疆": [86.68, 42.66],
		"江苏": [118.28, 34.06],
		"浙江": [119.28, 29.26],
		"湖北": [112.16, 31.96],
		"江西": [115.36, 28.68],
		"广东": [113.07, 24.27]
	};
	var convertData = function(data) {
		var res = [];
		for(var i = 0; i < data.length; i++) {
			var geoCoord = geoCoordMap[data[i].name];
			if(geoCoord) {
				res.push({
					name: data[i].name,
					value: geoCoord.concat(data[i].value),
					city: data[i].city,
					leixing: data[i].leixing,
					shixiao: data[i].shixiao,
					fanhuan: data[i].fanhuan
				});
			}
		}
		return res;
	};
	option = {

		backgroundColor: '#f0f0f0',
		tooltip: {

			trigger: 'item',
			triggerOn: 'mousemove',
			alwaysShowContent: true,
			backgroundColor: 'rgba(129,119,255,1)',
			borderColor: 'rgba(92,83,205,1)',
			borderWidth: '2',
			extraCssText: 'padding:10px;box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);',
			show: true,

			//formatter: '{a} <br/>{b}<br/> {c}'
			formatter: function(params) {
				var res;
				if(params.value > 0) {
					res = '注册地区：' + params.data.city + '<br/>';
					//res +='<img src="'+params.data.icon+'"/>';
					res += '注册类型：' + params.data.leixing + '<br/>';
					res += '注册时效：' + params.data.shixiao + '<br/>';
					res += '税收返还：' + params.data.fanhuan + '<span style="padding:2px 5px;margin-left:5px;background-color:#ff6600;border-radius:3px">最高</span><br/>';
					//res +=params.data.zixun;
					res += '<a href="https://www.youfa365.com/" style="color:#fff;padding:3px 20px; text-decoration:none;border:2px #fff solid;margin-top:10px;display:inline-block;border-radius:3px;" target="_blank">立即咨询</a>';
				} else {
					res = '';
				}

				return res;
			}
		},
		visualMap: [{
			seriesIndex: 0,
			min: 0,
			max: 4,
			calculable: false,
			show: false,
			// 表示 目标系列 的视觉样式。
			target: {
				inRange: {
					show: true,
					color: ['#b8b2ff', '#8177ff', '#6056e4', '#4b43ac']
				}
			}
		}],
		geo: {
			map: 'china',
			//为了鼠标滑过气泡时，同样显示tip
			tooltip: {
				trigger: 'item',
				triggerOn: 'mousemove',
				alwaysShowContent: true,
				backgroundColor: 'rgba(129,119,255,1)',
				borderColor: 'rgba(92,83,205,1)',
				borderWidth: '2',
				extraCssText: 'padding:10px;box-shadow: 0 0 3px rgba(0, 0, 0, 0.3);',
				show: true,
				formatter: function(params) {
					var res;
					res = '注册地区：' + params.data.city + '<br/>';
					//res +='<img src="'+params.data.icon+'"/>';
					res += '注册类型：' + params.data.leixing + '<br/>';
					res += '注册时效：' + params.data.shixiao + '<br/>';
					res += '税收返还：' + params.data.fanhuan + '<span style="padding:2px 5px;margin-left:5px;background-color:#ff6600;border-radius:3px">最高</span><br/>';
					res += '<a href="https://www.youfa365.com/" style="color:#fff;padding:3px 20px; text-decoration:none;border:2px #fff solid;margin-top:10px;display:inline-block;border-radius:3px;" target="_blank">立即咨询</a>';
					return res;
				}
			},
			label: {
				normal: {
					show: false
				},
				emphasis: {
					show: true
				}
			}
		},
		series: [{
				type: 'map',
				mapType: 'china',
				label: {
					normal: {
						//重新设置显示位置，不再使用此处显示文字
						show: false,
						color: '#fff',
						fontSize: 12,
						formatter: function(params) {
							var res;
							if(params.value > 0) {
								res = params.data.city + '\n';
							} else {
								res = '';
							}
							return res;
						}
					},
					emphasis: {
						show: false,
						color: '#fff'
					}
				},
				itemStyle: {
					normal: {
						borderColor: 'rgba(255, 255, 255, 1)'
					},
					emphasis: {
						areaColor: null,
						shadowOffsetX: 0,
						shadowOffsetY: 0,
						shadowBlur: 20,
						borderWidth: 0,
						shadowColor: 'rgba(0, 0, 0, 0.5)'
					}
				},
				data: convertData([{
						name: '北京',
						city: '北京',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '30天',
						fanhuan: '演示数据'
					},
					{
						name: '天津',
						city: '天津',
						value: 2,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '河北',
						city: '河北',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '30天',
						fanhuan: '演示数据'
					},
					{
						name: '新疆',
						city: '新疆',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '30天',
						fanhuan: '演示数据'
					},
					{
						name: '江苏',
						city: '江苏',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '30天',
						fanhuan: '演示数据'
					},
					{
						name: '浙江',
						city: '浙江',
						value: 2,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '湖北',
						city: '武汉',
						value: 4,
						leixing: '公司注册（极速版）',
						shixiao: '1天',
						fanhuan: '演示数据'
					},
					{
						name: '江西',
						city: '江西',
						value: 3,
						leixing: '公司注册（极速版）',
						shixiao: '2天',
						fanhuan: '演示数据'
					},
					{
						name: '广东',
						city: '广东',
						value: 2,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					}
				])
			},
			{
				name: 'Point', //30天注册
				type: 'scatter',
				coordinateSystem: 'geo',
				data: convertData([{
						name: '北京',
						city: '北京',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '河北',
						city: '河北',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '新疆',
						city: '新疆',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '江苏',
						city: '江苏',
						value: 1,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
				]),
				symbol: 'image://' + pao4,
				zlevel: 0,
				symbolSize: 1,
				label: {
					normal: {
						show: true,
						color: '#fff',
						position: ['50%', '50%'],
						formatter: function(params) {
							return params.data.city;
						}
					},
					emphasis: {
						show: false
					}
				}

			},
			{
				name: 'Point', //3天注册
				type: 'scatter',
				coordinateSystem: 'geo',
				data: convertData([{
						name: '天津',
						city: '天津',
						value: 2,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '浙江',
						city: '浙江',
						value: 2,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					},
					{
						name: '广东',
						city: '广东',
						value: 2,
						leixing: '公司注册（极速版）',
						shixiao: '3天',
						fanhuan: '演示数据'
					}
				]),
				symbol: 'image://' + pao3,
				zlevel: 1,
				symbolSize: 24,
				label: {
					normal: {
						show: true,
						color: '#fff',
						position: ['30%', '60%'],
						formatter: function(params) {
							return params.data.city;
						}
					},
					emphasis: {
						show: false
					}
				}
			},
			{
				name: 'Point', //2天注册
				type: 'scatter',
				//formatter: data.value,
				coordinateSystem: 'geo',
				data: convertData([{
					name: '江西',
					city: '江西',
					value: 3,
					leixing: '公司注册（极速版）',
					shixiao: '3天',
					fanhuan: '演示数据'
				}]),
				symbol: 'image://' + pao2,
				zlevel: 1,
				symbolSize: 24,
				label: {
					normal: {
						show: true,
						color: '#fff',
						position: ['10%', '100%'],
						formatter: function(params) {
							return params.data.city;
						}
					},
					emphasis: {
						show: false
					}
				}
			},

			{
				name: 'Point', //1天注册
				type: 'scatter',
				coordinateSystem: 'geo',
				data: convertData([{
					name: '湖北',
					city: '武汉',
					value: 4,
					leixing: '公司注册（极速版）',
					shixiao: '3天',
					fanhuan: '演示数据'
				}]),
				symbol: 'image://' + pao1,
				zlevel: 1,
				symbolSize: 24,
				label: {
					normal: {
						show: true,
						color: '#fff',
						position: ['80%', '75%'],
						formatter: function(params) {
							return params.data.city;
						}
					},
					emphasis: {
						show: false
					}
				}

			}

		]
	};

	setTimeout(function() {
		myChart.dispatchAction({
			type: 'showTip',
			seriesIndex: 0,
			dataIndex: 0
		})
	}, 1000);

	if(option && typeof option === "object") {
		myChart.setOption(option, true);
	}
	</script>
</body>
	
</html>