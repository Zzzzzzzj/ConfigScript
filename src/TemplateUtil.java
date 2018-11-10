import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemplateUtil {

    public static String buildTemplate() throws IOException{
        try (BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream("template\\config.template")))){
            StringBuilder builder =new StringBuilder();
            String line=in.readLine();
            while (line!=null){
                builder.append(line);
                builder.append("\n");
                line=in.readLine();
            }
            return builder.toString();
        }

    }

    public static String buildContentTemplate() throws IOException{
        try (BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream("template\\field.template")))){
            StringBuilder builder =new StringBuilder();
            String line=in.readLine();
            while (line!=null){
                builder.append(line);
                builder.append("\n");
                line=in.readLine();
            }
            return builder.toString();
        }
    }

}
