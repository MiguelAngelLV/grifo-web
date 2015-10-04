package com.elhackaton.grifo;



import jssc.SerialPort;
import jssc.SerialPortException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
@ApplicationScoped
public class Arduino  {


    private SerialPort port;

    public Arduino() {

    }


    @PostConstruct
    public void init() {
        port = new SerialPort("/dev/ttyACM0");
        read();
    }

    public void read() {
        while(true) {
            try {
                System.out.println(port.readString());
            } catch (SerialPortException e) {
                e.printStackTrace();
            }

        }

    }
}
