package com.sanjeev.demo;

class A {
    final int id;

    public A(final int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}

class B extends A {
    int overrideId;

    public B(int id) {
        super(id);
    }

    @Override
    public int getId() {
        return this.overrideId;
    }

    public void setId(int id) {
        this.overrideId = id;
    }
}
