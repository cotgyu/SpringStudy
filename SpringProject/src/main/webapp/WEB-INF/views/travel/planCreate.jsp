<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/taglib.jsp" %>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Home | Triangle</title>
	<!-- 공통 css -->
	<%@ include file="/WEB-INF/views/common/commoncss.jsp" %>
    <script src="https://api2.sktelecom.com/tmap/js?version=1&format=javascript&appKey=71ebb74e-bb98-4ffc-99c7-46f3758a4c36"></script>
	<script  src="https://code.jquery.com/jquery-3.4.1.js" integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="  crossorigin="anonymous"></script>       
    <script type="text/javascript">
	$(document).ready(function () {
		$("#call").click(function () {
			$('#show').html('....loading...');
			alert("test");
			$.ajax({
				type: "GET",
				url: "http://api.visitkorea.or.kr/openapi/service/rest/KorService/areaCode?ServiceKey=uaggmM92YCI2loPv%2FE1ACToqLNKJA86fQ7W6a0S%2Bw4S6w5AU7eOnwdznpcSxEnGSsq5W%2B3uW9Z%2BJekpTokZbZA%3D%3D&numOfRows=10&pageNo=1&MobileOS=ETC&MobileApp=TestApp&_type=json",
				success:function(data) {
					$("#show").html(JSON.stringify
							(data));
				}
			});
		});
	});    
	   	var map, marker, markerLayer;
		// 페이지가 로딩이 된 후 호출하는 함수입니다.
		function initTmap() {
			// map 생성
			// Tmap.map을 이용하여, 지도가 들어갈 div, 넓이, 높이를 설정합니다.
			 map = new Tmap.Map({div:'map_div', // map을 표시해줄 div
								width:'100%',  // map의 width 설정
								height:'400px' // map의 height 설정
								}); 
			map.setCenter(new Tmap.LonLat(126.985065, 37.566269).transform("EPSG:4326", "EPSG:3857"),16);//맵 중심좌표 설정
	// 다른지도?			map.setCenter(new Tmap.LonLat("126.7499746596188", "37.49980548622674").transform("EPSG:4326", "EPSG:3857"), 10);		
			markerLayer = new Tmap.Layer.Markers();//마커 레이어 생성
			map.addLayer(markerLayer);//map에 마커 레이어 추가
			map.events.register("mouseup", map, onClick);//마우스 버튼을 떼었을때 발생하는 이벤트 등록 
			 
			var cLL = map.getCenter();//중심 좌표 받아오기
			var size = new Tmap.Size(24,38);//아이콘 크기
			var offset = new Tmap.Pixel(-(size.w/2), -size.h); //아이콘 중심점
			var icon = new Tmap.Icon('http://tmapapis.sktelecom.com/upload/tmap/marker/pin_b_m_a.png',size,offset);//마커 아이콘 설정
			marker = new Tmap.Marker(cLL,icon);//마커 생성
			markerLayer.addMarker(marker);//레이어에 마커 추가
		};
		// 픽셀값을 받아 좌표로 변환해주고 마커를 마커레이어에 추가해주는 함수입니다.
		function addMarker(x,y){
			var ll = map.getLonLatFromPixel(new Tmap.Pixel(x, y));//Pixel 값을 LonLat 값으로 변환
			var size = new Tmap.Size(24,38);//아이콘 크기
			var offset = new Tmap.Pixel(-(size.w/2), -size.h); //아이콘 중심점
			var icon = new Tmap.Icon('http://tmapapis.sktelecom.com/upload/tmap/marker/pin_b_m_a.png',size,offset);//마커에 사용할 아이콘 설정
			var marker = new Tmap.Marker(ll,icon);//마커 생성
			markerLayer.addMarker(marker);//레이어에 마커 추가
		}
	
		// '보이기' 버튼을 클릭하면 마커레이어를 보여주는 함수입니다.
		function show(){
			markerLayer.setVisibility(true); // 레이어의 화면 표출 여부
		}
		// '숨기기' 버튼을 클릭하면 표출된 마커레이어를 숨겨주는 함수입니다.
		function hide(){
			markerLayer.setVisibility(false);
		}   
		// 맵 생성 실행
		initTmap();
	</script>	
</head>

<body onload="initTmap()">
<!-- topMenu (상단 메뉴) -->
<%@ include file="/WEB-INF/views/common/topMenu.jsp" %>
<div id="map_div">
</div>

<button id="call">클릭!</button>
<p id="show"></p>
<!--footer (하단) -->
<%@ include file="/WEB-INF/views/common/footer.jsp" %>

</body>
</html>
