package com.sl.util;

import com.sl.bean.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class TplTest {
    private static final Class[] CLASSES = {
            Company.class,
            Project.class,
            Experience.class,
            Contact.class,
            User.class
    };
    private static final Map<String, String> TPL_DIRS = new HashMap<>();
    // TODO: 更改绝对路径
    private static final String BASE_DIR = "C:\\Users\\Franklin\\Documents\\LearnJavaProjects\\02_resume\\src\\main\\java\\com\\sl\\";
    static {
        TPL_DIRS.put("Dao", "dao");
        TPL_DIRS.put("DaoImpl", "dao/impl");
        TPL_DIRS.put("Service", "service");
        TPL_DIRS.put("ServiceImpl", "service/impl");
        TPL_DIRS.put("Servlet", "servlet");
    }

    public static void main(String[] args) throws Exception {
        for (Map.Entry<String, String> entry : TPL_DIRS.entrySet()) {
            String suffix = entry.getKey(); // 后缀
            String dir = entry.getValue();
            // 获取 tpl 文件的路径
            String tpl = "tpl/" + suffix + ".tpl";
            String tplFilePath = TplTest.class.getClassLoader().getResource(tpl).getFile();
            // 模板文件的内容
            String text = FileUtils.readFileToString(new File(tplFilePath), "UTF-8");
            // 根据类名替换文件内容
            for (Class cls : CLASSES) {
                String clsName = cls.getSimpleName();
                String newText = text.replace("#0#", clsName).replace("#1#", clsName.toLowerCase());
                String fileName = clsName + suffix + ".java";
                String filePath = BASE_DIR + "/" + dir + "/" + fileName;

                File file = new File(filePath);
                if (file.exists()) {
                    System.out.println("已经存在：" + file);
                    continue;
                }

                FileUtils.writeStringToFile(file, newText, "UTF-8");
                System.out.println("新生成：" + file);
            }
        }
    }

}
