package com.zyp.carweb.command;

import com.zyp.carweb.model.Goods;

public interface Command {
    public void execute(Goods goods);

    public void aexecute(Goods goods);

    public void bexecute(Goods goods);

    public void cexecute(Goods goods);

    public void dexecute(Goods goods);

    public void fexecute(Goods goods);
}
