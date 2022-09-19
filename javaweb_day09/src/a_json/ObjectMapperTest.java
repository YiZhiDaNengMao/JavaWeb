package a_json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import pojo.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
    Json 与 Java对象之间的转换
 */
public class ObjectMapperTest {
    //新建核心对象ObjectMapper
    private ObjectMapper mapper = new ObjectMapper();

    /*
        1.User对象 <-> Json
        Json字符串 = {"name":"派大星","age":6}
        User对象 = User{"name":"派大星","age":6}
     */

    @Test
    public void test01() throws IOException {
        //1.新建User对象
        User user = new User("派大星", 6);
        //2.User对象转Json
        String json = mapper.writeValueAsString(user);
        System.out.println("Json格式" + json);
        //3.Json转User对象
        User user1 = mapper.readValue(json, User.class);

    }

    /*
    2.map<String,String>转json,json转map<String,String>
      json字符串 = {"姓名":"张三","性别":"男"}
      map对象 = {姓名=张三, 性别=男}
     */
    @Test
    public void test02() throws IOException {
        //map<String,String>转json
        HashMap<String,String> map = new HashMap<>();
        map.put("姓名","张三");
        map.put("性别","男");
        String json = mapper.writeValueAsString(map);
        System.out.println("Json格式: " + json);

        //json转map<String,String>
        HashMap hashMap = mapper.readValue(json, HashMap.class);
        System.out.println("java对象:" + hashMap);
    }

    /*
        3.map<String,User>转json, json转map<String,User>
         json字符串 = {
                "Java2206":{"name":"张三","age":23},
                "Java2207":{"name":"李四","age":24}}
        map对象 =
            {
                Java2206=User{name='张三', age=23},
                Java2207=User{name='李四', age=24}
            }
     */
    @Test
    public void test03() throws IOException {
        //map<String,User>转json
        HashMap<String,User> map = new HashMap<>();
        map.put("Java2206",new User("张三",19));
        map.put("Java2207",new User("李四",19));
        String s = mapper.writeValueAsString(map);
        System.out.println("Json格式: " + s);

        //json转map<String,User>
        HashMap hashMap = mapper.readValue(s, HashMap.class);
        System.out.println("java对象:" + hashMap);
    }

    /*
        4.List<String>转json, json转 List<String>
            json字符串 = ["张三","李四"]
            list对象 = [张三, 李四]
     */
    @Test
    public void test04() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("姓名");
        list.add("派大星");
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
        List list1 = mapper.readValue(s, List.class);
        System.out.println(list1);
    }


    /*
        5.List<User>转json, json转List<User>
            json字符串 =
            [
                {"name":"张三","age":23},
                {"name":"李四","age":24}
            ]
            list对象 =
            [
                User{name='张三', age=23},
                User{name='李四', age=24}
            ]
     */

    @Test
    public void test05() throws IOException {
        User u1 = new User("派大星", 6);
        User u2 = new User("蜡笔小新", 7);
        List<User> list = new ArrayList<>();
        list.add(u1);
        list.add(u2);
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
        List list1 = mapper.readValue(s, List.class);
        System.out.println(list1);
    }

}
