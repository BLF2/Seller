package net.blf2.dao;

import net.blf2.entity.ReponsityIo;

import java.util.List;

/**
 * Created by blf2 on 17-6-25.
 */
public interface IReponsity {
    void insertReponsity(ReponsityIo reponsityIo);
    void deleteReponsityByNum(String reponsityNum);
    void updateReponsity(ReponsityIo reponsityIo);
    ReponsityIo queryReponsityByNum(String reponsityNum);
    List<ReponsityIo> queryReponsityAll();
}
