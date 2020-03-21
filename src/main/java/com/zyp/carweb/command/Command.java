package com.zyp.carweb.command;

import com.zyp.carweb.model.Goods;

public interface Command {
    public void execute(Goods goods);
}
