<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
	<head>
		<title>DWR����</title>

		<script type='text/javascript' src='dwr/engine.js'></script>
		<script type='text/javascript' src='dwr/util.js'></script>
		<script type='text/javascript' src='dwr/interface/test10.js'></script>
		
		<script type="text/javascript">
			
			function test(){
			
				/*dwr.engine.setAsync(false);		//����Ϊͬ������ô���ȵ���method1��������ִ��method2����������ȷ��
				test10.method1(
					function(data){
				
						alert(data);
					}
				);*/
				test10.method2(
					function(data){
						
						DWRUtil.removeAllOptions("stu");
						DWRUtil.addOptions('stu',data,"id","name");
					}
				);	//�����첽ͨ�ţ�method1������method2����ִ�е��Ⱥ�˳��Ĳ��̶��ġ�
			}
			
			
		</script>
	</head>

	<body>
		<form>			
		<select id="stu" name="stuname">
			
		</select>
		
		
			��Ȩ��<input type="checkbox" name="hp1" userId="123" resourceSn="789" onclick="test()"/>
		</form>
	</body>
</html>
