package com.example.OnTapDTO1.repository;

import com.example.OnTapDTO1.config.HibernateConfig;
import com.example.OnTapDTO1.responese.MoiQuanHeResponse;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class MoiQuanHeRepository {
    List<MoiQuanHeResponse> listMQH=new ArrayList<>();

    public List<MoiQuanHeResponse> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listMQH=session.createQuery("SELECT new com.example.OnTapDTO1.responese.MoiQuanHeResponse(mqh.id,mqh.ma,mqh.ten) FROM MoiQuanHe mqh",MoiQuanHeResponse.class).getResultList();
        return listMQH;
    }

    public static void main(String[] args) {
        System.out.println("Mtam: "+new MoiQuanHeRepository().getAll());
    }

}
