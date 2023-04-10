package com.knoldus


object Driver extends App {

  //Multiple thread class object creation
  private val multipleThreadClass = new MultipleThreadClass

  //instance of Thread
  private val thread1 = new Thread(multipleThreadClass.runnableThread1)
  private val thread2 = new Thread(multipleThreadClass.runnableThread2)
  private val thread3 = new Thread(multipleThreadClass.runnableThread3)
  private val thread4 = new Thread(multipleThreadClass.runnableThread4)
  private val thread5 = new Thread(multipleThreadClass.runnableThread5)
  private val thread6 = new Thread(multipleThreadClass.runnableThread6)
  private val thread7 = new Thread(multipleThreadClass.runnableThread7)

  //thread Started
  thread1.start()
  thread3.start()
  thread2.start()
  thread6.start()
  thread7.start()
  thread4.start()
  thread5.start()

}
