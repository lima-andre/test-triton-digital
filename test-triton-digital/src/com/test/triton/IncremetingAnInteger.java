package com.test.triton;

import java.util.concurrent.atomic.AtomicInteger;

public class IncremetingAnInteger {
	
	private int integerToIncrement;
	private volatile int integerVolatileToIncrement;
    AtomicInteger atomicIntegerToIncrement = new AtomicInteger( 0 );

  
    /*
     * locking and synchronization
     */
    public synchronized int getIntegerWithLockAndSynchronizationIncrement(){
        return integerToIncrement++;
    }
  
    /*
     * atomicIntegerToIncrement is incremented atomically
     */
    public int getAtomicIntegerAtomically(){
        return atomicIntegerToIncrement.incrementAndGet();
    }
    
    /*
     * valatile increment
     */
    public synchronized int getIntegerWithVolatileIncrement(){
        return integerVolatileToIncrement++;
    }

}
