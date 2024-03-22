package xian.woniuxy.utli;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSqlmap {
    public void generator() throws Exception {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        // 指定Mybatis逆向工程配置文件的位置
        File configFile = new File("src/main/resources/mybatis/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);

        System.out.println("over");
    }

    public static void main(String[] args) throws Exception {
        try {
            GeneratorSqlmap t = new GeneratorSqlmap();
            t.generator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}