class Foo {

    private CountDownLatch l1;
    private CountDownLatch l2;

    public Foo() {
        l1 = new CountDownLatch(1);
        l2 = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        l1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        l1.await();
        printSecond.run();
        l2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        l2.await();
        printThird.run();
    }
}