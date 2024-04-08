package com.example.OnTapDTO1.repository;

import com.example.OnTapDTO1.config.HibernateConfig;
import com.example.OnTapDTO1.entity.Ban;
import com.example.OnTapDTO1.responese.BanResponse;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BanRepository {

    List<BanResponse> listB=new ArrayList<>();

    public List<BanResponse> getAll(){
        Session session= HibernateConfig.getFACTORY().openSession();
        listB=session.createQuery("SELECT new com.example.OnTapDTO1.responese.BanResponse(ban.id,ban.ma,ban.ten,ban.soThich,ban.gioiTinh,ban.moiQuanHe.id,ban.moiQuanHe.ten) " +
                "From Ban ban",BanResponse.class).getResultList();
        return listB;
    }

    public Ban getOne(int id){
        Ban ban=null;
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            ban=session.get(Ban.class,id);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return ban;
    }

    public boolean add(Ban ban){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.save(ban);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean update(Ban ban){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.update(ban);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(Ban ban){
        Transaction transaction=null;
        try(Session session= HibernateConfig.getFACTORY().openSession()){
            transaction=session.beginTransaction();
            session.delete(ban);
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BanRepository().getAll());
    }

}
