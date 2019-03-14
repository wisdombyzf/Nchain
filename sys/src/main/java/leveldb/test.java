package leveldb;

import org.iq80.leveldb.DB;
import org.iq80.leveldb.Options;
import org.iq80.leveldb.impl.Iq80DBFactory;

import java.io.File;

public class test {
    /*
     * An example of leveldb
     * To add an element to leveldb, run ' db.put(key,value) '
     * To find an element, run ' db.get(key) '
     * To delete an element, run ' db.delete(key) '
     */
    public static void test(){
        try{
            LevelDb db = new LevelDb("db");                // connect to leveldb
            db.put("key1","value1");                                // add an element
            byte[] test = db.get("key1");                           // find an element
            for(int i=0;i<test.length;i++){
                System.out.print(test[i]);
            }
            db.delete("key1");                                  // delete an element
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}


