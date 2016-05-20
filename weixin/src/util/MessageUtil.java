package util;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

import pojo.response.Article;
import pojo.response.ImageMessage;
import pojo.response.MusicMessage;
import pojo.response.NewsMessage;
import pojo.response.TextMessage;
import pojo.response.VideoMessage;
import pojo.response.VoiceMessage;

/**
 * ClassName: MessageUtil
 * @Description: 消息工具类
 * @author xj
 */
public class MessageUtil {

	/**
	 * 返回消息类型：文本
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 返回消息类型：音乐
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * 返回消息类型：图文
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * 返回消息类型：图片
	 */
	public static final String RESP_MESSAGE_TYPE_Image = "image";

	/**
	 * 返回消息类型：语音
	 */
	public static final String RESP_MESSAGE_TYPE_Voice = "voice";

	/**
	 * 返回消息类型：视频
	 */
	public static final String RESP_MESSAGE_TYPE_Video = "video";

	/**
	 * 请求消息类型：文本
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * 请求消息类型：图片
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * 请求消息类型：链接
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * 请求消息类型：地理位置
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * 请求消息类型：音频
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * 请求消息类型：视频
	 */
	public static final String REQ_MESSAGE_TYPE_VIDEO = "video";

	/**
	 * 请求消息类型：推送
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * 事件类型：subscribe(订阅)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * 事件类型：unsubscribe(取消订阅)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * 事件类型：CLICK(自定义菜单点击事件)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * 事件类型：VIEW(自定义菜单URl视图)
	 */
	public static final String EVENT_TYPE_VIEW = "VIEW";

	/**
	 * 事件类型：LOCATION(上报地理位置事件)
	 */
	public static final String EVENT_TYPE_LOCATION = "LOCATION";

	/**
	 * 事件类型：LOCATION(上报地理位置事件)
	 */
	public static final String EVENT_TYPE_SCAN = "SCAN";

	/**
	 * @Description: 解析微信发来的请求（XML）
	 * @param @param request
	 * @param @return
	 * @param @throws Exception
	 * @author dapengniao
	 * @date 2016年3月7日 上午10:04:02
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> parseXml(HttpServletRequest request)
			throws Exception {
		// 将解析结果存储在HashMap中
		Map<String, String> map = new HashMap<String, String>();
		// 从request中取得输入流
		InputStream inputStream = request.getInputStream();
		// 读取输入流
		SAXReader reader = new SAXReader();
		Document document = reader.read(inputStream);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		List<Element> elementList = root.elements();

		// 遍历所有子节点
		for (Element e : elementList)
			map.put(e.getName(), e.getText());

		// 释放资源
		inputStream.close();
		inputStream = null;

		return map;
	}

	/**
	 * @Description: 文本消息对象转换成xml
	 * @param @param textMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月8日 下午4:13:22
	 */
	public static String textMessageToXml(TextMessage textMessage) {
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	/**
	 * @Description: 图文消息对象转换成xml
	 * @param @param newsMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月8日 下午4:14:09
	 */
	public static String newsMessageToXml(NewsMessage newsMessage) {
		xstream.alias("xml", newsMessage.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(newsMessage);
	}

	/**
	 * @Description: 图片消息对象转换成xml
	 * @param @param imageMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月9日 上午9:25:51
	 */
	public static String imageMessageToXml(ImageMessage imageMessage) {
		xstream.alias("xml", imageMessage.getClass());
		return xstream.toXML(imageMessage);
	}

	/**
	 * @Description: 语音消息对象转换成xml
	 * @param @param voiceMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月9日 上午9:27:26
	 */
	public static String voiceMessageToXml(VoiceMessage voiceMessage) {
		xstream.alias("xml", voiceMessage.getClass());
		return xstream.toXML(voiceMessage);
	}

	/**
	 * @Description: 视频消息对象转换成xml
	 * @param @param videoMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月9日 上午9:31:09
	 */
	public static String videoMessageToXml(VideoMessage videoMessage) {
		xstream.alias("xml", videoMessage.getClass());
		return xstream.toXML(videoMessage);
	}

	/**
	 * @Description: 音乐消息对象转换成xml
	 * @param @param musicMessage
	 * @param @return
	 * @author dapengniao
	 * @date 2016年3月8日 下午4:13:36
	 */
	public static String musicMessageToXml(MusicMessage musicMessage) {
		xstream.alias("xml", musicMessage.getClass());
		return xstream.toXML(musicMessage);
	}

	/**
	 * 对象到xml的处理
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});
}