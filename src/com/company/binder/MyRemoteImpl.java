package com.company.binder;

import java.rmi.RemoteException;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public static void main(String[] args) {
        //代理模式
        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayhello() throws RemoteException {
        return "sever says ,'hey'";
    }
}
