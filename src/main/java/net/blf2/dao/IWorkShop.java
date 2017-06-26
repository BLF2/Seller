package net.blf2.dao;

import net.blf2.entity.WorkShop;

import java.util.List;

/**
 * Created by blf2 on 17-6-25.
 */
public interface IWorkShop {
    void insertWorkShop(WorkShop workShop);
    void deleteWorkShopByWorkShopNum(String workShopNum);
    void updateWorkShop(WorkShop workShop);
    WorkShop queryWorkShopByWorkShopNum(String workShopNum);
    List<WorkShop> queryWorkShopAll();
}
