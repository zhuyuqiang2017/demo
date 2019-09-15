package top.selfhelp;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * @author zhuyuqiang
 */
public class MybatisApplication {

    public static void main(String[] args) throws IOException {
        System.out.println("开始测试。。。。。。");
        String resource = "demo-mybatis/src/main/resources/mybatis/config/mybatis-config.xml";
        InputStream inputStream = new FileInputStream(new File(resource));
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession session = sqlSessionFactory.openSession()) {
//            Map blog = session.selectOne("top.selfhelp.ArticleMapper.", 101);
            Map blog = session.selectOne("top.selfhelp.ArticleMapper.selectArticle");
            System.out.println(blog);
        }
    }
}
