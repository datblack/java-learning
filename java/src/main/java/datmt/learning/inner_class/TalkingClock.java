package datmt.learning.inner_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.*;

public class TalkingClock {
    private int interval;
    private boolean beep;
    public TalkingClock(int interval, boolean beep) {
        this.beep = beep;
        this.interval = interval;
    }

    public TalkingClock() {
    }

    public void start() {
        var listener = new TimePrinter();
        var listenerr = new TimePrinterPri();
        var timer = new Timer(interval, listener);
        timer.start();
    }

     public class TimePrinter implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }

    class TimePrinterDef implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }

    protected class TimePrinterPro implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }

    private class TimePrinterPri implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }


    public static class TimePrinterSt implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }

    static class TimePrinterStDef implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }

    protected static class TimePrinterStPro implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }

    private static class TimePrinterStPri implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Time is: " + Instant.ofEpochMilli(e.getWhen()));
        }
    }
}
