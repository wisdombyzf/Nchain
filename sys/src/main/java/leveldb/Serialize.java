package leveldb;

import src.Block;
import src.BlockChain;

public class Serialize {
    public static byte[] serialize(Block s){
        byte[] b = s.getHeaders();
        for(int i=0;i<b.length;i++){
            System.out.print(b[i]);
        }
        return b;
    }

    /*
    public Block deSerialize(byte[] b){
        Block block;

        return block;
    }*/
    public static void main(String[] args){
        BlockChain blockChain = new BlockChain();
        Block block = blockChain.get(0);
        byte[] key = block.gethash().getBytes();
        byte[] value = Serialize.serialize(block);
        LevelDb db = new LevelDb("db/Blockchain");
        db.put(key, value);
    }
}
