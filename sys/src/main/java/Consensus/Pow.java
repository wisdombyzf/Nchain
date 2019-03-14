package Consensus;

import java.math.BigInteger;
import src.Block;


public class Pow {

    public static void run(Block block){
        BigInteger target = block.calTarget();          //难度值
        while(true){
            BigInteger hash = new BigInteger(block.calHash(), 16);
            if(hash.compareTo(target) == -1){           //如果哈希值小于难度值，返回-1
                break;
            }else{
                block.setTimestamp();
                if(block.getnonce() < Long.MAX_VALUE){
                    block.setnonce(block.getnonce() + 1);
                }
                else{ block.initnonce(); }
            }
        }
    }

    public static boolean verify(Block block){
        boolean result=false;
        if(block.calMerkleRoot().equals(block.getMerkleRoot()) &&
                (block.calHash()).equals(block.gethash()) &&
                (new BigInteger(block.gethash(), 16)).compareTo(Block.calTarget()) == -1){
            result=true;
        }
        return result;
    }


}
