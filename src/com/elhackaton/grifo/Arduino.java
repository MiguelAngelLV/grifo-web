package com.elhackaton.grifo;

import jssc.SerialPort;
import jssc.SerialPortException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Arduino {

    private SerialPort port;


    public Arduino() {


    }

    @PostConstruct
    public void init() {
        System.out.println("HOOOOOOOOOOLAAAAAAAAAAA");
        port = new SerialPort("/dev/ttyACM0");
        read();
    }


    public void read() {

        while(true) {
            try { System.out.println(port.readString());
            } catch (SerialPortException e) {}

        }
    }

    public String getDummy() {
        return "Hollaa";
    }


}
