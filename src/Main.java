import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder inPath=new StringBuilder("D\\cqsjdata");
        String otherPath="\\cfg_union_siyang.csv";
        inPath.append(otherPath);
        File file=new File(inPath.toString());

        System.out.println(inPath);

        StringBuilder className=new StringBuilder(otherPath.split("_")[1].split("\\.")[0]);
        className.append("Config");
        try {
            BufferedReader reader=new BufferedReader(new FileReader("D:\\cqsjdata\\"+otherPath));

            String line=null;

            List<Filed> list= new ArrayList<Filed>();
            //读第一行
            if ((line=reader.readLine())!=null) {
                String item[] = line.split(",");
                for (String str : item) {
                    Filed filed=new Filed();
                    filed.setDesc(str);
                    list.add(filed);
                }
            }
            reader.readLine();//第二行
            //第三行
            if ((line=reader.readLine())!=null){
                String item[] = line.split(",");
                for(int i=0;i<list.size();i++){
                    Filed filed=list.get(i);
                    if (item[i].equals("string")){
                        item[i]="String";
                    }
                    filed.setType(item[i]);
                }
            }
            //第四行
            if ((line=reader.readLine())!=null){
                String item[] = line.split(",");
                for(int i=0;i<list.size();i++){
                    Filed filed=list.get(i);
                    filed.setName(item[i]);
                }
            }
//            System.out.println(list.get(0));
//            InputStream inputStream = new FileInputStream(file);
//            int a=inputStream.read();
//            System.out.println(a);
            /**
             *
             */
        String template=TemplateUtil.buildTemplate();
        StringBuilder content=new StringBuilder();
        for (Filed filed:list){
            String result=replaceContent(filed);
            content.append(result);
            content.append("\n");
        }
        String newContent=content.toString();

        template=template.replaceAll("\\{content\\}",newContent);
        template=template.replaceAll("\\{configName\\}",className.toString());
            System.out.println(template);

            write("2",className.toString(),template,"d:/2");
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    private static void write(String packagePath, String fileName, String content, String output) throws IOException {
        String path = packagePath.replaceAll("\\.", "/");
        path = output + "/" + path;
        File dir = new File(path);
        if(!dir.exists()){
            dir.mkdirs();
        }
        path += "/" + fileName + ".txt";
        File file = new File(path);
        try(PrintWriter out = new PrintWriter(file))
        {
            out.println(content);
            out.flush();
        }
    }

    static String replaceContent(Filed filed) throws IOException {
        String template= TemplateUtil.buildContentTemplate();
        template=template.replaceAll("\\{desc\\}",filed.getDesc());
        template=template.replaceAll("\\{type\\}",filed.getType());
        template=template.replaceAll("\\{name\\}",filed.getName());
        return template;
    }

}
