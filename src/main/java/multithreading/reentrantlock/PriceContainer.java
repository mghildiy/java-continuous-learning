package multithreading.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PriceContainer {

    Lock lock = new ReentrantLock();
    double bitCoinPrice, etherPrice, ripplePrice;

    public Lock getLock() {
        return lock;
    }

    public void setBitCoinPrice(double bitCoinPrice) {
        this.bitCoinPrice = bitCoinPrice;
    }

    public void setEtherPrice(double etherPrice) {
        this.etherPrice = etherPrice;
    }

    public void setRipplePrice(double ripplePrice) {
        this.ripplePrice = ripplePrice;
    }

    public double getBitCoinPrice() {
        return bitCoinPrice;
    }

    public double getEtherPrice() {
        return etherPrice;
    }

    public double getRipplePrice() {
        return ripplePrice;
    }
};
