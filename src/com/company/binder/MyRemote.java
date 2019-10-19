package com.company.binder;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    public String sayhello() throws RemoteException;
}
