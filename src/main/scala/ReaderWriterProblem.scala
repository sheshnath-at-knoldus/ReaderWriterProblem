package com.knoldus

import java.util.concurrent.locks.ReentrantReadWriteLock

//class Reader Writer Problem
class ReaderWriterProblem {

  private val lock = new ReentrantReadWriteLock()
  private var data: List[String] = List("Before Write operation")
  private var readersNumber = 0

  def read(): Unit = {
    lock.readLock().lock()
    try {
      readersNumber += 1
      println("Data=" + data.mkString(","))
      println("Numbers of Readers at a Time =" + readersNumber)
    } catch {
      case exception: Exception => println("Exception occurred" + exception.getMessage)
    }
    finally {
      readersNumber -= 1
      lock.readLock().unlock()
    }
  }

  def write(writingData: String): Unit = {
    lock.writeLock().lock()
    try {
      data = data :+ writingData
      println("Data after write =" + data.mkString(","))
    } catch {
      case exception: Exception => println("Exception occurred" + exception.getMessage)
    }
    finally {
      lock.writeLock().unlock()
    }
  }
}


//Multiple Runnable threads are created

class MultipleThreadClass {

  val runnableThread4: Runnable = () => {
    instanceOfReaderWriter.write("Hello")
  }
  val runnableThread5: Runnable = () => {
    instanceOfReaderWriter.write("Sheshnath")
  }
  val runnableThread6: Runnable = () => {
    instanceOfReaderWriter.write(" is here")
  }
  val runnableThread1: Runnable = () => {
    instanceOfReaderWriter.read()
  }
  val runnableThread2: Runnable = () => {
    instanceOfReaderWriter.read()
  }
  val runnableThread3: Runnable = () => {
    instanceOfReaderWriter.read()
  }
  val runnableThread7: Runnable = () => {
    instanceOfReaderWriter.read()
  }
  private val instanceOfReaderWriter = new ReaderWriterProblem

}