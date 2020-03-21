package com.zyp.carweb.command;

import com.zyp.carweb.model.Goods;

public class Invoker {

    private Command LogCommand;

    public Command getLogCommand() {
        return LogCommand;
    }

    public void setLogCommand(Command logCommand) {
        LogCommand = logCommand;
    }

    public void goodsLog(Goods goods){
        LogCommand.execute(goods);
    }

}
