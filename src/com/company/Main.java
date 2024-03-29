package com.company;
import com.company.celve.Duck;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 多线程断点下载示例
 * @author YUANYUAN
 *
 */
public class Main extends Base {
    //下载所使用的线程数
    private static int threadCount=3;
    //当前活动的线程数
    private static int activeThread;

    public static void main(String[] args) {
//        try {
//            MuteLoadDemo();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        //策略模式，面对接口编程
//        MallardDuck mallardDuck = new MallardDuck();
//        mallardDuck.performFly();
//        mallardDuck.performQuack();
//        //观察者模式
//        WeatherData weatherData = new WeatherData();
//        WeatherConditionDisplay weatherConditionDisplay = new WeatherConditionDisplay(weatherData);
//        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
//        weatherData.setMeasureMents(1.00f,2.00f,3.00f);
//        //java自带的观察者模式
//        WeatherData2 weatherData2 = new WeatherData2();
//        CurrentConditionDisplay2 CurrentConditionDisplay2 = new CurrentConditionDisplay2(weatherData2);
//        weatherData2.setMeasureMents(5.00f,5.00f,5.00f);
//        //装饰者模式
//        Beverage beverage = new Expresso();
//         beverage = new Mocha(beverage);
//        System.out.println("装饰者模式"+beverage.getDescription()+"__"+beverage.cost());
//        Beverage beverage2 = new HouseBlend();
//        //用摩卡修饰它
//        beverage2=new Mocha(beverage2);
//        System.out.println("装饰者模式2"+beverage2.getDescription()+"__"+beverage2.cost());
//        beverage2=new BaiXiangGuo(beverage2);
//        System.out.println("装饰者模式2"+beverage2.getDescription()+"__"+beverage2.cost());
//        //工厂模式
//        PizzaStore nyPizzaStore = new NYPizzaStore();
//        //创建的模式新的
//        Pizza nypizza = nyPizzaStore.orderPizza("nypizza");
//        System.out.println("工厂模式"+nypizza.getName());
//        //适配器模式
//        com.company.adapter_model.Duck mallardDuck2 = new com.company.adapter_model.MallardDuck();
//        WildTurkey turkey = new WildTurkey();
//        TurkeyAdapter turkeyDuck= new TurkeyAdapter(turkey);//假装是鸭子的火鸡
//        turkeyDuck.fly();
//        turkeyDuck.quack();
//        for (int i = 0; i <5; i++) {
//            if (i==2){
//                return;
//            }
//            System.out.println(""+i);
//        }
      //  String isoString="杠";
   
       // printNineTo();
//        Main main = new Main();
//        main.doWork();
//        main.work();
//       // doTextFor();
//        testForFinal("final");

        //研究equals和==的区别
        //基本数据类型8个 byte short int long float double char boolean
        Integer a=new Integer(1);
        Integer b=new Integer(1);
        String  c=new String("aaa");
        String d=c;
        System.out.println((a==b)+""+a.equals(b));
        System.out.println(c==d);


    }

    private static void testForFinal(final String aFinal) {
        System.out.println("这个final是不能再被赋值的");
    }

    //测试循环嵌套的效率
    private static void doTextFor() {
        int i,j;
        long startTime = System.currentTimeMillis(); // 获取开始时间
        for ( i = 0; i <3; i++) {
            for ( j = 0; j <100 ; j++) {
                System.out.println("i"+i+"...j"+j);
            }
        }
        long endTime = System.currentTimeMillis(); // 获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    private  void doWork() {
    }


    private static void printNineTo(){
        for (int i = 1; i <10; i++) {
            for (int j = i; j <10 ; j++) {
                System.out.print(""+i+"*"+j+"="+i*j+" ");
            }
            System.out.print("\n");
        }

    }


    private static void MuteLoadDemo()throws Exception {
        //请求服务器的路径
        String path="http://127.0.0.1:8080/examples/index.html";
        //构造URL地址
        URL url=new URL(path);
        //打开连接
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        //设置请求超时的时间
        conn.setConnectTimeout(5000);
        //设置请求方式
        conn.setRequestMethod("GET");
        //获取相应码
        int code=conn.getResponseCode();
        if (code==200) {//请求成功
            //获取请求数据的长度
            int length=conn.getContentLength();
            //在客户端创建一个跟服务器文件大小相同的临时文件
            RandomAccessFile raf=new RandomAccessFile("setup.exe", "rwd");
            //指定临时文件的长度
            raf.setLength(length);
            raf.close();
            //假设3个线程去下载资源
            //平均每一个线程要下载的文件的大小
            int blockSize=length/threadCount;
            for (int threadId = 1; threadId <= threadCount; threadId++) {
                //当前线程下载数据的开始位置
                int startIndex=blockSize*(threadId-1);
                //当前线程下载数据的结束位置
                int endIndex=blockSize*threadId-1;
                //确定最后一个线程要下载数据的最大位置
                if (threadId==threadCount) {
                    endIndex=length;
                }
                //显示下载数据的区间
                System.out.println("线程【"+threadId+"】开始下载："+startIndex+"---->"+endIndex);
                //开启下载的子线程
                new DownloadThread(path, threadId, startIndex, endIndex).start();
                activeThread++;
                System.out.println("当前活动的线程数："+activeThread);
            }

        }else{//请求失败
            System.out.println("服务器异常，下载失败！");
        }
    }

    @Override
    void work() {
        System.out.println("work");
    }

    /**
     * 下载文件的子线程 每一个文件都下载对应的数据
     * @author YUANYUAN
     *
     */
    public static class DownloadThread extends Thread{
        private String path;
        private int threadId;
        private int startIndex;
        private int endIndex;

        /**
         * 构造方法
         * @param path 下载文件的路径
         * @param threadId 下载文件的线程
         * @param startIndex 下载文件开始的位置
         * @param endIndex 下载文件结束的位置
         */
        public DownloadThread(String path, int threadId, int startIndex,
                              int endIndex) {
            this.path = path;
            this.threadId = threadId;
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }



        @Override
        public void run() {
            //构造URL地址
            try {

                File tempFile=new File(threadId+".txt");
                //检查记录是否存在,如果存在读取数据
                if (tempFile.exists()) {
                    FileInputStream fis=new FileInputStream(tempFile);
                    byte[] temp=new byte[1024];
                    int length=fis.read(temp);
                    //读取到已经下载的位置
                    int downloadNewIndex=Integer.parseInt(new String(temp, 0, length));
                    //设置重新开始下载的开始位置
                    startIndex=downloadNewIndex;
                    fis.close();
                    //显示真实下载数据的区间
                    System.out.println("线程【"+threadId+"】真实开始下载数据区间："+startIndex+"---->"+endIndex);
                }

                URL url = new URL(path);
                HttpURLConnection conn=(HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                //设置请求属性，请求部分资源
                conn.setRequestProperty("Range", "bytes="+startIndex+"-"+endIndex);
                int code=conn.getResponseCode();
                if (code==206) {//下载部分资源，正常返回的状态码为206
                    InputStream is=conn.getInputStream();//已经设置了请求的位置，所以返回的是对应的部分资源
                    //构建随机访问文件
                    RandomAccessFile raf=new RandomAccessFile("setup.exe", "rwd");
                    //设置 每一个线程随机写文件开始的位置
                    raf.seek(startIndex);
                    //开始写文件
                    int len=0;
                    byte[] buffer=new byte[1024];
                    //该线程已经下载数据的长度
                    int total=0;

                    while((len=is.read(buffer))!=-1){//读取输入流
                        //记录当前线程已下载数据的长度
                        RandomAccessFile file=new RandomAccessFile(threadId+".txt","rwd");
                        raf.write(buffer,0,len);//写文件
                        total+=len;//更新该线程已下载数据的总长度
                        System.out.println("线程【"+threadId+"】已下载数据："+(total+startIndex));
                        //将已下载数据的位置记录写入到文件
                        file.write((startIndex+total+"").getBytes());
                        file.close();
                    }
                    is.close();
                    raf.close();
                    //提示下载完毕
                    System.out.println("线程【"+threadId+"】下载完毕");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("线程【"+threadId+"】下载出现异常！！");
            }finally{
                //活动的线程数减少
                activeThread--;
                if (activeThread==0) {
                    for (int i = 1; i <= threadCount; i++) {
                        File tempFile=new File(i+".txt");
                        tempFile.delete();
                    }
                    System.out.println("下载完毕，已清除全部临时文件");
                }
            }

        }
    }
}
