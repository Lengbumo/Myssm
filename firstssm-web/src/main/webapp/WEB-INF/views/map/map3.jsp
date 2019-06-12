<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@ include file="../common/top.jsp"%>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
    <script type="text/javascript" src="${CTX_PATH }/static/3rd/echarts/echarts-all.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/echarts/china.js"></script>
	<%-- <script src="//cdn.bootcss.com/echarts/4.0.2/echarts.min.js"></script>
	<script type="text/javascript" src="${CTX_PATH }/static/3rd/echarts/china.js"></script> 
	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>--%>
	<script type="text/javascript" src="${CTX_PATH }/static/loc/js/map/map.js"></script>
	
</head>

<body>
	 <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width:1200px;height: 600px;margin: 0 auto;"></div>
    
    <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var option = {
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['销量']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"销量",
                            "type":"bar",
                            "data":[5, 20, 40, 10, 10, 20]
                        }
                    ]
                };
                
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
    </script>
</body>
</html>