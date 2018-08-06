package net.dowhile.justDoIt.util;

import org.beetl.sql.core.*;
import org.beetl.sql.core.db.DBStyle;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.gen.GenConfig;
import org.beetl.sql.ext.gen.GenFilter;
import org.beetl.sql.ext.gen.MapperCodeGen;

public class Gen {
    public static void main(String[] args) throws Exception {
        ConnectionSource source = ConnectionSourceHelper.getSimple("com.mysql.jdbc.Driver","jdbc:mysql://127.0.0.1:3306/test","root","xiaoLei123");
        DBStyle mysql = new MySqlStyle();
        // sql语句放在classpagth的/sql 目录下
        SQLLoader loader = new ClasspathLoader("/sql");
// 数据库命名跟java命名一样，所以采用DefaultNameConversion，还有一个是UnderlinedNameConversion，下划线风格的，
        UnderlinedNameConversion nc = new  UnderlinedNameConversion();
// 最后，创建一个SQLManager,DebugInterceptor 不是必须的，但可以通过它查看sql执行情况
        SQLManager sqlManager = new SQLManager(mysql,loader,source,nc,new Interceptor[]{new DebugInterceptor()});
        MapperCodeGen mapper = new MapperCodeGen("net.dowhile.justDoIt.dao");
        GenConfig config = new GenConfig();
        config.codeGens.add(mapper);
//        生成所有的POJO代码和SQL 模板， GenFilter 用来过滤
        sqlManager.genALL("net.dowhile.justDoIt.model", config, new GenFilter() {
            @Override
            public boolean accept(String s) {
                //仅生成 user 表
                if(s.equalsIgnoreCase("girl")) {
                    return true;
                }else{
                    return false;
                }
            }
        });

//        sqlManager.genPojoCode("girl","net.dowhile.justDoIt.model",config);
//        sqlManager.genSQLFile("girl");
        //sqlManager.genPojoCode("xunjian","com.sxlq.informationCenter.entity",config);
        //sqlManager.genSQLFile("xunjian");

//        sqlManager.genPojoCode("shebeiweixiu","com.sxlq.informationCenter.entity",config);
//        sqlManager.genSQLFile("shebeiweixiu");


        //sqlManager.genPojoCode("shebeibaoyang","com.sxlq.informationCenter.entity",config);
        //sqlManager.genSQLFile("shebeibaoyang");


        //sqlManager.genPojoCode("column2","com.sxlq.jd.MCS.entity",config);
        //sqlManager.genSQLFile("column2");


        //sqlManager.genPojoCode("article","com.sxlq.jd.MCS.entity",config);
        //sqlManager.genSQLFile("article");
    }
}
