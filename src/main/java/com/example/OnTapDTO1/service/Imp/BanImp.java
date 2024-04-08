package com.example.OnTapDTO1.service.Imp;

import com.example.OnTapDTO1.entity.Ban;
import com.example.OnTapDTO1.repository.BanRepository;
import com.example.OnTapDTO1.request.BanRequest;
import com.example.OnTapDTO1.responese.BanResponse;
import com.example.OnTapDTO1.service.BanService;

import java.util.List;

public class BanImp implements BanService{
    BanRepository repo=new BanRepository();
    @Override
    public List<BanResponse> getAll() {
        return repo.getAll();
    }

    @Override
    public Ban getOne(int id) {
        return repo.getOne(id);
    }

    @Override
    public boolean add(Ban ban) {
        return false;
    }

    @Override
    public boolean update(Ban ban) {
        return false;
    }

    @Override
    public boolean delete(Ban ban) {
        return repo.delete(ban);
    }

    public boolean addRequest(BanRequest banRequest){
        Ban ban=new Ban();
        ban.setGioiTinh(banRequest.getGioiTinh());
        ban.setSoThich(banRequest.getSoThich());
        ban.setMa(banRequest.getMa());
        ban.setTen(banRequest.getTen());
        ban.setIdMoiQuanHe(banRequest.getIdMoiQuanHe());
        return repo.add(ban);
    }

    public boolean updateRequest(BanRequest banRequest){
        Ban ban=new Ban();
        ban.setId(banRequest.getId());
        ban.setGioiTinh(banRequest.getGioiTinh());
        ban.setSoThich(banRequest.getSoThich());
        ban.setMa(banRequest.getMa());
        ban.setTen(banRequest.getTen());
        ban.setIdMoiQuanHe(banRequest.getIdMoiQuanHe());
        return repo.update(ban);
    }
}
