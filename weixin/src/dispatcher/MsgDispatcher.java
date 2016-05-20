package dispatcher;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pojo.response.Article;
import pojo.response.NewsMessage;
import pojo.response.TextMessage;
import util.MessageUtil;


/**
 * ClassName: MsgDispatcher
 * @Description: ��Ϣҵ����ַ���
 * @author xj
 */
public class MsgDispatcher {
	public static String processMessage(Map<String, String> map) {
		String openid=map.get("FromUserName"); //�û�openid
		String mpid=map.get("ToUserName");   //���ں�ԭʼID
		
		//��ͨ�ı���Ϣ
		TextMessage txtmsg=new TextMessage();
		txtmsg.setToUserName(openid);
		txtmsg.setFromUserName(mpid);
		txtmsg.setCreateTime(new Date().getTime());
		txtmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) { // �ı���Ϣ
			String content=map.get("Content");
			if("1".equals(content)){
				txtmsg.setContent("��ã��㷢�͵�������1��");
			}else if("2".equals(content)){
				txtmsg.setContent("��ã��㷢�͵�������2��");
			}else if("3".equals(content)){
				txtmsg.setContent("��ã��㷢�͵�������3��");
			}else if("4".equals(content)){
				txtmsg.setContent("<a href=\"http://www.cuiyongzhi.com\">����־����</a>");
			}else{
				txtmsg.setContent("��ã���ӭ��������־���ͣ�");
			}
			return MessageUtil.textMessageToXml(txtmsg);
		}
		
		//��ͼ����Ϣ
		NewsMessage newmsg=new NewsMessage();
		newmsg.setToUserName(openid);
		newmsg.setFromUserName(mpid);
		newmsg.setCreateTime(new Date().getTime());
		newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) { // ͼƬ��Ϣ
			System.out.println("==============����ͼƬ��Ϣ��");
			Article article=new Article();
			article.setDescription("����ͼ����Ϣ1"); //ͼ����Ϣ������
			article.setPicUrl("http://res.cuiyongzhi.com/2016/03/201603086749_6850.png"); //ͼ����ϢͼƬ��ַ
			article.setTitle("ͼ����Ϣ1");  //ͼ����Ϣ����
			article.setUrl("http://www.cuiyongzhi.com");  //ͼ��url����
			List<Article> list=new ArrayList<Article>();
			list.add(article);     //���﷢�͵��ǵ�ͼ�ģ������Ҫ���Ͷ�ͼ����������list�м�����Article���ɣ�
			newmsg.setArticleCount(list.size());
			newmsg.setArticles(list);
			return MessageUtil.newsMessageToXml(newmsg);
		}
		
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) { // ������Ϣ
			txtmsg.setContent("");
			return MessageUtil.textMessageToXml(txtmsg);
		}
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) { // λ����Ϣ
			System.out.println("==============����λ����Ϣ��");
			return "";
		}
		
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) { // ��Ƶ��Ϣ
			System.out.println("==============������Ƶ��Ϣ��");
			return "";
		}
		
		
		if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) { // ������Ϣ
			System.out.println("==============����������Ϣ��");
			return "";
		}

		return null;
	}
}