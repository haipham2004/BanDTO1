package com.example.OnTapDTO1.repository;

import com.example.OnTapDTO1.config.HibernateConfig;
import com.example.OnTapDTO1.entity.Ban;
import com.example.OnTapDTO1.entity.MoiQuanHe;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MoiQuanHeRepository {
    List<MoiQuanHe> listMQH=new ArrayList<>();

    public List<MoiQuanHe> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listMQH=session.createQuery(" FROM MoiQuanHe mqh",MoiQuanHe.class).getResultList();
        return listMQH;
    }

    public MoiQuanHe getOne(int id){
        MoiQuanHe mqh=null;
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            mqh=session.get(MoiQuanHe.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return mqh;
    }

    public static void main(String[] args) {
        System.out.println("Mtam: "+new MoiQuanHeRepository().getAll());
    }

}
