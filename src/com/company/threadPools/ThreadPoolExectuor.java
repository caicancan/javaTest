package com.company.threadPools;

import java.util.concurrent.Executors;

public class ThreadPoolExectuor {

private ThreadPoolExectuor mThreadPoolExectuor;

public ThreadPoolExectuor newInstance(){
    synchronized (ThreadPoolExectuor.class) {
        if (mThreadPoolExectuor == null) {
            mThreadPoolExectuor = new ThreadPoolExectuor();
        }
    }
    return mThreadPoolExectuor;
}
public void test(){

}
}
