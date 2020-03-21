package com.zyp.carweb.command;

import com.zyp.carweb.model.Goods;

public class LogCommand implements Command {

    private Receiver receiver;

    public LogCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute(Goods goods) {
        receiver.saveGoodsLog(goods);
    }
}
