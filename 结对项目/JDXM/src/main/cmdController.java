package main;
import java.util.HashMap;
import java.util.Map;

//命令行解析
public class cmdController {
    public static Map<String, String> cmdControl(String[] args) {
        Map<String, String> control = new HashMap<>();
        for (int i = 0; i < args.length; i++) {
            if (i + 1 < args.length) {
                control.put(args[i], args[i + 1]);
                i++;
            }
        }
        return control;
    }
}
