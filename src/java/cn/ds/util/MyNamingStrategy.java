package cn.ds.util;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.internal.util.StringHelper;

public class MyNamingStrategy extends ImprovedNamingStrategy {
	// 处理的类名到表名的转换
	public String classToTableName(String className) {
		return "T_"
				+ addUnderscores(StringHelper.unqualify(className))
						.toUpperCase();	
	}

	// 属性:firstName 表:first_name
	// 处理的属性名到表的字段的转换
	public String propertyToColumnName(String propertyName) {
		return addUnderscores(StringHelper.unqualify(propertyName))
				.toUpperCase();
	}
}
