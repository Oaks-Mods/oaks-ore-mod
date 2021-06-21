package org.oakbricks.oakores.util;

public class TickUtil {
    public int ticks;

    public int maxLeadTimeAllowed() {
        return 400;
    }

    public void test() {
        System.out.println("TEST, THIS SHOULD BE DELAYED BY 400 TICKS");
    }

    //@Override
    public void tick() {
        ++this.ticks;
    }
    //@Override
    public void forPlayerEntityMixin() {
        if (this.ticks == this.maxLeadTimeAllowed()) {  // or >=
            this.ticks = 0; // or not do this
            this.test();
        }
    }
}
