package test;
import pojo.menu.ClickButton;
import pojo.menu.ViewButton;
import util.HttpUtils;

import com.alibaba.fastjson.JSONObject;

import net.sf.json.JSONArray;

public class MenuTest {
	public static void main(String[] args) {
		ClickButton cbt=new ClickButton();
		cbt.setKey("image");
		cbt.setName("�ظ�ͼƬ");
		cbt.setType("click");
		
		
		ViewButton vbt=new ViewButton();
		vbt.setUrl("http://www.cuiyongzhi.com");
		vbt.setName("����");
		vbt.setType("view");
		
		JSONArray sub_button=new JSONArray();
		sub_button.add(cbt);
		sub_button.add(vbt);
		
		
		JSONObject buttonOne=new JSONObject();
		buttonOne.put("name", "�˵�");
		buttonOne.put("sub_button", sub_button);
		
		JSONArray button=new JSONArray();
		button.add(vbt);
		button.add(buttonOne);
		button.add(cbt);
		
		JSONObject menujson=new JSONObject();
		menujson.put("button", button);
		System.out.println(menujson);
		//����Ϊ����ӿڵ�url   +�ź������token������Ͳ��������token��ȡ�ķ�������
		String url="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+"pgevmrZv4l7BWmiCNN9nrG-Mwk-o6lZLY0QdvnwzKkwWzI7SL-TNkvrvd6Y-pJD-xrkJH_y6X5QY6c03GlLO9CWsJ6k7e_k5WCJuYoHh51kEJQhADAMRY";
		
		try{
			String rs=HttpUtils.sendPostBuffer(url, menujson.toJSONString());
			System.out.println(rs);
		}catch(Exception e){
			System.out.println("�������");
		}
	}
}
