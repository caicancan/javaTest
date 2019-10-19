package com.company.cacheDesign;


/**
 * @function 作为缓存的实体类的写法
 * */
public class CacheImmutale {

    private static int MAX_SIZE=10;
    //使用数组来缓存已有的实例
    private static CacheImmutale[]  cache=new CacheImmutale[MAX_SIZE];
    //记录缓存实例在缓存中的位置，cache[pos-1]是最新缓存的实例
    private static int pos=0;

    private final String name;

    public CacheImmutale(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmutale valueof(String name){
        //遍历已缓存的对象
        for (int i = 0; i <MAX_SIZE ; i++) {
            //如果已有相同实例则返回该缓存的实例
            if (cache[i]!=null&&cache[i].getName().equals(name)){
                return cache[i];
            }
        }
        //如果缓存池已满
        if (pos==MAX_SIZE){
            //把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓存池的最开始位置
            cache[0]=new CacheImmutale(name);
            //把pos设置为1
            pos=1;
        }else {
            //把新创建的对象缓存起来，pos+1
            cache[pos++]=new CacheImmutale(name);
        }
        return cache[pos-1];
    }

    public boolean equals(Object obj){
        if (this==obj){
            return true;
        }

        return false;
    }
}
