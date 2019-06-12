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
		<div id="subordinate" style="width:1200px;height: 600px;margin: 0 auto;"></div>
	</div>
	
	<script type="text/javascript">
	var option = null;
	var provinceO = null;
	var dom = document.getElementById("container");
	// 基于准备好的dom，初始化echarts图表
	var myChart = echarts.init(dom);
 	var SubordinateMap = echarts.init(document.getElementById('subordinate'));
	
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
 			"广东": [113.07, 24.27],
 			'上海': [121.4648,31.2891]
 	};
 	
 	option = {
 		backgroundColor: '#f0f0f0',
		tooltip : {
            trigger: 'item', //提示框的触发类型。
            formatter: '{b}' //内容格式器可以支持异步回调函数。返回一个你想要提示的字符串就可以了
        },
        /* visualMap: [{
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
		}], */
        /* geo: {
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
				formatter: '{b}'
			},
			label: {
				normal: {
					show: false
				},
				emphasis: {
					show: true
				}
			}
		}, */
        dataRange: { //值域选择
            min: 0,
            max: 100,
            calculable: false,
            show: false,
            color: ['#ff3333', 'orange', 'yellow', 'lime', 'aqua'],
            textStyle: {  //文字颜色
                color: '#fff'
            }
        },
        series: [{ //图表生成的数据内容数组
        	name: '中国',
            type: 'map',   //图表类型为地图
            mapType: 'china',   //地图类型中国地图，
            selectedMode: 'single', //选中模式，可以设置多选模式和单选，不能选择则删除属性
            hoverable: false,   //悬浮是否高亮
            itemStyle:{
                normal: {        //地图样式
                    borderColor: '#71D1FF', //地图边界颜色
                    color: '#070C67'  //地图颜色
                },
                emphasis: {   //地图选中时样式
                    label: {
                        show: true,
                        textStyle: {
                            color: '#23262E' //选中时区域名字颜色
                        },
                    },
                    color: '#1de08f' //选中时颜色
                }
            },
            data:[
                {name:'上海',selected:true}   //上海默认别选中
            ],	
            geoCoord: geoCoordMap   //每个城市对应的经纬度
        }]
 	}
	
 	//省级
    provinceO = {
        title: { //标题
            text: '全国34个省市自治区',
            subtext: '省级'
        },
        tooltip: {
            trigger: 'item'  //提示框的触发类型。
        },
        legend: {   //图列
            orient: 'vertical', //图列显示的方式
            x: 'right',
            data: ['随机数据']
        },
        series: [
            {
                name: '随机数据',
                type: 'map',
                mapType: '湖南',  //要显示的省份，下钻就是通过on事件来更改属性
                selectedMode: 'single', //选中模式，可以设置多选模式和单选，不能选择则删除删除属性
                itemStyle: {
                    normal: {
                        label: { show: true }, //是否显示城市名字
                        borderColor: '#71D1FF',  //地图边界颜色
                        color: '#070C67'
                    },
                    emphasis: { label: { show: true } } //选中后样式

                },
                data: [
                    { name: '重庆市', value: Math.round(Math.random() * 1000) } //类似数据省略
                ]} 
        ]
    }
 	
 	setTimeout(function() {
		myChart.dispatchAction({
			type: 'showTip',
			seriesIndex: 0,
			dataIndex: 0
		})
	}, 1000);

	if(option && typeof option === "object") {
		myChart.setOption(option, true);
		
		myChart.on('mapSelected', function (param) {
		  console.log(param);
	      var name = param.target;//获得选中的城市
	      provinceO.series[0].mapType = name;//设置series的mapType属性为当前选中的城市
	      SubordinateMap.setOption(provinceO, true);//给SubordinateMapDIV重现加载地图

	  	});
	}
	
	</script>
</body>
	
</html>