package cn.ekgc.dkems.util;

import java.util.Properties;

public class ConstantUtil {
	private static Properties props = new Properties();
	static {
		try {
			props.load(ConstantUtil.class.getClassLoader().getResourceAsStream("dkems.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static final Integer PAGE_NUM = Integer.parseInt(props.getProperty("page.num"));
	public static final Integer PAGE_SIZE = Integer.parseInt(props.getProperty("page.size"));
	
	public static final String STATUS_ENABLE = props.getProperty("status.enable");
	public static final String STATUS_DISABLE = props.getProperty("status.disable");
	
	public static final String VIEW_PREFIX = props.getProperty("view.prefix");
	public static final String VIEW_SUFFIX = props.getProperty("view.suffix");
}
