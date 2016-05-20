package dispatcher;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import pojo.response.Article;
import pojo.response.Image;
import pojo.response.ImageMessage;
import pojo.response.NewsMessage;
import util.MessageUtil;

/**
 * ClassName: EventDispatcher
 * 
 * @Description: �¼���Ϣҵ��ַ���
 * @author xj
 */
public class EventDispatcher {

	public static String processEvent(Map<String, String> map) {
		String openid = map.get("FromUserName"); // �û�openid
		String mpid = map.get("ToUserName"); // ���ں�ԭʼID

		ImageMessage imgmsg = new ImageMessage();
		imgmsg.setToUserName(openid);
		imgmsg.setFromUserName(mpid);
		imgmsg.setCreateTime(new Date().getTime());
		imgmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_Image);

		// ��ͼ����Ϣ
		NewsMessage newmsg = new NewsMessage();
		newmsg.setToUserName(openid);
		newmsg.setFromUserName(mpid);
		newmsg.setCreateTime(new Date().getTime());
		newmsg.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) { // ��ע�¼�
			System.out.println("==============���ǹ�ע�¼���");

		}

		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) { // ȡ����ע�¼�
			System.out.println("==============����ȡ����ע�¼���");
		}

		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SCAN)) { // ɨ���ά���¼�
			System.out.println("==============����ɨ���ά���¼���");
		}

		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_LOCATION)) { // λ���ϱ��¼�
			System.out.println("==============����λ���ϱ��¼���");
		}

		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)) { // �Զ���˵�����¼�
			System.out.println("==============�����Զ���˵�����¼���");

		}

		if (map.get("Event").equals(MessageUtil.EVENT_TYPE_VIEW)) { // �Զ���˵�View�¼�
			System.out.println("==============�����Զ���˵�View�¼���");
		}

		return null;
	}
}