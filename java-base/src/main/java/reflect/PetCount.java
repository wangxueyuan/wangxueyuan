package reflect;

import reflect.Pets.Pet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PetCount {
    static class PetCounter extends LinkedHashMap<Class<? extends Pet>, Integer>
    {
        Map<Class<? extends Pet>, Integer> map = new HashMap<>();
        //构造函数
        public PetCounter()
        {
            for (Class clz : LiteralPetCreator.allTypes) {
                map.put(clz, 0);
            }//初始化所有的类别的个数为0
        }

        public void count(Pet pet)	//吧这个pet对象添加到map里面
        {
            for(Map.Entry<Class<? extends Pet>, Integer> pair : map.entrySet())
            {
                if(pair.getKey().isInstance(pet))	//找到了和pet匹配的对像，那么就添加一个
                {
                    map.put(pair.getKey(), pair.getValue() + 1);
                }
            }
        }

        public String toString()
        {
            StringBuilder result = new StringBuilder("{ ");
            for(Map.Entry<Class<? extends Pet>, Integer> pair : map.entrySet())//遍历所有的不重复的对象
            {
                result.append(pair.getKey().getSimpleName());	//类名
                result.append(" = ");
                result.append(pair.getValue());
                result.append(", ");
            }

            result.delete(result.length() - 2, result.length());	//去掉最后的", "
            result.append(" }");
            return result.toString();
        }
    }

    public static void main(String[] args)
    {
        LiteralPetCreator literalPetCreator = new LiteralPetCreator();
        PetCounter petCount = new PetCounter();
        for(Pet pet : literalPetCreator.createPetArray(20))
        {
            System.out.println((pet.getClass().getSimpleName() + " "));
            petCount.count(pet); //吧这个pet加入进去
        }

        System.out.println();
        System.out.println(petCount);	//输出所有的个数
    }

}
